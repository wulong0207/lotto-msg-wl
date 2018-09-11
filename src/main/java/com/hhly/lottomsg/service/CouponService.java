package com.hhly.lottomsg.service;

import java.util.List;

import com.hhly.lottomsg.bo.OperateCouponBO;

/**
 * @Desc 红包过期提醒处理
 * @Author HouXB
 * @Date 2017年2月24日
 * @Company 益彩网络科技公司
 * @Version 1.0
 */
public interface CouponService {
	
	/**
	 * 
	 * @Description 查询三天后过期的未通知红包
	 * @author HouXiangBao289
	 * @param noticeStatus 0未通知，1已通知
	 * @return
	 */
	List<OperateCouponBO> findList(int noticeStatus);

	/**
	 * 
	 * @Description 更新红包过期通知状态 
	 * @author HouXiangBao289
	 * @param id
	 * @param noticeStatus 0未通知，1已通知
	 * @return
	 */
	void updCouponStatus(List<OperateCouponBO> ids,int noticeStatus);

}
