package com.hhly.lottomsg.service;

import com.hhly.lottomsg.base.service.NodeMsgServiceBase;
import com.hhly.lottomsg.entity.OperateNodeMsg;

public interface NodeMsgService extends NodeMsgServiceBase{
	/**
	 * 处理各节点通知
	 * @Description 
	 * @author HouXiangBao289
	 * @param nodeMsg
	 */
	void handleNodeMsg(OperateNodeMsg nodeMsg) throws Exception;
	
}
