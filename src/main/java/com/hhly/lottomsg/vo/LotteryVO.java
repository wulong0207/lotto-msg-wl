package com.hhly.lottomsg.vo;

import java.util.Date;
import java.util.List;

import com.hhly.lottomsg.base.vo.BaseVO;

/**
 * @desc 彩种VO
 * @author huangb
 * @date 2017年3月6日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryVO extends BaseVO {

	private static final long serialVersionUID = 5758711397011984792L;

	/**
	 * 彩种code
	 */
	private Integer lotteryCode;

	/**
	 * 彩种类型
	 */
	private Short lotteryCategory;
	
    /**
     * 0：请选择；1：全国；2：华东六省；3：广东
     */
    private Short area;

	/**
	 * 彩期
	 */
	private String issueCode;

	/**
	 * 是否当前期0：不是当前期；1：当前期
	 */
	private Short currentIssue;

	/**
	 * 查询记录数(eg：查近8期)
	 */
	private Integer qryCount;
	
	/**
	 * 查询标识；1：查遗漏；2：查冷热；3：查概率
	 */
	private Integer qryFlag;
	/**
	 * 遗漏类型
	 */
	private Short omitType;
	/**
	 * 主表限号状态1：启用；2：禁用；3：过期
	 */
	private Short status;
	
	/**
	 * 限号日期
	 */
	private Date limitDate;
	
	/**
	 * 一个或多个子玩法
	 */
	private List<Integer> subPlays;
	
	/**
	 * 查询开奖公告彩种
	 */
	private Integer drawType;

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public LotteryVO() {
	}

	/**
	 * @param lotteryCode
	 *            彩种
	 */
	public LotteryVO(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	/**
	 * @param lotteryCode
	 *            彩种
	 * @param currentIssue
	 *            当前期
	 */
	public LotteryVO(Integer lotteryCode, Short currentIssue) {
		this(lotteryCode);
		this.currentIssue = currentIssue;
	}

	/**
	 * @param name
	 * @param num8
	 */
	public LotteryVO(int lotteryCode, int qryCount) {
		this.lotteryCode = lotteryCode;
		this.qryCount = qryCount;
	}

	/**
	 * @param lotteryCode
	 * @param issueCode
	 */
	public LotteryVO(Integer lotteryCode, String issueCode) {
		this.lotteryCode = lotteryCode;
		this.issueCode = issueCode;
	}

	public LotteryVO(String issueCode) {
		this.issueCode = issueCode;
	}

	public LotteryVO(String issueCode, int qryCount) {
		this(issueCode);
		this.qryCount = qryCount;
	}

	public LotteryVO(Integer lotteryCode, String issueCode, int qryCount) {
		this(lotteryCode, issueCode);
		this.qryCount = qryCount;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Short getLotteryCategory() {
		return lotteryCategory;
	}

	public void setLotteryCategory(Short lotteryCategory) {
		this.lotteryCategory = lotteryCategory;
	}

	public Short getArea() {
		return area;
	}

	public void setArea(Short area) {
		this.area = area;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public Short getCurrentIssue() {
		return currentIssue;
	}

	public void setCurrentIssue(Short currentIssue) {
		this.currentIssue = currentIssue;
	}

	public Integer getQryCount() {
		return qryCount;
	}

	public void setQryCount(Integer qryCount) {
		this.qryCount = qryCount;
	}

	public Short getOmitType() {
		return omitType;
	}

	public void setOmitType(Short omitType) {
		this.omitType = omitType;
	}

	public Integer getQryFlag() {
		return qryFlag;
	}

	public void setQryFlag(Integer qryFlag) {
		this.qryFlag = qryFlag;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public List<Integer> getSubPlays() {
		return subPlays;
	}

	public void setSubPlays(List<Integer> subPlays) {
		this.subPlays = subPlays;
	}

	public Integer getDrawType() {
		return drawType;
	}

	public void setDrawType(Integer drawType) {
		this.drawType = drawType;
	}
}
