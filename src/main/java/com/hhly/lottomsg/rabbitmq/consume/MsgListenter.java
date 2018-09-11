package com.hhly.lottomsg.rabbitmq.consume;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.bo.OperateSendBatchBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.entity.MessageModel;
import com.hhly.lottomsg.entity.OperateNodeMsg;
import com.hhly.lottomsg.service.BatchMsgService;
import com.hhly.lottomsg.service.NodeMsgService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* @Description: 消息监听类
* @author HouXiangBao289
* @date 2017年6月2日 下午3:40:18 
* @version V1.0.0
 */
@Component
public class MsgListenter {
	
	@Autowired
	private BatchMsgService batchMsgService;
	
	@Autowired
	private NodeMsgService nodeMsgService;
	
	protected Logger logger = Logger.getLogger(MsgListenter.class.getName());
	
	@Bean
	public Object creteMsgQueue() {    
		logger.info("create queue msg_queue ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("msg_queue",false,false,false,arguments);
	}

	@RabbitListener(queues="msg_queue", containerFactory="rabbitmqContainerFactory")
	public void onMessage(Message message)
    {
    	try
		{
			String strMsg = new String(message.getBody(),"UTF-8");
			logger.info("【通知信息服务】收到信息：" + strMsg);
			MessageModel msg = (MessageModel)JsonUtil.json2Object(strMsg, MessageModel.class);
            if(Constants.MSG_BATCH_SEND.equals(msg.getKey()))
            {
            	// CMS 手动发送消息
            	OperateSendBatchBO msgBatch = (OperateSendBatchBO) JSONObject.toBean(JSONObject.fromObject(msg.getMessage()),
            			OperateSendBatchBO.class);
            	boolean isSend = true;
            	long curDate = new Date().getTime();
        		if(msgBatch.getTime() > curDate)isSend=false;//待发送时间大于当前时间
        		batchMsgService.handleManualSendInfo(msgBatch.getCode(), isSend);
        		if(!isSend){
        			// 添加队列
                	batchMsgService.getQueue().add(msgBatch);
                	logger.info("【通知信息服务】后台手动发送批次号" + msgBatch.getCode() + "已添加到发送队列，队列大小：" + batchMsgService.getQueue().size());
        		}
            }
            else if(Constants.MSG_RESEND.equals(msg.getKey()))
            {
            	//重新发送消息
            	JSONArray msgIds = JSONArray.fromObject(msg.getMessage());
            	for(int i=0;i<msgIds.size();i++)
            	{
            		Integer id = msgIds.getInt(i);
            		batchMsgService.resendCmsMsg(id);
            	}
            }
            else if(Constants.MSG_NODE_RESEND.equals(msg.getKey()))
            {
            	//各执行节点自动发送
            	OperateNodeMsg nodeMsg = (OperateNodeMsg) JSONObject.toBean(JSONObject.fromObject(msg.getMessage()),
            			OperateNodeMsg.class);
            	nodeMsgService.handleNodeMsg(nodeMsg);
            }
            else{
            	logger.warn("【通知信息服务】不支持此信息类型发送！");
            }
        }
		catch(Exception e)
		{
        	logger.error("【通知信息服务】处理异常");
        	e.printStackTrace();
        }
	}

}
