package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.UserInfoNoticeBase;
import com.hhly.lottomsg.bo.NoticeUserInfoBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 关注提醒
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:18 
* @version V1.0.0
 */
@Service("userFollowService")
public class UserFollowServiceImpl extends UserInfoNoticeBase implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(UserFollowServiceImpl.class.getName());
	
	// 专家信息
	private String[] expertNames = {"${专家id}$","${专家昵称}$","${专家账户}$","${专家真实姓名}$","${专家手机号}$","${专家密码}$","${专家身份证号}$","${专家邮箱}$"};

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【通知信息管理】关注提醒模板未添加或已禁用");
			return;
		}
		if(data.length != 2){
			logger.warn("【通知信息管理】关注提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		try{
			// 查找专家
			UserInfoBO expertInfo = userInfoMapper.findUserInfoById(Integer.parseInt(data[0]));
			if(isNoSendChannel(template.getNoSendChannel(),expertInfo.getChannelId())){
				logger.info("【通知信息管理】该用户渠道已设置不发送关注提醒消息，账户：" + expertInfo.getAccount() + ",用户注册渠道id：" + expertInfo.getChannelId());
				return;
			}
			// 查找关注用户
			UserInfoBO user = userInfoMapper.findUserInfoById(Integer.parseInt(data[1]));
			// 转用户动态信息对象
			NoticeUserInfoBO noticeExpert = new NoticeUserInfoBO(expertInfo);
			// 创建通知信息
			NodeInfo nodeInfo = new NodeInfo();
			Map<String,String> map = getUserVariable(user);
			map.putAll(handleExpertVariable(noticeExpert));
			nodeInfo.setVariables(map);
			nodeInfo.setAppFieldsData(getPublicFields(template) + ";expertUserId:" + expertInfo.getId());
			// 处理通知信息
			List<OperateMsgInfoPO> msgs = handleSendInfo(template,expertInfo,nodeInfo,true,true,true);
			if(msgs != null){
				// 入库
				msgInfoDaoMapper.addMsgInfo(msgs);
			}
		}
		catch(Exception e){
			logger.error("【通知信息管理】关注提醒节点自动通知信息服务异常：被关注用户Id：" + data[0] + "，关注用户Id：" + data[1]);
			e.printStackTrace();
		}
		
	}
	
	private Map<String,String> handleExpertVariable(NoticeUserInfoBO user){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<userInfoKeys.length;i++){
			map.put(expertNames[i], user.getValueByName(userInfoKeys[i]));
		}
		return map;
	}
}
