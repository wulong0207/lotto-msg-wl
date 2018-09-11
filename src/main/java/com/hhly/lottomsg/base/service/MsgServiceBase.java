package com.hhly.lottomsg.base.service;

import java.util.List;

import com.hhly.lottomsg.po.OperateMsgInfoPO;

/**
 * 
* @Description:消息接口 
* @author HouXiangBao289
* @date 2017年12月20日 下午2:12:51 
* @version V1.0.0
 */
public interface MsgServiceBase{
	
	/**
	 * 
	 * @Description 批量保存通知信息
	 * @author HouXiangBao289
	 * @param msgInfoList
	 */
	void addMsgInfo(List<OperateMsgInfoPO> msgInfoList);
}
