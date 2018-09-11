package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.OrderNoticeBase;
import com.hhly.lottomsg.bo.NoticeUserInfoBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.OrderIssueInfoBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.OrderIssueInfoDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 专家推荐
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:05 
* @version V1.0.0
 */
@Service("recommendOrderService")
public class RecommendOrderServiceImpl extends OrderNoticeBase implements TemplateMsgService{
	
	@Autowired
	private OrderIssueInfoDaoMapper orderIssueInfoDaoMapper;
	
	private Logger logger = Logger.getLogger(RecommendOrderServiceImpl.class.getName());
	
	private String[] expertOrderKeys =  {"maxRoi","recommendReason","commissionRate","followNum","followAmount","createTime","commissionAmount"};
	private String[] expertOrderNames = {"${回报率}$","${推荐理由}$","${提成比率}$","${跟单总人数}$","${跟单总金额}$","${发起时间}$","${佣金}$"};
	private static final String playName = "${子玩法}$";

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) throws Exception{
		orderMoneyNotice(template,data);
	}
	
	/**
	 * 
	 * @Description 专家推荐
	 * @author HouXiangBao289
	 * @param template
	 * @throws Exception
	 */
	private void orderMoneyNotice(OperateMsgTemplateBO template,String[] data) {
		if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
			logger.warn("【通知信息管理】专家推荐方案提醒模板未添加或已禁用");
			return;
		}
		if(data.length != 2)
		{
			logger.warn("【通知信息管理】专家推荐方案提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		try{
			// 根据推荐方案号查询推荐方案
			OrderIssueInfoBO orderInfo = orderIssueInfoDaoMapper.findIssueBOById(data[1]);
			// 查询方案发单人(专家)
			UserInfoBO user = userInfoMapper.findUserInfoById(Integer.parseInt(data[0]));
			OrderBO order = orderDaoMapper.findOrderInfoByCode(orderInfo.getOrderCode());
			Map<String,String> variables = handleExpertOrderVariable(user,orderInfo,order);
			//APP附近字段数据
			String appFieldsData =getPublicFields(template) + ";lotteryCode:" + order.getLotCode() + ";orderId:" + orderInfo.getId() + ";orderCode:" + orderInfo.getOrderCode() + ";expertUserId:" + user.getId();
			// 查询专家粉丝
			List<UserInfoBO> sendUsers = userInfoMapper.findUserFans(orderInfo.getUserIssueId());
			for(UserInfoBO sendUser:sendUsers){
				if(isNoSendChannel(template.getNoSendChannel(),sendUser.getChannelId())){
					logger.info("【通知信息管理】该用户渠道已设置不发送专家推荐提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
					continue;
				}
				NodeInfo nodeInfo = new NodeInfo();
				nodeInfo.setAppFieldsData(appFieldsData);
				variables.putAll(getUserVariable(sendUser));
				nodeInfo.setVariables(variables);
				List<OperateMsgInfoPO> msgs = handleSendInfo(template,sendUser,nodeInfo,true,true,true);
				if(msgs != null){
					msgInfoDaoMapper.addMsgInfo(msgs);
				}
			}
		}catch(Exception e){
			logger.error("【通知信息管理】专家推荐方案提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description 处理消息动态内容
	 * @author HouXiangBao289
	 * @param userInfo 发单人
	 * @param orderInfo 推荐订单
	 * @return
	 */
	private Map<String,String> handleExpertOrderVariable(UserInfoBO userInfo,OrderIssueInfoBO orderInfo,OrderBO order){
		NoticeUserInfoBO noticeInfo = new NoticeUserInfoBO(userInfo);
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<userInfoKeys.length;i++){
			map.put(expertNames[i], noticeInfo.getValueByName(userInfoKeys[i]));
		}
		for(int i=0;i<expertOrderKeys.length;i++){
			map.put(expertOrderNames[i], orderInfo.getValueByName(expertOrderKeys[i]));
		}
		map.putAll(handleOrderVariable(order).getVariables());
		map.put(playName,getLotteryChildName(order.getPlay()));
		return map;
	}
}
