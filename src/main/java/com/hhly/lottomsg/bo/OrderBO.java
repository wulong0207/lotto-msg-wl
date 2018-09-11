package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.NumberFormatUtil;

/**
 * 
* @Description: 方案详情
* @author HouXiangBao289
* @date 2017年6月21日 上午11:40:44 
* @version V1.0.0
 */
public class OrderBO extends NodeBaseBO{
	private Integer id;
	private Integer lotCode;
	private String lotName = "";
	private Integer play;
	private String issue = "";
	private String nickName = "";
	private String accountName = "";
	private Integer buyType;
	private String buyTypeName = "";
	private String orderCode = "";
	private Double preBonus = 0.00;
	private String prizeGrade = "";
	private Integer redType;
	private String redTypeName = "";
	private Double redPacketMoney = 0.00;
	private Integer payStatus;
	private String payStatusName = ""; 
	private Integer progress = 0;
	private Integer userId;
	private Date buyTime;
	private String remark="";
	private Integer orderType;
	private String redeemCode;

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}

	public Integer getPlay() {
		return play;
	}

	public void setPlay(Integer play) {
		this.play = play;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @Description 根据字段名获取对应值 
	 * @author HouXiangBao289
	 * @param name
	 * @return
	 */
	@Override
	public String getValueByName(String name){
		if("lotName".equals(name))
		{
			return lotName;
		}
		else if("issue".equals(name))
		{
			return issue;
		}
		else if("nickName".equals(name))
		{
			return nickName==null?"":nickName;
		}
		else if("accountName".equals(name))
		{
			return accountName==null?"":accountName;
		}
		else if("buyTypeName".equals(name))
		{
			return buyTypeName;
		}
		else if("orderCode".equals(name))
		{
			return orderCode;
		}
		else if("preBonus".equals(name))
		{
			return NumberFormatUtil.format(preBonus==null?0.00:preBonus,"0.00");
		}
		else if("prizeGrade".equals(name))
		{
			return prizeGrade;
		}
		else if("redTypeName".equals(name))
		{
			return redTypeName;
		}
		else if("redPacketMoney".equals(name))
		{
			return NumberFormatUtil.format(redPacketMoney==null?0.00:redPacketMoney,"0.00");
		}
		else if("payStatusName".equals(name))
		{
			return payStatusName;
		}
		else if("progress".equals(name))
		{
			return progress.toString();
		}
		else if("buyTime".equals(name))
		{
			String time = DateUtil.convertDateToStr(buyTime, "MM-dd HH:mm");
			time = time.replace("-", "月").replace(" ", "日");
			return time;
		}
		else if("lotUrlName".equals(name))
		{
			return getLotUrlName(lotCode);
		}
		else if("remark".equals(name))
		{
			return remark;
		}
		else if("id".equals(name))
		{
			return id.toString();
		}
		else if("redeemCode".equals(name))
		{
			return redeemCode==null?"":redeemCode;
		}
		else
		{
			return "";
		}
	}

	public Integer getLotCode() {
		return lotCode;
	}
	public void setLotCode(Integer lotCode) {
		this.lotCode = lotCode;
	}
	public Integer getBuyType() {
		return buyType;
	}
	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}
	public String getBuyTypeName() {
		return buyTypeName;
	}
	public void setBuyTypeName(String buyTypeName) {
		this.buyTypeName = buyTypeName;
	}
	public Integer getRedType() {
		return redType;
	}
	public void setRedType(Integer redType) {
		this.redType = redType;
	}
	public String getRedTypeName() {
		return redTypeName;
	}
	public void setRedTypeName(String redTypeName) {
		this.redTypeName = redTypeName;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayStatusName() {
		return payStatusName;
	}
	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}
	/**
	 * 
	 * @Description 彩种名称 
	 * @author HouXiangBao289
	 * @return
	 */
	public String getLotName() {
		return lotName;
	}
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Double getPreBonus() {
		return preBonus;
	}
	public void setPreBonus(Double preBonus) {
		this.preBonus = preBonus;
	}
	public String getPrizeGrade() {
		return prizeGrade;
	}
	public void setPrizeGrade(String prizeGrade) {
		this.prizeGrade = prizeGrade;
	}
	public Double getRedPacketMoney() {
		return redPacketMoney;
	}
	public void setRedPacketMoney(Double redPacketMoney) {
		this.redPacketMoney = redPacketMoney;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	
	
}
