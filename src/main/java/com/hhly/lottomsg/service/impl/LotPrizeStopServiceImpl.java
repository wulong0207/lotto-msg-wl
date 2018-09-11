package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.OrderNoticeBase;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.PrizeNoticeService;

/**
 * 
* @Description: 中奖停追通知
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:57 
* @version V1.0.0
 */
@Service("lotPrizeStopService")
public class LotPrizeStopServiceImpl extends OrderNoticeBase implements PrizeNoticeService{
	
	@Value("${gpc_prize_stop}")
	private int gpcPrizeStopTypeId;//高频彩中奖停追模板编号
	
	@Value("${szc_prize_stop}")
	private int szcPrizeStopTypeId;//数字彩中奖停追模板编号
	
	@Override
	public void handlePrizeNoticeMsg(OrderBO order) throws Exception{
		// 处理代购中奖通知消息
		handlePrizeMsg(order);
	}

	private void handlePrizeMsg(OrderBO order) throws Exception{
		Integer typeId = 0;
		String lotPre = order.getLotCode().toString().substring(0, 1);
		if("1".equals(lotPre)){
			// 数字彩
			typeId = szcPrizeStopTypeId;
		}
		else if("2".equals(lotPre)){
			// 高频彩
			typeId = gpcPrizeStopTypeId;
		}
		OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateByTypeId(typeId);
		String sendLotterys = template.getSendLotteryCode();
		if(isNoSendLot(sendLotterys,order.getLotCode().toString())){
			logger.info("【通知信息管理】" + template.getTypeName() + "模板已设置不支持此彩种通知，彩种编号：" + order.getLotCode());
			return;
		}
		UserInfoBO user = userInfoMapper.findUserInfoById(order.getUserId());
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送中奖停追提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		NodeInfo nodeInfo = handleOrderVariable(order);
		chaseCodeInfoToMap(order.getOrderCode(),nodeInfo.getVariables());
		nodeInfo.setAppFieldsData(getPublicFields(template) + ";" + nodeInfo.getAppFieldsData());
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}

}

