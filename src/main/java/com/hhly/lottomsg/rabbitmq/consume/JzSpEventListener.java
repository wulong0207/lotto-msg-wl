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

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.entity.JzSpMessageData;

/**
 * 
* @Description:推送竞足相关数据处理 
* @author HouXiangBao289
* @date 2017年12月20日 下午2:25:42 
* @version V1.0.0
 */
@Component
public class JzSpEventListener extends BaseEventListener implements DataListener<JzSpMessageData> {
	
	private Map<String, String> extras = null;
	
	public JzSpEventListener(){
		extras = new HashMap<String,String>();
		extras.put("type", "jz_sp");
	}

    @Bean(name="football_listener")
    MessageListenerAdapter FootballListenerAdapter(JzSpEventListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveFootballMessage");
    }
    
    @Override
	public void onData(SocketIOClient socket, JzSpMessageData data, AckRequest ack) throws Exception {
    	// basketball_sp为事件的名称， data为发送的内容
		// 创建线程池
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
//         public void run() {
//        	 if(football_map.size()>0){
//        		 Set<Entry<Integer, JzSpMessageData>> entries = football_map.entrySet();
//        		 for (Entry<Integer, JzSpMessageData> data : entries) {
//        			 JzSpEventListener.server.getBroadcastOperations().sendEvent("basketball_sp", data.getValue().getList());
//        			 entries.remove(data);
//                 }
//        	 }
//           }  
//        }, 1, 10, TimeUnit.SECONDS);
    }
    
    @Bean
	public Object creteFootballQueue() {    
		logger.info("create queue football_sp ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("football_sp",false,false,false,arguments);
	}
    
    @RabbitListener(queues="football_sp")
    public void receiveFootballMessage(Message message) {
    	String sp = "";
    	try {
			String info = byteToString(message);
			logger.info("推送服务收到竞足变更SP数据：" + info);
    		JzSpMessageData data = JsonUtil.jsonToJcakObject(info, JzSpMessageData.class);
        	sp = URLEncoder.encode(JsonUtil.objectToJcakJson(data.getList()),"UTF-8").replace("+", "%20");
        	if(BaseEventListener.server != null){
        		BaseEventListener.server.getBroadcastOperations().sendEvent("getPushFootballSp", sp);
        	}else{
        		logger.warn("推送服务SocketIOServer为null");
        	}
        	
		} catch (UnsupportedEncodingException e) {
			logger.error("推送服务发生异常：UnsupportedEncodingException");
			e.printStackTrace();
		}
		catch(Exception e){
			logger.error("推送服务发生异常");
			e.printStackTrace();
		}
		
		try {
			if(thirdjoinPush){
				String rsMsg = sendToThirdjoinPush(LotteryEnum.Lottery.FB.getName() + "",sp);
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
//      sendToApp(sp,LotteryEnum.Lottery.FB.getName(),extras);
	}
    
	/*public static void main(String[] args) throws UnsupportedEncodingException {
		String info = "{\"list\":[{\"id\":23455,\"wdf\":null,\"score\":\"0:0\"},{\"id\":23455,\"wdf\":[\"22.4\",\"23.5\"],\"score\":null}]}";
		System.out.println("推送服务收到竞足变更SP数据：" + info);
		//JzSpMessageData data =JSONObject.parseObject(info, JzSpMessageData.class);
		//String sp = JSONArray.toJSONString(data.getList());
		JzSpMessageData data =JsonUtil.jsonToJcakObject(info, JzSpMessageData.class);
		String sp = JsonUtil.objectToJcakJson(data.getList());
		System.out.println(sp);
	}*/
}
