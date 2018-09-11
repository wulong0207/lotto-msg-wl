package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 *	@Desc	   通知信息模板信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:26:07
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
@SuppressWarnings("serial")
public class OperateMsgTemplateBO extends BaseBO{
    
	private Integer id;
	
	private Integer typeId;

	private String typeName;
	
	private String typeNode;
	
	private Short status;
	
	private Short mobStatus;
	
	private Short siteStatus;
	
	private Short appStatus;
	
	private Short wechatStatus;
	
	private String mobTitle;
	
	private String mobContent;
	
	private String siteTitle;
	
	private String siteContent;
	
	private String appTitle;
	
	private String appContent;
	
	private String typeDesc;

    private String createBy;

    private String modifyBy;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    
    private Integer wechatId;
    
    private String wechatTitle;

    private String headerCon;

    private String footerCon;

    private String appAddFields;
    
    private Integer msgType;
    
    private String wechatAddFields;
    
    private Integer toLotteryCode;
	private String activityUrl;
	private String conditionKey;
	private Integer startDays;
	private Integer endDays;
	private Integer lotteryCodeLimit;
	private Double setMoney;
	private Double setBalance;
	
	
	private Short smsSendChannel;
	private String noSendChannel = "";
	private String sendLotteryCode = "";

	public String getSendLotteryCode() {
		return sendLotteryCode;
	}

	public void setSendLotteryCode(String sendLotteryCode) {
		this.sendLotteryCode = sendLotteryCode;
	}

	public String getNoSendChannel() {
		return noSendChannel;
	}

	public void setNoSendChannel(String noSendChannel) {
		this.noSendChannel = noSendChannel;
	}

	/**
	 * 
	 * @Description 短信发送渠道
	 * @author HouXiangBao289
	 * @return
	 */
	public Short getSmsSendChannel() {
		return smsSendChannel;
	}

	/**
	 * 短信发送渠道
	 * @Description 
	 * @author HouXiangBao289
	 * @param smsSendChannel
	 */
	public void setSmsSendChannel(Short smsSendChannel) {
		this.smsSendChannel = smsSendChannel;
	}

	/**
	 * 
	 * @Description 用户余额阀值 
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getSetBalance() {
		return setBalance;
	}

	/**
	 * 
	 * @Description 用户余额阀值 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setSetBalance(Double setBalance) {
		this.setBalance = setBalance;
	}

	/**
	 * 
	 * @Description 跳转投注界面彩种id 
	 * @author HouXiangBao289
	 * @return
	 */
    public Integer getToLotteryCode() {
		return toLotteryCode;
	}

    /**
	 * 
	 * @Description 跳转投注界面彩种id 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setToLotteryCode(Integer toLotteryCode) {
		this.toLotteryCode = toLotteryCode;
	}

	/**
	 * 
	 * @Description 活动链接地址
	 * @author HouXiangBao289
	 * @return
	 */
	public String getActivityUrl() {
		return activityUrl;
	}

	/**
	 * 
	 * @Description 活动链接地址
	 * @author HouXiangBao289
	 * @return
	 */
	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	/**
	 * 
	 * @Description 条件key
	 * 1、noCerNoLogin:注册第N天未登录：未实名认证用户注册第N天未进行登录
	 * 2、noCerNoOrder:注册第N天未下单：未实名认证用户注册第N天未进行任何订单下单
	 * 3、noCerOrderNoBuy:注册（未实名认证）第N天有下单但未购买：未实名认证用户注册第N天有进行下单，但并未支付购买
	 * 4、cerOrderNoBuy:注册并实名认证后第N天未购买：已实名认证用户注册第N天有下单，但并未支付购买
	 * 5、orderNobuy:注册(不区分实名)第N天未购买：所有注册用户（不区分实名）第N天有进行下单，但并未支付购买
	 * 6、noSecondOrder:首单第N天未二单：用户第一个订单成功后第N天未进行下一个成功订单
	 * 7、dayRangeNoSecondOrder:首单15-30天内无第二单：用户第一个订单成功后第N天~第N天之间未进行下一个成功订单
	 * 8、dayRangeNoLogin:距上单30到50天未登录：用户距离上一个成功订单第N天~第N天未进行登录
	 * 9、dayRangeNoBuy:距上单30到50天未购买：用户距离上一个成功订单第N天~第N天未进行购买
	 * 10、balanceNoBuy:账户余额X元距离上单X天未购买：用户余额N元以上距离上一订单第N天未进行购买
	 * 11、noBigOrderDayRangeNoBuy:距上单15到30天未购买（低客单）：上单金额N元以下用户，第N天~第N天未购买
	 * 12、bigOrderDayRangeNoBuy:距上单30到50天未购买（高客单）：上单金额N元以上用户，第N天~第N天未购买
	 * 13、PreMonthOverMoneyNoBuy:上月购彩金额X元X天未购买:上月度购彩金额N元以上用户，第N天~第N天未购买
	 * @author HouXiangBao289
	 * @return
	 */
	public String getConditionKey() {
		return conditionKey;
	}

