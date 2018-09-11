package com.hhly.lottomsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.mapper.UserInfoDaoMapper;
import com.hhly.lottomsg.service.UserInfoService;

/**
 * 
* @Description: 会员业务处理类 
* @author HouXiangBao289
* @date 2017年6月14日 下午3:32:57 
* @version V1.0.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDaoMapper userInfoMapper;

	@Override
	public int findValidUserInfoCount() {
		return userInfoMapper.findValidUserInfoCount();
	}

	@Override
	public List<UserInfoBO> findValidUserInfo(Integer begin, Integer pageSize) {
		return userInfoMapper.findValidUserInfo(begin, pageSize);
	}

	@Override
	public List<UserInfoBO> findUserInfoByIds(List<Integer> list) {
		return userInfoMapper.findUserInfoByIds(list);
	}

	@Override
	public UserInfoBO findUserInfoById(int id) {
		return userInfoMapper.findUserInfoById(id);
	}

	@Override
	public List<UserInfoBO> findBirthdayUser() {
		return userInfoMapper.findBirthdayUser();
	}

	@Override
	public List<UserInfoBO> findCon1Users(Integer days) {
		return userInfoMapper.findCon1Users(days);
	}

}
