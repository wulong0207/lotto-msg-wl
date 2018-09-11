package com.hhly.lottomsg.entity;

/**
 * 
* @Description: 短信渠道 
* @author HouXiangBao289
* @date 2018年2月6日 下午3:28:16 
* @version V1.0.0
 */
public class SmsChannel {
	
	private String sn;
	private String pwd;
	
	public SmsChannel(){}
	
	public SmsChannel(String sn,String pwd){
		this.sn = sn;
		this.pwd = pwd;
	}
	
	/**
	 * 
	 * @Description 短信渠道账号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getSn() {
		return sn;
	}
	
	/**
	 * 
	 * @Description 短信渠道账号
	 * @author HouXiangBao289
	 * @param sn
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	/**
	 * 
	 * @Description 密码
	 * @author HouXiangBao289
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * 
	 * @Description 密码
	 * @author HouXiangBao289
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
