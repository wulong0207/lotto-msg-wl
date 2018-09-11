package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;
import com.hhly.lottomsg.common.enums.LotteryEnum.ConIssue;

/**
 * @desc  彩期+彩种名称
 * @author lidecheng
 * @date 2017年3月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class IssueLottBO extends BaseBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8007465540242635158L;
	
	private Short lotteryCategory;
	
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	
	/**
	 * 彩种名称
	 */
	private String lotteryName;
	/**
	 * 彩期期号
	 */
	private String issueCode;


	/**
	 * 官方开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;
	
	/**
	 * 奖池金额
	 */
	private Long jackpotAmount;
	/**
	 * 开奖号码
	 */
	private String drawCode;
	/**
	 * 格式例如： 一等奖,2,10000000 | 二等奖,5,200000 |用 | 线隔开；代表 奖项，注数，每注中奖金额
	 */
	private String drawDetail;
	/**
	 * 跳转路径
	 */
	private String drawDetailUrl;
	
	/**
	 * 试机号码
	 */
	private String drawCodeTest;
	
	public IssueLottBO(){
		
	}
	public IssueLottBO(CurrentAndPreIssueBO curbo,short current){
		if(ConIssue.CURRENT.getValue()==current){
			issueCode = curbo.getIssueCode();//赋值当前期
			lotteryTime = curbo.getLotteryTime();
		}
		if(ConIssue.LAST_CURRENT.getValue()==current){
			issueCode = curbo.getPreIssue();//赋值上一期
			lotteryTime = curbo.getPreLotteryTime();
		}
		lotteryCategory = curbo.getLotteryCategory() ;
		lotteryCode = curbo.getLotteryCode();
		lotteryName = curbo.getLotteryName();		
		jackpotAmount = curbo.getPreJackpot();
		drawCode = curbo.getPreDrawCode();
		drawDetail = curbo.getPreDrawDetail();
		drawDetailUrl=curbo.getDrawDetailUrl();
		drawCodeTest=curbo.getDrawCodeTest();
		drawDetailUrl=curbo.getDrawDetailUrl();
	}
	
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


	public Long getJackpotAmount() {
		return jackpotAmount;
	}

	public void setJackpotAmount(Long jackpotAmount) {
		this.jackpotAmount = jackpotAmount;
	}

	public String getDrawCode() {
		return drawCode;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public String getDrawDetail() {
		return drawDetail;
	}

	public void setDrawDetail(String drawDetail) {
		this.drawDetail = drawDetail;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public Date getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}
	
	@Override
	public String toString() {
		return "IssueLottBO [lotteryCategory=" + lotteryCategory + ", lotteryCode=" + lotteryCode + ", lotteryName="
				+ lotteryName + ", issueCode=" + issueCode + ", lotteryTime=" + lotteryTime + ", jackpotAmount="
				+ jackpotAmount + ", drawCode=" + drawCode + ", drawDetail=" + drawDetail + "]";
	}
}
