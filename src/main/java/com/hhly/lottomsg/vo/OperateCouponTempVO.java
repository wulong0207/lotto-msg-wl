package com.hhly.lottomsg.vo;


import java.util.Date;

import com.hhly.lottomsg.base.vo.BaseVO;

@SuppressWarnings("serial")
public class OperateCouponTempVO extends BaseVO{
    /**
     * 
     */
    private Integer id;

    /**
     * 关联配置表id
     */
    private Integer configId;
    /**
     * 活动编号
     */
    private String activityCode;
    /**
     * 关联类型，1：活动配置(对应表operate_activity_config)；2：唤醒模板红包配置;3：活动规则（对应表operate_activity_rule）
     */
    private Short configType;
    /**
     * 红包类型
     */
    private Short redType;

    /**
     * 红包状态
     */
    private Short redStatus;

    /**
     * 红包面额
     */
    private Double redValue;

    /**
     * 最低消费金额
     */
    private Double minSpendAmount;

    /**
     * 有效天数
     */
    private Short ectivityDay;

    /**
     * 激活时间
     */
    private Short activeEndTime;

    /**
     * 限制平台
     */
    private String limitPlatform;

    /**
     * 限制竞技彩种的过关方式
     */
    private String limitLotteryChildType;

    /**
     * 生成数量
     */
    private Integer limitNum;

    /**
     * 红包标签
     */
    private String redLabel;

    /**
     * 关联彩种运营管理ID，list
     */
    private String operateLotteryId;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String modifyBy;

    /**
     * 
     */
    private String createBy;

    /**
     * 可用渠道
     */
    private String channelId;

    /**
     * 限制彩种
     */
    private String limitLottery;

    /**
     * 限制彩种子玩法
     */
    private String limitLotteryChild;
    
    private String redName;
    
    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRedName() {
		return redName;
	}

	public void setRedName(String redName) {
		this.redName = redName;
	}



    /**
     * 红包类型
     * @return red_type 红包类型
     */
    public Short getRedType() {
        return redType;
    }

    /**
     * 红包类型
     * @param redType 红包类型
     */
    public void setRedType(Short redType) {
        this.redType = redType;
    }

    /**
     * 红包状态
     * @return red_status 红包状态
     */
    public Short getRedStatus() {
        return redStatus;
    }

    /**
     * 红包状态
     * @param redStatus 红包状态
     */
    public void setRedStatus(Short redStatus) {
        this.redStatus = redStatus;
    }

    /**
     * 红包面额
     * @return red_value 红包面额
     */
    public Double getRedValue() {
        return redValue;
    }

    /**
     * 红包面额
     * @param redValue 红包面额
     */
    public void setRedValue(Double redValue) {
        this.redValue = redValue;
    }

    /**
     * 最低消费金额
     * @return min_spend_amount 最低消费金额
     */
    public Double getMinSpendAmount() {
        return minSpendAmount;
    }

    /**
     * 最低消费金额
     * @param minSpendAmount 最低消费金额
     */
    public void setMinSpendAmount(Double minSpendAmount) {
        this.minSpendAmount = minSpendAmount;
    }

    /**
     * 有效天数
     * @return ectivity_day 有效天数
     */
    public Short getEctivityDay() {
        return ectivityDay;
    }

    /**
     * 有效天数
     * @param ectivityDay 有效天数
     */
    public void setEctivityDay(Short ectivityDay) {
        this.ectivityDay = ectivityDay;
    }

    /**
     * 激活时间
     * @return active_end_time 激活时间
     */
    public Short getActiveEndTime() {
        return activeEndTime;
    }

    /**
     * 激活时间
     * @param activeEndTime 激活时间
     */
    public void setActiveEndTime(Short activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    /**
     * 限制平台
     * @return limit_platform 限制平台
     */
    public String getLimitPlatform() {
        return limitPlatform;
    }

    /**
     * 限制平台
     * @param limitPlatform 限制平台
     */
    public void setLimitPlatform(String limitPlatform) {
        this.limitPlatform = limitPlatform == null ? null : limitPlatform.trim();
    }

    /**
     * 限制竞技彩种的过关方式
     * @return limit_lottery_child_type 限制竞技彩种的过关方式
     */
    public String getLimitLotteryChildType() {
        return limitLotteryChildType;
    }

    /**
     * 限制竞技彩种的过关方式
     * @param limitLotteryChildType 限制竞技彩种的过关方式
     */
    public void setLimitLotteryChildType(String limitLotteryChildType) {
        this.limitLotteryChildType = limitLotteryChildType == null ? null : limitLotteryChildType.trim();
    }

    /**
     * 生成数量
     * @return limit_num 生成数量
     */
    public Integer getLimitNum() {
        return limitNum;
    }

    /**
     * 生成数量
     * @param limitNum 生成数量
     */
    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    /**
     * 红包标签
     * @return red_label 红包标签
     */
    public String getRedLabel() {
        return redLabel;
    }

    /**
     * 红包标签
     * @param redLabel 红包标签
     */
    public void setRedLabel(String redLabel) {
        this.redLabel = redLabel == null ? null : redLabel.trim();
    }

    /**
     * 关联彩种运营管理ID，list
     * @return operate_lottery_id 关联彩种运营管理ID，list
     */
    public String getOperateLotteryId() {
        return operateLotteryId;
    }

    /**
     * 关联彩种运营管理ID，list
     * @param operateLotteryId 关联彩种运营管理ID，list
     */
    public void setOperateLotteryId(String operateLotteryId) {
        this.operateLotteryId = operateLotteryId == null ? null : operateLotteryId.trim();
    }

    /**
     * 
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     * @return modify_by 
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 
     * @param modifyBy 
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 可用渠道
     * @return channel_id 可用渠道
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 可用渠道
     * @param channelId 可用渠道
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 限制彩种
     * @return limit_lottery 限制彩种
     */
    public String getLimitLottery() {
        return limitLottery;
    }

    /**
     * 限制彩种
     * @param limitLottery 限制彩种
     */
    public void setLimitLottery(String limitLottery) {
        this.limitLottery = limitLottery == null ? null : limitLottery.trim();
    }

    /**
     * 限制彩种子玩法
     * @return limit_lottery_child 限制彩种子玩法
     */
    public String getLimitLotteryChild() {
        return limitLotteryChild;
    }

    /**
     * 限制彩种子玩法
     * @param limitLotteryChild 限制彩种子玩法
     */
    public void setLimitLotteryChild(String limitLotteryChild) {
        this.limitLotteryChild = limitLotteryChild == null ? null : limitLotteryChild.trim();
    }

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public Short getConfigType() {
		return configType;
	}

	public void setConfigType(Short configType) {
		this.configType = configType;
	}
    
}