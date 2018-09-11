package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hhly.lottomsg.base.bo.BaseBO;
import com.hhly.lottomsg.common.constants.PayConstants.TransTypeEnum;
import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @desc 用户交易流水
 * @author xiongjingang
 * @date 2017年3月1日 下午12:17:07
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TransUserBO extends BaseBO {

	private static final long serialVersionUID = -2592177709083909661L;
	/**
	 *自增长ID
	 */
	@JsonIgnore
	private Integer id;
	/**
	 *用户表主键ID
	 */
	@JsonIgnore
	private Integer userId;
	/**
	 *交易流水编号
	 */
	private String transCode;
	/**
	 *关联订单表的订单编号
	 */
	private String orderCode;
	/**
	 *1：充值；2：购彩；3：返奖；4：退款；5：提款；6：其它
	 */
	private Short transType;
	/**
	 *订单信息说明；有相应文档。
	 */
	private String orderInfo;
	/**
	 *交易结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date transEndTime;
	/**
	 *付款成功时入库时间。
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date transTime;
	/**
	 *第三方交易返回的时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date thirdTransTime;
	/**
	 *交易总金额；现金金额+红包金额+服务费
	 */
	private Double transAmount;
	/**
	 *实付现金金额
	 */
	private Double cashAmount;
	/**
	 *所用的红包消费总金额
	 */
	private Double redTransAmount;
	/**
	 *现金总余额
	 */
	private Double totalCashBalance;
	/**
	 *0：交易失败；1：交易成功；
	 */
	private Short transStatus;
	/**
	 *0：交易失败；1：交易成功；
	 */
	@JsonProperty("t_s_n")
	private String transStatusName;
	/**
	 *渠道表ID；取渠道ID，订单来源
	 */
	private String channelId;
	/**
	 *第三方返回的订单编号
	 */
	private String thirdTransId;
	/**
	 *服务费
	 */
	private Double serviceCharge;
	/**
	 *更新时间
	 */
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 *创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 使用80%金额
	 */
	@JsonIgnore
	private Double amount80;
	/**
	 * 使用20%金额
	 */
	@JsonIgnore
	private Double amount20;
	/**
	 * 使用中奖金额
	 */
	@JsonIgnore
	private Double amountWin;

	/**
	 * 字符串时间
	 */
	private String createTimeStr;
	/**
	 * 购买类型
	 */
	private Integer buyType;
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	/**
	 * 服务费率 2017-06-21 添加
	 */
	private Double serviceRate;
	/**
	 * 使用红包编号 2017-07-12 添加，用户撤单生成相应的红包
	 */
	private String redCode;
	/**
	 * 流水编号，可以是充值编号、提款编号等，存的是自己内部其它交易表的编号
	 */
	private String tradeCode;
	private String remark;// 描述
	private String showAmount;// 给前端显示的金额，带+-符号
	private String transName;// 交易名称
	@JsonIgnore
	private Short sourceType;// 交易来源 1直接充值、2即买即付、3人工充值、4代理充值 2017-11-08号添加
	/**
	 * 剩余红包总余额
	 */
	private Double totalRedBalance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Short getTransType() {
		return transType;
	}

	public void setTransType(Short transType) {
		this.transType = transType;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Date getTransEndTime() {
		return transEndTime;
	}

	public void setTransEndTime(Date transEndTime) {
		this.transEndTime = transEndTime;
	}

	public Date getTransTime() {
		return transTime;
	}

	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	public Date getThirdTransTime() {
		return thirdTransTime;
	}

	public void setThirdTransTime(Date thirdTransTime) {
		this.thirdTransTime = thirdTransTime;
	}

	public Double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Double transAmount) {
		this.transAmount = transAmount;
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Double getRedTransAmount() {
		return redTransAmount;
	}

	public void setRedTransAmount(Double redTransAmount) {
		this.redTransAmount = redTransAmount;
	}

	public Short getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(Short transStatus) {
		this.transStatus = transStatus;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getThirdTransId() {
		return thirdTransId;
	}

	public void setThirdTransId(String thirdTransId) {
		this.thirdTransId = thirdTransId;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
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

	public Double getTotalCashBalance() {
		return totalCashBalance;
	}

	public void setTotalCashBalance(Double totalCashBalance) {
		this.totalCashBalance = totalCashBalance;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getBuyType() {
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Double getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(Double serviceRate) {
		this.serviceRate = serviceRate;
	}

	public Double getAmount80() {
		return amount80;
	}

	public void setAmount80(Double amount80) {
		this.amount80 = amount80;
	}

	public Double getAmount20() {
		return amount20;
	}

	public void setAmount20(Double amount20) {
		this.amount20 = amount20;
	}

	public Double getAmountWin() {
		return amountWin;
	}

	public void setAmountWin(Double amountWin) {
		this.amountWin = amountWin;
	}

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getShowAmount() {
		return showAmount;
	}

	public void setShowAmount(String showAmount) {
		this.showAmount = showAmount;
	}

	public String getTransStatusName() {
		return transStatusName;
	}

	public void setTransStatusName(String transStatusName) {
		this.transStatusName = transStatusName;
	}

	public Short getSourceType() {
		return sourceType;
	}

	public void setSourceType(Short sourceType) {
		this.sourceType = sourceType;
	}

	public String getTransName() {
		if (!ObjectUtil.isBlank(getTransType())) {
			TransTypeEnum transTypeEnum = TransTypeEnum.getEnum(getTransType());
			return transTypeEnum.getValue();
		}
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public Double getTotalRedBalance() {
		return totalRedBalance;
	}

	public void setTotalRedBalance(Double totalRedBalance) {
		this.totalRedBalance = totalRedBalance;
	}

}