/**    
* @Title: PayParamVo.java  
* @Package com.hhly.skeleton.pay.vo  
* @Description: TODO
* @author xiongjingang 
* @date 2017年3月6日 下午2:53:33  
* @version V1.0    
*/
package com.hhly.lottomsg.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hhly.lottomsg.bo.OrderBaseInfoBO;
import com.hhly.lottomsg.bo.PayBankBO;
import com.hhly.lottomsg.bo.PayBankcardBO;
import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @desc 支付请求参数
 * @author xiongjingang
 * @date 2017年3月6日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayParamVO implements Serializable {
	private static final long serialVersionUID = -441057897717727911L;

	/**以下字段是客户端必传的**/
	private String orderCode;// 订单号
	private String redCode;// 彩金、优惠券code
	private String token;// 用户登录的token
	private Short platform;// 1：本站WEB；2：本站WAP；3：Android客户端；4：IOS客户端；5：未知；
	private Double balance;// 余额，不为0表示使用余额金额
	private Double payAmount;// 需要支付的现金金额
	private Integer bankId;// 银行ID（用户选择余额支付，该字段为空）
	private Integer bankCardId;// 银行卡ID（用户选择余额支付或者支付宝支付，银行卡ID为空）
	private String returnUrl;// 支付同步跳转地址，前台做为一个参数传递过来
	private String remark;// 描述
	private String extraData;// 额外字段
	private String buyType;// 购买类型
	private Integer isBatchPay;// 支付类型 0单个支付 、1批量支付
	private String channelId = "7";// 渠道ID，前端没有传值，默认7：未知渠道
	private Short change;// 是否切换（网银的切换成快捷、快捷地切换成网银。0不切换 1切换）
	private String openId;// 微信的openId
	private String appId;// 微信应用ID
	private String issueId;// 推单ID

	/**客户端无需提供*/
	private String clientIp;// 客户端IP
	private List<OrderBaseInfoBO> orderList;// 订单列表，单个支付和批量支付共用该字段，根据isBatchPay来区分是单个支付还是批量支付
	private String transCode;// 交易编号（系统生成）
	// private Short channelType;// 支付渠道类型 1：支付宝充值；2：微信支付；3：练练支付；4：百度支付；5：人工充值
	private String bankCode;// 银行编码（每一个银行有一个唯一的8位编码）
	private PayBankcardBO payBankcardBO;
	private PayBankBO payBankBO;
	private Double useRedAmount;// 使用红包金额
	private Double useBalance;// 使用余额金额
	private List<OrderQueryVo> orderQueryVoList;// 订单号，购买类型列表
	private Integer userId;// 用户Id
	private Date endSaleTime;// 支付截止时间
	private Double activityAmount;// 活动价格
	private String activityCode;// 活动编号
	private boolean isTest;// 是否为测试环境 true:是；false:否
	private OrderCopyPayInfoBO orderCopyPayInfoBO;// 推单方案信息

	public PayParamVO() {
		super();
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getPayAmount() {
		if (ObjectUtil.isBlank(payAmount)) {
			payAmount = 0.0;
		}
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Short getPlatform() {
		return platform;
	}

	public void setPlatform(Short platform) {
		this.platform = platform;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public List<OrderBaseInfoBO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderBaseInfoBO> orderList) {
		this.orderList = orderList;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Integer bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public PayBankcardBO getPayBankcardBO() {
		return payBankcardBO;
	}

	public void setPayBankcardBO(PayBankcardBO payBankcardBO) {
		this.payBankcardBO = payBankcardBO;
	}

	public PayBankBO getPayBankBO() {
		return payBankBO;
	}

	public void setPayBankBO(PayBankBO payBankBO) {
		this.payBankBO = payBankBO;
	}

	public Double getUseRedAmount() {
		return useRedAmount;
	}

	public void setUseRedAmount(Double useRedAmount) {
		this.useRedAmount = useRedAmount;
	}

	public Double getUseBalance() {
		return useBalance;
	}

	public void setUseBalance(Double useBalance) {
		this.useBalance = useBalance;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public Integer getIsBatchPay() {
		return isBatchPay;
	}

	public void setIsBatchPay(Integer isBatchPay) {
		this.isBatchPay = isBatchPay;
	}

	public List<OrderQueryVo> getOrderQueryVoList() {
		return orderQueryVoList;
	}

	public void setOrderQueryVoList(List<OrderQueryVo> orderQueryVoList) {
		this.orderQueryVoList = orderQueryVoList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Date getEndSaleTime() {
		return endSaleTime;
	}

	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	public Short getChange() {
		return change;
	}

	public void setChange(Short change) {
		this.change = change;
	}

	public Double getActivityAmount() {
		return activityAmount;
	}

	public void setActivityAmount(Double activityAmount) {
		this.activityAmount = activityAmount;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public boolean isTest() {
		return isTest;
	}

	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public OrderCopyPayInfoBO getOrderCopyPayInfoBO() {
		return orderCopyPayInfoBO;
	}

	public void setOrderCopyPayInfoBO(OrderCopyPayInfoBO orderCopyPayInfoBO) {
		this.orderCopyPayInfoBO = orderCopyPayInfoBO;
	}

	@Override
	public String toString() {
		return "PayParamVO [orderCode=" + orderCode + ", redCode=" + redCode + ", token=" + token + ", platform=" + platform + ", balance=" + balance + ", payAmount=" + payAmount + ", bankId=" + bankId + ", bankCardId=" + bankCardId + ", returnUrl="
				+ returnUrl + ", remark=" + remark + ", extraData=" + extraData + ", buyType=" + buyType + ", isBatchPay=" + isBatchPay + ", channelId=" + channelId + ", change=" + change + ", openId=" + openId + ", appId=" + appId + ", issueId="
				+ issueId + ", clientIp=" + clientIp + ", transCode=" + transCode + ", bankCode=" + bankCode + ", payBankcardBO=" + payBankcardBO + ", payBankBO=" + payBankBO + ", useRedAmount=" + useRedAmount + ", useBalance=" + useBalance
				+ ", orderQueryVoList=" + orderQueryVoList + ", userId=" + userId + ", endSaleTime=" + endSaleTime + ", activityAmount=" + activityAmount + ", activityCode=" + activityCode + ", isTest=" + isTest + "]";
	}

}
