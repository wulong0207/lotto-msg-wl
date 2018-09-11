package com.hhly.lottomsg.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.UserInfoNoticeBase;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.constants.UserConstants;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.MailUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 用户禁用提醒
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:18 
* @version V1.0.0
 */
@Service("forbiddenNoticeService")
public class ForbiddenNoticeServiceImpl extends UserInfoNoticeBase implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(ForbiddenNoticeServiceImpl.class.getName());
	
	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		try{
			if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
				logger.warn("【通知信息管理】用户禁用提醒模板未添加或已禁用");
				return;
			}
			if(data.length != 1){
				logger.warn("【通知信息管理】用户禁用提醒节点自动通知信息服务收到非法请求数据");
				return;
			}
			UserInfoBO user = userInfoMapper.findUserInfoById(Integer.parseInt(data[0]));
			if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
				logger.info("【通知信息管理】该用户渠道已设置不发送用户禁用提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
				return;
			}
			NodeInfo nodeInfo = new NodeInfo();
			Map<String,String> map = getUserVariable(user);
			map.put("${触发禁用时间}$", DateUtil.getNow());
			nodeInfo.setVariables(map);
			nodeInfo.setAppFieldsData(getPublicFields(template));
			List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
			if(msgs != null){
				msgInfoDaoMapper.addMsgInfo(msgs);
			}
			if(StringUtil.isBlank(user.getMobile()) && !StringUtil.isBlank(user.getEmail())){
				String content = "账户风险提醒：您的账户“" + user.getNickname() + "”存在被盗风险，已将账户冻结。如非本人操作，请及时修改密码。";
				MailUtil mail = new MailUtil();
				mail.sendMail(content, UserConstants.YICAI_NET, UserConstants.YICAI_EMAIL, user.getEmail());
				logger.info("【发送邮件服务】接收邮箱地址：" + user.getEmail() + ";邮件内容：" + content);
			}
			
		}catch(Exception e){
			logger.error("【通知信息管理】用户禁用提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}
}
