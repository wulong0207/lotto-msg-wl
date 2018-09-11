package com.hhly.lottomsg.rabbitmq.consume;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.common.util.ObjectUtil;
import com.hhly.lottomsg.service.CopyOrderService;
import com.hhly.lottomsg.vo.CopyOrderMsgModel;

/**
 * 抄单相关消息处理-发单，跟单出票成功和开奖成功处理
 */
@Component
public class CopyOrderMQListener{

	private Logger logger = LoggerFactory.getLogger(CopyOrderMQListener.class);
	
	@Resource
	private CopyOrderService copyOrderService;
	
	@Bean
	public Object createCopyOrderQueue() {    
		logger.info("create queue copy_order_queue ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("copy_order_queue",false,false,false,arguments);
	}
	
	@RabbitListener(queues="copy_order_queue")
	public void onMessage(Message message) {
		try {
			String msg = new String(message.getBody(),"UTF-8");
			logger.info("MQ[抄单queue收到消息]:" + msg);
			CopyOrderMsgModel msgModel = (CopyOrderMsgModel)JsonUtil.json2Object(msg, CopyOrderMsgModel.class);
			if(ObjectUtil.isBlank(msgModel) || ObjectUtil.isBlank(msgModel.getType()) || ObjectUtil.isBlank(msgModel.getOrderCodeStr())){
				logger.error("MQ[抄单消息不处理！ 入参]："+msg);
				return;
			}
			copyOrderService.execute(msgModel);
		} catch (Exception e) {
			logger.error("MQ[处理抄单消息失败！ 原因]：" + e);
		}
	}

}
