package com.hhly.lottomsg.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.UserInfoNoticeBase;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.OrderDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 积分兑换失败提醒
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:18 
* @version V1.0.0
 */
@Service("exchangeErrNoticeService")
public class ExchangeErrNoticeServiceImpl extends UserInfoNoticeBase implements TemplateMsgService{
	
	private Logger logger = Logger.getLogger(ExchangeErrNoticeServiceImpl.class.getName());
	
	@Autowired
	protected OrderDaoMapper orderDaoMapper;
	
	protected String[] orderKeys = {"id","lotName","issue","nickName","accountName","buyTypeName","orderCode","preBonus","prizeGrade","redTypeName","redPacketMoney","buyTime","lotUrlName","remark","redeemCode"};
	protected String[] orderNames = {"${方案id}$","${彩种}$","${彩期}$","${昵称}$","${账户}$","${购买类型}$","${方案编号}$","${中奖金额}$","${中奖等级}$","${红包类型}$","${红包面额}$","${购买时间}$","${彩种路径名称}$","${撤单原因}$","${兑换码}$"};
	
	/**
	 * data 订单号
	 */
	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		try{
			if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
				logger.warn("【通知信息管理】积分兑换失败提醒模板未添加或已禁用");
				return;
			}
			if(data.length != 1){
				logger.warn("【通知信息管理】积分兑换失败提醒节点自动通知信息服务收到非法请求数据");
				return;
			}
			OrderBO orderInfo = orderDaoMapper.findOrderInfoByCode(data[0]);
			UserInfoBO user = userInfoMapper.findUserInfoById(orderInfo.getUserId());
			if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
				logger.info("【通知信息管理】该用户渠道已设置不发送积分兑换失败提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
				return;
			}
			NodeInfo nodeInfo = new NodeInfo();
			Map<String,String> map = getUserVariable(user);
			if(orderInfo != null){
				for(int i=0;i<orderKeys.length;i++){
					map.put(orderNames[i], orderInfo.getValueByName(orderKeys[i]));
				}
			}
			nodeInfo.setVariables(map);
			nodeInfo.setAppFieldsData(getPublicFields(template));
			List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
			if(msgs != null){
				msgInfoDaoMapper.addMsgInfo(msgs);
			}
		}catch(Exception e){
			logger.error("【通知信息管理】积分兑换失败提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}
}
