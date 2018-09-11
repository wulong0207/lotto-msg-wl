package com.hhly.lottomsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.OrderCopyViewBO;
import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.mapper.OrderCopyInfoMapper;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/9/28 14:42
 * @company 益彩网络科技公司
 */
@Service("copyOrderAyscService")
public class CopyOrderAyscService {

    @Autowired
    private OrderCopyInfoMapper orderCopyInfoMapper;

    public ResultBO<?> updateUserIssueInfo(String orderCode){
        //查询发单用户ID
        Long mUserIssueId = orderCopyInfoMapper.queryOrderIssueIdByOrderCode(orderCode);
        //根据发单用户ID，在发单表统计跟单总人数和跟单总金额
        OrderCopyViewBO orderCopyViewBO= orderCopyInfoMapper.queryOrderFollowStatis(mUserIssueId.intValue());
        orderCopyViewBO.setUserIssueId(mUserIssueId.intValue());
        orderCopyInfoMapper.updateUserIssueInfo(orderCopyViewBO);
        return ResultBO.ok();
    }



}
