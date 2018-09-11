package com.hhly.lottomsg.service;

import com.hhly.lottomsg.bo.OperateMsgTemplateBO;

public interface MsgTemplateSerivce {
	
	OperateMsgTemplateBO findMsgTemplateByTypeId(Integer typeId);
	
	/**
	 * 
	 * @Description 发送模板消息
	 * @author HouXiangBao289
	 * @param templateId
	 * @return
	 */
	void sendTemplateMsgs(Integer templateId);
}
