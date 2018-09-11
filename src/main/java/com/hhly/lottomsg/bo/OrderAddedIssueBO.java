package com.hhly.lottomsg.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YiJian
 * @version 1.0
 * @desc 追号期数
 * @date 2017/5/24.
 * @company 益彩网络科技有限公司
 */
public class OrderAddedIssueBO implements Serializable {
    private static final long serialVersionUID = -6574699508807973842L;
    /**
     * 自增长ID
     */
    private Integer id;
    /**
     * 追号编号
     */
    private String orderAddCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 彩期期号
     */
    private String issueCode;
    /**
     * 认购金额
     */
    private Double buyAmount;
    /**
     * 倍数
     */
    private Integer multiple;
    /**
     * 追号状态； 1：追号中；2：中奖停追；3：追号结束；4：用户撤单；5：系统撤单；6：撤单中 7：停追撤单中 8: 用户撤单中
     */
    private Short addStatus;
    /**
     * 税前奖金
     */
    private Double preBonus;
    /**
     * 追号时间,完成下单的时间
     */
    private Date addTime;
    /**
     * 操作时间，用户修改操作的时间(包括系统CMS用户)
     */
    private Date modifyTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 追号顺序标识
     */
    private Short flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderAddCode() {
        return orderAddCode;
    }

    public void setOrderAddCode(String orderAddCode) {
        this.orderAddCode = orderAddCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    public Double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Short getAddStatus() {
        return addStatus;
    }

    public void setAddStatus(Short addStatus) {
        this.addStatus = addStatus;
    }

    public Double getPreBonus() {
        return preBonus;
    }

    public void setPreBonus(Double preBonus) {
        this.preBonus = preBonus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }
}
