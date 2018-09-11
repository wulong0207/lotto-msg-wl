package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.common.util.NumberFormatUtil;

/**
 * 
* @Description: 彩期 
* @author HouXiangBao289
* @date 2017年6月21日 下午12:12:19 
* @version V1.0.0
 */
public class IssueBO extends NodeBaseBO {
	private Integer lotCode;
	private String lotName="";
	private String issueCode="";
	private Integer statusId;
	private String statusName="";
	private String drawCode="";
	private Double jackpotAmount=0.0;
	private Date saleEndTime;

	public Date getSaleEndTime() {
		return saleEndTime;
	}
	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}
	
	/**
	 * 
	 * @Description 彩种编号 
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getLotCode() {
		return lotCode;
	}
	/**
	 * 
	 * @Description 彩种编号 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotCode(Integer lotCode) {
		this.lotCode = lotCode;
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
	/**
	 * 
	 * @Description 彩种名称
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}
	/**
	 * 
	 * @Description 期号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getIssueCode() {
		return issueCode;
	}
	/**
	 * 
	 * @Description 期号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}
	
	/**
	 * 
	 * @Description 销售状态id
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * 
	 * @Description 销售状态id
	 * @author HouXiangBao289
	 * @return
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * 
	 * @Description 销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * 
	 * @Description 销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * 
	 * @Description 开奖号码
	 * @author HouXiangBao289
	 * @return
	 */
	public String getDrawCode() {
		return drawCode;
	}
	/**
	 * 
	 * @Description 开奖号码
	 * @author HouXiangBao289
	 * @return
	 */
	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}
	/**
	 * 
	 * @Description 滚存
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getJackpotAmount() {
		return jackpotAmount;
	}
	/**
	 * 
	 * @Description 滚存
	 * @author HouXiangBao289
	 * @return
	 */
	public void setJackpotAmount(Double jackpotAmount) {
		this.jackpotAmount = jackpotAmount;
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
		else if("issueCode".equals(name))
		{
			return issueCode;
		}
		else if("statusName".equals(name))
		{
			return statusName;
		}
		else if("drawCode".equals(name))
		{
			return drawCode==null?"":drawCode;
		}
		else if("jackpotAmount".equals(name))
		{
			return NumberFormatUtil.format(jackpotAmount==null?0.00:jackpotAmount,"0.00");
		}
		else
		{
			return "";
		}
	}
	
}
