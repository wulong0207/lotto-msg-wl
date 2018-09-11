package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.NumberFormatUtil;

public class OrderIssueInfoBO extends NodeBaseBO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 发单用户表(m_user_issue_info)主键ID
     */
    private Integer userIssueId;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 最高回报率
     */
    private Float maxRoi;

    /**
     * 推荐理由
     */
    private String recommendReason;

    /**
     * 显示隐藏开关。默认为 1：显示， 0：隐藏
     */
    private Integer isShow;

    /**
     * 1：开奖后可见；2：全部可见；3：仅对抄单人可见；4：仅对关注人可见
     */
    private Integer orderVisibleType;

    /**
     * 提成比率 目前 4%-10%
     */
    private Float commissionRate;

    /**
     * 跟单总人数
     */
    private Integer followNum;

    /**
     * 跟单总金额
     */
    private Float followAmount;

    /**
     * 总佣金
     */
    private Float commissionAmount;

    /**
     * 置顶标签 1：置顶；0：不置顶 默认0
     */
    private Integer isTop;

    /**
     * 推荐标签 1：推荐；0：不推荐 默认0
     */
    private Integer isRecommend;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改用户id(后台操作员ID)
     */
    private String modifyBy;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 最近战况
     */
    private String recentRecord;
    /**
     * 命中率
     */
    private Float hitRate;
    /**
     * 连红数
     */
    private Integer continueHit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIssueId() {
        return userIssueId;
    }

    public void setUserIssueId(Integer userIssueId) {
        this.userIssueId = userIssueId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Float getMaxRoi() {
        return maxRoi;
    }

    public void setMaxRoi(Float maxRoi) {
        this.maxRoi = maxRoi;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason == null ? null : recommendReason.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getOrderVisibleType() {
        return orderVisibleType;
    }

    public void setOrderVisibleType(Integer orderVisibleType) {
        this.orderVisibleType = orderVisibleType;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Float getFollowAmount() {
        return followAmount;
    }

    public void setFollowAmount(Float followAmount) {
        this.followAmount = followAmount;
    }

    public Float getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Float commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getRecentRecord() {
		return recentRecord;
	}

	public void setRecentRecord(String recentRecord) {
		this.recentRecord = recentRecord;
	}

	public Float getHitRate() {
		return hitRate;
	}

	public void setHitRate(Float hitRate) {
		this.hitRate = hitRate;
	}

	public Integer getContinueHit() {
		return continueHit;
	}

	public void setContinueHit(Integer continueHit) {
		this.continueHit = continueHit;
	}
	
	/**
	 * 
	 * @Description 根据字段名获取对应值 
	 * @author HouXiangBao289
	 * @param name
	 * @return
	 */
	@Override
	public String getValueByName(String name){
		if("orderCode".equals(name))
		{
			return orderCode;
		}
		else if("maxRoi".equals(name))
		{
			return maxRoi==null?"0.00":maxRoi.toString();
		}
		else if("recommendReason".equals(name))
		{
			return recommendReason;
		}
		else if("commissionRate".equals(name))
		{
			return commissionRate==null?"0":commissionRate.toString();
		}
		else if("followNum".equals(name))
		{
			return followNum==null?"0":followNum.toString();
		}
		else if("followAmount".equals(name))
		{
			return NumberFormatUtil.format(followAmount==null?0.00:followAmount,"0.00");
		}
		else if("createTime".equals(name))
		{
			String time = DateUtil.convertDateToStr(createTime, "MM-dd HH:mm");
			return time;
		}
		else if("commissionAmount".equals(name))
		{
			return NumberFormatUtil.format(commissionAmount==null?0.00:commissionAmount,"0.00");
		}
		else if("id".equals(name))
		{
			return id.toString();
		}
		else
		{
			return "";
		}
	}
    
}