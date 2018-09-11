package com.hhly.lottomsg.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.bo.SendResultBO;
import com.hhly.lottomsg.common.enums.MessageStatus;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.connection.HttpProxy;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
@Component
public class PushUtil {

	private static List<JPushClient> jpushClients =  new ArrayList<JPushClient>();
	
	@Value("${jg_app_key}")
	private void setAppKey(String appKey){
		String [] appKeys = appKey.split(";");
		if ("true".equals(HttpUtil.HTTP_PROXY_ENABLE)) {
			for(String key:appKeys){
				String[] keySecret = key.split(":");
				jpushClients.add(new JPushClient(keySecret[1], keySecret[0],new HttpProxy(HttpUtil.HTTP_PROXYHOST,Integer.parseInt(HttpUtil.HTTP_PROXYPORT)),ClientConfig.getInstance()));	
			}
		}else{
			for(String key:appKeys){
				String[] keySecret = key.split(":");
				jpushClients.add(new JPushClient(keySecret[1], keySecret[0]));
			}
		}
	}
	
	/**
	 *  
	 * @Description 给指定标签用户发自定义透传消息  
	 * @author HouXiangBao289
	 * @param masterSecret
	 * @param appKey
	 * @param message 发送内容
	 * @param tag 标签
	 * @param extras 附加字段
	 * @param isApnsProduction true 生产环境，false 开发环境
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
    public static SendResultBO sendMessageToTagUser(String message,String tag,Map<String, String> extras,boolean isApnsProduction)  
    {  
    	
    	SendResultBO result = null;
    	for(JPushClient jpushClient:jpushClients){
    		if(result == null){
    			try{
    				result = sendMessageToTagUser(jpushClient,message,tag,extras,isApnsProduction);
    			}
				catch (APIConnectionException e){
					e.printStackTrace();
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接口连接异常");
				}
				catch (APIRequestException e){
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),e.getErrorMessage());
				}
    		}
    		else{
    			try{
    				sendMessageToTagUser(jpushClient,message,tag,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){

				}
				catch (APIRequestException e){

				}
    		}
    	}
    	return result;
    }

//    public static void main(String[] args) {
//    	List<String> aliasList = new ArrayList<String>();
//    	aliasList.add("test_453");
//    	Map<String,String> extras = new HashMap<String,String>();
//		Map<String,String> fieldsData = new HashMap<String,String>();
//		fieldsData.put("userId", "453");
//		fieldsData.put("activityUrl", "https://sitm.2ncai.com/hd-recharge.html");
//		fieldsData.put("toBuyLotteryCode", "");
//		extras.put(Constants.APP_MSG_TYPE, "406");
//		extras.put(Constants.APP_MSG_ADD_DATA, JsonUtil.object2Json(fieldsData));
//    	PushUtil.sendAlias("亲爱的helei11，本站有充值送礼活动，快来充值吧！", aliasList,extras,false);
//	}
    
    /**
     * 
     * @Description 给所有平台的用户发自定义透传消息 
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param message 发送内容
     * @param aliasList 发送用户别名
     * @param extras 附加字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendMessageToAllUser(String message,List<String> aliasList,Map<String, String> extras,boolean isApnsProduction)
    {
    	SendResultBO result = null;
    	for(JPushClient jpushClient:jpushClients){
    		if(result == null){
	    		try{
	    			result = sendMessageToAllUser(jpushClient,message,aliasList,extras,isApnsProduction);
		    	}
				catch (APIConnectionException e){
					e.printStackTrace();
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接口连接异常");
				}
				catch (APIRequestException e){
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),e.getErrorMessage());
				}
    		}
    		else{
	    		try{
	    			sendMessageToAllUser(jpushClient,message,aliasList,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){
				}
				catch (APIRequestException e){
				}
    		}
    	}
    	return result;
    }
    
    /**
     * 
     * @Description 客户端 给所有平台的一个或者一组用户发送信息 
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param title 标题
     * @param aliasList 发送用户别名
     * @param extras 附近字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendAlias(String title, List<String> aliasList,Map<String,String> extras,boolean isApnsProduction)  
    {  
    	SendResultBO result = null;
    	for(JPushClient jpushClient:jpushClients){
    		if(result == null){
	    		try{
	    			result = sendAlias(jpushClient,title,aliasList,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){
					e.printStackTrace();
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接口连接异常");
				}
				catch (APIRequestException e){
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),e.getErrorMessage());
				}
    		}
    		else{
	    		try{
	    			sendAlias(jpushClient,title,aliasList,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){
				}
				catch (APIRequestException e){
				}
    		}
    	}
    	return result;
    }
    
    /**
     * 
     * @Description 广播
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param title 标题
     * @param extras 附近字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendAllClient(String title, Map<String,String> extras,boolean isApnsProduction)  
    {  
    	SendResultBO result = null;
    	for(JPushClient jpushClient:jpushClients){
    		if(result == null){
	    		try{
	    			result = sendAll(jpushClient,title,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){
					e.printStackTrace();
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),"接口连接异常");
				}
				catch (APIRequestException e){
					result = new SendResultBO(MessageStatus.SEND_FAIL.getCode(),e.getErrorMessage());
				}
    		}
    		else{
	    		try{
//	    			JPushClient  jpushClient= new JPushClient("0de6b623551b5bedafdc7870", "67576a47932f414f5c15391d");
	    			sendAll(jpushClient,title,extras,isApnsProduction);
	    		}
				catch (APIConnectionException e){
				}
				catch (APIRequestException e){
				}
    		}
    	}
    	return result;
    }
    
	/**
	 *  
	 * @Description 给指定标签用户发自定义透传消息  
	 * @author HouXiangBao289
	 * @param masterSecret
	 * @param appKey
	 * @param message 发送内容
	 * @param tag 标签
	 * @param extras 附加字段
	 * @param isApnsProduction true 生产环境，false 开发环境
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
    public static SendResultBO sendMessageToTagUser(JPushClient jpushClient,String message,String tag,Map<String, String> extras,boolean isApnsProduction) throws APIConnectionException, APIRequestException  
    {  
        PushPayload payload = buildPushObject_tag_Message(message,tag, extras,isApnsProduction);
        PushResult result = jpushClient.sendPush(payload);
        if(result.getResponseCode()==200)
        	return new SendResultBO(MessageStatus.SEND_SUC.getCode(),"");
        else
        	return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),result.getOriginalContent());
    }
	
    /**
     * 
     * @Description 给所有平台的所有用户发自定义透传消息 
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param message 发送内容
     * @param aliasList 发送用户别名
     * @param extras 附加字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendMessageToAllUser(JPushClient jpushClient,String message,List<String> aliasList,Map<String, String> extras,boolean isApnsProduction) throws APIConnectionException, APIRequestException  
    {
        PushPayload payload = buildPushObject_all_alias_Message(message,aliasList, extras,isApnsProduction);
        PushResult result = jpushClient.sendPush(payload);
        if(result.getResponseCode()==200)
        	return new SendResultBO(MessageStatus.SEND_SUC.getCode(),"");
        else
        	return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),result.getOriginalContent());
    }
    
    /**
     * 
     * @Description 客户端 给所有平台的一个或者一组用户发送信息 
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param title 标题
     * @param aliasList 发送用户别名
     * @param extras 附近字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendAlias(JPushClient jpushClient,String title, List<String> aliasList,Map<String,String> extras,boolean isApnsProduction) throws APIConnectionException, APIRequestException  
    {  
        PushPayload payload = allPlatformAndAlias(title, extras, aliasList,isApnsProduction);
        PushResult result = jpushClient.sendPush(payload);
        if(result.getResponseCode()==200)
        	return new SendResultBO(MessageStatus.SEND_SUC.getCode(),"");
        else
        	return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),result.getOriginalContent());
    }
    
    /**
     * 
     * @Description 客户端 给所有平台的一个或者一组用户发送信息 
     * @author HouXiangBao289
     * @param masterSecret
     * @param appKey
     * @param title 标题
     * @param extras 附近字段
     * @param isApnsProduction true 生产环境，false 开发环境
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static SendResultBO sendAll(JPushClient jpushClient,String content, Map<String,String> extras,boolean isApnsProduction) throws APIConnectionException, APIRequestException  
    {  
        PushPayload payload = allPlatform(content, extras,isApnsProduction);
        PushResult result = jpushClient.sendPush(payload);
        if(result.getResponseCode()==200)
        	return new SendResultBO(MessageStatus.SEND_SUC.getCode(),"");
        else
        	return new SendResultBO(MessageStatus.SEND_FAIL.getCode(),result.getOriginalContent());
    }
    
    /** 
     * 发送透传消息 
     * @param message 推送内容
     * @param extras  附加字段
     * @return
     */  
    private static PushPayload buildPushObject_all_alias_Message(String message,  List<String> aliasList,
            Map<String, String> extras,boolean isApnsProduction)  
    {  
    	if(extras == null) extras = new HashMap<String,String>();
        return PushPayload.newBuilder().setPlatform(Platform.all())  
        // 设置平台  
        .setAudience(Audience.alias(aliasList))  
            // 按什么发送 tag alia  
            .setMessage(Message.newBuilder().setMsgContent(message).addExtras(extras).build())  
            //设置ios平台环境  True 表示推送生产环境，False 表示要推送开发环境   默认是开发  
            .setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).setTimeToLive(60).build()).build();
    }
    
    /** 
     * 给指定标签用户发送透传消息 
     * @param message 推送内容
     * @param extras  附加字段
     * @return
     */  
    private static PushPayload buildPushObject_tag_Message(String message, String tag,
            Map<String, String> extras,boolean isApnsProduction)  
    {
    	if(extras == null) extras = new HashMap<String,String>();
        return PushPayload.newBuilder().setPlatform(Platform.all())  
        // 设置平台  
        .setAudience(Audience.tag(tag))
            // 按什么发送 tag alia  
            .setMessage(Message.newBuilder().setMsgContent(message).addExtras(extras).build())  
            //设置ios平台环境  True 表示推送生产环境，False 表示要推送开发环境   默认是开发  
            .setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).setTimeToLive(60).build()).build();
    }
  
    /** 
     * 极光推送：生成向一个或者一组用户发送的通知消息。 
     */  
    private static PushPayload allPlatformAndAlias(String alert, Map<String, String> extras,  
            List<String> aliasList,boolean isApnsProduction)  
    {
    	if(extras == null) extras = new HashMap<String,String>();
        return PushPayload  
                .newBuilder()
                .setPlatform(Platform.all())  
                .setAudience(Audience.alias(aliasList))  
                .setNotification(  
                        Notification  
                                .newBuilder()
                                .setAlert(alert)  
                                .addPlatformNotification(  
                                        AndroidNotification.newBuilder().addExtras(extras).build())  
                                .addPlatformNotification(  
                                        IosNotification.newBuilder().addExtras(extras).build())  
                                .build())  
                .setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).setTimeToLive(60).build()).build();  
    }
    
    /** 
     * 广播方式
     */  
    private static PushPayload allPlatform(String alert, Map<String, String> extras,  boolean isApnsProduction)  
    {
    	if(extras == null) extras = new HashMap<String,String>();
        return PushPayload  
                .newBuilder()
                .setPlatform(Platform.all())  
                .setAudience(Audience.all())  
                .setNotification(  
                        Notification  
                                .newBuilder()
                                .setAlert(alert)  
                                .addPlatformNotification(  
                                        AndroidNotification.newBuilder().addExtras(extras).build())  
                                .addPlatformNotification(  
                                        IosNotification.newBuilder().addExtras(extras).build())  
                                .build())  
                .setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).setTimeToLive(60).build()).build();  
    }
    
}
