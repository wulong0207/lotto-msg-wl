package com.hhly.lottomsg.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hhly.lottomsg.base.service.MsgServiceBase;
import com.hhly.lottomsg.bo.NoticeUserInfoBO;
import com.hhly.lottomsg.bo.OperateMsgInfoBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OperateSendingMsgBO;
import com.hhly.lottomsg.bo.SendResultBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.enums.LotteryChildEnum.LotteryChild;
import com.hhly.lottomsg.common.enums.MessageStatus;
import com.hhly.lottomsg.common.enums.SendType;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.common.util.PushUtil;
import com.hhly.lottomsg.common.util.RedisUtil;
import com.hhly.lottomsg.common.util.SmsSendUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.mapper.MsgInfoDaoMapper;
import com.hhly.lottomsg.mapper.MsgTemplateDaoMapper;
import com.hhly.lottomsg.mapper.UserInfoDaoMapper;
import com.hhly.lottomsg.mapper.UserMsgConfigDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

public abstract class MsgServiceBaseImpl implements MsgServiceBase{
	
	protected Logger logger = Logger.getLogger(MsgServiceBaseImpl.class.getName());
	
	@Autowired
	protected MsgInfoDaoMapper msgInfoDaoMapper;
	
	@Autowired
	protected UserMsgConfigDaoMapper userMsgConfigMapper;
	
	@Autowired
	protected UserInfoDaoMapper userInfoMapper;
	
	@Autowired
	protected MsgTemplateDaoMapper msgTemplateMapper;
	
	@Autowired
	protected RedisUtil redisUtil;
	
	@Value("${mob_msg_send}")
	protected boolean mobMsgSend;
	
	@Value("${app_msg_send}")
	protected boolean appMsgSend;
	
	@Value("${is_apns_production}")
	public boolean isApnsProduction;
	protected String[] userInfoKeys = {"id","nickName","accountName","actualName","mobile","password","idNumber","email","forbitEndTime"};
	// 用户信息
	protected String[] userInfoNames = {"${会员id}$","${昵称}$","${账户}$","${真实姓名}$","${手机号}$","${密码}$","${身份证号}$","${会员邮箱}$","${禁用解除时间}$"};
	
	/**
	 * 匹配动态变量正则表达式
	 */
	protected String patter = "\\$\\{.*?\\}\\$";
	
	@Override
	public void addMsgInfo(List<OperateMsgInfoPO> msgInfoList) {
		if(msgInfoList != null && msgInfoList.size() > 0){
			msgInfoDaoMapper.addMsgInfo(msgInfoList);
		}
	}
	
