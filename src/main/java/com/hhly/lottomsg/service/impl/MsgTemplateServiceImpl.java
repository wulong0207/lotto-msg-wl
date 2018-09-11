package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.MsgServiceBaseImpl;
import com.hhly.lottomsg.bo.OperateMsgInfoBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.service.MsgTemplateSerivce;

/**
 * 
* @Description: 信息模板业务处理
* @author HouXiangBao289
* @date 2017年6月19日 上午11:55:05 
* @version V1.0.0
 */
@Service("msgTemplateSerivce")
public class MsgTemplateServiceImpl extends MsgServiceBaseImpl implements MsgTemplateSerivce {
	
	@Override
	public OperateMsgTemplateBO findMsgTemplateByTypeId(Integer typeId) {
		return msgTemplateMapper.findMsgTemplateByTypeId(typeId);
	}

	@Override
	public void sendTemplateMsgs(Integer templateTypeId) {
		List<OperateMsgInfoBO> list = null;
		OperateMsgTemplateBO bo = msgTemplateMapper.findMsgTemplateByTypeId(templateTypeId);
		if(bo != null){
			list = msgInfoDaoMapper.findMsgsByTemplate(bo.getId());
			for(OperateMsgInfoBO msgInfo:list){
				sendUserMsg(msgInfo,bo);
			}
		}
	}

}
