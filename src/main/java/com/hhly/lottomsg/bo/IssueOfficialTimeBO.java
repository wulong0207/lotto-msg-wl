package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 彩期出票时间段实体
 * @author huangb
 * @date 2017年4月19日
 * @company 益彩网络
 * @version v1.0
 */
public class IssueOfficialTimeBO extends BaseBO {

	private static final long serialVersionUID = -2640242786429316282L;
	/**
	 * 官方出票开始时间点（用于低频和高频彩；eg 9:00）
	 */
	private String officialStartTimeStr;
	/**
	 * 官方出票结束时间点（用于低频和高频彩；eg 20:00）
	 */
	private String officialEndTimeStr;
	/**
	 * 上一期官方出票结束时间（用于竞技彩；eg 04/18 7:30）
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date lastOfficialEndTime;
	/**
	 * 官方出票开始时间（用于竞技彩；eg 04/18 7:30）
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date officialStartTime;
	/**
	 * 官方出票结束时间（用于竞技彩；eg 04/18 7:30）
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date officialEndTime;

	public IssueOfficialTimeBO() {
	}

	public IssueOfficialTimeBO(Date lastOfficialEndTime, Date officialStartTime, Date officialEndTime) {
		this.lastOfficialEndTime = lastOfficialEndTime;
		this.officialStartTime = officialStartTime;
		this.officialEndTime = officialEndTime;
	}

	public String getOfficialStartTimeStr() {
		return officialStartTimeStr;
	}

	public void setOfficialStartTimeStr(String officialStartTimeStr) {
		this.officialStartTimeStr = officialStartTimeStr;
	}

	public String getOfficialEndTimeStr() {
		return officialEndTimeStr;
	}

	public void setOfficialEndTimeStr(String officialEndTimeStr) {
		this.officialEndTimeStr = officialEndTimeStr;
	}

	public Date getLastOfficialEndTime() {
		return lastOfficialEndTime;
	}

	public void setLastOfficialEndTime(Date lastOfficialEndTime) {
		this.lastOfficialEndTime = lastOfficialEndTime;
	}

	public Date getOfficialStartTime() {
		return officialStartTime;
	}

	public void setOfficialStartTime(Date officialStartTime) {
		this.officialStartTime = officialStartTime;
	}

	public Date getOfficialEndTime() {
		return officialEndTime;
	}

	public void setOfficialEndTime(Date officialEndTime) {
		this.officialEndTime = officialEndTime;
	}

}
