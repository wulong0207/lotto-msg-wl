package com.hhly.lottomsg.vo;

import java.util.Date;

import com.hhly.lottomsg.base.vo.PageVO;
import com.hhly.lottomsg.common.valid.NotNull;

@SuppressWarnings("serial")
public class OperateMsgNewVO extends PageVO{
    
	@NotNull
	private Integer id;
	
	private Integer status;
	
	private Integer mobStatus;
	
	private Integer siteStatus;
	
	private Integer appStatus;
	
	private Integer wechatStatus;
	
	private String mobTitle;
	
	private String mobContent;
	
	private String siteTitle;
	
	private String siteContent;
	
	private String appTitle;
	
	private String appContent;
	
	private String remark;

    private String createBy;

    private String modifyBy;
    
    private Date updateTime;
    
    private Integer wechatId;
    
    private String wechatTitle;

    private String headerCon;

    private String footerCon;
    
    private Date preSendTime;
    private Integer templateId;
    private String msgBatch;
    private String userType;
    private String sendReason;
    
    private Integer searchTimeType;
    private Date startTime;
    private Date endTime;
    private Integer msgType;
    
    private String appFields;
    private String wechatFields;
    
    private Integer toLotteryCode;
	private String activityUrl;

	public Integer getToLotteryCode() {
		return toLotteryCode;
	}

	public void setToLotteryCode(Integer toLotteryCode) {
		this.toLotteryCode = toLotteryCode;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	public String getWechatFields() {
		return wechatFields;
	}

	public void setWechatFields(String wechatFields) {
		this.wechatFields = wechatFields;
	}

	public String getAppFields() {
		return appFields;
	}

	public void setAppFields(String appFields) {
		this.appFields = appFields;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getSearchTimeType() {
		return searchTimeType;
	}

	public void setSearchTimeType(Integer searchTimeType) {
		this.searchTimeType = searchTimeType;
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

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getMsgBatch() {
		return msgBatch;
	}

	public void setMsgBatch(String msgBatch) {
		this.msgBatch = msgBatch;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getSendReason() {
		return sendReason;
	}

	public void setSendReason(String sendReason) {
		this.sendReason = sendReason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getPreSendTime() {
		if(preSendTime==null)preSendTime=new Date();
		return preSendTime;
	}

	public void setPreSendTime(Date preSendTime) {
		this.preSendTime = preSendTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMobStatus() {
		return mobStatus;
	}

	public void setMobStatus(Integer mobStatus) {
		this.mobStatus = mobStatus;
	}

	public Integer getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(Integer siteStatus) {
		this.siteStatus = siteStatus;
	}

	public Integer getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
	}

	public Integer getWechatStatus() {
		return wechatStatus;
	}

	public void setWechatStatus(Integer wechatStatus) {
		this.wechatStatus = wechatStatus;
	}

	public String getMobTitle() {
		return mobTitle;
	}

	public void setMobTitle(String mobTitle) {
		this.mobTitle = mobTitle;
	}

	public String getMobContent() {
		return mobContent;
	}

	public void setMobContent(String mobContent) {
		this.mobContent = mobContent;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getSiteContent() {
		return siteContent;
	}

	public void setSiteContent(String siteContent) {
		this.siteContent = siteContent;
	}

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

	public String getAppContent() {
		return appContent;
	}

	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}



	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getWechatId() {
		return wechatId;
	}

	public void setWechatId(Integer wechatId) {
		this.wechatId = wechatId;
	}

	public String getWechatTitle() {
		return wechatTitle;
	}

	public void setWechatTitle(String wechatTitle) {
		this.wechatTitle = wechatTitle;
	}

	public String getHeaderCon() {
		return headerCon;
	}

	public void setHeaderCon(String headerCon) {
		this.headerCon = headerCon;
	}

	public String getFooterCon() {
		return footerCon;
	}

	public void setFooterCon(String footerCon) {
		this.footerCon = footerCon;
	}
    
}