package com.hhly.lottomsg.service;

import java.util.List;

import com.hhly.lottomsg.bo.UserInfoBO;

public interface UserInfoService {
	/**
	 * 
	 * @Desc 查询有效用户个数
	 * @return
	 */
	int findValidUserInfoCount();
	
	/**
	 * 
	 * @Desc 分次查询有效用户列表
	 * @param list
	 * @param begin
	 * @param end
	 * @return
	 */
	List<UserInfoBO> findValidUserInfo(Integer begin, Integer pageSize);
	
	/**
	 * 
	 * @Desc 根据用户id集合分次查询用户列表
	 * @CreatDate 2017年4月14日 下午2:28:46
	 * @param list
	 * @return
	 */
	List<UserInfoBO> findUserInfoByIds(List<Integer> list);
	
	/**
	 * 
	 * @Desc 根据用户id查询用户
	 * @CreatDate 2017年4月14日 下午2:28:46
	 * @param id
	 * @return
	 */
	UserInfoBO findUserInfoById(int id);
	
	/**
	 * 
	 * @Desc 根据用户id集合分次查询用户列表
	 * @CreatDate 2017年4月14日 下午2:28:46
	 * @param list
	 * @return
	 */
	List<UserInfoBO> findBirthdayUser();
	
	/**
	 * 
	 * @Description 1、注册第N天未登录：未实名认证用户注册第N天未进行登录
	 * @author HouXiangBao289
	 * @param days 天数
	 * @return
	 */
	List<UserInfoBO> findCon1Users(Integer days);
}
