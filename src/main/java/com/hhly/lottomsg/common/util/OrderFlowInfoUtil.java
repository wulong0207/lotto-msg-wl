package com.hhly.lottomsg.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hhly.lottomsg.common.constants.MessageCodeConstants;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/5/27 16:33
 * @company 益彩网络科技公司
 */
public class OrderFlowInfoUtil {

    public static final Map<String,String> STATUS_TO_MESSAGE = new ConcurrentHashMap<String,String>();

    static {
        STATUS_TO_MESSAGE.put(MessageCodeConstants.SUBMIT_ORDER, PropertyUtil.getConfigValue(MessageCodeConstants.SUBMIT_ORDER));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.PAY_FAIL, PropertyUtil.getConfigValue(MessageCodeConstants.PAY_FAIL));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.NO_PAY_OVERDUE, PropertyUtil.getConfigValue(MessageCodeConstants.NO_PAY_OVERDUE));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.PAY_SUCCESS_IN_TIME, PropertyUtil.getConfigValue(MessageCodeConstants.PAY_SUCCESS_IN_TIME));
        //STATUS_TO_MESSAGE.put(MessageCodeConstants.PAY_SUCCESS_NO_TIME, PropertyUtil.getConfigValue(MessageCodeConstants.PAY_SUCCESS_NO_TIME));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.TICKET_SUCCESS, PropertyUtil.getConfigValue(MessageCodeConstants.TICKET_SUCCESS));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.TICKET_FIAL, PropertyUtil.getConfigValue(MessageCodeConstants.TICKET_FIAL));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.ORDER_WINNING, PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_WINNING));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.ORDER_NO_WINNING, PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_NO_WINNING));
        STATUS_TO_MESSAGE.put(MessageCodeConstants.ORDER_SENDED_MONEY, PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_SENDED_MONEY));
    }
}
