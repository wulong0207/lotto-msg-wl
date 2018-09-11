package com.hhly.lottomsg.po;

import java.util.Date;

import com.hhly.lottomsg.vo.OperateMsgInfoVO;

/**
 *	@Desc    通知信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:25:36
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
public class OperateMsgInfoPO {
	
    private Integer id;

    private String nickName;

    private String accountName;

    private Long cusMobile;

    private Integer templateId;

    private String templateName;

    private Short sendType;

    private Short status;

    private String sendError;

    private String msgTitle = "";

    private String msgContent;

    private String msgBatch;

    private Date sendTime;

    private Date readTime;

    private String msgDesc;
    
    private Date createTime;
    
    private Date preSendTime;
    
    private String createBy;
    
    private Integer userId;
    
    private Integer msgType;

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

	public OperateMsgInfoPO() {
		
	}

	public OperateMsgInfoPO(OperateMsgInfoVO vo) {
		this.templateId = vo.getTemplateId();
		this.templateName = vo.getTemplateName();
		this.sendType = vo.getSendType();
		this.status = vo.getStatus();
		this.sendError = vo.getSendError();
		this.msgBatch = vo.getMsgBatch();
		this.msgTitle = vo.getMsgTitle();
		this.msgContent = vo.getMsgContent();
		this.userId = vo.getUserId();
		this.createTime = vo.getCreateTime();
		this.msgDesc = vo.getMsgDesc();
		this.createBy = vo.getCreateBy();
		this.preSendTime = vo.getPreSendTime();
		this.sendTime = vo.getSendTime();
		this.accountName = vo.getAccountName();
		this.nickName = vo.getNickName();
		this.cusMobile = vo.getCusMobile();
		this.msgType = vo.getMsgType();
	}
	
	

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMsgBatch() {
		return msgBatch;
	}

	public void setMsgBatch(String msgBatch) {
		this.msgBatch = msgBatch;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
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

	public Date getPreSendTime() {
		return preSendTime;
	}

	public void setPreSendTime(Date preSendTime) {
		this.preSendTime = preSendTime;
	}

}