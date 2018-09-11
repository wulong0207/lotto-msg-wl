package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/9/26 18:20
 * @company 益彩网络科技公司
 */
public class OrderCopyViewBO extends BaseBO {

    private static final long serialVersionUID = 1L;

    /**
     * 发单次数
     */
    private Integer issueCount;

    /**
     * 发单总额
     */
    private Double issueAmount;

    /**
     * 跟单总人数
     */
    private Integer followCount;

    /**
     * 跟单总金额
     */
    private Double followAmount;

    /**
     * 推单主键
     */
    private Integer orderIssueId;

    /**
     * 专家主键ID
     */
    private Integer userIssueId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 最近战况 5|2
     */
    private String recentRecord;

    /**
     * 命中率
     */
    private Double hitRate;

    /**
     * 连红
     */
    private Integer continueHit;

    /**
     * 盈利率
     */
    private Double profitRate;

    /**
     * 命中次数
     */
    private Integer hitNum;

    /**
     * 命中订单金额
     */
    private Double hitMoney;

    /**
     * 中奖金额
     */
    private Double winAmount;

    /**
     * 返佣总佣金
     */
    private Double commissionAmount;

    public Integer getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(Integer issueCount) {
        this.issueCount = issueCount;
    }

    public Double getIssueAmount() {
        return issueAmount;
    }

    public void setIssueAmount(Double issueAmount) {
        this.issueAmount = issueAmount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Double getFollowAmount() {
        return followAmount;
    }

    public void setFollowAmount(Double followAmount) {
        this.followAmount = followAmount;
    }

    public Integer getOrderIssueId() {
        return orderIssueId;
    }

    public void setOrderIssueId(Integer orderIssueId) {
        this.orderIssueId = orderIssueId;
    }

    public Integer getUserIssueId() {
        return userIssueId;
    }

    public void setUserIssueId(Integer userIssueId) {
        this.userIssueId = userIssueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecentRecord() {
        return recentRecord;
    }

    public void setRecentRecord(String recentRecord) {
        this.recentRecord = recentRecord;
    }

    public Double getHitRate() {
        return hitRate;
    }

    public void setHitRate(Double hitRate) {
        this.hitRate = hitRate;
    }

    public Integer getContinueHit() {
        return continueHit;
    }

    public void setContinueHit(Integer continueHit) {
        this.continueHit = continueHit;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Double profitRate) {
        this.profitRate = profitRate;
    }

    public Integer getHitNum() {
        return hitNum;
    }

    public void setHitNum(Integer hitNum) {
        this.hitNum = hitNum;
    }

    public Double getHitMoney() {
        return hitMoney;
    }

    public void setHitMoney(Double hitMoney) {
        this.hitMoney = hitMoney;
    }

    public Double getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Double winAmount) {
        this.winAmount = winAmount;
    }

    public Double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
}
