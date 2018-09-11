/**
 * netty-websocketio 事件监听类
 * @date    2017-05-15
 * @author  scott
 * @company 深圳益彩网络
 * 
 */
package com.hhly.lottomsg.rabbitmq.consume;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.entity.JlSpMessageData;

/**
 * 
* @Description:推送竞蓝相关数据处理 
* @author HouXiangBao289
* @date 2017年12月20日 下午2:24:50 
* @version V1.0.0
 */
@Component
public class JlSpEventListener extends BaseEventListener implements DataListener<JlSpMessageData> {
	
	private Map<String, String> extras = null;
	
	public JlSpEventListener(){
		extras = new HashMap<String,String>();
		extras.put("type", "jl_sp");
	}
    
    @Bean(name="basketball_listener")
    MessageListenerAdapter BasketballListenerAdapter(JlSpEventListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveBasketballMessage");
    }
    
    @Bean
   	public Object createBasketBallQueue() {    
   		logger.info("create queue basketball_sp ........................");
   		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
   		return new Queue("basketball_sp",false,false,false,arguments);
   	}
    
    @Override
	public void onData(SocketIOClient socket, JlSpMessageData data, AckRequest ack) throws Exception {
//    	// 接收
//    	// basketball_sp为事件的名称， data为发送的内容
//    	// 创建线程池
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//         public void run() {
//        	 if(basketball_map.size()>0){
//        		 Set<Entry<Integer, JlSpMessageData>> entries = basketball_map.entrySet();
//        		 for (Entry<Integer, JlSpMessageData> data : entries) {  
//        			 
//        			 entries.remove(data);
//                 }
//        	 }
//           }  
//        }, 1, 10, TimeUnit.SECONDS);
    }
    
    @RabbitListener(queues="basketball_sp")
	public void receiveBasketballMessage(Message message) {
		String sp = "";
		try {
			String info = byteToString(message);
			logger.info("推送服务收到竞篮变更SP数据：" + info);
			JlSpMessageData data =JSONObject.parseObject(info, JlSpMessageData.class);
			sp = URLEncoder.encode(JSONArray.toJSONString(data.getList()),"UTF-8").replace("+", "%20");
			if(BaseEventListener.server != null){
				BaseEventListener.server.getBroadcastOperations().sendEvent("getPushBasketballSp", sp);
        	}else{
        		logger.warn("推送服务SocketIOServer为null");
        	}
		} catch (UnsupportedEncodingException e) {
			logger.error("推送服务发生异常：UnsupportedEncodingException");
			e.printStackTrace();
		} catch (Exception e){
			logger.error("推送服务发生异常：");
			e.printStackTrace();
		}

		try {
			if(thirdjoinPush){
				String rsMsg = sendToThirdjoinPush(LotteryEnum.Lottery.BB.getName() + "",sp);
				logger.info("【推送服务】第三方推送返回信息：" + rsMsg);
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("推送服务发生异常：NoSuchAlgorithmException");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("推送服务发生异常：IOException");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			logger.error("推送服务发生异常：URISyntaxException");
			e.printStackTrace();
		}
    	
//		sendToApp(sp,LotteryEnum.Lottery.BB.getName(),extras);
	}

}
