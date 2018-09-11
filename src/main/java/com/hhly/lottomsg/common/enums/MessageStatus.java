package com.hhly.lottomsg.common.enums;

public enum MessageStatus {
	
	NO_SEND((short)0,"待发送"),
	SEND_SUC((short)1,"发送成功"),
	SEND_FAIL((short)2,"发送失败"),
	CANCEL_SEND((short)3,"取消发送"),
	READ((short)5,"已阅读");
	
	MessageStatus(Short code,String name){
		this.code=code;
		this.name = name;
	}
	
	private Short code;
	private String name;

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
