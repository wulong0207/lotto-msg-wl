package com.hhly.lottomsg.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hhly.lottomsg.base.service.NodeMsgServiceBase;
import com.hhly.lottomsg.bo.OperateMsgConfigBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OperateSendingMsgBO;
import com.hhly.lottomsg.bo.SendResultBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.MessageStatus;
import com.hhly.lottomsg.common.enums.OrderEnum.NumberCode;
import com.hhly.lottomsg.common.enums.SendType;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.OrderNoUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

public abstract class NodeMsgServiceBaseImpl extends MsgServiceBaseImpl implements NodeMsgServiceBase{
	
	@Override
	public List<OperateMsgInfoPO> handleSendInfo(OperateMsgTemplateBO template,UserInfoBO user,NodeInfo nodeMsg,
			boolean appLotNotice,boolean isSmsSend,boolean isSend){
		List<OperateMsgInfoPO> msgList = new ArrayList<OperateMsgInfoPO>();
		try{
			if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode()))	
				return null;
			OperateMsgConfigBO userConfig = userMsgConfigMapper.findUserConfig(user.getId(), template.getId());
			String batchCode = OrderNoUtil.getOrderNo(NumberCode.SEND_BATCH);
			
			//用户各端是否通知，默认true
			boolean isUserAPPSend = true;
			boolean isUserSmsSend = true;
			boolean isUserSiteSend = true;
//			boolean isUserWechatSend = true;
			
			if(userConfig != null){
				if(userConfig.getApp().equals(UseStatus.INVALID.getCode()))
					isUserAPPSend = false;
				if(userConfig.getMob().equals(UseStatus.INVALID.getCode()))
					isUserSmsSend = false;
				if(userConfig.getSite().equals(UseStatus.INVALID.getCode()))
					isUserSiteSend = false;
//				if(userConfig.getWechat().equals(UseStatus.INVALID.getCode()))
//					isUserWechatSend = false;
			}

			// 处理APP通知信息发送
			if(appMsgSend && isUserAPPSend && appLotNotice 
					&& template.getAppStatus().equals(UseStatus.VALID.getCode()) && user.getMsgApp().equals(UseStatus.VALID.getCode())){
				OperateMsgInfoPO appInfo = createNodeMsgInfo(template,user,SendType.APP.getCode(),batchCode,nodeMsg);
				OperateSendingMsgBO sendMsgInfo = CreateSendMsg(appInfo);
				sendMsgInfo.setTypeId(template.getTypeId());
				sendMsgInfo.setAppFields(nodeMsg.getAppFieldsData());
				String appNotDisturb = user.getAppNotDisturb();//用户免打扰时间
				if((StringUtil.isBlank(appNotDisturb) || isNotDisturb(appNotDisturb)) && isSend)
				{
					SendResultBO sendResultBO = sendApp(sendMsgInfo);// APP发送
					appInfo.setStatus(sendResultBO.getCode());//更新发送状态
					appInfo.setSendError(sendResultBO.getMessage());
					appInfo.setSendTime(new Date());
				}
				msgList.add(appInfo);
			}
			
			// 处理手机短信发送
			if(mobMsgSend && isSmsSend && isUserSmsSend && user.getMsgMob().equals(UseStatus.VALID.getCode()) 
					&& template.getMobStatus().equals(UseStatus.VALID.getCode())){
				//手机短信
				OperateMsgInfoPO smsInfo = createNodeMsgInfo(template,user,SendType.SMS.getCode(),batchCode,nodeMsg);
				String mobNotDisturb = user.getMobNotDisturb();//用户免打扰时间
				if((StringUtil.isBlank(mobNotDisturb) || isNotDisturb(mobNotDisturb)) && isSend)
				{
					OperateSendingMsgBO sendInfo = CreateSendMsg(smsInfo);
					sendInfo.setSmsSendChannel(template.getSmsSendChannel().intValue());
					SendResultBO sendResultBO = sendSms(sendInfo);
					smsInfo.setStatus(sendResultBO.getCode());
					smsInfo.setSendError(sendResultBO.getMessage());
					smsInfo.setSendTime(new Date());
				}
				msgList.add(smsInfo);
			}
			
