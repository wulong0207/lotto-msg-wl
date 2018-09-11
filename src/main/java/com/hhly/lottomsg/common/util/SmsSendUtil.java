package com.hhly.lottomsg.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.common.constants.UserConstants;
import com.hhly.lottomsg.common.enums.MessageStatus;
import com.hhly.lottomsg.entity.SmsChannel;

/**
 * 发送短信工具类
 * @desc
 * @author zhouyang
 * @date 2017年2月14日
 * @company 益彩网络科技公司
 * @version 1.0
 * 修改2017年4月18日17:12:47
 * 
 */
@Component
public class SmsSendUtil {
	
	private static Logger logger = Logger.getLogger(SmsSendUtil.class.getName());
	
	/*
	 * webservice服务器定义
	 */
	private static List<SmsChannel> channelList = new ArrayList<SmsChannel>();

	@Value("${sms_send_channel}")
	public void setSendChannel(String sendChannel) {
		String [] channels = sendChannel.split(";");
		for(int i=0;i<channels.length;i++){
			String channelInfo = channels[i];
			String[] channel = channelInfo.split(":");
			channelList.add(new SmsChannel(channel[0],channel[1]));
		}
	}
	
	/*
	 * 方法名称：getMD5 
	 * 功    能：字符串MD5加密 
	 * 参    数：待转换字符串 
	 * 返 回 值：加密之后字符串
	 */
	public static String getMD5(String sourceStr){
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}


