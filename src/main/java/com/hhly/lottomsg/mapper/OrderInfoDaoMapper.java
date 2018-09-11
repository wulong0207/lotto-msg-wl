package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OrderAddedIssueBO;
import com.hhly.lottomsg.bo.OrderBaseInfoBO;
import com.hhly.lottomsg.bo.TransUserBO;

/**
 * @author yuanshangbing
 *
 * @Date 2017年5月26日
 *
 * @Desc 订单处理数据接口
 */
public interface OrderInfoDaoMapper {

	/**
	 * 根据订单号查询订单
	 * @param orderCode
	 * @param userId
	 * @return
	 */
	OrderBaseInfoBO queryOrderInfo(@Param("orderCode") String orderCode, @Param("userId") Integer userId);

	/**
	 * 根据追号单号查询追号订单
	 * @param orderAddCode
	 * @param userId
	 * @return
	 */
	OrderBaseInfoBO queryOrderAddInfo(@Param("orderAddCode") String orderAddCode, @Param("userId") Integer userId);
	
	/**
	 * 根据追号单号查询追号期数
	 * @param orderAddCode
	 * @param userId
	 * @return
	 */
	List<OrderAddedIssueBO> getOrderAddedIssues(OrderAddedIssueBO addedIssueBO);
	
	TransUserBO getOrderTrans(@Param("orderCode") String orderCode, @Param("transStatus") Short transStatus);

}