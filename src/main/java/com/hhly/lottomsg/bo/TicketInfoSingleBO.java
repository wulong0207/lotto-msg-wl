package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/4/7 15:48
 * @company 益彩网络科技公司
 */
public class TicketInfoSingleBO extends BaseBO {

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 票状态 -2出票失败;-1送票失败;0不出票;1待分配;2已分配;3已送票;4已出票
     */
    private Integer ticketStatus;

    /**
     * 渠道商返回备注
     */
    private String channelRemark;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getChannelRemark() {
        return channelRemark;
    }

    public void setChannelRemark(String channelRemark) {
        this.channelRemark = channelRemark;
    }
}
