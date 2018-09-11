package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.common.constants.UserConstants;
import com.hhly.lottomsg.common.enums.SmsChannelEnum;
import com.hhly.lottomsg.common.util.MailUtil;
import com.hhly.lottomsg.common.util.SmsSendUtil;
import com.hhly.lottomsg.service.ISendService;
import com.hhly.lottomsg.vo.BodyPartVO;

/**
 * 
* @Description: 发送服务 
* @author HouXiangBao289
* @date 2017年12月11日 下午4:53:14 
* @version V1.0.0
 */
@Service("sendService")
public class SendServiceImpl implements ISendService {

	private static final Logger logger = Logger.getLogger(SendServiceImpl.class);
	
	@Override
	public boolean doSendSms(String mobile, String content) {
		logger.info("【发送短信服务】接收手机号：" + mobile + ";短信内容：" + content);
		try 
		{
			boolean isSuc = SmsSendUtil.mdsmssend(SmsChannelEnum.VALIDATECODE.getCode(),mobile, content, "", "", "", "");
			return isSuc;
		}
		catch (Exception e) 
		{
			logger.error("【发送短信服务】发送异常：");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean doSendMail(String to, String content) {
		logger.info("【发送邮件服务】接收邮箱地址：" + to + ";邮件内容：" + (content.length() > 15 ? content.substring(0, 5):content));
		MailUtil mail = new MailUtil();
		return mail.sendMail(content, UserConstants.YICAI_NET, UserConstants.YICAI_EMAIL, to);
	}

//	@Override
	public boolean doSendFilePathMail(String[] toArr, String content, String[] filePathArr) {
		logger.info("【发送邮件服务】接收邮箱地址(群发)：" + toArr + ";邮件内容：" + (content.length() > 15 ? content.substring(0, 5):content));
		MailUtil mail = new MailUtil();
		return mail.sendMail(content, UserConstants.YICAI_NET, UserConstants.YICAI_EMAIL, toArr,filePathArr);
	}
	
	@Override
	public boolean doSendBodyPartMail(String[] toArr, String content, List<BodyPartVO> fileBodyPartList) {
		logger.info("【发送邮件服务】接收邮箱地址(群发)：" + toArr + ";邮件内容：" + (content.length() > 15 ? content.substring(0, 5):content));
		MailUtil mail = new MailUtil();
		return mail.sendMail(content, UserConstants.YICAI_NET, UserConstants.YICAI_EMAIL, toArr,fileBodyPartList);
	}

}
