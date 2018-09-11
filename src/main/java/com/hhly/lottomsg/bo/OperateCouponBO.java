package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

@SuppressWarnings("serial")
public class OperateCouponBO extends BaseBO{
    private Integer id;

    private String redCode;

    private Short redCategory;

    private String activityCode;

    private String operateLotteryId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activeEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date obtainTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date redOverdueTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date useTime;

    private Short redType;

    private String redName;

    private Double redValue;

    private Double redBalance;

    private Integer minSpendAmount;

    private Integer userId;

    private Short ectivityDay;

    private String channelId;

    private String redLabel;

    private Short redStatus;

    private String limitPlatform;

    private String limitLottery;

    private String useRule;

    private String redRemark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    private String modifyBy;

    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String remark;
    
    private Short redSource;
    
    //账号名  
    private String accountName;
    //渠道名
    private String channelName;
    //渠道来源
    private Short terminalPlatform;
    
    /**
     * 限制红包彩种子玩法
     */
    private String limitLotteryChild;

    /**
     * 限制竞技彩种的过关方式
     */
    private String limitLotteryChildType; 
    
    /**
     * 随机红包类型
     */    
    private Short randomRedType;
    
    private Integer noticeStatus;

    /**
     * 
     * @Description 红包过期通知状态
     * @author HouXiangBao289
     * @return
     */
	public Integer getNoticeStatus() {
		return noticeStatus;
	}
	/**
     * 
     * @Description 红包过期通知状态
     * @author HouXiangBao289
     * @return
     */
	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
    
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public Short getRedCategory() {
		return redCategory;
	}

	public void setRedCategory(Short redCategory) {
		this.redCategory = redCategory;
	}

	public String getActivityCode() {
		return activityCode;
	}
	
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	
	public String getOperateLotteryId() {
		return operateLotteryId;
	}

	public void setOperateLotteryId(String operateLotteryId) {
		this.operateLotteryId = operateLotteryId;
	}

	public Date getActiveEndTime() {
		return activeEndTime;
	}

	public void setActiveEndTime(Date activeEndTime) {
		this.activeEndTime = activeEndTime;
	}

	public Date getObtainTime() {
		return obtainTime;
	}

	public void setObtainTime(Date obtainTime) {
		this.obtainTime = obtainTime;
	}

	public Date getRedOverdueTime() {
		return redOverdueTime;
	}

	public void setRedOverdueTime(Date redOverdueTime) {
		this.redOverdueTime = redOverdueTime;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public Short getRedType() {
		return redType;
	}

	public void setRedType(Short redType) {
		this.redType = redType;
	}

	public String getRedName() {
		return redName;
	}

	public void setRedName(String redName) {
		this.redName = redName;
	}

	public Double getRedValue() {
		return redValue;
	}

	public void setRedValue(Double redValue) {
		this.redValue = redValue;
	}

	public Double getRedBalance() {
		return redBalance;
	}

	public void setRedBalance(Double redBalance) {
		this.redBalance = redBalance;
	}

	public Integer getMinSpendAmount() {
		return minSpendAmount;
	}

	public void setMinSpendAmount(Integer minSpendAmount) {
		this.minSpendAmount = minSpendAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getEctivityDay() {
		return ectivityDay;
	}

	public void setEctivityDay(Short ectivityDay) {
		this.ectivityDay = ectivityDay;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getRedLabel() {
		return redLabel;
	}

	public void setRedLabel(String redLabel) {
		this.redLabel = redLabel;
	}

	public Short getRedStatus() {
		return redStatus;
	}

	public void setRedStatus(Short redStatus) {
		this.redStatus = redStatus;
	}

	public String getLimitPlatform() {
		return limitPlatform;
	}

	public void setLimitPlatform(String limitPlatform) {
		this.limitPlatform = limitPlatform;
	}

	public String getLimitLottery() {
		return limitLottery;
	}

	public void setLimitLottery(String limitLottery) {
		this.limitLottery = limitLottery;
	}

	public String getUseRule() {
		return useRule;
	}

	public void setUseRule(String useRule) {
		this.useRule = useRule;
	}

	public String getRedRemark() {
		return redRemark;
	}

	public void setRedRemark(String redRemark) {
		this.redRemark = redRemark;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Short getTerminalPlatform() {
		return terminalPlatform;
	}

	public void setTerminalPlatform(Short terminalPlatform) {
		this.terminalPlatform = terminalPlatform;
	}

	public Short getRedSource() {
		return redSource;
	}

	public void setRedSource(Short redSource) {
		this.redSource = redSource;
	}

	public String getLimitLotteryChild() {
		return limitLotteryChild;
	}

	public void setLimitLotteryChild(String limitLotteryChild) {
		this.limitLotteryChild = limitLotteryChild;
	}

	public String getLimitLotteryChildType() {
		return limitLotteryChildType;
	}

	public void setLimitLotteryChildType(String limitLotteryChildType) {
		this.limitLotteryChildType = limitLotteryChildType;
	}

	public Short getRandomRedType() {
		return randomRedType;
	}

	public void setRandomRedType(Short randomRedType) {
		this.randomRedType = randomRedType;
	}
}