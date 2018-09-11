package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OperateCouponBO;

/**
 * 
 * @author HouXb
 * @Version 1.0
 * @CreatDate 2017-1-15 下午4:03:18
 * @Desc 红包过期处理
 */
public interface CouponDaoMapper {
	
	/**
	 * 
	 * @Description 查询三天后过期的红包 
	 * @author HouXiangBao289
	 * @param noticeStatus 0未通知,1已通知
	 * @return
	 */
	List<OperateCouponBO> findList(@Param("noticeStatus")int noticeStatus);

	/**
	 * 
	 * @Description 更新红包过期通知状态 
	 * @author HouXiangBao289
	 * @param id
	 * @param noticeStatus 0未通知,1已通知
	 * @return
	 */
	void updCouponStatus(@Param("ids") List<OperateCouponBO> ids,@Param("noticeStatus")int noticeStatus);
  
}