package com.hhly.lottomsg.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhly.lottomsg.bo.OperateSendingMsgBO;

public class Message {
	private int type;
	private List<OperateSendingMsgBO> data;
	
	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date sendtime;
	
	
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<OperateSendingMsgBO> getData() {
		return data;
	}
	public void setData(List<OperateSendingMsgBO> data) {
		this.data = data;
	}

}
