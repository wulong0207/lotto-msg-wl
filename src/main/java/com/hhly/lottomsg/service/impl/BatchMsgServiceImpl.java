package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.MsgServiceBaseImpl;
import com.hhly.lottomsg.bo.OperateMsgConfigBO;
import com.hhly.lottomsg.bo.OperateMsgInfoBO;
import com.hhly.lottomsg.bo.OperateMsgNewBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OperateSendBatchBO;
import com.hhly.lottomsg.bo.OperateSendingMsgBO;
import com.hhly.lottomsg.bo.SendResultBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.enums.MessageStatus;
import com.hhly.lottomsg.common.enums.SendStatus;
import com.hhly.lottomsg.common.enums.SendType;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.mapper.NewMsgDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.BatchMsgService;
import com.hhly.lottomsg.service.manage.ThreadPoolManager;
import com.hhly.lottomsg.vo.OperateMsgNewVO;

@Service("batchMsgService")
public class BatchMsgServiceImpl extends MsgServiceBaseImpl implements BatchMsgService {

	@Autowired
	private NewMsgDaoMapper newMsgMapper;
	
	protected Logger logger = Logger.getLogger(BatchMsgServiceImpl.class.getName());
	
	private DelayQueue<OperateSendBatchBO> queue = new DelayQueue<OperateSendBatchBO>();
	
	/**
	 * 处理后台手动发送
	 */
	@Override
	public void handleManualSendInfo(String batchCode,boolean isSend) throws Exception
	{
		//查询待发送状态的信息
		OperateMsgNewBO newMsg = newMsgMapper.findNewMsgByBatch(batchCode);
		//查找对应模板信息
		OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateById(newMsg.getTemplateId());
		if(template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【后台手动发送信息处理服务】" + template.getTypeName() + "模板已禁用！");
			return;
		}
		if(newMsg != null && newMsg.getStatus().equals(SendStatus.NO_SEND.getCode()))
		{
			if(isSend){
				//更新信息状态为发送中
				newMsgMapper.updateNewMsgStatus(SendStatus.SENDING.getCode(),newMsg.getId());
			}
			//读取上传文件
			List<String> uploadUserIds = redisUtil.getObj(batchCode,new ArrayList<String>());
			int userCount= 0;
			boolean isAllUser = true;// 默认通知所有用户
			if(uploadUserIds != null && uploadUserIds.size() > 0){
				isAllUser = false;
				userCount = uploadUserIds.size();
			}
			List<String> noMobiles = new ArrayList<String>();
			if(isAllUser){
				//通知所有用户
				userCount = userInfoMapper.findValidUserInfoCount();// 通知用户数
				int num = 0;
				List<UserInfoBO> list = new ArrayList<UserInfoBO>();
				for (int i=1;i<=userCount;i++) 
				{
					if (i % 1000 == 0 || i ==userCount) 
					{
						int begin = num * 1000;
						list = userInfoMapper.findValidUserInfo(begin, 1000);
						doProcess(list, newMsg,template,isSend,noMobiles);
						list =new ArrayList<UserInfoBO>();
						num++;
					}
				}
			}
			else
			{
				// 上传用户
				List<Integer> userIds = new ArrayList<Integer>();
				int i = 1;
				for(String userId:uploadUserIds)
				{
					try{
						int id = Integer.parseInt(userId.trim());
						userIds.add(id);
					}
					catch(Exception e)
					{
						logger.info("【后台手动发送信息处理服务】非法用户id：" + userId);
						userCount--;
						continue;
					}
					if (i % 1000 == 0 || i == userCount)
					{
						List<UserInfoBO> list = userInfoMapper.findUserInfoByIds(userIds);
						doProcess(list, newMsg,template,isSend,noMobiles);
						userIds = new ArrayList<Integer>();
					}
					i++;
				}
			}
			logger.info("【后台手动发送信息处理服务】发送批次号：" + batchCode + "，是否通知所有用户(没有缓存数据)：" + isAllUser + "，用户数：" + userCount);
			if(isSend){
				// 发送完成更新状态
				newMsgMapper.updateNewMsgStatus(SendStatus.SEND_SUC.getCode(), newMsg.getId());
			}
			redisUtil.delObj(batchCode);//清理缓存
		}else{
			logger.info("【后台手动发送信息处理服务】没有查到发送批次号：" + batchCode + "符合条件的记录");
		}
	}
	
