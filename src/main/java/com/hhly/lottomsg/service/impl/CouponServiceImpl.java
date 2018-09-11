package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.OperateCouponBO;
import com.hhly.lottomsg.mapper.CouponDaoMapper;
import com.hhly.lottomsg.service.CouponService;

@Service("couponService")
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	private CouponDaoMapper couponDaoMapper;

	@Override
	public List<OperateCouponBO> findList(int noticeStatus) {
		return couponDaoMapper.findList(noticeStatus);
	}

	@Override
	public void updCouponStatus(List<OperateCouponBO> ids,int noticeStatus) {
		if(ids.size() > 0){
			couponDaoMapper.updCouponStatus(ids, noticeStatus);
		}
	}

}
