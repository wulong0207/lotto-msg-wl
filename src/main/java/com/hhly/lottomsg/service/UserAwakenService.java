package com.hhly.lottomsg.service;

public interface UserAwakenService {

	/**
	 * 
	 * @Description 处理用户唤醒消息
	 * @author HouXiangBao289
	 * @param vo
	 */
	void handleUserAwakenMsg(Integer templateCode)  throws Exception;
	
}
