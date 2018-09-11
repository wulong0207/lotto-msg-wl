package com.hhly.lottomsg.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 银行实体
 * @author xiongJinGang
 * @date 2017年4月8日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayBankBO implements Serializable {
	private static final long serialVersionUID = -4636809320077958924L;
	/**
	 * 自增ID
	 */
	private Integer id;
	/**
	 * 银行名称
	 */
	private String name;
	/**
	 * 银行简称
	 */
	private String cName;
	/**
	 * 银行状态:0停用,1可用
	 */
	private Short status;
	/**
	 * 支付类型:1银行卡,2第三方支付
	 */
	private Short payType;
	/**
	 * 银行大Logo
	 */
	private String bLogo;
	/**
	 * 银行小Logo
	 */
	private String sLogo;
	/**
	 * PC排序
	 */
	private Short orderPc;
	/**
	 * H5排序
	 */
	private Short orderH5;
	/**
	 * ANDROID排序
	 */
	private Short orderAndroid;
	/**
	 * IOS排序
	 */
	private Short orderIos;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 修改人
	 */
	private String modifyBy;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 银行编码
	 */
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getPayType() {
		return payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	public String getbLogo() {
		return bLogo;
	}

	public void setbLogo(String bLogo) {
		this.bLogo = bLogo;
	}

	public String getsLogo() {
		return sLogo;
	}

	public void setsLogo(String sLogo) {
		this.sLogo = sLogo;
	}

	public Short getOrderPc() {
		return orderPc;
	}

	public void setOrderPc(Short orderPc) {
		this.orderPc = orderPc;
	}

	public Short getOrderH5() {
		return orderH5;
	}

	public void setOrderH5(Short orderH5) {
		this.orderH5 = orderH5;
	}

	public Short getOrderAndroid() {
		return orderAndroid;
	}

	public void setOrderAndroid(Short orderAndroid) {
		this.orderAndroid = orderAndroid;
	}

	public Short getOrderIos() {
		return orderIos;
	}

	public void setOrderIos(Short orderIos) {
		this.orderIos = orderIos;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}