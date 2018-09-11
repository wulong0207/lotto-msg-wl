package com.hhly.lottomsg.service;

import com.hhly.lottomsg.bo.OrderBO;

public interface OrderService {
	/**
	 * 
	 * @Description 获取中奖订单
	 * @author HouXiangBao289
	 * @param orderCode
	 * @return
	 */
	OrderBO findOrderInfoByCode(String orderCode);
}
