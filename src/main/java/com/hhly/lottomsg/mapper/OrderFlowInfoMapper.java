package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OrderFlowInfoBO;
import com.hhly.lottomsg.po.OrderFlowInfoPO;


/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 订单流程
 * @date 2017/4/15 16:39
 * @company 益彩网络科技公司
 */
public interface OrderFlowInfoMapper {

	/**
	 * 插入
	 * @param orderFlowInfoPO
	 */
	void insertOrderFlowInfo(OrderFlowInfoPO orderFlowInfoPO);

	/**
	 * 查询此流程是否已经存在
	 * @param orderCode
	 * @param status
	 * @return
	 */
	List<OrderFlowInfoBO> queryOrderFlowInfos(@Param("orderCode") String orderCode, @Param("status") Integer status,
			@Param("message") String message);


} 