	/**
	 * 
	 * @Description 条件key
	 * 1、noCerNoLogin:注册第N天未登录：未实名认证用户注册第N天未进行登录
	 * 2、noCerNoOrder:注册第N天未下单：未实名认证用户注册第N天未进行任何订单下单
	 * 3、noCerOrderNoBuy:注册（未实名认证）第N天有下单但未购买：未实名认证用户注册第N天有进行下单，但并未支付购买
	 * 4、cerOrderNoBuy:注册并实名认证后第N天未购买：已实名认证用户注册第N天有下单，但并未支付购买
	 * 5、orderNobuy:注册(不区分实名)第N天未购买：所有注册用户（不区分实名）第N天有进行下单，但并未支付购买
	 * 6、noSecondOrder:首单第N天未二单：用户第一个订单成功后第N天未进行下一个成功订单
	 * 7、dayRangeNoSecondOrder:首单15-30天内无第二单：用户第一个订单成功后第N天~第N天之间未进行下一个成功订单
	 * 8、dayRangeNoLogin:距上单30到50天未登录：用户距离上一个成功订单第N天~第N天未进行登录
	 * 9、dayRangeNoBuy:距上单30到50天未购买：用户距离上一个成功订单第N天~第N天未进行购买
	 * 10、balanceNoBuy:账户余额X元距离上单X天未购买：用户余额N元以上距离上一订单第N天未进行购买
	 * 11、noBigOrderDayRangeNoBuy:距上单15到30天未购买（低客单）：上单金额N元以下用户，第N天~第N天未购买
	 * 12、bigOrderDayRangeNoBuy:距上单30到50天未购买（高客单）：上单金额N元以上用户，第N天~第N天未购买
	 * 13、PreMonthOverMoneyNoBuy:上月购彩金额X元X天未购买:上月度购彩金额N元以上用户，第N天~第N天未购买
	 * @author HouXiangBao289
	 * @return
	 */
	public void setConditionKey(String conditionKey) {
		this.conditionKey = conditionKey;
	}

	/**
	 * 
	 * @Description 多少天
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getStartDays() {
		return startDays;
	}

	/**
	 * 
	 * @Description 多少天
	 * @author HouXiangBao289
	 * @return
	 */
	public void setStartDays(Integer startDays) {
		this.startDays = startDays;
	}

	/**
	 * 
	 * @Description 到多少天
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getEndDays() {
		return endDays;
	}

	/**
	 * 
	 * @Description 到多少天
	 * @author HouXiangBao289
	 * @return
	 */
	public void setEndDays(Integer endDays) {
		this.endDays = endDays;
	}

	/**
	 * 
	 * @Description 上一笔订单查询限制彩种id
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getLotteryCodeLimit() {
		return lotteryCodeLimit;
	}

	/**
	 * 
	 * @Description 上一笔订单查询限制彩种id
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotteryCodeLimit(Integer lotteryCodeLimit) {
		this.lotteryCodeLimit = lotteryCodeLimit;
	}

	/**
	 * 
	 * @Description 设置金额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getSetMoney() {
		return setMoney;
	}

	/**
	 * 
	 * @Description 设置金额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setSetMoney(Double setMoney) {
		this.setMoney = setMoney;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getWechatAddFields() {
		return wechatAddFields;
	}

	public void setWechatAddFields(String wechatAddFields) {
		this.wechatAddFields = wechatAddFields;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeNode() {
		return typeNode;
	}

	public void setTypeNode(String typeNode) {
		this.typeNode = typeNode;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getMobStatus() {
		return mobStatus;
	}

	public void setMobStatus(Short mobStatus) {
		this.mobStatus = mobStatus;
	}

	public Short getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(Short siteStatus) {
		this.siteStatus = siteStatus;
	}

	public Short getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Short appStatus) {
		this.appStatus = appStatus;
	}

	public Short getWechatStatus() {
		return wechatStatus;
	}

	public void setWechatStatus(Short wechatStatus) {
		this.wechatStatus = wechatStatus;
	}

	public String getMobTitle() {
		return mobTitle;
	}

	public void setMobTitle(String mobTitle) {
		this.mobTitle = mobTitle;
	}

	public String getMobContent() {
		return mobContent;
	}

	public void setMobContent(String mobContent) {
		this.mobContent = mobContent;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getSiteContent() {
		return siteContent;
	}

	public void setSiteContent(String siteContent) {
		this.siteContent = siteContent;
	}

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

	public String getAppContent() {
		return appContent;
	}

	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getWechatId() {
		return wechatId;
	}

	public void setWechatId(Integer wechatId) {
		this.wechatId = wechatId;
	}

	public String getWechatTitle() {
		return wechatTitle;
	}

	public void setWechatTitle(String wechatTitle) {
		this.wechatTitle = wechatTitle;
	}

	public String getHeaderCon() {
		return headerCon;
	}

	public void setHeaderCon(String headerCon) {
		this.headerCon = headerCon;
	}

	public String getFooterCon() {
		return footerCon;
	}

	public void setFooterCon(String footerCon) {
		this.footerCon = footerCon;
	}

	public String getAppAddFields() {
		return appAddFields;
	}

	public void setAppAddFields(String appAddFields) {
		this.appAddFields = appAddFields;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
    
}