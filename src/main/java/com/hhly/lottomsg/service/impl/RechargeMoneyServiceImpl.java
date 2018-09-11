package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.FinanceBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.FinanceDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 充值提醒 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:05 
* @version V1.0.0
 */
@Service("rechargeMoneyService")
public class RechargeMoneyServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	@Autowired
	private FinanceDaoMapper financeDaoMapper;
	
	private Logger logger = Logger.getLogger(RechargeMoneyServiceImpl.class.getName());
	
	private String[] rechargeInfoKeys = {"rechargeAmount","accountBalance","bankCardCode"};
	private String[] rechargeInfoNames = {"${充值金额}$","${当前余额}$","${提款卡号}$"};

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		try
		{
			rechargeMoneyNotice(template,data);
		}
		catch(Exception e){
			logger.warn("【通知信息管理】充值提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description 充值提醒
	 * @author HouXiangBao289
	 * @param data 格式：用户Id;充值金额;当前余额
	 * @param template
	 * @throws Exception
	 */
	private void rechargeMoneyNotice(OperateMsgTemplateBO template,String[] data)throws Exception {
		if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【通知信息管理】充值提醒模板未添加或已禁用");
			return;
		}
		if(data.length != 2)
		{
			logger.warn("【通知信息管理】充值提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		int userId = Integer.parseInt(data[0]);
		UserInfoBO user = userInfoMapper.findUserInfoById(userId);
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送充值提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		FinanceBO rechargeInfo = financeDaoMapper.selectRechargeLog(user.getId(), data[1]);
		Map<String,String> variables = handleVariable(user,rechargeInfo);
		NodeInfo nodeInfo = new NodeInfo();
		nodeInfo.setVariables(variables);
		//APP附近字段数据
		String appFieldsData = getPublicFields(template);
		nodeInfo.setAppFieldsData(appFieldsData);
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}
	
	private Map<String,String> handleVariable(UserInfoBO user,FinanceBO rechargeInfo){
		Map<String,String> map = new HashMap<String,String>();
		map.putAll(getUserVariable(user));
		for(int i=0;i<rechargeInfoKeys.length;i++){
			map.put(rechargeInfoNames[i], rechargeInfo.getValueByName(rechargeInfoKeys[i]));
		}
		return map;
	}
}
