package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * 返回彩种期号信息
 * 
 * @author HouXB
 *
 */
@SuppressWarnings("serial")
public class NewIssueBO extends BaseBO {
	/**
	 * 彩期序列号
	 */
	private Integer id;
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	/**
	 * 彩种对象，包含编号，彩种名等相关信息
	 */
	private NewTypeBO lotteryType;
	/**
	 * 彩期期号
	 */
	private String issueCode;
	/**
	 * 彩种名称
	 */
	private String lotteryName;
	/**
	 * 0：不是当前期；1：当前期
	 */
	private Short currentIssue;
	/**
	 * 0：暂停销售；1：未开售；2：预售中；3：销售中；4：销售截止；5：已开奖；6：已派奖；7：已兑奖
	 */
	private Short saleStatus;
	/**
	 * 官方截止销售时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date officialEndTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date officialStartTime;
	/**
	 * 彩票开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;
	/**
	 * 彩票开售时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date saleTime;
	/**
	 * 彩票销售截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date saleEndTime;
	/**
	 * 彩票销售总金额
	 */
	private Long salesAmount;
	/**
	 * 奖池金额
	 */
	private Long jackpotAmount;
	/**
	 * 开奖号码
	 */
	private String drawCode;
	/**
	 * 格式例如： 一等奖,2,10000000 | 二等奖,5,200000 |用 | 线隔开；代表 奖项，注数，每注中奖金额
	 */
	private String drawDetail;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 修改人
	 */
	private String modifyBy;
	/**
	 * cms修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifyTime;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 奖池可开出的一等奖数量(如：500万注数)
	 */
	private int firstPrizeCount;
	/**
	 * 销售倒计时长
	 */
	private long saleDownCount = 0;
	/**
	 * 是否最新开奖
	 */
	private Integer issueLastest;
	

	public Date getOfficialStartTime() {
		return officialStartTime;
	}

	public void setOfficialStartTime(Date officialStartTime) {
		this.officialStartTime = officialStartTime;
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

    public NewTypeBO getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(NewTypeBO lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public Short getCurrentIssue() {
		return currentIssue;
	}

	public void setCurrentIssue(Short currentIssue) {
		this.currentIssue = currentIssue;
	}

	public Short getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Date getOfficialEndTime() {
		return officialEndTime;
	}

	public void setOfficialEndTime(Date officialEndTime) {
		this.officialEndTime = officialEndTime;
	}

	public Date getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public Date getSaleEndTime() {
		return saleEndTime;
	}

	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}

	public Long getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(Long salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Long getJackpotAmount() {
		return jackpotAmount;
	}

	public void setJackpotAmount(Long jackpotAmount) {
		this.jackpotAmount = jackpotAmount;
	}

	public String getDrawCode() {
		return drawCode;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public String getDrawDetail() {
		return drawDetail;
	}

	public void setDrawDetail(String drawDetail) {
		this.drawDetail = drawDetail;
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

	public int getFirstPrizeCount() {
		return firstPrizeCount;
	}

	public void setFirstPrizeCount(int firstPrizeCount) {
		this.firstPrizeCount = firstPrizeCount;
	}

	public long getSaleDownCount() {
		if (this.saleDownCount <= 0) {
			return this.saleEndTime.getTime() - new Date().getTime();
		}
		return saleDownCount;
	}

	public void setSaleDownCount(long saleDownCount) {
		this.saleDownCount = saleDownCount;
	}

	public Integer getIssueLastest() {
		return issueLastest;
	}

	public void setIssueLastest(Integer issueLastest) {
		this.issueLastest = issueLastest;
	}
}
