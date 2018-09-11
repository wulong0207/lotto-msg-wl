package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.OrderBaseInfoBO;
import com.hhly.lottomsg.bo.OrderCopyViewBO;
import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.constants.SymbolConstants;
import com.hhly.lottomsg.common.util.IssueUtil;
import com.hhly.lottomsg.common.util.NumberUtil;
import com.hhly.lottomsg.common.util.ObjectUtil;
import com.hhly.lottomsg.mapper.OrderCopyInfoMapper;
import com.hhly.lottomsg.mapper.OrderInfoDaoMapper;
import com.hhly.lottomsg.service.CopyOrderService;
import com.hhly.lottomsg.vo.CopyOrderMsgModel;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单-发单，跟单出票成功和开奖成功消息处理
 * @date 2017/9/26 12:18
 * @company 益彩网络科技公司
 */
@Service("copyOrderService")
public class CopyOrderServiceImpl implements CopyOrderService {

    private Logger logger = LoggerFactory.getLogger(CopyOrderServiceImpl.class);

    @Autowired
    private OrderCopyInfoMapper orderCopyInfoMapper;

    @Autowired
    private OrderInfoDaoMapper orderInfoDaoMapper;

    @Autowired
    private CopyOrderAyscService copyOrderAyscService;

    @Override
    public ResultBO<?> execute(CopyOrderMsgModel copyOrderMsgModel) throws Exception {
        //1.解析orderCodestr，判断是否是抄单，并把发单，跟单，开奖用拆分开
        List<String> orderList = Arrays.asList(copyOrderMsgModel.getOrderCodeStr().split(SymbolConstants.COMMA));
        List<String> issueList = new ArrayList<String>();
        List<String> followList = new ArrayList<String>();
        List<String> drawList = new ArrayList<String>();
        for(String orderCode : orderList){
            OrderBaseInfoBO orderBaseInfoBO = orderInfoDaoMapper.queryOrderInfo(orderCode,null);
            if(Constants.NUM_2 == copyOrderMsgModel.getType()){//开奖
                drawList.add(orderCode);
            }else if(Constants.NUM_1 == copyOrderMsgModel.getType()){//出票
                if(Constants.NUM_2 == orderBaseInfoBO.getOrderType()){//推单
                    issueList.add(orderCode);
                }else if (Constants.NUM_3 == orderBaseInfoBO.getOrderType()){//跟单
                    followList.add(orderCode);
                }
            }
        }
        //2.出票成功-推单
        issueTicketHandler(issueList);
        //3.出票成功-跟单
        followTicketHandler(followList);
        //4.开奖成功 ，一个推单和下面的跟单一起开奖后，开奖系统把发单的订单编号发过来。
        orderDrawHandler(drawList);
        return ResultBO.ok();
    }