	/**
	 * 
	 * @Desc 给一批用户发消息
	 * @param list
	 * @param newMsg
	 */
	private void doProcess(final List<UserInfoBO> list, final OperateMsgNewBO newMsg,final OperateMsgTemplateBO template,final boolean isSend,final List<String> noMobiles)
	{
		ThreadPoolManager.execute(new Runnable()
		{
			@Override
			public void run()
			{
				List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
				
				for (UserInfoBO user : list)
				{
					String userMobile = user.getMobile();
					boolean isSmsSend = true;
					if(noMobiles.contains(userMobile)){
						isSmsSend = false;
					}else{
						noMobiles.add(userMobile);
					}
					if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
						logger.info("【通知信息管理】该用户渠道已设置不发送后台手动发送消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
						continue;
					}
					List<OperateMsgInfoPO> msgs = handleSendInfo(newMsg, user,template,isSend,isSmsSend);
					if(msgs != null)
						msgInfoList.addAll(msgs);
				}
				
				//保存发送给用户的消息记录
				if(msgInfoList.size() > 0){
					msgInfoDaoMapper.addMsgInfo(msgInfoList);
				}
			}
		});
	}
	
	/**
	 * 
	 * @Desc 组装用户通知信息
	 * @param bo
	 * @param user
	 * @return 消息记录
	 * @throws Exception 
	 */
	private List<OperateMsgInfoPO> handleSendInfo(final OperateMsgNewBO bo,final UserInfoBO user,final OperateMsgTemplateBO template,final boolean isSend,final boolean isSmsSend)
	{
		//保存数据
		List<OperateMsgInfoPO> msgList = new ArrayList<OperateMsgInfoPO>();
		try{
			OperateMsgConfigBO userConfig = userMsgConfigMapper.findUserConfig(user.getId(), bo.getTemplateId());
			// 模板(消息类型)消息接收开关，默认用户接收
			boolean siteStatus = true;
			boolean mobStatus = true;
			boolean appStatus = true;
//			boolean wechatStatus = true;

			if(userConfig != null){
				if(userConfig.getSite().equals(UseStatus.INVALID.getCode()))
					siteStatus = false;// 不接收此模板站内信消息
				if(userConfig.getMob().equals(UseStatus.INVALID.getCode()))
					mobStatus = false;// 不接收此模板手机短信
				if(userConfig.getApp().equals(UseStatus.INVALID.getCode()))
					appStatus = false;// 不接收此模板APP通知
//				if(userConfig.getWechat().equals(UseStatus.INVALID.getCode()))
//					wechatStatus = false;// 不接收此模板微信公众号消息
			}
			
			// 站内信处理
			if (user.getMsgSite().equals(UseStatus.VALID.getCode()) && siteStatus 
					&& template.getSiteStatus().equals(UseStatus.VALID.getCode()) && bo.getSiteStatus().equals(UseStatus.VALID.getCode()))
			{
				OperateMsgInfoPO msgInfo = createMsgInfo(bo,user,SendType.SITE.getCode());
				msgInfo.setSendTime(new Date());
				msgList.add(msgInfo);
			}

			// 手机短信处理
			if (mobMsgSend && isSmsSend && user.getMsgMob().equals(UseStatus.VALID.getCode())  
					&& template.getMobStatus().equals(UseStatus.VALID.getCode()) && mobStatus && bo.getMobStatus().equals(UseStatus.VALID.getCode())) 
			{
				String mobNotDisturb = user.getMobNotDisturb();//用户免打扰时间
				if(StringUtil.isBlank(mobNotDisturb) || isNotDisturb(mobNotDisturb))
				{
					//手机短信
					OperateMsgInfoPO msgInfo = createMsgInfo(bo,user,SendType.SMS.getCode());
					if(isSend){
						OperateSendingMsgBO sendInfo = CreateSendMsg(msgInfo);
						sendInfo.setSmsSendChannel(template.getSmsSendChannel().intValue());
						SendResultBO sendResultBO = sendSms(sendInfo);
						msgInfo.setStatus(sendResultBO.getCode());
						msgInfo.setSendError(sendResultBO.getMessage());
						msgInfo.setSendTime(new Date());
					}
					msgList.add(msgInfo);
				}
			}
			
			// APP通知
			if(appMsgSend && user.getMsgApp().equals(UseStatus.VALID.getCode()) 
					&& template.getAppStatus().equals(UseStatus.VALID.getCode()) && appStatus && bo.getAppStatus().equals(UseStatus.VALID.getCode()))
			{
				String appNotDisturb = user.getAppNotDisturb();//用户免打扰时间
				if (StringUtil.isBlank(appNotDisturb) || isNotDisturb(appNotDisturb)) 
				{
					//APP消息
					OperateMsgInfoPO msgInfo = createMsgInfo(bo,user,SendType.APP.getCode());
					OperateSendingMsgBO sendMsgInfo = CreateSendMsg(msgInfo);
					sendMsgInfo.setTypeId(template.getTypeId());//模板编号
					if(isSend){
						SendResultBO sendResultBO = sendApp(sendMsgInfo);
						msgInfo.setStatus(sendResultBO.getCode());
						msgInfo.setSendError(sendResultBO.getMessage());
						msgInfo.setSendTime(new Date());
					}
					msgList.add(msgInfo);
				}
			}

//			if (userWechatStatus && wechatStatus && bo.getWechatStatus() == UseStatus.VALID.getCode())
//			{
//				OperateSendingMsgBO sendMsgInfo = handleWechatMsg(msgList,bo, user,template);
//				sendMsgInfo.setWechatFields(bo.getWechatFields());
//				sendMsgList.add(sendMsgInfo);
//			}
		}
		catch (Exception e)
		{
			logger.error("【后台手动发送信息处理服务】处理用户" + user.getAccount() + "消息发生异常：");
			e.printStackTrace();
			return null;
		}
		if(msgList.size() > 0)
			return msgList;
		else
			return null;
	}

//	private OperateSendingMsgBO handleWechatMsg(List<OperateMsgInfoPO> msgList,
//			OperateMsgNewBO bo, UserInfoBO user,//查找对应模板信息
//			OperateMsgTemplateBO template)
//	{
//		//微信公众号
//		OperateMsgInfoPO msgInfo = createMsgInfo(bo,user,4);
//		msgInfo.setSendType(4);
//		
//		msgInfo.setMsgContent(bo.getHeaderCon() + "&" + bo.getFooterCon());
//		// 特有数据
//		msgInfo.setMsgDesc(template.getWechatAddFields());
//		msgList.add(msgInfo);
//		OperateSendingMsgBO sendMsgInfo = CreateSendMsg(msgInfo);
//		//查找微信模板信息
//		OperateWechatTemplateBO wechatConfig = msgTemplateMapper.findWechatTemplateById(template.getWechatId());
//		sendMsgInfo.setHeaderColor(wechatConfig.getHeaderColor());
//		sendMsgInfo.setFooterColor(wechatConfig.getFooterColor());
//		sendMsgInfo.setWechatFieldsColors(wechatConfig.getColor());
//		sendMsgInfo.setHeaderContent(bo.getHeaderCon());
//		sendMsgInfo.setFooterContent(bo.getFooterCon());
//		return sendMsgInfo;
//	}
	
