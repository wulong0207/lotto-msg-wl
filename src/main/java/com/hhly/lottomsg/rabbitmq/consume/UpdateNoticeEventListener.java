package com.hhly.lottomsg.rabbitmq.consume;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.hhly.lottomsg.common.enums.LotPushMethod;
import com.hhly.lottomsg.entity.UpdateDataNotice;

/**
 * 
* @Description: 彩种数据更新推送处理
* @author HouXiangBao289
* @date 2017年12月20日 下午2:30:53 
* @version V1.0.0
 */
@Component
public class UpdateNoticeEventListener extends BaseEventListener implements DataListener<UpdateDataNotice> {
    
    @Override
	public void onData(SocketIOClient socket, UpdateDataNotice data, AckRequest ack) throws Exception {
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
	public Object creteUpdateNoticeQueue() {    
		logger.info("create queue update_notice ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("update_notice",false,false,false,arguments);
	}
    
    /**
     * 
     * @Description 接收数据 
     * @author HouXiangBao289
     * @param message
     */
    @RabbitListener(queues="update_notice")
    public void receiveUpdateNoticeMessage(Message message) {
    		String info = "";
    		UpdateDataNotice data = null;
			try {
				info = byteToString(message);
				data =JSONObject.parseObject(info, UpdateDataNotice.class);
	        	logger.info("推送服务收到数据更新通知：" + info);
	        	String pushMethod = LotPushMethod.getNameByCode(data.getLotteryCode());
	        	if(pushMethod.length() > 0){
	        		if(UpdateNoticeEventListener.server != null){
	    				UpdateNoticeEventListener.server.getBroadcastOperations().sendEvent(pushMethod, info);
	            	}else{
	            		logger.warn("推送服务SocketIOServer为null");
	            	}
	        	}
			} 
			catch (UnsupportedEncodingException e) {
				logger.error("推送服务发生异常：UnsupportedEncodingException");
				e.printStackTrace();
			}
	    	catch(Exception ex){
	    		logger.error("推送服务发生异常：");
	    		ex.printStackTrace();
	    	}
            
			try {
				if(thirdjoinPush){
					String rsMsg = sendToThirdjoinPush(data.getLotteryCode().toString(), data.getUpdateDataType().toString());
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
            
//       	sendToApp(info,data.getLotteryCode(),null);
 
	}

}
