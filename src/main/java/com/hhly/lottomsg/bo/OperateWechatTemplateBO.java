package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 *	@Desc    微信公众号模板信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:25:36
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
@SuppressWarnings("serial")
public class OperateWechatTemplateBO extends BaseBO{
    
	private Integer id;

	private String typeCode;
	
	private String typeName;
	
	private Integer status;
	
	private String headerColor;
	
	private String footerColor;
	
	private String title;
	
	private String color;
	
	private Integer msgType;
	
	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getHeaderColor() {
		return headerColor;
	}

	public void setHeaderColor(String headerColor) {
		this.headerColor = headerColor;
	}

	public String getFooterColor() {
		return footerColor;
	}

	public void setFooterColor(String footerColor) {
		this.footerColor = footerColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}