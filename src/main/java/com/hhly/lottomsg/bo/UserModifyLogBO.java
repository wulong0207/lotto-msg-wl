package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * 用户操作日志
 * @desc
 * @author zhouyang
 * @date 2017年2月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class UserModifyLogBO extends BaseBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 主键ID
	 */
	@JsonProperty("p_id")
	private Integer id;
	
	/**
	 * 用户ID
	 */
	@JsonProperty("u_id")
	private Integer userId;
	
	/**
	 * 用户操作类型或者栏目
	 */
	@JsonProperty("u_act")
	private Short userAction;
	
	/**
	 * 操作状态	0：失败，1：成功，2：操作中
	 */
	@JsonProperty("op_sts")
	private Short operationStatus;
	
	/**
	 * 用户IP
	 */
	@JsonProperty("u_ip")
	private String userIp;
	
	/**
	 * 修改前的数据
	 */
	@JsonProperty("log_bf")
	private String logBefore;
	private String preLoginTime;

	public String getPreLoginTime() {
		return preLoginTime;
	}

	public void setPreLoginTime(String preLoginTime) {
		this.preLoginTime = preLoginTime;
	}

	/**
	 * 修改后的数据
	 */
	@JsonProperty("log_af")
	private String logAfter;
	
	/**
	 * 创建时间
	 */
	@JsonProperty("cre_tm")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	/**
	 * 备注
	 */
	@JsonProperty("rmk")
	private String remark;

	/**
	 * 城市
	 */
	@JsonProperty("pro")
	private String province;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getUserAction() {
		return userAction;
	}

	public void setUserAction(Short userAction) {
		this.userAction = userAction;
	}

	public Short getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(Short operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getLogBefore() {
		return logBefore;
	}

	public void setLogBefore(String logBefore) {
		this.logBefore = logBefore;
	}

	public String getLogAfter() {
		return logAfter;
	}

	public void setLogAfter(String logAfter) {
		this.logAfter = logAfter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
