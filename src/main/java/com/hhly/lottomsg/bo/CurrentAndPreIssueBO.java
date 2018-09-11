package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc  当前期+彩种名称
 * @author lidecheng
 * @date 2017年3月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CurrentAndPreIssueBO extends BaseBO {
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	
	/**
	 * 1：数字彩；2：高频彩；3：竞技彩
	 */
	private Short lotteryCategory;
	
	/**
	 * 彩种名称
	 */
	private String lotteryName;
	/**
	 * 当前期彩期期号
	 */
	private String issueCode;
	
	/**
	 * 当前期截止销售时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date saleEndTime;
	
	/**
	 * 当前期官方开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;
	/**
	 * 最新开奖期彩期期号
	 */
	private String preIssue;

	/**
	 * 官方开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date preLotteryTime;
	
	/**
	 * 奖池金额
	 */
	private Long preJackpot;
	/**
	 * 开奖号码
	 */
	private String preDrawCode;
	
	/**
	 * 试机号码
	 */
	private String drawCodeTest;
	/**
	 * 格式例如： 一等奖,2,10000000 | 二等奖,5,200000 |用 | 线隔开；代表 奖项，注数，每注中奖金额
	 */
	private String preDrawDetail;	
	/**
	 * 跳转路径
	 */
	private String drawDetailUrl;
	
	
	public String getDrawCodeTest() {
		return drawCodeTest;
	}

	public void setDrawCodeTest(String drawCodeTest) {
		this.drawCodeTest = drawCodeTest;
	}

	public String getDrawDetailUrl() {
		return drawDetailUrl;
	}

	public void setDrawDetailUrl(String drawDetailUrl) {
		this.drawDetailUrl = drawDetailUrl;
	}

	public Short getLotteryCategory() {
		return lotteryCategory;
	}

	public void setLotteryCategory(Short lotteryCategory) {
		this.lotteryCategory = lotteryCategory;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public Date getSaleEndTime() {
		return saleEndTime;
	}

	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}

	public String getPreIssue() {
		return preIssue;
	}

	public void setPreIssue(String preIssue) {
		this.preIssue = preIssue;
	}

	public Date getPreLotteryTime() {
		return preLotteryTime;
	}

	public void setPreLotteryTime(Date preLotteryTime) {
		this.preLotteryTime = preLotteryTime;
	}

	public Long getPreJackpot() {
		return preJackpot;
	}

	public void setPreJackpot(Long preJackpot) {
		this.preJackpot = preJackpot;
	}

	public String getPreDrawCode() {
		return preDrawCode;
	}

	public void setPreDrawCode(String preDrawCode) {
		this.preDrawCode = preDrawCode;
	}

	public String getPreDrawDetail() {
		return preDrawDetail;
	}

	public void setPreDrawDetail(String preDrawDetail) {
		this.preDrawDetail = preDrawDetail;
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

	public Date getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

}