	/**
	 * 判断免打扰时间
	 * @Description 
	 * @author HouXiangBao289
	 * @param appNotDisturb
	 * @return
	 * @throws Exception
	 */
	protected boolean isNotDisturb(String appNotDisturb)
	{
		if(!StringUtil.isBlank(appNotDisturb))
		{
			String[] time = appNotDisturb.split("-");
			try 
			{
				return !DateUtil.isCurDateAtTimeRange("HH:mm", time[0], time[1]);
			} 
			catch (Exception e)
			{
				logger.error("用户免打扰时间格式不正确！异常信息：");
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 
	 * @Desc 组装用户发送数据
	 * @param bo
	 * @param user
	 */
	protected OperateSendingMsgBO CreateSendMsg(OperateMsgInfoPO vo) 
	{
		OperateSendingMsgBO sendMsgInfo = new OperateSendingMsgBO();
		sendMsgInfo.setMsgTitle(vo.getMsgTitle());
		sendMsgInfo.setMsgContent(vo.getMsgContent());
		sendMsgInfo.setMsgBatch(vo.getMsgBatch());
		sendMsgInfo.setAccountName(vo.getAccountName());
		sendMsgInfo.setNickName(vo.getNickName());
		sendMsgInfo.setCusMobile(vo.getCusMobile());
		sendMsgInfo.setUserId(vo.getUserId());
		sendMsgInfo.setSendType(vo.getSendType());
		sendMsgInfo.setCusMobile(vo.getCusMobile());
		sendMsgInfo.setAccountName(vo.getAccountName());
		sendMsgInfo.setAppFields(vo.getMsgDesc());
		return sendMsgInfo;
	}

	
	/**
	 * 发送微信公众号消息
	 * @param msg
	 */
	protected void sendWechat(OperateSendingMsgBO msg) 
	{
		// TODO 微信公众号对接
	}

	/**
	 * 
	 * @Description 发送APP通知信息
	 * @author HouXiangBao289
	 * @param msg
	 * @return 返回结果：1发送成功;2发送失败
	 */
	protected SendResultBO sendApp(OperateSendingMsgBO msg) 
	{
		if(appMsgSend){
			try
			{
				// 通知用户别名列表
				List<String> aliasList = new ArrayList<String>();
				if(msg.getUserId() == null)
				{
					logger.warn("【APP通知】通知用户id为空");
					return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接收用户id为空");
				}
				String sendUserId = isApnsProduction?"":"test_";
				sendUserId = sendUserId + msg.getUserId();
				logger.info("APP通知" + sendUserId + "(用户终端标识)：" + msg.getMsgContent());
				// 通知用户
				aliasList.add(sendUserId);
				// 附加字段
				Map<String,String> extras = new HashMap<String,String>();
				Map<String,String> fieldsData = new HashMap<String,String>();
				fieldsData.put("userId", msg.getUserId().toString());
				if(!StringUtil.isBlank(msg.getAppFields()))
				{
					String[] appFields = msg.getAppFields().split(";");
					for(String field:appFields)
					{
						// 处理包含链接地址特殊符
						int index = field.indexOf(":");
						if(index > 0)
						{
							String data1 = field.substring(0, index);
							String data2 = field.substring(index + 1);
							fieldsData.put(data1, data2);	
						}
					}
				}
				// 消息类型，存放跳转界面地址，用于识别消息
				extras.put(Constants.APP_MSG_TYPE, msg.getTypeId()==null?"未知消息":msg.getTypeId()+"");
				extras.put(Constants.APP_MSG_ADD_DATA, JsonUtil.object2Json(fieldsData));
				return PushUtil.sendAlias(msg.getMsgContent(), aliasList,extras,isApnsProduction);
//				msgDaoMapper.updateMsgSendStatus(msg.getMsgBatch(), msg.getUserId(), msg.getSendType(),msgStatus);
			}catch(Exception e){
				logger.error("【APP通知】处理异常：");
				e.printStackTrace();
				return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),e.getMessage());
			}
		}
		else
		{
			logger.warn("【APP通知】发送失败，APP发送服务已关闭");
			return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"APP发送服务已关闭");
//			msgDaoMapper.updateMsgSendStatus(msg.getMsgBatch(), msg.getUserId(), msg.getSendType(),(int)MessageStatus.SEND_FAIL.getCode());
		}
	}

	/**
	 * 发送站内信
	 * @param msg
	 */
	protected void sendSite(OperateSendingMsgBO msg) 
	{
		
	}
	
