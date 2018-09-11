package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OrderBaseInfoBO;
import com.hhly.lottomsg.bo.OrderCopyViewBO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单相关操作方法
 * @date 2017/9/26 16:44
 * @company 益彩网络科技公司
 */
public interface OrderCopyInfoMapper {

    /**
     * 根据订单编号查询发单信息
     * @param orderCode
     * @return
     */
    OrderCopyViewBO queryOrderIssueInfoByOrderCode(String orderCode);

    /**
     * 查询用户发单次数和发单总额
     * @param userId
     * @return
     */
    OrderCopyViewBO queryOrderInfoStatistics(Integer userId);

    /**
     * 根据跟单订单编号，查询同一个发单下的跟单总人数
     * @param orderCode
     * @return
     */
    OrderCopyViewBO queryOrderFollowedCount(String orderCode);

    /**
     * 根据跟单订单编号，查询同一个发单下的跟单总金额
     * @param orderCode
     * @return
     */
    Double queryOrderFollowedAmount(String orderCode);

    /**
     * 根据跟单订单编号，查询发单用户ID
     * @param orderCode
     * @return
     */
    Long queryOrderIssueIdByOrderCode(String orderCode);

    /**
     * 根据发单用户ID查询总跟单人数，和总跟单金额
     * @param muserIssueId
     * @return
     */
    OrderCopyViewBO queryOrderFollowStatis(Integer muserIssueId);

    /**
     * 查询专家最近七场的战绩（近几场中几场/连红）
     * @param userId
     * @param type 查询类型 1:战绩，连红 2：命中总订单金额，命中中奖金额 3:投注金额
     * @return
     */
    List<OrderBaseInfoBO> queryOrderIssueRecord(@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     * 查询用户总佣金
     * @param userIssueId
     * @return
     */
    Double queryTotalCommission(Integer userIssueId);


    /**
     * 更新发单表
     * @param orderCopyViewBO
     */
    void updateOrderIssueInfo(OrderCopyViewBO orderCopyViewBO);

    /**
     * 更新专家表
     * @param orderCopyViewBO
     */
    void updateUserIssueInfo(OrderCopyViewBO orderCopyViewBO);

    /**
     * 更新订单为已推单
     */
    void updateOrderInfo(String orderCode);









}
