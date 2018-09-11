package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.NumberFormatUtil;

/**
 * 
* @Description:追号计划 
* @author HouXiangBao289
* @date 2017年6月21日 下午2:47:41 
* @version V1.0.0
 */
public class ChaseCodePlanBO extends NodeBaseBO{
	private Integer lotCode;
	private String nickName = "";
	private String lotName = "";
	private Integer userId;
	private String issue = "";
	private Integer chaseIssueNum;
	private Integer chasedIssueNum=0;
	private Integer status;
	private String statusName = "";
	private Double prizeMoney=0.0;
	private Date buyTime;
	private String orderAddCode = "";

	public Integer getLotCode() {
		return lotCode;
	}
	public void setLotCode(Integer lotCode) {
		this.lotCode = lotCode;
	}
	public String getOrderAddCode() {
		return orderAddCode;
	}
	public void setOrderAddCode(String orderAddCode) {
		this.orderAddCode = orderAddCode;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
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
	public Integer getChaseIssueNum() {
		return chaseIssueNum;
	}
	public void setChaseIssueNum(Integer chaseIssueNum) {
		this.chaseIssueNum = chaseIssueNum;
	}
	public Integer getChasedIssueNum() {
		return chasedIssueNum;
	}
	public void setChasedIssueNum(Integer chasedIssueNum) {
		this.chasedIssueNum = chasedIssueNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Double getPrizeMoney() {
		return prizeMoney;
	}
	public void setPrizeMoney(Double prizeMoney) {
		this.prizeMoney = prizeMoney;
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
		else if("userId".equals(name))
		{
			return userId.toString();
		}
		else if("lotName".equals(name))
		{
			return lotName;
		}
		else if("issue".equals(name))
		{
			return issue;
		}
		else if("chaseIssueNum".equals(name))
		{
			return chaseIssueNum==null?"":chaseIssueNum.toString();
		}
		else if("chasedIssueNum".equals(name))
		{
			return chasedIssueNum==null?"":chasedIssueNum.toString();
		}
		else if("statusName".equals(name))
		{
			return statusName;
		}
		else if("prizeMoney".equals(name))
		{
			return NumberFormatUtil.format(prizeMoney==null?0.00:prizeMoney,"0.00");
		}
		else if("buyTime".equals(name))
		{
			String time = DateUtil.convertDateToStr(buyTime, "MM-dd HH:mm");
			time = time.replace("-", "月").replace(" ", "日");
			return time;
		}
		else if("orderAddCode".equals(name)){
			return orderAddCode;
		}
		else if("lotUrlName".equals(name))
		{
			return getLotUrlName(lotCode);
		}
		else
		{
			return "";
		}
	}
}
