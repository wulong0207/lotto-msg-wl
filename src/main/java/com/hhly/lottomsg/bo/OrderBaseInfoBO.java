package com.hhly.lottomsg.bo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhly.lottomsg.base.bo.BaseBO;
import com.hhly.lottomsg.common.constants.SymbolConstants;
import com.hhly.lottomsg.common.util.IssueUtil;
import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/3/13 15:54
 * @company 益彩网络科技公司
 */
public class OrderBaseInfoBO extends BaseBO {



	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 订单编号
	 */
	private String orderCode;

	/**
	 * 小彩种编号，参考LotteryEnum 枚举
	 */
	private Integer lotteryChildCode;

	/**
	 * 小彩种名称
	 */
	private String lotteryChildName;

	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;

	/**
	 * 彩种名称
	 */
	private String lotteryName;

	/**
	 * 彩种logo的url
	 */
	private String lotteryLogoUrl;

	/**
	 * 竞彩订单投注内容，数字彩和追号的到各自对象里取
	 */
	private List<String> jcPlanContent;

	/**
	 * 默认订单创建日期 未支付且未过期的方案取方案截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date showDate;

	/**
	 * 本站销售截止时间 （未支付时的倒计时）
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endSaleTime;

	/**
	 * 官方销售截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTicketTime;

	/**
	 * 订单支付截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderPayEndTime;

	/**
	 * 出票时间（时间段串）
	 */
	private String ticketTime;

	/**
	 * 派奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date throwTime;

	/**
	 * 数字彩：开奖号码
	 */
	private String drawCode;
	
	/**
	 * 开奖号码类型
	 */
	private Integer drawCodeType;

	/**
	 * 税前奖金
	 */
	private Double preBonus;

	/**
	 * 税后奖金
	 */
	private Double aftBonus;

	/**
	 * 支付时使用的红包编号
	 */
	private String redCode;

	/**
	 * 支付时使用的红包名称
	 */
	private String redName;

	/**
	 * 开奖后生成的红包编号名称
	 */
	private String redNameGet;

	/**
	 * 开奖后生成的红包编号
	 */
	private String redCodeGet;

	/**
	 * 现金支付金额
	 */
	private Double cashAmount;

	/**
	 * 红包支付金额
	 */
	private Double redAmount;

	/**
	 * 红包返奖金额
	 */
	private Double getRedAmount;

	/**
	 * 期号
	 */
	private String lotteryIssue;

	/**
	 * 方案 0:全部； 1：代购；2：追号代购；3：合买；4：追号计划;5:推单（可以推）6:已推单
	 */
	private Integer buyType;

	/**
     * 订单金额
     */
	private Double orderAmount;

	/**
	 * 订单状态 1：待上传；2：待拆票；3：拆票中；4：待出票；5:出票中；6：已出票；7：出票失败；8：已撤单;9拆票失败
	 */
	private Integer orderStatus;

	/**
	 * 支付状态 1：等待支付；2：支付成功；3：未支付过期；4：支付失败；5：用户取消；6：退款
	 */
	private Integer payStatus;

	/**
	 * 开奖状态 1：未开奖；2：未中奖；3：已中奖；4：已派奖
	 */
	private Integer winningStatus;

	/**
	 * 追号状态； 1：追号中；2：中奖停追；3：追号结束；4：用户撤单；5：系统撤单；
	 */
	private Integer addStatus;

	/**
	 * 追号：已追期数
	 */
	private Integer hadIssue;

	/**
	 * 追号：总期数
	 */
	private Integer totalIssue;

	/**
	 * 追号：正在执行追号的彩期(追号中的状态)
	 */
	private String curAddLotteryIssue;

	/**
	 * 追号：从哪期停止追号的彩期（中奖停追，用户撤单，系统撤单的状态）
	 */
	private String stopAddLotteryIssue;

	/**
	 * 追号：停止类型； 1：奖项；2：金额；3：永追
	 */
	private Integer stopType;

	/**
	 * 串关 2_1,3_1组成
	 */
	private String bunchStr;

	/**
	 * 订单总倍数
	 */
	private Integer multipleNum;

	/**
	 * 订单总注数
	 */
	private Integer betNum;

	/**
	 * 1：单式；2：复式；3：胆拖；
	 */
	private Integer contentType;

	/**
	 * 备注，出票失败原因从此取
	 */
	private String remark;

	/**
	 * 最大场次编号
	 */
	private String maxBuyScreen;
	/**
	 * 竞技彩购买的场次编号
	 */
	private String buyScreen;

