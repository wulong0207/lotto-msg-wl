package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.ChaseCodePlanBO;

public interface ChaseCodePlanDaoMapper {
	/**
	 * 
	 * @Description 查询订单相关追号计划信息 
	 * @author HouXiangBao289
	 * @param orderCode
	 * @return
	 */
	ChaseCodePlanBO selectChaseCodeByOrder(@Param("orderCode") String orderCode);
	
	/**
	 * 
	 * @Description 根据订单追号编号查询追号计划信息
	 * @author HouXiangBao289
	 * @param orderAddCode
	 * @return
	 */
	ChaseCodePlanBO selectChaseCodeByOrderAddCode(@Param("orderAddCode") String orderAddCode);
}
