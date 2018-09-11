package com.hhly.lottomsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.OrderBO;
import com.hhly.lottomsg.mapper.OrderDaoMapper;
import com.hhly.lottomsg.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDaoMapper orderDaoMapper;
	
	@Override
	public OrderBO findOrderInfoByCode(String orderCode) {
		return orderDaoMapper.findOrderInfoByCode(orderCode);
	}

}
