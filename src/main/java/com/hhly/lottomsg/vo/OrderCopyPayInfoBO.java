package com.hhly.lottomsg.vo;

import java.util.Date;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单三期-支付对象BO
 * @date 2018/1/11 11:12
 * @company 益彩网络科技公司
 */
public class OrderCopyPayInfoBO extends BaseBO {

	private String issueId;// 方案详情ID
	/**
	 * 专家账户ID
	 */
	private Integer userIssueId;

	/**
	 * 最早赛事销售截止时间
	 */
	private Date saleEndDate;

	/**
	 * 彩种
	 */
	private Integer lotteryCode;

	/**
	 * 彩期
	 */
	private String issueCode;

	/**
	 * 彩种LOGO
	 */
	private String lotteryLogoUrl;

	/**
	 * 方案查看价格
	 */
	private Double price;

	/**
	 * 商户ID
	 */
	private String masterId;

	private String channelId;// 渠道Id

	private String orderInfo;// 描述信息
	private Short transType;// 交易类型

	public Integer getUserIssueId() {
		return userIssueId;
	}

	public void setUserIssueId(Integer userIssueId) {
		this.userIssueId = userIssueId;
	}

	public Date getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getLotteryLogoUrl() {
		return lotteryLogoUrl;
	}

	public void setLotteryLogoUrl(String lotteryLogoUrl) {
		this.lotteryLogoUrl = lotteryLogoUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Short getTransType() {
		return transType;
	}

	public void setTransType(Short transType) {
		this.transType = transType;
	}

}
