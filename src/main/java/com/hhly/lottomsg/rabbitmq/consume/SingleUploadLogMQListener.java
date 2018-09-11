package com.hhly.lottomsg.rabbitmq.consume;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.entity.SingleUploadLogMsgModel;
import com.hhly.lottomsg.po.SingleUploadLogPO;
import com.hhly.lottomsg.service.SingleUploadLogService;
@Component("singleUploadLogMQListener")
public class SingleUploadLogMQListener{

	private Logger logger = LoggerFactory.getLogger(SingleUploadLogMQListener.class);
	
	@Resource
	private SingleUploadLogService singleUploadLogService;
	
	@Bean
	public Object creteSingleUploadLogQueue() {    
		logger.info("create queue single_upload_log_queue ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("single_upload_log_queue",false,false,false,arguments);
	}
	
	@RabbitListener(queues="single_upload_log_queue")
	public void onMessage(Message message) {
		try {
			String msg = new String(message.getBody(),"UTF-8");
			logger.info("MQ[单式上传日志 queue收到消息]:" + msg);
			SingleUploadLogMsgModel msgModel = (SingleUploadLogMsgModel)JsonUtil.json2Object(msg, SingleUploadLogMsgModel.class);
			SingleUploadLogPO singleUploadLogPO = new SingleUploadLogPO();
			BeanUtils.copyProperties(msgModel, singleUploadLogPO);
			singleUploadLogService.insert(singleUploadLogPO);
		} catch (UnsupportedEncodingException e) {
			logger.error("MQ[单式上传日志 ],入库失败！ 原因：" + e);
		}
	}

}
