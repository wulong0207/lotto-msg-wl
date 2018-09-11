package com.hhly.lottomsg.rabbitmq.consume;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.common.enums.SendType;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.entity.SendModel;
import com.hhly.lottomsg.service.ISendService;
/**
 * 
* @Description: 手机短信或邮件发送监听
* @author HouXiangBao289
* @date 2017年6月2日 下午3:40:18 
* @version V1.0.0
 */
@Component
public class SendListenter{
	
	@Autowired
	private ISendService sendService;
	
	protected Logger logger = Logger.getLogger(SendListenter.class.getName());
	
	@Bean
	public Object creteSendQueue() {    
		logger.info("create queue send_queue ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("send_queue",false,false,false,arguments);
	}

	@RabbitListener(queues="send_queue")
	public void onMessage(Message message)
    {
    	// 接收手机短信和邮件内容
		try {
			String strMsg = new String(message.getBody(),"UTF-8");
			logger.info("【发送服务】收到信息：" + strMsg);
			SendModel msg = (SendModel)JsonUtil.json2Object(strMsg, SendModel.class);
			if(msg.getType().equals(SendType.SMS.getCode()))
			{
				// 手机短信
				sendService.doSendSms(msg.getAccount(), msg.getContent());
			}
			else if(msg.getType().equals(SendType.EAMIL.getCode()) && !StringUtil.isBlank(msg.getAccount()))
			{
				//邮件
				sendService.doSendMail(msg.getAccount(), msg.getContent());
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("【发送服务】发送异常：");
			e.printStackTrace();
		}
	}

}
