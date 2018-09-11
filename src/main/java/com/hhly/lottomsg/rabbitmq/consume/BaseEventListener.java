package com.hhly.lottomsg.rabbitmq.consume;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Value;

import com.corundumstudio.socketio.SocketIOServer;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.util.HttpUtil;
import com.hhly.lottomsg.common.util.Md5EncryptSign;
import com.hhly.lottomsg.common.util.PushUtil;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import net.sf.json.JSONObject;
/**
 * 
* @Description: 推送业务数据处理
* @author HouXiangBao289
* @date 2017年12月20日 下午2:22:50 
* @version V1.0.0
 */
public class BaseEventListener {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static SocketIOServer server = null;
	
	@Value("${environment_id}")
	protected String environmentId;  
	
	@Value("${app_msg_send}")
	protected boolean appMsgSend;
	
	@Value("${send_msg_url}")
	protected String sendMsgUrl;// 第三方推送地址
	
	@Value("${company_code}")
	protected String companyCode;// 公司代码
	
	@Value("${app_key}")
	protected String appKey;
	
	@Value("${app_secret}")
	protected String appSecret;//秘钥
	
	@Value("${thirdjoin_push}")
	protected boolean thirdjoinPush;//推送开关
	
	@Value("${is_apns_production}")
	public boolean isApnsProduction;
	
//	/**  线程池  默认线程为机器CPU核素*2 **/
//	private  static final ScheduledExecutorService scheduledThreadPool = 
//			Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	
//	public void setServer(final SocketIOServer server) {
//		BaseEventListener.server = server;
//    }

	public String getProductionKey() {
		String productionKey = isApnsProduction?"":"test_";
		return productionKey;
	}
	
	public String byteToString(Message content) throws UnsupportedEncodingException{
		return new String(content.getBody(),"utf-8").toString();
	}
	
	// 推送
	public void sendToApp(String info,int lotId,Map<String, String> extras) throws APIConnectionException, APIRequestException{
		if(appMsgSend){
			PushUtil.sendMessageToTagUser(info,getProductionKey() + lotId, extras,isApnsProduction);
		}
	}
	