    /**
     * 开奖处理
     * @param drawList
     */
    private void orderDrawHandler(List<String> drawList) {
        if(!ObjectUtil.isBlank(drawList)) {
            for (String orderCode : drawList) {
                //1.判断订单编号在发单表是否存在
                OrderCopyViewBO orderCopyViewBO = orderCopyInfoMapper.queryOrderIssueInfoByOrderCode(orderCode);
                if(orderCopyViewBO!=null){
                    Integer joinCount = 0;//连红 开奖
                    StringBuilder recordStr = new StringBuilder();//战绩（近几场中几场）开奖
                    Double totalOrderAmount = 0d;//命中总订单金额 开奖
                    Double totalWinAmount = 0d;//命中中奖金额 开奖
                    Double totalBetAmount = 0d;//投注金额 开奖
                    Integer winCount = 0;//推荐中奖单数 开奖
                    Integer betCount = 0;//推荐单数 //已开奖
                    //命中率:推荐方案中奖的单数/推荐的总单数 开奖
                    Double hitRate = 0d; //开奖
                    //盈利率：中奖金额-投注金额/投注金额//开奖
                    Double profitRate =0d; //开奖

                    //2.七场战绩（近几场中几场）和最近的连红(不受七场的限制),统计已开奖的
                    List<OrderBaseInfoBO> orderBaseInfoBOs = orderCopyInfoMapper.queryOrderIssueRecord(orderCopyViewBO.getUserId(), Constants.NUM_1);
                    if(!ObjectUtil.isBlank(orderBaseInfoBOs)){
                        if(orderBaseInfoBOs.size()<=7){
                            List<Integer> resultList = new ArrayList<Integer>();//结果串（统计连红 1：胜 2：负）
                            recordStr.append(orderBaseInfoBOs.size());
                            int count = 0;
                            for(OrderBaseInfoBO orderBaseInfoBO : orderBaseInfoBOs){
                                if(orderBaseInfoBO.getWinningStatus()==3 || orderBaseInfoBO.getWinningStatus()==4){//中奖
                                    resultList.add(1);
                                    count++;
                                }else if(orderBaseInfoBO.getWinningStatus()==2){//未中奖
                                    resultList.add(0);
                                }
                            }
                            joinCount = IssueUtil.joinRed(resultList);//连红
                            recordStr.append(SymbolConstants.VERTICAL_BAR).append(count);
                        }else{//大于七场，战绩只取七场，连红不受七场控制
                            List<Integer> resultList = new ArrayList<Integer>();//结果串（统计连红 1：胜 2：负）
                            recordStr.append(Constants.NUM_7);
                            int count = 0;
                            for(int i=0;i<7;i++){
                                if(orderBaseInfoBOs.get(i).getWinningStatus()==3 || orderBaseInfoBOs.get(i).getWinningStatus()==4){//中奖
                                    count++;
                                }
                            }
                            recordStr.append(SymbolConstants.VERTICAL_BAR).append(count);
                            for(OrderBaseInfoBO orderBaseInfoBO : orderBaseInfoBOs){
                                if(orderBaseInfoBO.getWinningStatus()==3 || orderBaseInfoBO.getWinningStatus()==4){//中奖
                                    resultList.add(1);
                                }else if(orderBaseInfoBO.getWinningStatus()==2){//未中奖
                                    resultList.add(0);
                                }
                            }
                            joinCount = IssueUtil.joinRed(resultList);//连红
                        }
                    }
                    //3.命中总订单金额，命中中奖金额
                    List<OrderBaseInfoBO> winOrderBaseInfoBOs = orderCopyInfoMapper.queryOrderIssueRecord(orderCopyViewBO.getUserId(), Constants.NUM_2);
                    if(!ObjectUtil.isBlank(winOrderBaseInfoBOs)){
                        winCount = winOrderBaseInfoBOs.size();
                        for(OrderBaseInfoBO orderBaseInfoBO : winOrderBaseInfoBOs){
                            totalOrderAmount = NumberUtil.sum(totalOrderAmount,orderBaseInfoBO.getOrderAmount());
                            totalWinAmount = NumberUtil.sum(totalWinAmount,orderBaseInfoBO.getPreBonus());
                        }
                    }
                    //4.投注金额
                    List<OrderBaseInfoBO> betOrderBaseInfoBOs = orderCopyInfoMapper.queryOrderIssueRecord(orderCopyViewBO.getUserId(), Constants.NUM_3);
                    if(!ObjectUtil.isBlank(betOrderBaseInfoBOs)){
                        betCount = betOrderBaseInfoBOs.size();
                        for(OrderBaseInfoBO orderBaseInfoBO : betOrderBaseInfoBOs){
                            totalBetAmount = NumberUtil.sum(totalBetAmount,orderBaseInfoBO.getOrderAmount());
                        }
                    }
                    //5.专家表总佣金
                    Double totalCommission = orderCopyInfoMapper.queryTotalCommission(orderCopyViewBO.getUserIssueId());
                    hitRate = NumberUtil.div(winCount,betCount,2);
                    //盈利率：中奖金额-投注金额/投注金额
                    profitRate = NumberUtil.div(NumberUtil.sub(totalWinAmount,totalBetAmount),totalBetAmount,2);
                    //6.更新发单表
                    OrderCopyViewBO orderCopyViewBO1 = new OrderCopyViewBO();
                    orderCopyViewBO1.setRecentRecord(recordStr.toString());
                    orderCopyViewBO1.setHitRate(hitRate);
                    orderCopyViewBO1.setContinueHit(joinCount);
                    orderCopyViewBO1.setOrderIssueId(orderCopyViewBO.getOrderIssueId());
                    orderCopyInfoMapper.updateOrderIssueInfo(orderCopyViewBO1);
                    //7.更新用户表
                    orderCopyViewBO1.setProfitRate(profitRate);
                    orderCopyViewBO1.setHitNum(winCount);
                    orderCopyViewBO1.setHitMoney(totalOrderAmount);
                    orderCopyViewBO1.setCommissionAmount(totalCommission);
                    orderCopyViewBO1.setWinAmount(totalWinAmount);
                    orderCopyViewBO1.setUserIssueId(orderCopyViewBO.getUserIssueId());
                    orderCopyInfoMapper.updateUserIssueInfo(orderCopyViewBO1);
                }else{
                    logger.error("MQ[抄单消息,开奖成功不处理,原因：]"+orderCode+"没有找到对应的推单记录！");
                }
            }
        }
    }

