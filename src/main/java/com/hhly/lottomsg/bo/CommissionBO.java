package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;
/**
 * 返佣情况/明细 BO
 * @author longguoyou
 * @date 2017年10月11日
 * @compay 益彩网络科技有限公司
 */
public class CommissionBO extends BaseBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private String orderCode;//订单编号
	private Integer followNum;//跟单人输
	private Double followAmount;//跟单金额
	private Double commissionAmount;//佣金金额
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//跟单时间
	private String createTimeStr;//发单日期
    private String nickName;//用户昵称
    private Integer winStatus;//中奖情况
    
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Integer getWinStatus() {
		return winStatus;
	}
	public void setWinStatus(Integer winStatus) {
		this.winStatus = winStatus;
	}
    
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Integer getFollowNum() {
		return followNum;
	}
	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}
	public Double getFollowAmount() {
		return followAmount;
	}
	public void setFollowAmount(Double followAmount) {
		this.followAmount = followAmount;
	}
	public Double getCommissionAmount() {
		return commissionAmount;
	}
	public void setCommissionAmount(Double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
}
