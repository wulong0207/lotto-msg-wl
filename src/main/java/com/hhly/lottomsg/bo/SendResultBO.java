package com.hhly.lottomsg.bo;

public class SendResultBO {
	private Short code;
	private String message;
	
	public SendResultBO(){}
	
	public SendResultBO(Short code,String message){
		this.code = code;
		this.message = message;
	}
	
	public Short getCode() {
		return code;
	}
	public void setCode(Short code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
