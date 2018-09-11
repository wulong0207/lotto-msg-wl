package com.hhly.lottomsg.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 彩种BO
 * @author huangb
 * @date 2017年3月6日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryBO extends BaseBO {

	private static final long serialVersionUID = 8163931145658264005L;
	/**
	 * 彩种code
	 */
	private Integer lotteryCode;
	/**
	 * 彩种名称
	 */
	private String lotteryName;
	/**
	 * 彩种logo地址
	 */
	private String lotteryLogoUrl;
	
	/**
	 * 彩种状态 0：暂停销售(限制平台)；1：正常销售 ；2：停止销售
	 */
	private Short saleStatus;
	
	/**
	 * 官方开奖时间
	 * 格式为： 2|21:15,4|21:15,7|21:15
	 * 代表周二，周四，周日的21:15分开奖
	 */
	private String drawTime;
	
	/**
	 * 休市时间
	 * 格式为： 2017/01/27,2017/01/28
	 * 代表2017年1月27日休市
	 */
	private String vacations;
	/**
	 * 官方开售时间(即官方可送票时间)；
	 * 若为数字彩,高频彩：1|8:00,2|8:00,3|8:00,4|8:00,5|8:00,6|8:00,7|8:00;
	 *	代表星期几的第一期的官方开售时间
	 *	若为竞彩彩：格式为 1|09:00,2|09:00,3|07:30,4|07:30,5|09:002|09:00,6|09:00,7|09:00  ；
	 *	代表周一，周二，周五每天9点，周三到周四每天7点30开售。
	 *	(不包括老足彩，北京单场，胜负过关彩种，
	 * 	这些彩种为人工在彩期中录入或数据抓取)
	 */
	private String startSailTime;
	/**
	 * 官方截止销售时间
	 */
	private String endSaleTime;
	
	/**
	 * 官方检票时间距离的秒数
	 */
	private Integer endCheckTime;
	/**
	 * 	只针对高频彩；例如：1-30|300,31-60|600, 1到30期，时间间隔为300秒，31到60期时间间隔为600秒。其它彩种为空 1-30为每5分钟一期，31-60为每10分钟一期；
	 */
	private String sailDayCycle;

	/**
	 * 本站销售截止时间前多少秒
	 */
	private Integer buyEndTime;

	/**
	 * 子玩法集
	 */
	@JsonIgnore
	private List<LotChildBO> listLotChildBO;
	
	/********* 20171019 add 彩种状态分平台限制 ********/
	/**
	 * 暂停销售限制平台 1:Web;2:Wap;3:Android;4:IOS;5其它平台 (与字段saleStatus关联使用),多个平台之间用逗号分隔
	 */
	private String platform;
	

	public List<LotChildBO> getListLotChildBO() {
		return listLotChildBO;
	}

	public void setListLotChildBO(List<LotChildBO> listLotChildBO) {
		this.listLotChildBO = listLotChildBO;
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

	public String getLotteryLogoUrl() {
		return lotteryLogoUrl;
	}

	public void setLotteryLogoUrl(String lotteryLogoUrl) {
		this.lotteryLogoUrl = lotteryLogoUrl;
	}

	public Short getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getDrawTime() {
		return drawTime;
	}

	public void setDrawTime(String drawTime) {
		this.drawTime = drawTime;
	}

	public String getVacations() {
		return vacations;
	}

	public void setVacations(String vacations) {
		this.vacations = vacations;
	}

	public String getStartSailTime() {
		return startSailTime;
	}

	public void setStartSailTime(String startSailTime) {
		this.startSailTime = startSailTime;
	}

	public String getEndSaleTime() {
		return endSaleTime;
	}

	public void setEndSaleTime(String endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	public Integer getEndCheckTime() {
		return endCheckTime;
	}

	public void setEndCheckTime(Integer endCheckTime) {
		this.endCheckTime = endCheckTime;
	}

	public String getSailDayCycle() {
		return sailDayCycle;
	}

	public void setSailDayCycle(String sailDayCycle) {
		this.sailDayCycle = sailDayCycle;
	}

	public Integer getBuyEndTime() {
		return buyEndTime;
	}

	public void setBuyEndTime(Integer buyEndTime) {
		this.buyEndTime = buyEndTime;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}