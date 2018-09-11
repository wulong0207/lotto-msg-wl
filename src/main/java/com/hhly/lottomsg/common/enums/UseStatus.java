package com.hhly.lottomsg.common.enums;

public enum UseStatus {
	
	INVALID((short)0,"无效"),
	VALID((short)1,"有效");
	
	UseStatus(Short code,String name){
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
