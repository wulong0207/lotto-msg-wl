package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hhly.lottomsg.base.bo.BaseBO;
import com.hhly.lottomsg.common.constants.PayConstants;
import com.hhly.lottomsg.common.util.ObjectUtil;
import com.hhly.lottomsg.vo.PayParamVO;

/**
 * @desc 用户充值管理
 * @author xiongjingang
 * @date 2017年3月1日 下午3:40:27
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TransRechargeBO extends BaseBO {
	private static final long serialVersionUID = -7368002328260963842L;
	private String activityCode;// 活动编号
	/**
	*到账金额
	*/
	private Double arrivalAmount;
	/**
	*银行卡号
	*/
	private String bankCardNum;
	/**
	*1：储蓄卡；2：信用卡；3：其它
	*/
	private Short bankCardType;
	/**
	 *充值渠道编号
	 */
	@JsonIgnore
	private String channelCode;
	/**
	*市场渠道ID
	*/
	private String channelId;
	/**
	*创建人
	*/
	@JsonIgnore
	private String createBy;
	/**
	*创建时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 *自增长主键ID
	 */
	@JsonIgnore
	private Integer id;
	/**
	 *实际进入用户钱包的金额（提款时用于计算，用户使用了充值红包时才有值）
	 */
	@JsonIgnore
	private Double inWallet;
	/**
	*修改人
	*/
	@JsonIgnore
	private String modifyBy;
	/**
	*修改时间
	*/
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifyTime;
	/**
	 * 订单编号，存储格式：订单号,buyType;……
	 */
	private String orderCode;
	/**
	*1：快捷支付；2：网银支付；3：其它支付；
	*/
	private Short payType;
	/**
	*充值金额
	*/
	private Double rechargeAmount;
	/**
	 * 银行ID
	 */
	@JsonIgnore
	private Integer rechargeBank;
	/**
	 * 银行名称
	 */
	@JsonProperty("r_b_n")
	private String rechargeBankName;
	/**
	*1、支付宝充值；2、微信支付；3、连连支付；4、百度支付；5、人工充值；6、易宝支付；7、代理系统充值；8、聚合支付；9、现在支付；10、神州支付；11、掌易付支付；12、威富通支付；13、兴业银行
	*在PayConstants.PayChannelEnum中查看
	*/
	@JsonIgnore
	private Short rechargeChannel;
	/**
	 *充值渠道名称
	 */
	@JsonProperty("r_c_n")
	private String rechargeChannelName;
	/**
	*1：本站WEB；2：本站WAP；3：Android客户端；4：IOS客户端；5：未知；
	*/
	@JsonIgnore
	private Short rechargePlatform;
	/**
	*充值描述
	*/
	private String rechargeRemark;
	/**
	*红包金额
	*/
	private Double redAmount;
	/**
	 * 彩金优惠券CODE
	 */
	private String redCode;
	/**
	*描述
	*/
	@JsonIgnore
	private String remark;
	/**
	*请求响应时间
	*/
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date responseTime;
	/**
	*服务费
	*/
	private Double serviceCharge;
	/**
	 * 服务费率，2017-06-21 日添加
	 */
	private Double serviceRate;
	/**
	*补单人
	*/
	@JsonIgnore
	private String supplementBy;
	@JsonIgnore
	private Short switchStatus;// 网银和快捷切换状态:0不切换;1切换
	/**
	*第三方流水号
	*/
	private String thirdTransNum;
	/**
	*第三方交易时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date thirdTransTime;
	/**
	*交易结束时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonIgnore
	private Date transEndTime;
	/**
	*自定义用户充值流水编号
	*/
	private String transRechargeCode;
	/**
	*1审核通过; 2审核不通过; 3银行处理成功; 4银行处理失败; 5已到帐;6待审核;7银行处理中
	*/
	private Short transStatus;
	/**
	 * 交易状态名称
	 */
	@JsonProperty("t_s_n")
	private String transStatusName;
	/**
	*交易时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date transTime;
	/**
	*更新时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonIgnore
	private Date updateTime;
	/**
	*用户ID
	*/
	@JsonIgnore
	private Integer userId;
	/**
	 * 是否可提款状态:0不可提、1可提 、2已提
	 */
	@JsonIgnore
	private Short takenStatus;
	/**
	 *  0充值、1即买即付，默认0
	 */
	@JsonIgnore
	private Short rechargeType;
	/**
	 * 是否为批量支付：0单个支付、1批量支付
	 */
	@JsonIgnore
	private Short batchPay;
	// 带符号的交易金额，保留2位小数
	@JsonProperty("s_a")
	private String showAmount;
	@JsonIgnore
	private Integer payChannelId;// 充值渠道ID
	@JsonIgnore
	private Short tradeType;// 交易类型

	public TransRechargeBO() {
		super();
	}

	public TransRechargeBO(PayParamVO payParam) {
		// this.rechargeChannel = payParam.getChannelType();
		PayBankcardBO payBankcardBO = payParam.getPayBankcardBO();
		this.payType = PayConstants.PayTypeEnum.THIRD_PAYMENT.getKey();// 默认第三方支付
		this.bankCardType = PayConstants.BankCardTypeEnum.OTHER.getKey();// 默认其它类型
		this.rechargeBank = payParam.getBankId();// 银行Id
		// 银行卡号不为空
		if (!ObjectUtil.isBlank(payBankcardBO)) {
			// 是否开启快捷支付 0：否，1：是
			Short openBank = payBankcardBO.getOpenbank();
			if (PayConstants.BandCardQuickEnum.HAD_OPEN.getKey().equals(openBank)) {
				this.payType = PayConstants.PayTypeEnum.QUICK_PAYMENT.getKey();// 快捷支付
			} else {
				this.payType = PayConstants.PayTypeEnum.BANK_PAYMENT.getKey();// 网银支付
			}
			this.bankCardType = payBankcardBO.getBanktype();
			this.bankCardNum = payBankcardBO.getCardcode();
		} else {
			this.payType = PayConstants.PayTypeEnum.THIRD_PAYMENT.getKey();// 其它支付
		}
		this.rechargeRemark = payParam.getRemark();
		this.rechargePlatform = payParam.getPlatform();
		// this.channelId = payParam.getChannelId();
		this.remark = payParam.getRemark();
		this.redAmount = payParam.getUseRedAmount();
		this.orderCode = payParam.getOrderCode();
		this.redCode = payParam.getRedCode();// 红包编号
		this.transStatus = PayConstants.TransStatusEnum.TRADE_UNDERWAY.getKey();// 交易进行中
	}

	public String getActivityCode() {
		return activityCode;
	}

	public Double getArrivalAmount() {
		return arrivalAmount;
	}

	public String getBankCardNum() {
		return bankCardNum;
	}

	public Short getBankCardType() {
		return bankCardType;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Integer getId() {
		return id;
	}

	public Double getInWallet() {
		return inWallet;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public Short getPayType() {
		return payType;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public Integer getRechargeBank() {
		return rechargeBank;
	}

	public Short getRechargeChannel() {
		return rechargeChannel;
	}

	public Short getRechargePlatform() {
		return rechargePlatform;
	}

	public String getRechargeRemark() {
		return rechargeRemark;
	}

	public Double getRedAmount() {
		return redAmount;
	}

	public String getRedCode() {
		return redCode;
	}

	public String getRemark() {
		return remark;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public Double getServiceRate() {
		return serviceRate;
	}

	public String getSupplementBy() {
		return supplementBy;
	}

	public Short getSwitchStatus() {
		return switchStatus;
	}

	public String getThirdTransNum() {
		return thirdTransNum;
	}

	public Date getThirdTransTime() {
		return thirdTransTime;
	}

	public Date getTransEndTime() {
		return transEndTime;
	}

	public String getTransRechargeCode() {
		return transRechargeCode;
	}

	public Short getTransStatus() {
		return transStatus;
	}

	public Date getTransTime() {
		return transTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public void setArrivalAmount(Double arrivalAmount) {
		this.arrivalAmount = arrivalAmount;
	}

	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}

	public void setBankCardType(Short bankCardType) {
		this.bankCardType = bankCardType;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInWallet(Double inWallet) {
		this.inWallet = inWallet;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public void setRechargeBank(Integer rechargeBank) {
		this.rechargeBank = rechargeBank;
	}

	public void setRechargeChannel(Short rechargeChannel) {
		this.rechargeChannel = rechargeChannel;
	}

	public void setRechargePlatform(Short rechargePlatform) {
		this.rechargePlatform = rechargePlatform;
	}

	public void setRechargeRemark(String rechargeRemark) {
		this.rechargeRemark = rechargeRemark;
	}

	public void setRedAmount(Double redAmount) {
		this.redAmount = redAmount;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public void setServiceRate(Double serviceRate) {
		this.serviceRate = serviceRate;
	}

	public void setSupplementBy(String supplementBy) {
		this.supplementBy = supplementBy;
	}

	public void setSwitchStatus(Short switchStatus) {
		this.switchStatus = switchStatus;
	}

	public void setThirdTransNum(String thirdTransNum) {
		this.thirdTransNum = thirdTransNum;
	}

	public void setThirdTransTime(Date thirdTransTime) {
		this.thirdTransTime = thirdTransTime;
	}

	public void setTransEndTime(Date transEndTime) {
		this.transEndTime = transEndTime;
	}

	public void setTransRechargeCode(String transRechargeCode) {
		this.transRechargeCode = transRechargeCode;
	}

	public void setTransStatus(Short transStatus) {
		this.transStatus = transStatus;
	}

	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getTakenStatus() {
		return takenStatus;
	}

	public void setTakenStatus(Short takenStatus) {
		this.takenStatus = takenStatus;
	}

	public Short getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(Short rechargeType) {
		this.rechargeType = rechargeType;
	}

	public Short getBatchPay() {
		return batchPay;
	}

	public void setBatchPay(Short batchPay) {
		this.batchPay = batchPay;
	}

	public String getRechargeBankName() {
		return rechargeBankName;
	}

	public void setRechargeBankName(String rechargeBankName) {
		this.rechargeBankName = rechargeBankName;
	}

	public String getRechargeChannelName() {
		return rechargeChannelName;
	}

	public void setRechargeChannelName(String rechargeChannelName) {
		this.rechargeChannelName = rechargeChannelName;
	}

	public String getTransStatusName() {
		return transStatusName;
	}

	public void setTransStatusName(String transStatusName) {
		this.transStatusName = transStatusName;
	}

	public String getShowAmount() {
		return showAmount;
	}

	public void setShowAmount(String showAmount) {
		this.showAmount = showAmount;
	}

	public Integer getPayChannelId() {
		return payChannelId;
	}

	public void setPayChannelId(Integer payChannelId) {
		this.payChannelId = payChannelId;
	}

	public Short getTradeType() {
		return tradeType;
	}

	public void setTradeType(Short tradeType) {
		this.tradeType = tradeType;
	}

	@Override
	public String toString() {
		return "TransRechargeBO [transRechargeCode=" + transRechargeCode + ", rechargeChannel=" + rechargeChannel + ", payType=" + payType + ", rechargeBank=" + rechargeBank + ", bankCardType=" + bankCardType + ", bankCardNum=" + bankCardNum
				+ ", transTime=" + transTime + ", userId=" + userId + ", rechargeAmount=" + rechargeAmount + ", serviceCharge=" + serviceCharge + ", redAmount=" + redAmount + ", redCode=" + redCode + ", orderCode=" + orderCode + "]";
	}

}