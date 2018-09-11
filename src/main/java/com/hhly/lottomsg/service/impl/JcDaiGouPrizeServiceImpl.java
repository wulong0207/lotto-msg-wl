package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.OrderNoticeBase;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.constants.PayConstants.BuyTypeEnum;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.PrizeNoticeService;

/**
 * 
* @Description: 竞彩代购中奖通知
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:57 
* @version V1.0.0
 */
@Service("jcDaiGouPrizeService")
public class JcDaiGouPrizeServiceImpl extends OrderNoticeBase implements PrizeNoticeService{
	
	// 竞彩代购中奖通知模板编号
	@Value("${jc_daigou_prize}")
	private int jcDaiGouPrize;
	
	@Value("${jc_send_time}")
	private String jcSendTime;
	
	@Override
	public void handlePrizeNoticeMsg(OrderBO order) throws Exception{
		int typeId = 0;
		if(order.getBuyType().equals(BuyTypeEnum.PURCHASING.getKey())){
			// 代购
			typeId = jcDaiGouPrize;
		}
		else if(order.getBuyType().equals(BuyTypeEnum.JOINT_PURCHASE.getKey())){
			// 合买
			
		}
		OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateByTypeId(typeId);
		String sendLotterys = template.getSendLotteryCode();
		if(isNoSendLot(sendLotterys,order.getLotCode().toString())){
			logger.info("【通知信息管理】" + template.getTypeName() + "模板已设置不支持此彩种通知，彩种编号：" + order.getLotCode());
			return;
		}
		// 处理代购中奖通知消息
		NodeInfo nodeInfo = handleOrderVariable(order);
		UserInfoBO user = userInfoMapper.findUserInfoById(order.getUserId());
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送竞彩代购中奖提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		nodeInfo.setAppFieldsData(getPublicFields(template) + ";" + nodeInfo.getAppFieldsData());
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}
}