	/**
	 * 出票时间
	 */
	private IssueOfficialTimeBO issueOfficialTimeBO;

	/**
	 * 1.数字彩(低频彩，高频彩) 2.竞技彩（竟足，竟篮,北京单场，胜负过关） 3.老足彩
	 */
	private Integer lotteryType;

	/**
	 * 1,2,3,4 进行中（包括1,2未支付） 5,6 已完成
	 */
	private Integer colSort;

	/**
	 * 是否大乐透加号0：否；1：是
	 */
	private Integer isDltAdd;

	/**
	 * 最新订单流程信息
	 */
	private OrderFlowInfoBO orderFlowInfoBO;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 普通订单统一状态 1:待支付, 2:未支付过期, 3:等待出票, 4:出票中, 5:投注失败, 6:投注成功
	 */
	private Integer orderUnionStatus;
	
	/**
	 * 普通订单统一状态文本
	 */
	private String orderUnionStatusText;
	
	/**
	 * 普通订单流程统一状态
	 */
	private Integer orderFlowUnionStatus;
	
	/**
	 * 普通订单流程统一状态文本
	 */
	private String orderFlowUnionStatusText;

	/**
	 * 追号订单统一状态  1:待支付, 2:未支付过期, 3:追号中, 4:追号结束, 5:中奖停追, 6:追号撤单, 7:投注失败
	 */
	private Integer addOrderUnionStatus;
	
	/**
	 * 追号订单统一状态文本
	 */
	private String addOrderUnionStatusText;
	
	/**
	 * 追号订单流程统一状态
	 */
	private Integer addOrderFlowUnionStatus;
	
	/**
	 * 追号订单流程统一状态文本
	 */
	private String addOrderFlowUnionStatusText;

	/**
	 * 加奖奖金
	 */
	private Double addedBonus;
	
	
	/***************************** 方案详情普通订单顶部的时间点 order_info start */
	/**
	 * 方案详情顶部 普通订单创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderCreateTime;

	/**
	 * 方案详情顶部 订单支付相关时间，对应状态：未支付过期,支付失败,支付成功并等待出票
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderBuyTime;

	/**
	 * 方案详情顶部 订单更新时间，对应状态： 出票中
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderUpdateTime;

	/**
	 * 方案详情顶部 订单出票相关时间，对应状态： 出票失败并已退款,出票成功，等待开奖
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date comeOutTime;

	/**
	 * 方案详情顶部 订单中奖相关时间，对应状态： 未中奖,等待派奖
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;

	/**
	 * 方案详情顶部 订单派奖时间，对应状态： 已派奖
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sendTime;
	/* 方案详情顶部的时间点 order_info end */

	/************************* 方案详情追号订单顶部的时间点 order_add start */
	/**
	 * 方案详情顶部 追号：创建时间 待支付。
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addCreateTime;

	/**
	 * 方案详情顶部 追号：支付相关时间，对应状态： 未支付过期，支付失败，支付成功
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addBuyTime;

	/**
	 * 方案详情顶部 追号：追号中取的时间，对应状态： 追号中
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addTime;

	/**
	 * 方案详情顶部 追号中根据状态显示 等待追号，追号失败，追号成功等内容
	 * 1：追号成功；2：追号失败；3：系统撤单；4：用户撤单；5：等待追号;6撤单中，7停追撤单中，8用户撤单中
	 */
	private Integer lastAddIssueStatus;

	/**
	 * 方案详情顶部 追号，内容里面的期号。对应状态：追号中
	 */
	private String addIssueCode;

	/**
	 * 方案详情顶部 追号：对应状态：追号结束，中奖停追，追号撤单取的时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addEndTime;

	/* 方案详情顶部的时间点 order_add end */

	/**
	 * 投注平台:1：Web,2:Wap;3:Android;4:IOS
	 */
	private Integer platform;

	/**
	 * 投注文件url
	 */
	private String bettingUrl;

	/**
	 * 停追条件
	 */
	private String stopCondition;

	private Date updateTime;

	/**
	 * 竞技彩投注类型, 字典编码1512
	 */
	private Short categoryId;

	/**
	 * 活动编号
	 */
	private String activityCode;
	
	/**
	 * 当前期
	 */
	private String period;
	
	/**
	 * 奖金文本
	 */
	private String winningText;

	/**
	 * 0:不能推单 1、推单（可以推） 2、已推单 3、已跟单
	 */
	private Integer orderType=0;