    /**
     * 出票成功，跟单处理
     * @param followList
     */
    private void followTicketHandler(List<String> followList) {
        if(!ObjectUtil.isBlank(followList)){
            for(String orderCode : followList) {
                //抄单跟单总人数，推单主键ID
                OrderCopyViewBO orderCopyViewBO = orderCopyInfoMapper.queryOrderFollowedCount(orderCode);
                if(orderCopyViewBO!=null && orderCopyViewBO.getFollowCount()>0){//判断跟单记录是否存在
                    //抄单跟单总金额
                    Double amount = orderCopyInfoMapper.queryOrderFollowedAmount(orderCode);
                    // 1.更新发单表跟单人数，跟单金额等字段
                    OrderCopyViewBO orderCopyViewBO1 = new OrderCopyViewBO();
                    orderCopyViewBO1.setFollowCount(orderCopyViewBO.getFollowCount());
                    orderCopyViewBO1.setFollowAmount(amount);
                    orderCopyViewBO1.setOrderIssueId(orderCopyViewBO.getOrderIssueId());
                    orderCopyInfoMapper.updateOrderIssueInfo(orderCopyViewBO1);
                    // 2.跟新发单用户表跟单总人数，跟单总金额等
                    //copyOrderAyscService.updateUserIssueInfo(copyOrderMsgModel.getOrderCode());

                    Long mUserIssueId = orderCopyInfoMapper.queryOrderIssueIdByOrderCode(orderCode);
                    //根据发单用户ID，在发单表统计跟单总人数和跟单总金额
                    orderCopyViewBO= orderCopyInfoMapper.queryOrderFollowStatis(mUserIssueId.intValue());
                    orderCopyViewBO.setUserIssueId(mUserIssueId.intValue());
                    orderCopyInfoMapper.updateUserIssueInfo(orderCopyViewBO);
                }else{
                    logger.error("MQ[抄单消息,跟单出票成功不处理,原因：]"+orderCode+"没有找到对应的跟单记录！");
                }
            }

        }
    }

    /**
     * 发单出票处理
     * @param issueList
     */
    private void issueTicketHandler(List<String> issueList) {
        if(!ObjectUtil.isBlank(issueList)){
            for(String orderCode : issueList){
                //查询userIssueId，userID
                OrderCopyViewBO orderCopyViewBO = orderCopyInfoMapper.queryOrderIssueInfoByOrderCode(orderCode);
                if(orderCopyViewBO!=null){//判断推单记录是否存在
                    Integer userIssueId = orderCopyViewBO.getUserIssueId();
                    //1.查订单表，当前用户发单次数和发单总额
                    orderCopyViewBO = orderCopyInfoMapper.queryOrderInfoStatistics(orderCopyViewBO.getUserId());
                    //2.更新专家表发单次数和发单总额
                    orderCopyViewBO.setUserIssueId(userIssueId);
                    orderCopyInfoMapper.updateUserIssueInfo(orderCopyViewBO);
                    //3.更新订单为已推单
                    orderCopyInfoMapper.updateOrderInfo(orderCode);
                }else{
                    logger.error("MQ[抄单消息,推单出票成功不处理,原因：]"+orderCode+"没有找到对应的推单记录！");
                }
            }
        }
    }




}
