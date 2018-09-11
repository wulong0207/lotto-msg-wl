package com.hhly.lottomsg.service;

import com.hhly.lottomsg.bo.OrderFlowInfoBO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 订单流程信息处理类
 * @date 2017/5/22 15:23
 * @company 益彩网络科技公司
 */
public interface OrderFlowInfoService {

    /**
     * 插入流程信息 orderCode createTime status必传。批量orderCode以,隔开
     * @param orderFlowInfoBO
     * @throws Exception
     */
    void insert(OrderFlowInfoBO orderFlowInfoBO) throws Exception;

}
