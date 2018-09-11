package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.DoBusinessBO;

public interface DoBusinessDaoMapper {
	/**
	 * 
	 * @Description 获取红包信息 
	 * @author HouXiangBao289
	 * @param userId
	 * @param redCode
	 * @return
	 */
	DoBusinessBO findRedPackByCode(@Param("userId")Integer userId,@Param("redCode")String redCode);
	
	/**
	 * 
	 * @Description 获取用户最新红包 
	 * @author HouXiangBao289
	 * @param userId
	 * @return
	 */
	DoBusinessBO findCurRedPack(@Param("userId")Integer userId);
}
