package com.hhly.lottomsg.vo;

import java.util.Date;

import com.hhly.lottomsg.base.vo.PageVO;
import com.hhly.lottomsg.common.valid.NotNull;

@SuppressWarnings("serial")
public class OperateMsgInfoVO extends PageVO{
	
    @NotNull
	private Integer id;
    
    @NotNull
    private Integer templateId;
    
    @NotNull
    private String templateName;
    
	@NotNull
    private Short sendType;
    
	@NotNull
    private Short status;
    
    private String sendError;

    @NotNull
    private String msgBatch;

    @NotNull
    private Date createTime;
    
    private Date preSendTime;
    private Date sendTime;
    
    private String nickName;
    private String accountName;
    private Long cusMobile;
    
    
    public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
     * 查询条件下拉选项，包括用户昵称、用户账号、手机号，分别对应的值为1,2,3
     */
    private Integer searchUserType;
    
    /**
     * 用户昵称或用户账号或手机号
     */
    private String searchUserInfo;
    
    /**
     * 查询条件下拉选项，包括创建时间、发送时间、阅读时间，分别对应的值为1,2,3
     */
    private Integer searchTimeType;
    
    private Date startTime;
    
    private Date endTime;
    
    private Integer msgType;
    
    private String msgTitle;
    private String msgContent;
    private Integer userId;
    
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

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

    private String msgDesc;
	
	private String createBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Short getSendType() {
		return sendType;
	}

	public void setSendType(Short sendType) {
		this.sendType = sendType;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getSendError() {
		return sendError;
	}

	public void setSendError(String sendError) {
		this.sendError = sendError;
	}

	public String getMsgBatch() {
		return msgBatch;
	}

	public void setMsgBatch(String msgBatch) {
		this.msgBatch = msgBatch;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getSearchUserType() {
		return searchUserType;
	}

	public void setSearchUserType(Integer searchUserType) {
		this.searchUserType = searchUserType;
	}

	public String getSearchUserInfo() {
		return searchUserInfo;
	}

	public void setSearchUserInfo(String searchUserInfo) {
		this.searchUserInfo = searchUserInfo;
	}

	public Integer getSearchTimeType() {
		return searchTimeType;
	}

	public void setSearchTimeType(Integer searchTimeType) {
		this.searchTimeType = searchTimeType;
	}

	public Date getPreSendTime() {
		return preSendTime;
	}

	public void setPreSendTime(Date preSendTime) {
		this.preSendTime = preSendTime;
	}

}