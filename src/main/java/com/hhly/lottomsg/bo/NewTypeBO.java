package com.hhly.lottomsg.bo;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

@SuppressWarnings("serial")
public class NewTypeBO extends BaseBO{

	private Integer id;

    private Integer lotteryCode;

    private String lotteryName;

    private Short conIssueNum;

    private Short stopAddIssue;

    private String lotteryLogoUrl;

    private Short adminCategory;

    private Short lotteryCategory;

    private Short saleStatus;

    private String area;

    private Short autoType;

    private Short synIssue;

    private Integer saleTime;

    private Integer buyEndTime;

    private Integer splitMaxNum;

    private Integer endCheckTime;

    private Integer splitMaxAmount;

    private String createBy;

    private String modifyBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String remark;

    private String startSailTime;

	private String endSailTime;

	private String sailDayCycle;

	private String vacations;
	
	private String drawTime;
	
	private String format;
	//递增数
	private int end;
	//扩展字段
	//官方结束销售时间
	Map<String, String[]> endRule;
	//官方开始销售时间（可送票数时间）
	Map<String, String[]> startRule;
	//官方开始开奖时间规则
	Map<String, String[]> drawTimeRule;
	//高频销售周期
	int[][] cycles;

	public Map<String, String[]> getDrawTimeRule() {
		return drawTimeRule;
	}
	public void setDrawTimeRule(Map<String, String[]> drawTimeRule) {
		this.drawTimeRule = drawTimeRule;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLotteryCode() {
        return lotteryCode;
    }
    public void setLotteryCode(Integer lotteryCode) {
        this.lotteryCode = lotteryCode;
    }
    public String getLotteryName() {
		return lotteryName;
	}
	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}
	public Short getConIssueNum() {
		return conIssueNum;
	}
	public void setConIssueNum(Short conIssueNum) {
		this.conIssueNum = conIssueNum;
	}
	public Short getStopAddIssue() {
		return stopAddIssue;
	}
	public void setStopAddIssue(Short stopAddIssue) {
		this.stopAddIssue = stopAddIssue;
	}
	public String getLotteryLogoUrl() {
		return lotteryLogoUrl;
	}
	public void setLotteryLogoUrl(String lotteryLogoUrl) {
		this.lotteryLogoUrl = lotteryLogoUrl;
	}
	public Short getAdminCategory() {
		return adminCategory;
	}
	public void setAdminCategory(Short adminCategory) {
		this.adminCategory = adminCategory;
	}
	public Short getLotteryCategory() {
		return lotteryCategory;
	}
	public void setLotteryCategory(Short lotteryCategory) {
		this.lotteryCategory = lotteryCategory;
	}
	public Short getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Short getAutoType() {
		return autoType;
	}
	public void setAutoType(Short autoType) {
		this.autoType = autoType;
	}
	public Short getSynIssue() {
		return synIssue;
	}
	public void setSynIssue(Short synIssue) {
		this.synIssue = synIssue;
	}
	public Integer getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Integer saleTime) {
		this.saleTime = saleTime;
	}
	public Integer getBuyEndTime() {
		return buyEndTime;
	}
	public void setBuyEndTime(Integer buyEndTime) {
		this.buyEndTime = buyEndTime;
	}
	public Integer getSplitMaxNum() {
		return splitMaxNum;
	}
	public void setSplitMaxNum(Integer splitMaxNum) {
		this.splitMaxNum = splitMaxNum;
	}
	public Integer getEndCheckTime() {
		return endCheckTime;
	}
	public void setEndCheckTime(Integer endCheckTime) {
		this.endCheckTime = endCheckTime;
	}
	public Integer getSplitMaxAmount() {
		return splitMaxAmount;
	}
	public void setSplitMaxAmount(Integer splitMaxAmount) {
		this.splitMaxAmount = splitMaxAmount;
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
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartSailTime() {
		return startSailTime;
	}
	public void setStartSailTime(String startSailTime) {
		this.startSailTime = startSailTime;
	}
	public String getEndSailTime() {
		return endSailTime;
	}
	public void setEndSailTime(String endSailTime) {
		this.endSailTime = endSailTime;
	}
	public String getSailDayCycle() {
		return sailDayCycle;
	}
	public void setSailDayCycle(String sailDayCycle) {
		this.sailDayCycle = sailDayCycle;
	}
	public String getVacations() {
		return vacations;
	}
	public void setVacations(String vacations) {
		this.vacations = vacations;
	}
	public Map<String, String[]> getEndRule() {
		return endRule;
	}
	public void setEndRule(Map<String, String[]> endRule) {
		this.endRule = endRule;
	}
	public Map<String, String[]> getStartRule() {
		return startRule;
	}
	public void setStartRule(Map<String, String[]> startRule) {
		this.startRule = startRule;
	}
	public int[][] getCycles() {
		return cycles;
	}
	public void setCycles(int[][] cycles) {
		this.cycles = cycles;
	}
	public String getDrawTime() {
		return drawTime;
	}
	public void setDrawTime(String drawTime) {
		this.drawTime = drawTime;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	

    
}