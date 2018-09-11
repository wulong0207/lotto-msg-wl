package com.hhly.lottomsg.service;

import java.util.concurrent.DelayQueue;

import com.hhly.lottomsg.entity.SaleEndIssue;

public interface IssueService {
	
	/**
	 * 
	 * @Description 把今日销售截止的彩期加入队列 
	 * @author HouXiangBao289
	 */
	void addIssueToQueue();
	
	/**
	 * 
	 * @Description 截止前1小时通知相关用户 
	 * @author HouXiangBao289
	 * @param issue
	 */
	void saleEndBeforeNotice(SaleEndIssue issue);
	
	/**
	 * 获取队列
	 * @Description 
	 * @author HouXiangBao289
	 * @return
	 */
	DelayQueue<SaleEndIssue> getQueue();
	
	/**
	 * 
	 * @Description SP实时推送测试代码 
	 * @author HouXiangBao289
	 * @return
	 */
//	List<Integer> findSalingMatchs();
}
