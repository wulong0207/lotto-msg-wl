package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.FinanceBO;

public interface FinanceDaoMapper {
	/**
	 * 
	 * @Description 查找充值记录信息 
	 * @author HouXiangBao289
	 * @param userId
	 * @param rechargeCode
	 * @return
	 */
	FinanceBO selectRechargeLog(@Param("userId") Integer userId,@Param("rechargeCode") String rechargeCode);
	
	/**
	 * 
	 * @Description	查找提款记录 
	 * @author HouXiangBao289
	 * @param userId
	 * @param takenCode
	 * @return
	 */
	FinanceBO selectTakenLog(@Param("userId") Integer userId,@Param("takenCode") String takenCode);
}