			//处理站内信
			if(isUserSiteSend && user.getMsgSite().equals(UseStatus.VALID.getCode()) 
					&& template.getSiteStatus().equals(UseStatus.VALID.getCode())){
				OperateMsgInfoPO siteInfo = createNodeMsgInfo(template,user,SendType.SITE.getCode(),batchCode,nodeMsg);
				siteInfo.setSendTime(new Date());
				msgList.add(siteInfo);
			}
		}
		catch(Exception e){
			logger.error("【节点发送信息处理服务】处理用户" + user.getAccount() + "消息发生异常:");
			e.printStackTrace();
		}
		if(msgList.size() > 0)
			return msgList;
		else
			return null;
	}
	
	/**
	 * 
	 * @Description 组装和处理各节点通知信息入库数据 
	 * @author HouXiangBao289
	 * @param bo 模板
	 * @param user 用户
	 * @param type 发送类型
	 * @param batchCode 批次号
	 * @param nodeData 节点通知数据
	 * @return
	 */
	private OperateMsgInfoPO createNodeMsgInfo(OperateMsgTemplateBO bo,UserInfoBO user,
			Short type,String batchCode,NodeInfo nodeData)
	{
		OperateMsgInfoPO msgInfo = new OperateMsgInfoPO();
		String title = "";
		String content = "";
		
		if(SendType.SITE.getCode().equals(type)){
			// 站内信
			title = bo.getSiteTitle();
			content = bo.getSiteContent();
			msgInfo.setSendType(SendType.SITE.getCode());
			msgInfo.setMsgDesc(nodeData.getAppFieldsData());
		}
		else if(SendType.SMS.getCode().equals(type))
		{
			//手机短信
			content = bo.getMobContent();
			msgInfo.setSendType(SendType.SMS.getCode());
		}
		else if(SendType.APP.getCode().equals(type))
		{
			//APP
			content = bo.getAppContent();
			// 微信公众号特有数据，将保存在备注中
			msgInfo.setMsgDesc(nodeData.getAppFieldsData());
			msgInfo.setSendType(SendType.APP.getCode());
		}
//		else if(SendType.WECHAT.getCode().equals(type))
//		{
//			//微信公众号
//			title = bo.getWechatTitle();
//			content = bo.getHeaderCon() + "&" + bo.getFooterCon();
//			msgInfo.setSendType(SendType.WECHAT.getCode());
//			// 微信公众号特有数据，将保存在备注中
//			msgInfo.setMsgDesc(nodeData.getWechatFieldsData());
//		}
		
		if(!StringUtil.isBlank(title))
		{
			List<String> findList = StringUtil.findStr(title, patter);
			for(String str:findList){
				String data = nodeData.getVariables().get(str);
				title = title.replace(str, data==null?"":data);
			}
		}
		
		if(!StringUtil.isBlank(content))
		{
			List<String> findList = StringUtil.findStr(content, patter);
			for(String str:findList){
				String data = nodeData.getVariables().get(str);
				content = content.replace(str, data==null?"":data);
			}
		}
		
		msgInfo.setMsgTitle(title);
		msgInfo.setMsgContent(content);
		msgInfo.setCreateBy(bo.getCreateBy());
		msgInfo.setMsgBatch(batchCode);
		msgInfo.setTemplateId(bo.getId());
		msgInfo.setAccountName(user.getAccount());
		msgInfo.setNickName(user.getNickname());
		msgInfo.setMsgType(bo.getMsgType());
		if(!StringUtil.isBlank(user.getMobile())){
			msgInfo.setCusMobile(Long.parseLong(user.getMobile()));
		}
		msgInfo.setUserId(user.getId());
		msgInfo.setStatus(MessageStatus.NO_SEND.getCode());
		
		return msgInfo;
	}
	
}
