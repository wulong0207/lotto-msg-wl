package com.hhly.lottomsg.service;

import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.vo.CopyOrderMsgModel;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单-发单，跟单出票成功和开奖成功消息处理
 * @date 2017/9/26 12:14
 * @company 益彩网络科技公司
 */
public interface CopyOrderService {

    /**
     * 根据类型处理抄单消息
     * @param copyOrderMsgModel
     * @throws Exception
     */
    ResultBO<?> execute(CopyOrderMsgModel copyOrderMsgModel)throws Exception;
}