	/**
	 * 单倍截止时间
	 */
	private Date endLocalTime;

	/**
	 * 预测奖金 1.1-4.11 前面最小奖金，后面最大奖金
	 */
	@JsonIgnore
	private String maxBonusStr;

	/**
	 * 渠道ID
	 */
	private String channelId;
	//**************************推单*********start/
	/**
	 * 提成比例
	 */
	@JsonIgnore
	private Double commissionRate;

	/**
	 * 提成拥金=（税后奖金-购彩金额）*提成比例
	 */
	private Double commissionAmount;

	/**
	 * 奖金金额=税后奖金-提成拥金+加奖奖金
	 */
	private Double bonusAmount;

	/**
	 * 1：开奖后可见；2：全部可见；3：仅对抄单人可见；4：仅对关注人可见
	 */
	private Integer orderVisibleType;

	/**
	 * 抄单人昵称
	 */
	private String copyNickName;

	/**
	 * 抄单人图像
	 */
	private String copyHeadUrl;

	/**
	 * 发单用户ID 跳专家详情使用
	 */
	private Integer userIssueId;
	//**************************推单*********end/

	public String getLotteryIssue() {
		return lotteryIssue;
	}

	public void setLotteryIssue(String lotteryIssue) {
		this.lotteryIssue = lotteryIssue;
	}

