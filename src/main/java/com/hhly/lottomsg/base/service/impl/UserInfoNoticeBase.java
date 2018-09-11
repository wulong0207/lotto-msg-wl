package com.hhly.lottomsg.base.service.impl;

import java.util.List;

import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

public class UserInfoNoticeBase extends NodeMsgServiceBaseImpl{

	/**
	 * 
	 * @Description 会员信息变更提醒
	 * @author HouXiangBao289
	 * @param data 格式：用户Id
	 * @param template
	 * @throws Exception 
	 */
	protected void userInfoUpdateNotice(OperateMsgTemplateBO template,String[] data) throws Exception {
		if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【通知信息管理】用户信息变更提醒模板未添加或已禁用");
			return;
		}
		UserInfoBO user = userInfoMapper.findUserInfoById(Integer.parseInt(data[0]));
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送会员信息变更提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		NodeInfo nodeInfo = new NodeInfo();
		nodeInfo.setVariables(getUserVariable(user));
		nodeInfo.setAppFieldsData(getPublicFields(template));
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}

}
