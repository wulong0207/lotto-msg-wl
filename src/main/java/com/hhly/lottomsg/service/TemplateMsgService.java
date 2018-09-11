package com.hhly.lottomsg.service;

import com.hhly.lottomsg.bo.OperateMsgTemplateBO;

/**
 * 
* @Description: 处理模板消息发送接口 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:14:43 
* @version V1.0.0
 */
public interface TemplateMsgService{
	
	void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) throws Exception;
}
