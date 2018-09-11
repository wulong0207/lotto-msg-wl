package com.hhly.lottomsg.entity;

import java.util.List;

import com.hhly.lottomsg.bo.OperateSendingMsgBO;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

public class NoticeInfo {
		
	private List<OperateMsgInfoPO> noticeInfoList;//保存数据
	private List<OperateSendingMsgBO> sendMsgList;//通知数据
	
	public NoticeInfo(List<OperateMsgInfoPO> noticeInfoList,List<OperateSendingMsgBO> sendMsgList){
		this.noticeInfoList = noticeInfoList;
		this.sendMsgList = sendMsgList;
	}
	
	public List<OperateMsgInfoPO> getNoticeInfoList() {
		return noticeInfoList;
	}
	public void setNoticeInfoList(List<OperateMsgInfoPO> noticeInfoList) {
		this.noticeInfoList = noticeInfoList;
	}
	public List<OperateSendingMsgBO> getSendMsgList() {
		return sendMsgList;
	}
	public void setSendMsgList(List<OperateSendingMsgBO> sendMsgList) {
		this.sendMsgList = sendMsgList;
	}
		
}
