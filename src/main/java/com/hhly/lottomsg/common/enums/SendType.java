package com.hhly.lottomsg.common.enums;

public enum SendType {
	
	SITE((short)1,"站内信"),
	SMS((short)2,"手机短信"),
	APP((short)3,"APP"),
	WECHAT((short)4,"微信公众号"),
	EAMIL((short)5,"邮件");
	
	SendType(Short code,String name){
		this.code = code;
		this.name = name;
	}
	
	private Short code;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}
	
	
}
