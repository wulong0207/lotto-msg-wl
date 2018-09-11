package com.hhly.lottomsg.base.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hhly.lottomsg.bo.ChaseCodePlanBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.ChaseCodePlanDaoMapper;
import com.hhly.lottomsg.mapper.OrderDaoMapper;

public class OrderNoticeBase extends NodeMsgServiceBaseImpl{
	
	@Autowired
	protected OrderDaoMapper orderDaoMapper;
	
	@Autowired
	protected ChaseCodePlanDaoMapper chaseCodePlanDaoMapper;
	
	protected String[] orderKeys = {"id","lotName","issue","nickName","accountName","buyTypeName","orderCode","preBonus","prizeGrade","redTypeName","redPacketMoney","buyTime","lotUrlName","remark","redeemCode"};
	protected String[] orderNames = {"${方案id}$","${彩种}$","${彩期}$","${昵称}$","${账户}$","${购买类型}$","${方案编号}$","${中奖金额}$","${中奖等级}$","${红包类型}$","${红包面额}$","${购买时间}$","${彩种路径名称}$","${撤单原因}$","${兑换码}$"};
	// 专家信息
	protected String[] expertNames = {"${专家id}$","${专家昵称}$","${专家账户}$","${专家真实姓名}$","${专家手机号}$","${专家密码}$","${专家身份号}$","${专家邮箱}$","${禁用解除时间}$"};
	
	protected NodeInfo handleOrderVariable(OrderBO order){
		NodeInfo data = new NodeInfo();
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<orderKeys.length;i++){
			map.put(orderNames[i], order.getValueByName(orderKeys[i]));
		}
		data.setVariables(map);
		data.setAppFieldsData("lotteryCode:" + order.getLotCode() + ";buyType:" + order.getBuyType() + ";orderCode:" + order.getOrderCode());
		return data;
	}
	
	/**
	 * 
	 * @Description 处理追号相关字段
	 * @author HouXiangBao289
	 * @param chaseCodeInfo
	 * @param map
	 */
	protected void chaseCodeInfoToMap(String orderCode,Map<String,String> map){
		ChaseCodePlanBO chaseCodeInfo = chaseCodePlanDaoMapper.selectChaseCodeByOrder(orderCode);
		if(chaseCodeInfo != null){
			map.put("${追号期数}$", chaseCodeInfo.getChaseIssueNum()==null?"":chaseCodeInfo.getChaseIssueNum().toString());
			map.put("${已追期数}$", chaseCodeInfo.getChasedIssueNum().toString());
			map.put("${追号状态}$", chaseCodeInfo.getStatusName());
			map.put("${追号中奖金额}$", chaseCodeInfo.getPrizeMoney().toString());
		}
	}
}
