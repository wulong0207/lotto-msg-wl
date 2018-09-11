package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 *	@Desc    用户设置信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:25:36
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
@SuppressWarnings("serial")
public class OperateMsgConfigBO extends BaseBO{
    
	private Integer id;
	
	private Integer templateId;
	
	private String templateName;
	
	private Integer userId;
	
	private Short mob;
	
	private Short app;
	
	private Short site;
	
	private Short wechat;

	public Integer getId() {
		return id;
	}

	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getMob() {
		return mob;
	}

	public void setMob(Short mob) {
		this.mob = mob;
	}

	public Short getApp() {
		return app;
	}

	public void setApp(Short app) {
		this.app = app;
	}

	public Short getSite() {
		return site;
	}

	public void setSite(Short site) {
		this.site = site;
	}

	public Short getWechat() {
		return wechat;
	}

	public void setWechat(Short wechat) {
		this.wechat = wechat;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}