	public Integer getBuyType() {
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Double getPreBonus() {
		return preBonus;
	}

	public void setPreBonus(Double preBonus) {
		this.preBonus = preBonus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getWinningStatus() {
		return winningStatus;
	}

	public void setWinningStatus(Integer winningStatus) {
		this.winningStatus = winningStatus;
	}

	public Integer getHadIssue() {
		return hadIssue;
	}

	public void setHadIssue(Integer hadIssue) {
		this.hadIssue = hadIssue;
	}

	public Integer getTotalIssue() {
		return totalIssue;
	}

	public void setTotalIssue(Integer totalIssue) {
		this.totalIssue = totalIssue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Integer getAddStatus() {
		return addStatus;
	}

	public void setAddStatus(Integer addStatus) {
		this.addStatus = addStatus;
	}

	public Integer getLotteryChildCode() {
		return lotteryChildCode;
	}

	public void setLotteryChildCode(Integer lotteryChildCode) {
		this.lotteryChildCode = lotteryChildCode;
	}

	public String getLotteryChildName() {
		return lotteryChildName;
	}

	public void setLotteryChildName(String lotteryChildName) {
		this.lotteryChildName = lotteryChildName;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public String getLotteryLogoUrl() {
		return lotteryLogoUrl;
	}

	public void setLotteryLogoUrl(String lotteryLogoUrl) {
		this.lotteryLogoUrl = lotteryLogoUrl;
	}

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public String getBunchStr() {
		return bunchStr;
	}

	public void setBunchStr(String bunchStr) {
		this.bunchStr = bunchStr;
	}

	public Integer getMultipleNum() {
		return multipleNum;
	}

	public void setMultipleNum(Integer multipleNum) {
		this.multipleNum = multipleNum;
	}

	public Integer getBetNum() {
		return betNum;
	}

	public void setBetNum(Integer betNum) {
		this.betNum = betNum;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public Date getEndSaleTime() {
		return endSaleTime;
	}

	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	public String getTicketTime() {
		return ticketTime;
	}

	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}

	public Date getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

	public String getDrawCode() {
		return drawCode;
	}
	
	public Integer getDrawCodeType() {
		return drawCodeType;
	}

	public void setDrawCodeType(Integer drawCodeType) {
		this.drawCodeType = drawCodeType;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Double getRedAmount() {
		return redAmount;
	}

	public void setRedAmount(Double redAmount) {
		this.redAmount = redAmount;
	}

	public String getMaxBuyScreen() {
		return maxBuyScreen;
	}

	public void setMaxBuyScreen(String maxBuyScreen) {
		this.maxBuyScreen = maxBuyScreen;
	}

	public Date getThrowTime() {
		return throwTime;
	}

	public void setThrowTime(Date throwTime) {
		this.throwTime = throwTime;
	}

	public IssueOfficialTimeBO getIssueOfficialTimeBO() {
		return issueOfficialTimeBO;
	}

	public void setIssueOfficialTimeBO(IssueOfficialTimeBO issueOfficialTimeBO) {
		this.issueOfficialTimeBO = issueOfficialTimeBO;
	}

	public Double getAftBonus() {
		return aftBonus;
	}

	public void setAftBonus(Double aftBonus) {
		this.aftBonus = aftBonus;
	}

	public String getRedCodeGet() {
		return redCodeGet;
	}

	public void setRedCodeGet(String redCodeGet) {
		this.redCodeGet = redCodeGet;
	}

	public Double getGetRedAmount() {
		return getRedAmount;
	}

	public void setGetRedAmount(Double getRedAmount) {
		this.getRedAmount = getRedAmount;
	}

	public Integer getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(Integer lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getCurAddLotteryIssue() {
		return curAddLotteryIssue;
	}

	public void setCurAddLotteryIssue(String curAddLotteryIssue) {
		this.curAddLotteryIssue = curAddLotteryIssue;
	}

	public String getRedName() {
		return redName;
	}

	public void setRedName(String redName) {
		this.redName = redName;
	}

	public String getRedNameGet() {
		return redNameGet;
	}

	public void setRedNameGet(String redNameGet) {
		this.redNameGet = redNameGet;
	}

	public Integer getStopType() {
		return stopType;
	}

	public void setStopType(Integer stopType) {
		this.stopType = stopType;
	}

	public Integer getColSort() {
		return colSort;
	}

	public void setColSort(Integer colSort) {
		this.colSort = colSort;
	}

	public String getStopAddLotteryIssue() {
		return stopAddLotteryIssue;
	}

	public void setStopAddLotteryIssue(String stopAddLotteryIssue) {
		this.stopAddLotteryIssue = stopAddLotteryIssue;
	}

	public Integer getIsDltAdd() {
		return isDltAdd;
	}

	public void setIsDltAdd(Integer isDltAdd) {
		this.isDltAdd = isDltAdd;
	}

	public Date getEndTicketTime() {
		return endTicketTime;
	}

	public void setEndTicketTime(Date endTicketTime) {
		this.endTicketTime = endTicketTime;
	}

	public Date getOrderPayEndTime() {
		return orderPayEndTime;
	}

	public void setOrderPayEndTime(Date orderPayEndTime) {
		this.orderPayEndTime = orderPayEndTime;
	}

	public List<String> getJcPlanContent() {
		return jcPlanContent;
	}

	public void setJcPlanContent(List<String> jcPlanContent) {
		this.jcPlanContent = jcPlanContent;
	}

	public OrderFlowInfoBO getOrderFlowInfoBO() {
		return orderFlowInfoBO;
	}

	public void setOrderFlowInfoBO(OrderFlowInfoBO orderFlowInfoBO) {
		this.orderFlowInfoBO = orderFlowInfoBO;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOrderUpdateTime() {
		return orderUpdateTime;
	}

	public void setOrderUpdateTime(Date orderUpdateTime) {
		this.orderUpdateTime = orderUpdateTime;
	}

	public Date getComeOutTime() {
		return comeOutTime;
	}

	public void setComeOutTime(Date comeOutTime) {
		this.comeOutTime = comeOutTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddCreateTime() {
		return addCreateTime;
	}

	public void setAddCreateTime(Date addCreateTime) {
		this.addCreateTime = addCreateTime;
	}

	public Date getAddBuyTime() {
		return addBuyTime;
	}

	public void setAddBuyTime(Date addBuyTime) {
		this.addBuyTime = addBuyTime;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Date getOrderBuyTime() {
		return orderBuyTime;
	}

	public void setOrderBuyTime(Date orderBuyTime) {
		this.orderBuyTime = orderBuyTime;
	}

	public Date getAddEndTime() {
		return addEndTime;
	}

	public void setAddEndTime(Date addEndTime) {
		this.addEndTime = addEndTime;
	}

	public String getAddIssueCode() {
		return addIssueCode;
	}

	public void setAddIssueCode(String addIssueCode) {
		this.addIssueCode = addIssueCode;
	}

	public Integer getLastAddIssueStatus() {
		return lastAddIssueStatus;
	}

	public void setLastAddIssueStatus(Integer lastAddIssueStatus) {
		this.lastAddIssueStatus = lastAddIssueStatus;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getBettingUrl() {
		return bettingUrl;
	}

	public void setBettingUrl(String bettingUrl) {
		this.bettingUrl = bettingUrl;
	}

	public Integer getOrderUnionStatus() {
		return orderUnionStatus;
	}

	public void setOrderUnionStatus(Integer orderUnionStatus) {
		this.orderUnionStatus = orderUnionStatus;
	}
	
	public String getOrderUnionStatusText() {
		return orderUnionStatusText;
	}

	public void setOrderUnionStatusText(String orderUnionStatusText) {
		this.orderUnionStatusText = orderUnionStatusText;
	}
	
	public Integer getOrderFlowUnionStatus() {
		return orderFlowUnionStatus;
	}

	public void setOrderFlowUnionStatus(Integer orderFlowUnionStatus) {
		this.orderFlowUnionStatus = orderFlowUnionStatus;
	}

	public String getOrderFlowUnionStatusText() {
		return orderFlowUnionStatusText;
	}

	public void setOrderFlowUnionStatusText(String orderFlowUnionStatusText) {
		this.orderFlowUnionStatusText = orderFlowUnionStatusText;
	}

	public Integer getAddOrderUnionStatus() {
		return addOrderUnionStatus;
	}

	public void setAddOrderUnionStatus(Integer addOrderUnionStatus) {
		this.addOrderUnionStatus = addOrderUnionStatus;
	}
	
	public String getAddOrderUnionStatusText() {
		return addOrderUnionStatusText;
	}

	public void setAddOrderUnionStatusText(String addOrderUnionStatusText) {
		this.addOrderUnionStatusText = addOrderUnionStatusText;
	}
	
	public Integer getAddOrderFlowUnionStatus() {
		return addOrderFlowUnionStatus;
	}

	public void setAddOrderFlowUnionStatus(Integer addOrderFlowUnionStatus) {
		this.addOrderFlowUnionStatus = addOrderFlowUnionStatus;
	}

	public String getAddOrderFlowUnionStatusText() {
		return addOrderFlowUnionStatusText;
	}

	public void setAddOrderFlowUnionStatusText(String addOrderFlowUnionStatusText) {
		this.addOrderFlowUnionStatusText = addOrderFlowUnionStatusText;
	}

	public String getBuyScreen() {
		return buyScreen;
	}

	public void setBuyScreen(String buyScreen) {
		this.buyScreen = buyScreen;
	}

	public String getStopCondition() {
		return stopCondition;
	}

	public void setStopCondition(String stopCondition) {
		this.stopCondition = stopCondition;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Short categoryId) {
		this.categoryId = categoryId;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getWinningText() {
		return winningText;
	}

	public void setWinningText(String winningText) {
		this.winningText = winningText;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}


	public Date getEndLocalTime() {
		return endLocalTime;
	}

	public void setEndLocalTime(Date endLocalTime) {
		this.endLocalTime = endLocalTime;
	}

	public Double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Double getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(Double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Double getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Double getAddedBonus() {
		return addedBonus;
	}

	public void setAddedBonus(Double addedBonus) {
		this.addedBonus = addedBonus;
	}

	public Integer getOrderVisibleType() {
		return orderVisibleType;
	}

	public void setOrderVisibleType(Integer orderVisibleType) {
		this.orderVisibleType = orderVisibleType;
	}

	public String getCopyNickName() {
		return copyNickName;
	}

	public void setCopyNickName(String copyNickName) {
		this.copyNickName = copyNickName;
	}

	public String getCopyHeadUrl() {
		return copyHeadUrl;
	}

	public void setCopyHeadUrl(String copyHeadUrl) {
		this.copyHeadUrl = copyHeadUrl;
	}

	public String getMaxBonusStr() {
		return maxBonusStr;
	}

	public void setMaxBonusStr(String maxBonusStr) {
		this.maxBonusStr = maxBonusStr;
	}

	public Double getMaxBonus() {
		if(!ObjectUtil.isBlank(maxBonusStr)){
			String bonus[] = maxBonusStr.split(SymbolConstants.TRAVERSE_SLASH);
			if(bonus.length==2){
                 return Double.valueOf(bonus[1]);
			}
		}
		return 0d;
	}

	public Double getMinBonus() {
		if(!ObjectUtil.isBlank(maxBonusStr)){
			String bonus[] = maxBonusStr.split(SymbolConstants.TRAVERSE_SLASH);
			if(bonus.length==2){
				return Double.valueOf(bonus[0]);
			}
		}
		return 0d;
	}

	public Integer getUserIssueId() {
		return userIssueId;
	}

	public void setUserIssueId(Integer userIssueId) {
		this.userIssueId = userIssueId;
	}

	public String getCommissionRateStr() {
		if(!ObjectUtil.isBlank(commissionRate)){
			return IssueUtil.getPercentageStr(commissionRate);
		}else{
			return null;
		}
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
