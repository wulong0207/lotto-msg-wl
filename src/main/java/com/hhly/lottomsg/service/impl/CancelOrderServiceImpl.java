package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.OrderDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 撤单提醒
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:18 
* @version V1.0.0
 */
@Service("cancelOrderService")
public class CancelOrderServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(CancelOrderServiceImpl.class.getName());
	
	@Autowired
	protected OrderDaoMapper orderDaoMapper;
	
	protected String[] orderKeys = {"id","lotName","issue","nickName","accountName","buyTypeName","orderCode","buyTime","lotUrlName","remark"};
	protected String[] orderNames = {"${方案id}$","${彩种}$","${彩期}$","${昵称}$","${账户}$","${购买类型}$","${方案编号}$","${购买时间}$","${彩种路径名称}$","${撤单原因}$"};
	

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) throws Exception{
		if(data.length != 1){
			logger.warn("【通知信息管理】撤单提醒服务收到非法请求数据");
			return;
		}
		OrderBO order = orderDaoMapper.findOrderInfoByCode(data[0]);
		UserInfoBO user = userInfoMapper.findUserInfoById(order.getUserId());
		if(user != null)
		{
			if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
				logger.info("【通知信息管理】该用户渠道已设置不发送撤单提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
				return;
			}
			Map<String,String> variables = handleVariable(order);
			NodeInfo nodeInfo = new NodeInfo();
			nodeInfo.setVariables(variables);
			//APP附近字段数据
			String appFieldsData = getPublicFields(template) + ";lotteryCode:" + order.getLotCode() + ";buyType:" + order.getBuyType() + ";orderCode:" + order.getOrderCode();
			nodeInfo.setAppFieldsData(appFieldsData);
			List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
			if(msgs != null){
				msgInfoDaoMapper.addMsgInfo(msgs);
			}
		}
		
	}
	
	private Map<String,String> handleVariable(OrderBO order){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<orderKeys.length;i++){
			map.put(orderNames[i], order.getValueByName(orderKeys[i]));
		}
		return map;
	}

}
