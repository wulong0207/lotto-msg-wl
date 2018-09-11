package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OperateMsgConfigBO;
import com.hhly.lottomsg.bo.OperateMsgConfigLotteryBO;

public interface UserMsgConfigDaoMapper {
	 
		/**
		 * 查询用户模板接收设置信息
		 * @param userId
		 * @param typeId
		 */
		OperateMsgConfigBO findUserConfig(@Param("userId") Integer userId,@Param("typeId") Integer typeId);
		
		/**
		 * 
		 * @Description 根据用户和彩种查询是否接收相关配置
		 * @author HouXiangBao289
		 * @param userId
		 * @param lotCode
		 * @return
		 */
		OperateMsgConfigLotteryBO findLotteryMsgConfig(@Param("userId") Integer userId,@Param("lotCode") Integer lotCode,@Param("msgType") Integer msgType);
	
}