	/**
	 * 
	 * @Description 对接第三方推送 
	 * @author HouXiangBao289
	 * @param topic
	 * @param content
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws NoSuchAlgorithmException
	 */
	public String sendToThirdjoinPush(String topic,String content) throws IOException, URISyntaxException, NoSuchAlgorithmException{
		topic = appKey+"/"+ environmentId + topic;
		
		SortedMap<String, Object> parameterMap = new TreeMap<>();
		parameterMap.put("appKey", appKey);
		parameterMap.put("userId", Constants.THIRD_PUSH_USERID);
		parameterMap.put("targetId", topic);
		parameterMap.put("chatType", Constants.CHATTYPE);
		parameterMap.put("content", content);
		String sign = Md5EncryptSign.createSign(Constants.CHARACTER_ENCODING,parameterMap,appSecret);
		
		JSONObject paramMap = new JSONObject();
		paramMap.put("userId", Constants.THIRD_PUSH_USERID);
		paramMap.put("targetId", topic);
		paramMap.put("chatType", Constants.CHATTYPE);
		paramMap.put("content", content);
		paramMap.put("sign", sign);
		String url = sendMsgUrl.replace("{companyCode}", companyCode).replace("{appKey}", appKey);
		String params = paramMap.toString();
//		logger.info("【推送服务】请求第三方推送接口数据：" + params);
		String result = HttpUtil.doPost(url, params);
		return result;
	}
	
//	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//			List<JczqTrendSpBO> list = new ArrayList<JczqTrendSpBO>();
//			JczqTrendSpBO b = new JczqTrendSpBO();
//			b.setId(Long.parseLong("126805"));
//			b.setWdf(new String[]{"2.99",
//						"2.99",
//						"2.99",
//		                "-1",
//		                "2.99",
//		                "2.99",
//		                "2.99"});
//			JczqTrendSpBO b1 = new JczqTrendSpBO();
//			b1.setId(Long.parseLong("125837"));
//			b1.setWdf(new String[]{"2.88",
//						"2.88",
//						"2.88",
//		                "1",
//		                "2.88",
//		                "2.88",
//		                "2.88"});
//			list.add(b);
//			list.add(b1);
////			String content = URLEncoder.encode(JSONArray.toJSONString(list),"UTF-8").replace("+", "%20");
//			String content = "[{\"id\":126805,\"ws\":{\"win\":[\"4.30\",\"3.35\",\"4.75\",\"7.70\",\"13.00\",\"14.00\",\"2017-10-20 08:23:38\"],\"lost\":[\"5.90\",\"7.45\",\"13.50\",\"32.00\",\"60.00\",\"75.00\",\"2017-10-20 08:23:38\"]},\"bs\":[\"211.5\",\"1.75\",\"1.75\",\"2017-10-20 13:21:21\"],\"wf\":[\"1.22\",\"3.03\",\"2017-10-20 13:58:09\",\"-6.5\",\"1.75\",\"1.75\",\"2017-10-20 08:23:38\"]},{\"id\":21869,\"ws\":{\"win\":[\"4.60\",\"5.20\",\"10.00\",\"21.00\",\"36.00\",\"50.00\",\"2017-10-20 11:49:45\"],\"lost\":[\"4.00\",\"3.85\",\"6.10\",\"11.00\",\"21.00\",\"24.00\",\"2017-10-20 11:49:45\"]},\"bs\":[\"210.5\",\"1.70\",\"1.80\",\"2017-10-20 12:21:37\"],\"wf\":[\"2.36\",\"1.38\",\"2017-10-20 11:49:32\",\"4.5\",\"1.75\",\"1.75\",\"2017-10-20 11:49:24\"]},{\"id\":21870,\"ws\":{\"win\":[\"4.05\",\"3.45\",\"4.25\",\"6.20\",\"9.50\",\"10.00\",\"2017-10-19 15:30:25\"],\"lost\":[\"7.30\",\"10.50\",\"22.00\",\"40.00\",\"100.00\",\"120.00\",\"2017-10-19 15:30:25\"]},\"bs\":[\"154.5\",\"1.75\",\"1.75\",\"2017-10-18 21:11:48\"],\"wf\":[\"1.12\",\"3.90\",\"2017-10-19 15:30:19\",\"-8.5\",\"1.75\",\"1.75\",\"2017-10-19 15:30:12\"]},{\"id\":21871,\"ws\":{\"win\":[\"5.90\",\"8.30\",\"15.00\",\"32.00\",\"70.00\",\"90.00\",\"2017-10-18 21:11:48\"],\"lost\":[\"3.80\",\"3.50\",\"4.90\",\"7.35\",\"12.00\",\"13.50\",\"2017-10-18 21:11:48\"]},\"bs\":[\"153.5\",\"1.70\",\"1.80\",\"2017-10-20 08:36:01\"],\"wf\":[\"3.00\",\"1.23\",\"2017-10-18 21:11:49\",\"6.5\",\"1.75\",\"1.75\",\"2017-10-18 21:11:49\"]},{\"id\":21872,\"ws\":{\"win\":[\"3.95\",\"3.40\",\"4.50\",\"6.70\",\"10.50\",\"11.50\",\"2017-10-19 22:30:41\"],\"lost\":[\"6.70\",\"9.50\",\"19.00\",\"35.00\",\"80.00\",\"100.00\",\"2017-10-19 22:30:41\"]},\"bs\":[\"143.5\",\"1.70\",\"1.80\",\"2017-10-18 21:11:49\"],\"wf\":[\"1.17\",\"3.40\",\"2017-10-19 22:29:59\",\"-7.5\",\"1.75\",\"1.75\",\"2017-10-19 22:29:51\"]},{\"id\":21873,\"ws\":{\"win\":[\"3.75\",\"3.55\",\"5.10\",\"7.70\",\"13.00\",\"15.00\",\"2017-10-19 20:37:01\"],\"lost\":[\"5.55\",\"7.70\",\"14.00\",\"30.00\",\"67.00\",\"85.00\",\"2017-10-19 20:37:01\"]},\"bs\":[\"155.5\",\"1.70\",\"1.80\",\"2017-10-18 21:11:49\"],\"wf\":[\"1.26\",\"2.82\",\"2017-10-19 20:36:49\",\"-5.5\",\"1.69\",\"1.81\",\"2017-10-19 20:36:36\"]},{\"id\":21874,\"ws\":{\"win\":[\"4.75\",\"5.45\",\"10.50\",\"22.00\",\"39.00\",\"52.00\",\"2017-10-20 09:36:02\"],\"lost\":[\"4.05\",\"3.75\",\"5.80\",\"10.50\",\"19.50\",\"22.00\",\"2017-10-20 09:36:02\"]},\"bs\":[\"225.5\",\"1.75\",\"1.75\",\"2017-10-20 08:23:37\"],\"wf\":[\"2.60\",\"1.31\",\"2017-10-20 13:20:59\",\"5.5\",\"1.75\",\"1.75\",\"2017-10-20 13:20:06\"]},{\"id\":21875,\"ws\":{\"win\":[\"4.15\",\"4.35\",\"8.35\",\"16.00\",\"30.00\",\"38.00\",\"2017-10-20 13:11:25\"],\"lost\":[\"4.05\",\"4.20\",\"7.80\",\"15.00\",\"27.00\",\"34.00\",\"2017-10-20 13:11:25\"]},\"bs\":[\"216.5\",\"1.70\",\"1.80\",\"2017-10-20 08:23:38\"],\"wf\":[\"1.88\",\"1.62\",\"2017-10-20 13:42:25\",\"1.5\",\"1.75\",\"1.75\",\"2017-10-20 13:23:09\"]},{\"id\":21876,\"ws\":{\"win\":[\"4.20\",\"3.50\",\"5.15\",\"8.50\",\"15.50\",\"17.00\",\"2017-10-20 08:23:38\"],\"lost\":[\"5.25\",\"6.45\",\"12.00\",\"28.00\",\"50.00\",\"65.00\",\"2017-10-20 08:23:38\"]},\"bs\":[\"203.5\",\"1.70\",\"1.80\",\"2017-10-20 13:37:23\"],\"wf\":[\"1.31\",\"2.60\",\"2017-10-20 08:23:38\",\"-5.5\",\"1.75\",\"1.75\",\"2017-10-20 08:23:38\"]},{\"id\":21879,\"ws\":{\"win\":[\"4.20\",\"3.50\",\"5.15\",\"8.50\",\"15.50\",\"17.00\",\"2017-10-20 08:23:39\"],\"lost\":[\"5.25\",\"6.45\",\"12.00\",\"28.00\",\"50.00\",\"65.00\",\"2017-10-20 08:23:39\"]},\"bs\":[\"202.5\",\"1.80\",\"1.70\",\"2017-10-20 08:23:39\"],\"wf\":[\"1.27\",\"2.76\",\"2017-10-20 13:29:10\",\"-6.5\",\"1.75\",\"1.75\",\"2017-10-20 13:47:13\"]},{\"id\":21881,\"ws\":{\"win\":[\"3.90\",\"4.00\",\"6.90\",\"12.50\",\"24.00\",\"28.00\",\"2017-10-20 13:00:14\"],\"lost\":[\"4.45\",\"4.75\",\"9.25\",\"19.00\",\"33.00\",\"45.00\",\"2017-10-20 13:00:14\"]},\"bs\":[\"220.5\",\"1.75\",\"1.75\",\"2017-10-20 11:49:54\"],\"wf\":[\"1.54\",\"2.00\",\"2017-10-20 12:59:55\",\"-2.5\",\"1.75\",\"1.75\",\"2017-10-20 12:59:40\"]}]";
//			content = URLEncoder.encode(content,"UTF-8").replace("+", "%20");
//			JSONObject paramMap = new JSONObject();
//			String topic = "301";
//			String appKey = "1011100000000000007101152";
//			String sendMsgUrl = "http://www.71ant.com/thirdjoin/core/ticket/{companyCode}/{appKey}/message/push";
//			String companyCode ="1011100000000000007";
//			String appSecret = "91bc26ca5ffa52def5e9e84f03de6405";
//			paramMap.put("targetId", "topic");
//			topic = appKey+"/test_"+topic;
//			paramMap.put("topic", topic);
//			paramMap.put("chatType", "4");
//			paramMap.put("content", content);
//			String sign = MD5Util.EncoderByMd5("appKey=" + appKey + "&chatType=4&content=" + content + "&targetId=topic&topic=" + topic + "&appSecret=" + appSecret);
//			paramMap.put("sign", sign);
//			String url = sendMsgUrl.replace("{companyCode}", companyCode).replace("{appKey}", appKey);
//			String params = paramMap.toString();
//			System.out.println("url：" + url);
//			System.out.println("请求参数："+params);
//			String result;
//			try {
//				result = HttpUtil.doPost(url, params);
//				System.out.println("result："+result);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (URISyntaxException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	
}
