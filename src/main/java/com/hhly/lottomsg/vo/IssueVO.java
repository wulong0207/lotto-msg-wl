package com.hhly.lottomsg.vo;

import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.entity.SaleEndIssue;

/**
 * 
* @Description: 彩期 
* @author HouXiangBao289
* @date 2017年6月21日 下午12:12:19 
* @version V1.0.0
 */
public class IssueVO {
	private Integer lotCode;
	private String issueCode;
	private Short saleStatus;
	
	public IssueVO(){}
	
	public IssueVO(SaleEndIssue issue){
		this.lotCode = issue.getLotCode();
		this.issueCode = issue.getIssueCode();
		this.saleStatus = LotteryEnum.LotIssueSaleStatus.SALING.getValue();//销售中的彩期
	}
	
	/**
	 * 
	 * @Description 销售状态 
	 * @author HouXiangBao289
	 * @return
	 */
	public Short getSaleStatus() {
		return saleStatus;
	}
	/**
	 * 
	 * @Description 销售状态 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
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
	
}
