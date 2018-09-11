package com.hhly.lottomsg.service;

import java.util.concurrent.DelayQueue;

import com.hhly.lottomsg.base.service.MsgServiceBase;
import com.hhly.lottomsg.bo.OperateSendBatchBO;

/**
 * @Desc 通知信息服务
 * @Author HouXB
 * @Date 2017年2月24日
 * @Company 益彩网络科技公司
 * @Version 1.0
 */
public interface BatchMsgService extends MsgServiceBase{
	
	/**
	 * 处理通知信息
	 * @Description 
	 * @author HouXiangBao289
	 * @param bo
	 */
	void handleManualSendInfo(String batchCode,boolean isSend)throws Exception;
	
	/**
	 * 
	 * @Description 到了发送时间即发 
	 * @author HouXiangBao289
	 * @param batchCode
	 * @throws Exception
	 */
	void sendManualMsg(String batchCode)throws Exception;

	/**
	 * 重新发送
	 * @Description 
	 * @author HouXiangBao289
	 * @param id
	 */
	void resendCmsMsg(Integer id);
	
	/**
	 * 
	 * @Description 获取队列
	 * @author HouXiangBao289
	 * @return
	 */
	DelayQueue<OperateSendBatchBO> getQueue();
	
	/**
	 * 
	 * @Description 查询未发送信息
	 * @author HouXiangBao289
	 */
	void findNoSendMsgToQueue();
	
	/**
	 * 
	 * @Description 处理待发消息
	 * @author HouXiangBao289
	 * @param templateCode
	 * @throws Exception
	 */
	void sendWaitMsg(Integer templateCode);

}
