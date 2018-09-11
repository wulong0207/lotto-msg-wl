package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 世界杯球队淘汰通知 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:15:41
* @version V1.0.0
 */
@Service("obsoletedNoticeService")
public class ObsoletedNoticeServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(ObsoletedNoticeServiceImpl.class.getName());

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		if(template == null || template.getStatus().intValue() == UseStatus.INVALID.getCode().intValue()){
			logger.warn("【通知信息管理】世界杯球队淘汰通知模板未添加或已禁用！");
			return;
		}
		if(data.length != 3){
			logger.warn("【通知信息管理】世界杯球队淘汰通知节点自动通知信息服务收到非法请求数据");
			return;
		}
		
		int lotteryCode = Integer.parseInt(data[0]);// 彩种编号
		NodeInfo nodeInfo = new NodeInfo();
		//APP附近字段数据
		String appFieldsData = getPublicFields(template);
		nodeInfo.setAppFieldsData(appFieldsData);
		Map<String,String> variables = new HashMap<String,String>();
		String lotName = "冠军竞猜球队";
		if(lotteryCode == 309){lotName="冠亚军竞猜对阵";}
		variables.put("${彩种}$", lotName);
		variables.put("${球队名称}$", data[2]);
		List<String> mobiles = userInfoMapper.findUserSameMobile();
		List<String> noMobiles = new ArrayList<String>();
		List<UserInfoBO> users = userInfoMapper.findObsoletedUsers(lotteryCode + "%", "%" + data[1] + "@%");
		logger.info("【通知信息管理】世界杯球队淘汰通知提醒节点自动通知信息服务获取通知用户数：" + users.size());
		List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
		for(UserInfoBO user:users)
		{
			if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
				logger.info("【通知信息管理】该用户渠道已设置不发送世界杯球队淘汰通知消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
				continue;
			}
			try{
				boolean isSmsSend = true;// 多账号绑定同一手机号只发送一次
				String userMobile = user.getMobile();
				if(mobiles.contains(userMobile)){
					if(noMobiles.contains(userMobile)){
						isSmsSend = false;
					}else{
						noMobiles.add(userMobile);
					}
				}
				Map<String,String> map = getUserVariable(user);
				map.putAll(variables);
				nodeInfo.setVariables(map);
				List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,isSmsSend,true);
				if(msgs!=null)
					msgInfoList.addAll(msgs);
			}catch(Exception e){
				logger.warn("【通知信息管理】世界杯球队淘汰通知提醒节点自动通知信息服务异常：");
				e.printStackTrace();
			}
		}
		if(msgInfoList.size() > 0)
			msgInfoDaoMapper.addMsgInfo(msgInfoList);
		
	}

}
