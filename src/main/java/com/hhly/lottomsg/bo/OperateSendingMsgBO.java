package com.hhly.lottomsg.bo;

/**
 * 
* @Description: 组装发送信息
* @author HouXiangBao289
* @date 2017年5月25日 下午5:57:28 
* @version V1.0.0
 */
public class OperateSendingMsgBO{

	//id
	private Integer typeId;
	//发送类型(站内信1,手机短信2,APP 3,微信公众号4)
    private Short sendType;
    private String msgBatch;
    private String nickName;
    private String accountName;
    private Long cusMobile;
    private String msgTitle;
    private String msgContent;
    private Integer userId;
    private int smsSendChannel;// 短信发送渠道id

    public int getSmsSendChannel() {
		return smsSendChannel;
	}

	public void setSmsSendChannel(int smsSendChannel) {
		this.smsSendChannel = smsSendChannel;
	}

	private String appFields;

	public String getAppFields() {
		return appFields;
	}

	public void setAppFields(String appFields) {
		this.appFields = appFields;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getCusMobile() {
		return cusMobile;
	}

	public void setCusMobile(Long cusMobile) {
		this.cusMobile = cusMobile;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Short getSendType() {
		return sendType;
	}

	public void setSendType(Short sendType) {
		this.sendType = sendType;
	}

	public String getMsgBatch() {
		return msgBatch;
	}

	public void setMsgBatch(String msgBatch) {
		this.msgBatch = msgBatch;
	}

}