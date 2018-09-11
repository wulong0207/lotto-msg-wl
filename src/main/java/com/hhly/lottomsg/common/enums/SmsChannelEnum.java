package com.hhly.lottomsg.common.enums;

/**
 * 
* @Description: 短信渠道
* @author HouXiangBao289
* @date 2018年2月7日 上午11:01:22 
* @version V1.0.0
 */
public enum SmsChannelEnum {

	// 开奖号码通知
	VALIDATECODE(1,"验证码渠道"),
	// 购彩提醒
	MARKETING(2,"营销渠道");
		
	SmsChannelEnum(int code,String name){
		this.code = code;
		this.name = name;
	}
	
	private int code;
	private String name;
	
	public static String getNameByCode(int code){
		for(SmsChannelEnum e: SmsChannelEnum.values()){
			if(e.getCode() == code){
				return e.getName();
			}
		}
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
		
}
