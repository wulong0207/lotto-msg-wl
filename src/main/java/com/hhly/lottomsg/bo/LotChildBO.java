package com.hhly.lottomsg.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 彩种子玩法
 * @author huangb
 * @date 2017年3月7日
 * @company 益彩网络
 * @version v1.0
 */
public class LotChildBO extends BaseBO {

	private static final long serialVersionUID = -7869336311059560315L;
	/**
	 * 子玩法code
	 */
	private Integer lotteryChildCode;
	/**
	 * 彩种code
	 */
	private Integer lotteryCode;
	/**
	 * 子玩法名称
	 */
	private String childName;
	/**
	 * 大彩种名称
	 */
	@JsonIgnore
	private String lotteryName;
	/**
	 * 子玩法状态0：暂停销售；1：正常销售
	 */
	private Short saleStatus;
	/**
	 * 父子级：0 、父级  1、子级
	 */
	@JsonIgnore
	private Short level;
	
	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}
	
	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public Integer getLotteryChildCode() {
		return lotteryChildCode;
	}

	public void setLotteryChildCode(Integer lotteryChildCode) {
		this.lotteryChildCode = lotteryChildCode;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Short getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
	}

}