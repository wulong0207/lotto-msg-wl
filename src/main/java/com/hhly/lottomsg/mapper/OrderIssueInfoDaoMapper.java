package com.hhly.lottomsg.mapper;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OrderIssueInfoBO;
/**
 * 
* @Description: 专家推荐订单
* @author HouXiangBao289
* @date 2017年11月10日 下午5:59:16 
* @version V1.0.0
 */
public interface OrderIssueInfoDaoMapper {

	OrderIssueInfoBO findIssueBOById(@Param("orderCode") String orderCode);
}