	/*
	 * 方法名称：mdgetSninfo 
	 * 功    能：获取信息
	 * 参    数：sn,pwd(软件序列号，加密密码md5(sn+password))
	 * 
	 */
	public String mdgetSninfo(int channelCode) throws Exception {
		SmsChannel smsChannel = channelList.get(channelCode-1);
		String result = "";
		String soapAction = "http://entinfo.cn/mdgetSninfo";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		xml += "<soap:Body>";
		xml += "<mdgetSninfo xmlns=\"http://entinfo.cn/\">";
		xml += "<sn>" + smsChannel.getSn() + "</sn>";
		xml += "<pwd>" + smsChannel.getPwd() + "</pwd>";
		xml += "<mobile>" + "" + "</mobile>";
		xml += "<content>" + "" + "</content>";
		xml += "<ext>" + "" + "</ext>";
		xml += "<stime>" + "" + "</stime>";
		xml += "<rrid>" + "" + "</rrid>";
		xml += "<msgfmt>" + "" + "</msgfmt>";
		xml += "</mdgetSninfo>";
		xml += "</soap:Body>";
		xml += "</soap:Envelope>";

		URL url;
		ByteArrayOutputStream bout = null;
		OutputStream out = null;
		InputStreamReader isr = null;
		BufferedReader in = null;
		try {
			url = new URL(UserConstants.SMS_SERVICE_URL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			out = httpconn.getOutputStream();
			out.write(b);

			isr = new InputStreamReader(httpconn
					.getInputStream());
			in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern.compile("<mdgetSninfoResult>(.*)</mdgetSninfoResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally {
			if (bout!=null) {
				bout.close();
			}
			if(out!=null){
				out.close();
			}
			if(isr!=null){
				isr.close();
			}
			if(in!=null){
				in.close();
			}
		}
	}

	
	/*
	 * 方法名称：mdgxsend 
	 * 功    能：发送个性短信 
	 * 参    数：mobile,content,ext,stime,rrid,msgfmt(手机号，内容，扩展码，定时时间，唯一标识，内容编码)
	 * 返 回 值：唯一标识，如果不填写rrid将返回系统生成的
	 */
	public String mdgxsend(int channelCode,String mobile, String content, String ext, String stime,
			String rrid, String msgfmt) throws Exception {
		SmsChannel smsChannel = channelList.get(channelCode-1);
		String result = "";
		String soapAction = "http://entinfo.cn/mdgxsend";
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xml.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		xml.append("<soap:Body>");
		xml.append("<mdgxsend xmlns=\"http://entinfo.cn/\">");
		xml.append("<sn>" + smsChannel.getSn() + "</sn>");
		xml.append("<pwd>" + smsChannel.getPwd() + "</pwd>");
		xml.append("<mobile>" + mobile + "</mobile>");
		xml.append("<content>" + content + "</content>");
		xml.append("<ext>" + ext + "</ext>");
		xml.append("<stime>" + stime + "</stime>");
		xml.append("<rrid>" + rrid + "</rrid>");
		xml.append("<msgfmt>" + msgfmt + "</msgfmt>");
		xml.append("</mdgxsend>");
		xml.append("</soap:Body>");
		xml.append("</soap:Envelope>");

		ByteArrayOutputStream bout = null;
		OutputStream out = null;
		InputStreamReader isr = null;
		BufferedReader in = null;
		URL url;
		try {
			url = new URL(UserConstants.SMS_SERVICE_URL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			bout = new ByteArrayOutputStream();
			bout.write(xml.toString().getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			isr = new InputStreamReader(httpconn
					.getInputStream());
			in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern.compile("<mdgxsendResult>(.*)</mdgxsendResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally {
			if (bout!=null) {
				bout.close();
			}
			if(out!=null){
				out.close();
			}
			if(isr!=null){
				isr.close();
			}
			if(in!=null){
				in.close();
			}
		}
	}
	
	
	/*
	 * 方法名称：mdsmssend
	 * 功    能：发送短信 
	 * 参    数：mobile,content,ext,stime,rrid,msgfmt(手机号，内容，扩展码，定时时间，唯一标识，内容编码)
	 * 返 回 值：唯一标识，如果不填写rrid将返回系统生成的
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static String smsSend(int channelCode,String mobile, String content, String ext, String stime,
			String rrid,String msgfmt) throws Exception {
		SmsChannel smsChannel = channelList.get(channelCode-1);
		content = URLEncoder.encode("【2N彩票】" + content);
		ext=ext==null?"":ext;
		stime=stime==null?"":stime;
		rrid=rrid==null?"":rrid;
		msgfmt=msgfmt==null?"":msgfmt;
		
		String result = "";
		String soapAction = "http://entinfo.cn/mdsmssend";
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xml.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		xml.append("<soap:Body>");
		xml.append("<mdsmssend  xmlns=\"http://entinfo.cn/\">");
		xml.append("<sn>" + smsChannel.getSn() + "</sn>");
		xml.append("<pwd>" + smsChannel.getPwd() + "</pwd>");
		xml.append("<mobile>" + mobile + "</mobile>");
		xml.append("<content>" + content + "</content>");
		xml.append("<ext>" + ext + "</ext>");
		xml.append("<stime>" + stime + "</stime>");
		xml.append("<rrid>" + rrid + "</rrid>");
		xml.append("<msgfmt>" + msgfmt + "</msgfmt>");
		xml.append("</mdsmssend>");
		xml.append("</soap:Body>");
		xml.append("</soap:Envelope>");
		
		ByteArrayOutputStream bout = null;
		OutputStream out = null;
		InputStreamReader isr = null;
		BufferedReader in = null;
		URL url;
		try {
			url = new URL(UserConstants.SMS_SERVICE_URL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			bout = new ByteArrayOutputStream();
			bout.write(xml.toString().getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			isr = new InputStreamReader(httpconn
					.getInputStream());
			in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				System.out.println(inputLine);
				Pattern pattern = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally {
			if (bout!=null) {
				bout.close();
			}
			if(out!=null){
				out.close();
			}
			if(isr!=null){
				isr.close();
			}
			if(in!=null){
				in.close();
			}
		}
	}
	
	/**
	 * 
	 * @Description 发送短信(代理请求配置)
	 * @author HouXiangBao289
	 * @param mobile
	 * @param content
	 * @param ext
	 * @param stime
	 * @param rrid
	 * @param msgfmt
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static boolean mdsmssend(int channelCode,String mobile, String content, String ext, String stime,
			String rrid,String msgfmt) throws Exception {
		SmsChannel smsChannel = channelList.get(channelCode-1);
		logger.info("短信发送渠道：" + smsChannel.getSn());
		content = URLEncoder.encode("【2N彩票】" + content);
		ext=ext==null?"":ext;
		stime=stime==null?"":stime;
		rrid=rrid==null?"":rrid;
		msgfmt=msgfmt==null?"":msgfmt;

		String soapAction = "http://entinfo.cn/mdsmssend";
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xml.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		xml.append("<soap:Body>");
		xml.append("<mdsmssend  xmlns=\"http://entinfo.cn/\">");
		xml.append("<sn>" + smsChannel.getSn() + "</sn>");
		xml.append("<pwd>" + smsChannel.getPwd() + "</pwd>");
		xml.append("<mobile>" + mobile + "</mobile>");
		xml.append("<content>" + content + "</content>");
		xml.append("<ext>" + ext + "</ext>");
		xml.append("<stime>" + stime + "</stime>");
		xml.append("<rrid>" + rrid + "</rrid>");
		xml.append("<msgfmt>" + msgfmt + "</msgfmt>");
		xml.append("</mdsmssend>");
		xml.append("</soap:Body>");
		xml.append("</soap:Envelope>");
		
		String contentType = "text/xml; charset=gb2312";
		String charset = "gb2312";
		String rs = HttpUtil.doPostXml(UserConstants.SMS_SERVICE_URL, xml.toString(), soapAction,contentType,charset);
		logger.info("【手机短信发送服务】请求返回" + rs);
		Pattern pattern = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");
		Matcher matcher = pattern.matcher(rs);
		String result = "";
		while (matcher.find()) {
			result = matcher.group(1);
		}
		boolean isOk = false;
		if(result!=""){
			Long resultNum = Long.parseLong(result);
			if(resultNum > 0){
				isOk = true;
			}
		};
		return isOk;
	}
	
	/**
	 * 
	 * @Description 发送短信(代理请求配置)
	 * @author HouXiangBao289
	 * @param mobile
	 * @param content
	 * @param ext
	 * @param stime
	 * @param rrid
	 * @param msgfmt
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static int sendSms(int channelCode,String mobile, String content, String ext, String stime,
			String rrid,String msgfmt) throws Exception {
		SmsChannel smsChannel = channelList.get(channelCode-1);
		logger.info("短信发送渠道：" + smsChannel.getSn());
		content = URLEncoder.encode("【2N彩票】" + content);
		ext=ext==null?"":ext;
		stime=stime==null?"":stime;
		rrid=rrid==null?"":rrid;
		msgfmt=msgfmt==null?"":msgfmt;

		String soapAction = "http://entinfo.cn/mdsmssend";
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xml.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		xml.append("<soap:Body>");
		xml.append("<mdsmssend  xmlns=\"http://entinfo.cn/\">");
		xml.append("<sn>" + smsChannel.getSn() + "</sn>");
		xml.append("<pwd>" + smsChannel.getPwd() + "</pwd>");
		xml.append("<mobile>" + mobile + "</mobile>");
		xml.append("<content>" + content + "</content>");
		xml.append("<ext>" + ext + "</ext>");
		xml.append("<stime>" + stime + "</stime>");
		xml.append("<rrid>" + rrid + "</rrid>");
		xml.append("<msgfmt>" + msgfmt + "</msgfmt>");
		xml.append("</mdsmssend>");
		xml.append("</soap:Body>");
		xml.append("</soap:Envelope>");
		
		String contentType = "text/xml; charset=gb2312";
		String charset = "gb2312";
		String rs = HttpUtil.doPostXml(UserConstants.SMS_SERVICE_URL, xml.toString(), soapAction,contentType,charset);
		logger.info("【手机短信发送服务】请求返回" + rs);
		Pattern pattern = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");
		Matcher matcher = pattern.matcher(rs);
		String result = "";
		while (matcher.find()) {
			result = matcher.group(1);
		}
		if(result != ""){
			Long resultNum = Long.parseLong(result);
			if(resultNum > 0){
				return MessageStatus.SEND_SUC.getCode();// 发送成功
			}else{
				return resultNum.intValue();// 错误码
			}
		}
		return 0;// 返回未知信息
	}
	
	public static String getCodeMessage(int code){
		if(code > 0)return "发送成功";
		switch(code){
			case -2:
				return "帐号/密码不正确";
			case -4:
				return "余额不足支持本次发送";
			case -5:
				return "数据格式错误";
			case -6:
				return "参数有误";
			case -7:
				return "权限受限";
			case -8:
				return "流量控制错误";
			case -9:
				return "扩展码权限错误";
			case -10:
				return "内容长度长";
			case -11:
				return "内部数据库错误";
			case -12:
				return "序列号状态错误";
			case -14:
				return "服务器写文件失败";
			case -17:
				return "没有权限";
			case -19:
				return "禁止同时使用多个接口地址";
			case -20:
				return "相同手机号，相同内容重复提交";
			case -21:
				return "Ip鉴权失败";
			case -22:
				return "Ip鉴权失败";
			case -23:
				return "缓存无此序列号信息";
			case -601:
				return "序列号为空，参数错误";
			case -602:
				return "序列号格式错误，参数错误";
			case -603:
				return "密码为空，参数错误";
			case -604:
				return "手机号码为空，参数错误";
			case -605:
				return "内容为空，参数错误";
			case -606:
				return "ext长度大于9，参数错误";
			case -607:
				return "参数错误 扩展码非数字";
			case -608:
				return "参数错误 定时时间非日期格式";
			case -609:
				return "rrid长度大于18,参数错误 ";
			case -610:
				return "参数错误 rrid非数字";
			case -611:
				return "参数错误 内容编码不符合规范";
			case -623:
				return "手机个数与内容个数不匹配";
			case -624:
				return "扩展个数与手机个数数";
			case -625:
				return "定时时间个数与手机个数数不匹配";
			case -626:
				return "rrid个数与手机个数数不匹配";
		}
		return "未知短信发送返回码";
	}
	
}
