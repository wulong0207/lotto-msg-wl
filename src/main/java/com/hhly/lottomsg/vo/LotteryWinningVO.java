package com.hhly.lottomsg.vo;

import java.util.Date;

import com.hhly.lottomsg.base.vo.PageVO;

/**
 * @desc 彩种中奖级别
 * @author huangb
 * @date 2017年2月24日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryWinningVO extends PageVO {

	private static final long serialVersionUID = -3025854426025923916L;
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
	private Date modifyTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public LotteryWinningVO() {
	}

	/**
	 * 构造
	 * 
	 * @param lotteryCode
	 *            彩种编号
	 */
	public LotteryWinningVO(Integer lotteryCode) {
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