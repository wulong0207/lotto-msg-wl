package com.hhly.lottomsg.common.enums;

public enum SendStatus {
	
	NO_SEND((short)0,"待发送"),
	SENDING((short)1,"发送中"),
	SEND_SUC((short)2,"发送成功"),
	CANCEL_SEND((short)3,"取消发送");
	
	SendStatus(Short code,String name){
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