	/**
	 * 
	 * @Desc 发送短信
	 * @param 短信内容
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	protected SendResultBO sendSms(OperateSendingMsgBO msg){
		if(mobMsgSend){
			try 
			{
				if(msg.getCusMobile() == null){
					return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接收用户手机号为空");
				}
				else
				{
					int code = SmsSendUtil.sendSms(msg.getSmsSendChannel(),msg.getCusMobile().toString(), msg.getMsgContent(), null,null,null,null);
					short msgStatus = (MessageStatus.SEND_SUC.getCode().intValue() == code)? MessageStatus.SEND_SUC.getCode():MessageStatus.SEND_FAIL.getCode();
					return new SendResultBO(msgStatus,SmsSendUtil.getCodeMessage(code));
//					msgDaoMapper.updateMsgSendStatus(msg.getMsgBatch(), msg.getUserId(), msg.getSendType(), msgStatus);
				}
			}
			catch (Exception e)
			{
				logger.error("【手机短信通知服务】发生异常：");
				e.printStackTrace();
				return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"处理异常：" + e.getMessage());
//				msgDaoMapper.updateMsgSendStatus(msg.getMsgBatch(), msg.getUserId(), msg.getSendType(), (int)MessageStatus.SEND_FAIL.getCode());
			}
		}
		else
		{
			logger.warn("【手机短信通知服务】发送短信失败，短信发送已关闭");
			return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"短信发送服务已关闭");
//			msgDaoMapper.updateMsgSendStatus(msg.getMsgBatch(), msg.getUserId(), msg.getSendType(),(int)MessageStatus.SEND_FAIL.getCode());
		}
	}
	
	/**
	 * 获取子玩法名称(只支持竞彩)
	 * @param lotChildBOs
	 * @param lotteryChildCode
	 * @return
	 */
	protected String getLotteryChildName(Integer lotteryChildCode){
		LotteryChild child = LotteryChild.valueOf(lotteryChildCode);
		if(child == null){return "";}
		return child.getShortName();
	}
	