	/**
	 * 
	 * @Description 组装处理通知信息入库数据
	 * @author HouXiangBao289
	 * @param bo
	 * @param user
	 * @param type
	 * @return
	 */
	private OperateMsgInfoPO createMsgInfo(OperateMsgNewBO bo,UserInfoBO user,Short type)
	{
		OperateMsgInfoPO msgInfo = new OperateMsgInfoPO();
		String title = "";
		String content = "";
		Map<String,String> map = getUserVariable(user);
		String desc = "activityUrl:"+(bo.getActivityUrl()==null?"":bo.getActivityUrl())+";toBuyLotteryCode:" 
				+ (bo.getToLotteryCode()==null?"":bo.getToLotteryCode());
		if(SendType.SITE.getCode().equals(type))
		{
			// 站内信
			if(bo.getSiteTitle() != null){
				// 替换模板title 昵称字段
				title = bo.getSiteTitle();
			}
			if(bo.getSiteContent() != null){
				// 替换模板content 昵称字段
				content = bo.getSiteContent();	
			}
			msgInfo.setSendType(SendType.SITE.getCode());
		}
		else if(SendType.SMS.getCode().equals(type))
		{
			// 手机短信
			if(bo.getMobTitle() != null){
				title = bo.getMobTitle();
			}
			if(bo.getMobContent() != null){
				content = bo.getMobContent();	
			}
			msgInfo.setSendType(SendType.SMS.getCode());
			desc = bo.getRemark();
		}
		else if(SendType.APP.getCode().equals(type))
		{
			// APP通知
			if(bo.getAppContent() != null){
				content = bo.getAppContent();
			}
			msgInfo.setSendType(SendType.APP.getCode());
			
			if(!StringUtil.isBlank(bo.getAppFields())){
				desc += desc + ";" + bo.getAppFields();
			}
		}
		msgInfo.setMsgDesc(desc);
		
		if(!StringUtil.isBlank(title))
		{
			List<String> findList = StringUtil.findStr(title, patter);
			for(String str:findList){
				String data = map.get(str);
				title = title.replace(str, data==null?"":data);
			}
		}
		
		if(!StringUtil.isBlank(content))
		{
			List<String> findList = StringUtil.findStr(content, patter);
			for(String str:findList){
				String data = map.get(str);
				content = content.replace(str, data==null?"":data);
			}
		}
		
		msgInfo.setMsgTitle(title);
		msgInfo.setMsgContent(content);
		msgInfo.setCreateBy(bo.getCreateBy());
		msgInfo.setMsgBatch(bo.getMsgBatch());
		msgInfo.setPreSendTime(bo.getPreSendTime());
		msgInfo.setAccountName(user.getAccount());
		msgInfo.setNickName(user.getNickname());
		msgInfo.setMsgType(bo.getMsgType());
		if(user.getMobile() != null){
			msgInfo.setCusMobile(Long.parseLong(user.getMobile()));
		}
		msgInfo.setUserId(user.getId());
		msgInfo.setStatus(MessageStatus.NO_SEND.getCode());
		msgInfo.setTemplateId(bo.getTemplateId());
		return msgInfo;
	}
	
