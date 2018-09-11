package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 *	@Desc	   新信息信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:26:07
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
@SuppressWarnings("serial")
public class OperateMsgNewBO extends BaseBO{
    
	private Integer id;

	private Short status;
	
	private Short mobStatus;
	
	private Short siteStatus;
	
	private Short appStatus;
	
	private Short wechatStatus;
	
	private String mobTitle = "";
	
	private String mobContent;
	
	private String siteTitle;
	
	private String siteContent;
	
	private String appTitle;
	
	private String appContent;

    private String createBy;

    private String modifyBy;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    
    private Integer wechatId;
    
    private String wechatTitle;

    private String headerCon;

    private String footerCon;

    private Integer templateId;
    private String msgBatch;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date preSendTime;
    private String sendReason;
    private String remark;
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

	public Date getPreSendTime() {
		return preSendTime;
	}

	public void setPreSendTime(Date preSendTime) {
		this.preSendTime = preSendTime;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getMobStatus() {
		return mobStatus;
	}

	public void setMobStatus(Short mobStatus) {
		this.mobStatus = mobStatus;
	}

	public Short getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(Short siteStatus) {
		this.siteStatus = siteStatus;
	}

	public Short getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Short appStatus) {
		this.appStatus = appStatus;
	}

	public Short getWechatStatus() {
		return wechatStatus;
	}

	public void setWechatStatus(Short wechatStatus) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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