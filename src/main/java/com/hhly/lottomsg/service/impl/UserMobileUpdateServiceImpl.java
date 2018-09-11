package com.hhly.lottomsg.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.UserInfoNoticeBase;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 会员换手机登录提醒
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:18 
* @version V1.0.0
 */
@Service("userMobileUpdateService")
public class UserMobileUpdateServiceImpl extends UserInfoNoticeBase implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(UserMobileUpdateServiceImpl.class.getName());

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) {
		try{
			if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
				logger.warn("【通知信息管理】会员换手机登录提醒模板未添加或已禁用");
				return;
			}
			if(data.length != 1){
				logger.warn("【通知信息管理】会员换手机登录提醒节点自动通知信息服务收到非法请求数据");
				return;
			}
			userInfoUpdateNotice(template,data);
		}catch(Exception e){
			logger.warn("【通知信息管理】会员换手机登录提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}

}