	@Override
	public void resendCmsMsg(Integer id)
	{
		OperateMsgInfoBO msgInfo = msgInfoDaoMapper.findMsgInfoById(id);
		sendUserMsg(msgInfo);
	}
	
	@Override
	public DelayQueue<OperateSendBatchBO> getQueue() {
		return queue;
	}

	@Override
	public void findNoSendMsgToQueue() {
		OperateMsgNewVO vo = new OperateMsgNewVO();
		vo.setStatus((int)Constants.NO_SEND_STATUS);
		List<OperateMsgNewBO> noSendList = newMsgMapper.findNewMsgList(vo);
		for(OperateMsgNewBO bo:noSendList){
			Date sendTime = bo.getPreSendTime();
			if(sendTime==null)sendTime=new Date();
			queue.add(new OperateSendBatchBO(bo.getMsgBatch(),sendTime.getTime()));
		}
	}

	@Override
	public void sendManualMsg(String batchCode) throws Exception {
		List<OperateMsgInfoBO> msgs = msgInfoDaoMapper.findMsgsByBatch(batchCode);
		for(OperateMsgInfoBO msg:msgs){
			sendUserMsg(msg);
		}
		OperateMsgNewBO newMsg = newMsgMapper.findNewMsgByBatch(batchCode);
		if(newMsg != null){
			// 发送完成更新状态
			newMsgMapper.updateNewMsgStatus(SendStatus.SEND_SUC.getCode(), newMsg.getId());	
		}
	}
	
	@Override
	public void sendWaitMsg(Integer templateCode){
		List<OperateMsgInfoBO> msgs = msgInfoDaoMapper.findMsgsByTemplateCode(templateCode);
		for(OperateMsgInfoBO msg:msgs){
			sendUserMsg(msg);
		}
	}

}
