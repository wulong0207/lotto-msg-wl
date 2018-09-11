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
* @Description: 普通彩中奖通知
* @author HouXiangBao289
* @date 2017年6月19日 下午4:16:57 
* @version V1.0.0
 */
@Service("lotPrizeService")
public class LotPrizeServiceImpl extends OrderNoticeBase implements PrizeNoticeService{

	@Value("${szc_daigou_fudong_prize}")
	private int szcDaiGouFuDongTypeId;//数字彩代购浮动奖通知模板编号
	
	@Value("${szc_daigou_guding_prize}")
	private int szcDaiGouGuDingTypeId;//数字彩代购固定奖通知模板编号
	
	@Value("${szc_zhuihao_fudong_prize}")
	private int szcZhuiHaoFuDongTypeId;//数字彩追号浮动奖通知模板编号
	
	@Value("${szc_zhuihao_guding_prize}")
	private int szcZhuiHaoGuDingTypeId;//数字彩追号固定奖通知模板编号
	
	@Value("${gpc_daigou_prize}")
	private int gpcDaigouTypeId;//高频彩代购中奖通知模板编号
	
	@Value("${gpc_zhuihao_prize}")
	private int gpcZhuiHaoTypeId;//高频彩追号中奖通知模板编号
	
	@Override
	public void handlePrizeNoticeMsg(OrderBO order) throws Exception{
		// 处理代购中奖通知消息
		handlePrizeMsg(order);
	}

	private void handlePrizeMsg(OrderBO order) throws Exception{
		Integer typeId = 0;
		if(order.getBuyType() < 3){
			String lotPre = order.getLotCode().toString().substring(0, 1);
			// 代购或追号
			if("1".equals(lotPre)){
				// 数字彩
				if(order.getBuyType()==1){
					// 代购
					if(order.getPreBonus() == 0.00){
						typeId = szcDaiGouFuDongTypeId;//浮动奖模板
					}else if(order.getPreBonus() > 0){
						typeId = szcDaiGouGuDingTypeId;//固定奖模板
					}
				}else if(order.getBuyType()==2){
					// 追号
					if(order.getPreBonus() == 0.00){
						typeId = szcZhuiHaoFuDongTypeId;//浮动奖模板
					}else if(order.getPreBonus() > 0){
						typeId = szcZhuiHaoGuDingTypeId;//固定奖模板
					}
				}
			}
			else if("2".equals(lotPre)){
				if(order.getPreBonus() > 0){
					// 高频彩
					if(order.getBuyType()==1){
						typeId = gpcDaigouTypeId;//	高频彩代购中奖通知模板编号
					}else if(order.getBuyType()==2){
						typeId = gpcZhuiHaoTypeId;//高频彩追号中奖通知模板编号
					}
				}
				
			}
		}
		else if(order.getBuyType() == 3){
			// 合买
			
		}
		OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateByTypeId(typeId);
		String sendLotterys = template.getSendLotteryCode();
		if(isNoSendLot(sendLotterys,order.getLotCode().toString())){
			logger.info("【通知信息管理】" + template.getTypeName() + "模板已设置不支持此彩种通知，彩种编号：" + order.getLotCode());
			return;
		}
		UserInfoBO user = userInfoMapper.findUserInfoById(order.getUserId());
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送" + template.getTypeName() + "消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
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

