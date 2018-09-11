package com.hhly.lottomsg.vo;

import java.util.List;

import com.hhly.lottomsg.base.vo.BaseVO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单-发单，跟单出票成功，开奖等入参VO
 * @date 2017/9/26 11:02
 * @company 益彩网络科技公司
 */
public class CopyOrderMsgModel extends BaseVO {

    /**
     * 入参：类型 1:出票成功；2：开奖成功
     */
    private Integer type;

    /**
     * 入参：订单编号串，多个以,分割
     */
    private String orderCodeStr;

    /**
     * 内部使用 1:出票成功-推单；2:出票成功-跟单；3：开奖
     */
    private Integer outType;

    /**
     * 内部使用订单编号list
     */
    private List<String> outOrderCodeList;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderCodeStr() {
        return orderCodeStr;
    }

    public void setOrderCodeStr(String orderCodeStr) {
        this.orderCodeStr = orderCodeStr;
    }

    public Integer getOutType() {
        return outType;
    }

    public void setOutType(Integer outType) {
        this.outType = outType;
    }

    public List<String> getOutOrderCodeList() {
        return outOrderCodeList;
    }

    public void setOutOrderCodeList(List<String> outOrderCodeList) {
        this.outOrderCodeList = outOrderCodeList;
    }
}
