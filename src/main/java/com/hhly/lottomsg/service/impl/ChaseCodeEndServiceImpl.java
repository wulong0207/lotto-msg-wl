package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.ChaseCodePlanBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.common.enums.OrderEnum.BuyType;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.ChaseCodePlanDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 追号结束通知
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:57 
* @version V1.0.0
 */
@Service("chaseCodeEndService")
public class ChaseCodeEndServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{

	@Autowired
	protected ChaseCodePlanDaoMapper chaseCodePlanDaoMapper;
	
	private String[] orderAddKeys = {"userId","nickName","lotName","issue","chaseIssueNum","chasedIssueNum","statusName","prizeMoney","buyTime","orderAddCode","lotUrlName"};
	private String[] orderAddNames = {"${会员id}$","${昵称}$","${彩种}$","${彩期}$","${追号期数}$","${已追期数}$","${追号状态}$","${中奖金额}$","${发起时间}$","${追号编号}$","${彩种路径名称}$"};
	
	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template, String[] data) throws Exception {
		if(data.length != 1){
			logger.warn("【通知信息管理】追号结束提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		ChaseCodePlanBO orderAddPlan = chaseCodePlanDaoMapper.selectChaseCodeByOrderAddCode(data[0]);
		orderAddPlan.setLotName(LotteryEnum.Lottery.getLottery(orderAddPlan.getLotCode()).getDesc());
		UserInfoBO user = userInfoMapper.findUserInfoById(orderAddPlan.getUserId());
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送追号结束提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		orderAddPlan.setNickName(user.getNickname());
		Map<String,String> map = handleVariable(orderAddPlan);
		NodeInfo nodeInfo = new NodeInfo();
		nodeInfo.setVariables(map);
		//APP附近字段数据
		String appFieldsData = getPublicFields(template) + ";lotteryCode:" + orderAddPlan.getLotCode() + ";buyType:" + BuyType.BUY_CHASE.getValue() + ";orderCode:" + orderAddPlan.getOrderAddCode();
		nodeInfo.setAppFieldsData(appFieldsData);
		
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}
	
	private Map<String,String> handleVariable(ChaseCodePlanBO chaseCode){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<orderAddKeys.length;i++){
			map.put(orderAddNames[i], chaseCode.getValueByName(orderAddKeys[i]));
		}
		return map;
	}

}

