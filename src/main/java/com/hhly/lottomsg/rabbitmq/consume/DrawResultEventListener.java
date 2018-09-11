/**
 * netty-websocketio 事件监听类
 * @date    2017-05-15
 * @author  scott
 * @company 深圳益彩网络
 * 
 */
package com.hhly.lottomsg.rabbitmq.consume;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.hhly.lottomsg.bo.IssueLottBO;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.entity.DrawResultData;

/**
 * 
* @Description: 推送各彩种变更开奖结果处理 
* @author HouXiangBao289
* @date 2017年7月10日 上午10:13:28 
* @version V1.0.0
 */
@Component
public class DrawResultEventListener extends BaseEventListener implements DataListener<DrawResultData> {
	
	@Bean
	public Object createDrawResultQueue() {    
		logger.info("create queue draw_result ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("draw_result",false,false,false,arguments);
	}

    @Bean(name="drawResult_listener")
    MessageListenerAdapter drawResultListenerAdapter(DrawResultEventListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveDrawResultMessage");
    }
    
    @Override
	public void onData(SocketIOClient socket, DrawResultData data, AckRequest ack) throws Exception {
    	//接收
    }
    
   
    
    @RabbitListener(queues="draw_result")
    public void receiveDrawResultMessage(Message message) {
    	try
    	{
    		String jsonStr = byteToString(message);
        	DrawResultData data = JSONObject.parseObject(jsonStr, DrawResultData.class);
        	//开奖时间格式化
            String drawResult = JsonUtil.objectToJcakJson(data.getList());
            logger.info("推送服务收到消息：" + drawResult);
            drawResult = URLEncoder.encode(drawResult,"UTF-8").replace("+", "%20");
            if(BaseEventListener.server != null){
            	BaseEventListener.server.getBroadcastOperations().sendEvent("getPushDrawResult", drawResult);
        	}else{
        		logger.warn("推送服务SocketIOServer为null");
        	}
            
    		for(IssueLottBO bo:data.getList()){
    			logger.info("彩种变更开奖结果，彩种：" + bo.getLotteryName() + " 彩期：" + bo.getIssueCode() + " 开奖结果：" + bo.getDrawCode() + " 已推送");	
    		}
       	}
    	catch(Exception ex)
    	{
    		 logger.error("推送服务发生异常：");
    		 ex.printStackTrace();
    	}
    	
	}
}

