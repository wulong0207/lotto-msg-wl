package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.common.util.NumberFormatUtil;

/**
 * 
* @Description: 财务管理 
* @author HouXiangBao289
* @date 2017年6月21日 下午12:23:43 
* @version V1.0.0
 */
public class FinanceBO extends NodeBaseBO{
	private String nickName = "";
	private Double rechargeAmount = 0.00;
	private Double accountBalance = 0.00;
	private Double extractAmount = 0.00;
	private String bankCardCode = "";
	private String failInfo = "";
	private String mobile = "";
	private String redTypeName = "";
	private Integer redType;
	private Double redMoney = 0.00;
	
	/**
	 * 
	 * @Description 昵称 
	 * @author HouXiangBao289
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 
	 * @Description 昵称 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 
	 * @Description 充值金额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getRechargeAmount() {
		return rechargeAmount;
	}
	/**
	 * 
	 * @Description 充值金额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	
	/**
	 * 
	 * @Description 当前余额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getAccountBalance() {
		return accountBalance;
	}
	/**
	 * 
	 * @Description 当前余额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	/**
	 * 
	 * @Description 提款金额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getExtractAmount() {
		return extractAmount;
	}
	/**
	 * 
	 * @Description 提款金额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setExtractAmount(Double extractAmount) {
		this.extractAmount = extractAmount;
	}
	/**
	 * 
	 * @Description 提款卡号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getBankCardCode() {
		return bankCardCode;
	}
	/**
	 * 
	 * @Description 提款卡号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setBankCardCode(String bankCardCode) {
		this.bankCardCode = bankCardCode;
	}
	/**
	 * 
	 * @Description 提款失败原因
	 * @author HouXiangBao289
	 * @return
	 */
	public String getFailInfo() {
		return failInfo;
	}
	/**
	 * 
	 * @Description 提款失败原因
	 * @author HouXiangBao289
	 * @return
	 */
	public void setFailInfo(String failInfo) {
		this.failInfo = failInfo;
	}
	
	/**
	 * 
	 * @Description 手机号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 
	 * @Description 手机号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public String getRedTypeName() {
		return redTypeName;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedTypeName(String redTypeName) {
		this.redTypeName = redTypeName;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getRedType() {
		return redType;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedType(Integer redType) {
		this.redType = redType;
	}
	/**
	 * 
	 * @Description 红包面额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getRedMoney() {
		return redMoney;
	}
	/**
	 * 
	 * @Description 红包面额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedMoney(Double redMoney) {
		this.redMoney = redMoney;
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
		if("nickName".equals(name))
		{
			return nickName==null?"":nickName;
		}
		else if("rechargeAmount".equals(name))
		{
			return NumberFormatUtil.format(rechargeAmount==null?0.00:rechargeAmount,"0.00");
		}
		else if("redTypeName".equals(name))
		{
			return redTypeName;
		}
		else if("accountBalance".equals(name))
		{
			return NumberFormatUtil.format(accountBalance==null?0.00:accountBalance,"0.00");
		}
		else if("extractAmount".equals(name))
		{
			return NumberFormatUtil.format(extractAmount==null?0.00:extractAmount,"0.00");
		}
		else if("redMoney".equals(name))
		{
			return NumberFormatUtil.format(redMoney==null?0.00:redMoney,"0.00");
		}
		else if("bankCardCode".equals(name))
		{
			int startIndex = 0;
			if(bankCardCode.length() > 4){
				startIndex = bankCardCode.length() - 4;
			}
			return bankCardCode.substring(startIndex);
		}
		else if("failInfo".equals(name))
		{
			return failInfo==null?"":failInfo;
		}
		else if("mobile".equals(name))
		{
			return mobile==null?"":mobile;
		}
		else
		{
			return "";
		}
	}
	
}
