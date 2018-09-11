package com.hhly.lottomsg.service.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.common.enums.OrderEnum.OrderTypeEnum;
import com.hhly.lottomsg.service.OrderService;
import com.hhly.lottomsg.service.PrizeNoticeService;

/**
 * 
* @Description: 中奖通知管理 
* @author HouXiangBao289
* @date 2017年6月23日 下午4:46:33 
* @version V1.0.0
 */
@Component
public class PrizeNoticeManager {
	
	@Autowired
	private PrizeNoticeService jcDaiGouPrizeService;
	
	@Autowired
	private PrizeNoticeService lotPrizeService;
	
	@Autowired
	private PrizeNoticeService lotPrizeStopService;
	
	@Autowired
	private OrderService orderSerivce;
	
	@Autowired
	private PrizeNoticeService recommendPrizeService;

	/**
	 * 
	 * @Description 分类处理
	 * @author HouXiangBao289
	 * @param orderCode
	 * @throws Exception
	 */
	public void prizeNotice(String orderCode) throws Exception{
		OrderBO order = orderSerivce.findOrderInfoByCode(orderCode);
		if("3".equals(order.getLotCode().toString().substring(0, 1))){
			jcDaiGouPrizeService.handlePrizeNoticeMsg(order);
		}else{
			lotPrizeService.handlePrizeNoticeMsg(order);
		}
		if(order.getOrderType().intValue() == OrderTypeEnum.YTD.getValue().intValue()){
			recommendPrizeService.handlePrizeNoticeMsg(order);
		}
	}
	
	public void prizeStopNotice(String orderCode) throws Exception{
		OrderBO order = orderSerivce.findOrderInfoByCode(orderCode);
		lotPrizeStopService.handlePrizeNoticeMsg(order);
	}
}
