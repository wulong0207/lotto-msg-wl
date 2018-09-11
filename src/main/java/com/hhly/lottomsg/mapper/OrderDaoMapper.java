package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OrderBO;

public interface OrderDaoMapper {
	/**
	 * 
	 * @Description 获取中奖订单
	 * @author HouXiangBao289
	 * @param orderCode
	 * @return
	 */
	OrderBO findOrderInfoByCode(@Param("orderCode") String orderCode);
}
