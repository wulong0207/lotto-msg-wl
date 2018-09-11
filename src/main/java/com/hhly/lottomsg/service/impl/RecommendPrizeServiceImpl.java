package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.OrderNoticeBase;
import com.hhly.lottomsg.bo.NoticeUserInfoBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.OrderIssueInfoBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.OrderIssueInfoDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.PrizeNoticeService;

/**
 * 
* @Description: 推荐提成通知
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:57 
* @version V1.0.0
 */
@Service("recommendPrizeService")
public class RecommendPrizeServiceImpl extends OrderNoticeBase implements PrizeNoticeService{
	
	private Logger logger = Logger.getLogger(RecommendPrizeServiceImpl.class.getName());
	
	@Autowired
	private OrderIssueInfoDaoMapper orderIssueInfoDaoMapper;
	
	@Value("${recommend_commision}")
	private int recommendCommision;
	
	private String[] recommendOrderKeys =  {"maxRoi","recommendReason","commissionRate","followNum","followAmount","createTime","commissionAmount"};
	private String[] recommendOrderNames = {"${回报率}$","${推荐理由}$","${提成比率}$","${跟单总人数}$","${跟单总金额}$","${发起时间}$","${佣金}$"};

	
	@Override
	public void handlePrizeNoticeMsg(OrderBO order){
		try{
			
			OrderIssueInfoBO recommendOrder = orderIssueInfoDaoMapper.findIssueBOById(order.getOrderCode());
			//有抄单人且有提成
			if(recommendOrder.getFollowNum() > 0 && recommendOrder.getCommissionAmount() > 0.00){
				NodeInfo nodeInfo = handleOrderVariable(order);
				Map<String,String> map = new HashMap<String,String>();
				for(int i=0;i<recommendOrderKeys.length;i++){
					map.put(recommendOrderNames[i], recommendOrder.getValueByName(recommendOrderKeys[i]));
				}
				// 发单人
				UserInfoBO user = userInfoMapper.findUserInfoById(order.getUserId());
				OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateByTypeId(recommendCommision);
				if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
					logger.info("【通知信息管理】该用户渠道已设置不发送提成提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
					return;
				}
				NoticeUserInfoBO noticeInfo = new NoticeUserInfoBO(user);
				for(int i=0;i<userInfoKeys.length;i++){
					map.put(expertNames[i], noticeInfo.getValueByName(userInfoKeys[i]));
				}
				nodeInfo.getVariables().putAll(map);
				
				//APP附近字段数据
				String appFieldsData = getPublicFields(template) + ";lotteryCode:" + order.getLotCode() + ";orderId:" + order.getId() 
					+ ";orderCode:" + order.getOrderCode() + ";expertUserId:" + user.getId();
				nodeInfo.setAppFieldsData(appFieldsData);
				List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
				if(msgs != null){
					msgInfoDaoMapper.addMsgInfo(msgs);
				}
			}
		}catch(Exception e){
			logger.error("【通知信息管理】推荐提成通知提醒节点自动通知信息服务异常：发单人ID：" + order.getUserId() + "，方案编号：" + order.getOrderCode());
			e.printStackTrace();
		}
	}
}
