package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 彩种中奖级别
 * @author huangb
 * @date 2017年2月24日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryWinningBO extends BaseBO {

	private static final long serialVersionUID = -2108707538641229367L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 奖项编号
	 */
	private Integer code;
	/**
	 * 奖项名称
	 */
	private String name;
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	/**
	 * 奖项金额
	 */
	private Double money;
	/**
	 * 排序
	 */
	private Integer orderId;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 修改人
	 */
	private String modifyBy;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifyTime;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	public LotteryWinningBO() {
	}

	/**
	 * 构造
	 * 
	 * @param lotteryCode
	 *            彩种编号
	 */
	public LotteryWinningBO(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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

}