	/**
	 * 
	 * @Description 消息用户动态信息
	 * @author HouXiangBao289
	 * @param userInfo
	 * @return
	 */
	protected Map<String,String> getUserVariable(UserInfoBO userInfo){
		NoticeUserInfoBO noticeInfo = new NoticeUserInfoBO(userInfo);
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<userInfoKeys.length;i++){
			map.put(userInfoNames[i], noticeInfo.getValueByName(userInfoKeys[i]));
		}
		return map;
	}
	
	/**
	 * 
	 * @Desc 组装用户发送数据（后台手动发送）
	 * @param bo
	 * @param user
	 */
	protected OperateSendingMsgBO CreateSendMsg(OperateMsgInfoBO vo) 
	{
		OperateSendingMsgBO sendMsgInfo = new OperateSendingMsgBO();
		sendMsgInfo.setTypeId(vo.getTemplateId());
		sendMsgInfo.setMsgTitle(vo.getMsgTitle());
		sendMsgInfo.setMsgContent(vo.getMsgContent());
		sendMsgInfo.setMsgBatch(vo.getMsgBatch());
		sendMsgInfo.setAccountName(vo.getAccountName());
		sendMsgInfo.setNickName(vo.getNickName());
		sendMsgInfo.setCusMobile(vo.getCusMobile());
		sendMsgInfo.setUserId(vo.getUserId());
		if(vo.getSendType() != null)
			sendMsgInfo.setSendType(Short.parseShort(vo.getSendType()));	
		sendMsgInfo.setCusMobile(vo.getCusMobile());
		sendMsgInfo.setAccountName(vo.getAccountName());
		return sendMsgInfo;
	}
	
	protected void sendUserMsg(OperateMsgInfoBO msgInfo){
		OperateSendingMsgBO sendMsg = CreateSendMsg(msgInfo);
		OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateById(msgInfo.getTemplateId());
		if(template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【重新发送服务】" + template.getTypeName() + "模板已禁用！");
			return;
		}
		SendResultBO sendResultBO = null;
		if(SendType.SITE.getCode().toString().equals(msgInfo.getSendType())){
			// 站内信
			logger.info("【重新发送服务】站内信：" + JsonUtil.object2Json(sendMsg));
		}
		else if(SendType.SMS.getCode().toString().equals(msgInfo.getSendType()))
		{
			logger.info("【重新发送服务】手机短信：" + JsonUtil.object2Json(sendMsg));
			sendMsg.setSmsSendChannel(template.getSmsSendChannel().intValue());
			// 手机短信
			sendResultBO = sendSms(sendMsg);
		}
		else if(SendType.APP.getCode().toString().equals(msgInfo.getSendType()))
		{
//			OperateMsgNewBO typeMsg =  msgDaoMapper.findNewMsgByBatch(msgInfo.getMsgBatch());
			sendMsg.setAppFields(msgInfo.getMsgDesc());// APP特有参数值保存title中
			sendMsg.setTypeId(template.getTypeId());
			logger.info("【重新发送服务】APP消息：" + JsonUtil.object2Json(sendMsg));
			sendResultBO = sendApp(sendMsg);
		}
		
		if(sendResultBO != null){
			msgInfoDaoMapper.updateMsgSendStatus(msgInfo.getMsgBatch(), msgInfo.getUserId(), Integer.parseInt(msgInfo.getSendType()), (int)sendResultBO.getCode(),sendResultBO.getMessage());
		}
	}
	
	protected void sendUserMsg(OperateMsgInfoBO msgInfo,OperateMsgTemplateBO template){
		OperateSendingMsgBO sendMsg = CreateSendMsg(msgInfo);
		if(template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【重新发送服务】" + template.getTypeName() + "模板已禁用！");
			return;
		}
		SendResultBO sendResultBO = null;
		if(SendType.SITE.getCode().toString().equals(msgInfo.getSendType())){
			// 站内信
			logger.info("【重新发送服务】站内信：" + JsonUtil.object2Json(sendMsg));
		}
		else if(SendType.SMS.getCode().toString().equals(msgInfo.getSendType()))
		{
			logger.info("【重新发送服务】手机短信：" + JsonUtil.object2Json(sendMsg));
			sendMsg.setSmsSendChannel(template.getSmsSendChannel().intValue());
			// 手机短信
			sendResultBO = sendSms(sendMsg);
		}
		else if(SendType.APP.getCode().toString().equals(msgInfo.getSendType()))
		{
//			OperateMsgNewBO typeMsg =  msgDaoMapper.findNewMsgByBatch(msgInfo.getMsgBatch());
			sendMsg.setAppFields(msgInfo.getMsgDesc());// APP特有参数值保存title中
			sendMsg.setTypeId(template.getTypeId());
			logger.info("【重新发送服务】APP消息：" + JsonUtil.object2Json(sendMsg));
			sendResultBO = sendApp(sendMsg);
		}
		
		if(sendResultBO != null){
			msgInfoDaoMapper.updateMsgSendStatus(msgInfo.getMsgBatch(), msgInfo.getUserId(), Integer.parseInt(msgInfo.getSendType()), (int)sendResultBO.getCode(),sendResultBO.getMessage());
		}
	}
	
	/**
	 * 
	 * @Description 模板消息公共字段数据 
	 * @author HouXiangBao289
	 * @param template
	 * @return
	 */
	protected String getPublicFields(OperateMsgTemplateBO template) {
		return "activityUrl:" + (template.getActivityUrl()==null?"":template.getActivityUrl())  
				+ ";toBuyLotteryCode:" + (template.getToLotteryCode()==null?"":template.getToLotteryCode());
	}
	
	/**
	 * 
	 * @Description 判断是否发送
	 * @author HouXiangBao289
	 * @param noSendChannels
	 * @param userChannelId
	 * @return
	 */
	protected boolean isNoSendChannel(String noSendChannels,String userChannelId){
		if(!StringUtil.isBlank(noSendChannels)){
			noSendChannels = noSendChannels + ",";
			if(noSendChannels.contains(userChannelId + ",")){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description 判断是否发送
	 * @author HouXiangBao289
	 * @param noSendChannels
	 * @param userChannelId
	 * @return
	 */
	protected boolean isNoSendLot(String noSendLots,String lotId){
		if(!StringUtil.isBlank(noSendLots)){
			noSendLots = noSendLots + ",";
			if(noSendLots.contains(lotId + ","))
				return false;
			else
				return true;
		}
		return false;
	}
}
