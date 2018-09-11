package com.hhly.lottomsg.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.bo.LotteryWinningBO;
import com.hhly.lottomsg.bo.NewIssueBO;
import com.hhly.lottomsg.bo.OrderAddedIssueBO;
import com.hhly.lottomsg.bo.OrderBaseInfoBO;
import com.hhly.lottomsg.bo.OrderFlowInfoBO;
import com.hhly.lottomsg.bo.SportAgainstInfoBO;
import com.hhly.lottomsg.bo.TransUserBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.constants.MessageCodeConstants;
import com.hhly.lottomsg.common.constants.PayConstants.PayStatusEnum;
import com.hhly.lottomsg.common.constants.PayConstants.UserTransStatusEnum;
import com.hhly.lottomsg.common.constants.SymbolConstants;
import com.hhly.lottomsg.common.enums.CancellationConstants.OrderAddIssueStatusEnum;
import com.hhly.lottomsg.common.enums.CancellationConstants.OrderAddStatusEnum;
import com.hhly.lottomsg.common.enums.CancellationConstants.OrderStatusEnum;
import com.hhly.lottomsg.common.enums.CancellationConstants.OrderWinningStatusEnum;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.common.enums.OrderEnum;
import com.hhly.lottomsg.common.enums.OrderEnum.OrderAddStopType;
import com.hhly.lottomsg.common.enums.OrderFlowInfoEnum;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.ObjectUtil;
import com.hhly.lottomsg.common.util.PropertyUtil;
import com.hhly.lottomsg.mapper.LotteryInfoMapper;
import com.hhly.lottomsg.mapper.LotteryWinningDaoMapper;
import com.hhly.lottomsg.mapper.OrderFlowInfoMapper;
import com.hhly.lottomsg.mapper.OrderInfoDaoMapper;
import com.hhly.lottomsg.po.OrderFlowInfoPO;
import com.hhly.lottomsg.service.OrderFlowInfoService;
import com.hhly.lottomsg.vo.LotteryWinningVO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 订单流程信息处理类
 * @date 2017/5/22 15:23
 * @company 益彩网络科技公司
 */
@Service("orderFlowInfoService")
public class OrderFlowInfoServiceImpl implements OrderFlowInfoService {

	private Logger logger = LoggerFactory.getLogger(OrderFlowInfoServiceImpl.class);

	@Autowired
	private OrderInfoDaoMapper orderInfoDaoMapper;

	@Autowired
	private LotteryInfoMapper lotteryInfoMapper;

	@Autowired
	private OrderFlowInfoMapper orderFlowInfoMapper;

	@Autowired
	private LotteryWinningDaoMapper lotteryWinningDaoMapper;

	@Override
	public void insert(OrderFlowInfoBO orderFlowInfoBO) throws Exception {
		try {
			Short buyType = orderFlowInfoBO.getBuyType() != null ? orderFlowInfoBO.getBuyType().shortValue() : 0;
			String orderCodes[] = null;
			if (OrderEnum.BuyType.BUY_CHASE.getValue() != buyType) {// 代购
				orderCodes = orderFlowInfoBO.getOrderCode().split(SymbolConstants.COMMA);
			} else {// 追号
				orderCodes = orderFlowInfoBO.getOrderAddCode().split(SymbolConstants.COMMA);
			}
			if (ObjectUtil.isBlank(orderCodes)) {
				return;
			}
			for (String orderCode : orderCodes) {
				insertOne(orderCode, orderFlowInfoBO);
			}
		} catch (Exception e) {
			logger.error("插入订单流程信息失败", e);
		}

	}

	private void insertOne(String orderCode, OrderFlowInfoBO orderFlowInfoBO) {
		OrderBaseInfoBO orderBaseInfoBO = null;
		OrderAddedIssueBO orderAddedIssue = null;
		Short buyType = orderFlowInfoBO.getBuyType() != null ? orderFlowInfoBO.getBuyType().shortValue() : 0;
		if (OrderEnum.BuyType.BUY_CHASE.getValue() != buyType) {// 代购
			orderBaseInfoBO = orderInfoDaoMapper.queryOrderInfo(orderCode, null);
		} else {// 追号
			orderBaseInfoBO = orderInfoDaoMapper.queryOrderAddInfo(orderCode, null);
			if (!ObjectUtil.isBlank(orderFlowInfoBO.getOrderAddIssue())) {
				OrderAddedIssueBO addedIssueBO = new OrderAddedIssueBO();
				addedIssueBO.setOrderAddCode(orderCode);
				addedIssueBO.setIssueCode(orderFlowInfoBO.getOrderAddIssue());
				List<OrderAddedIssueBO> orderAddedIssues = orderInfoDaoMapper.getOrderAddedIssues(addedIssueBO);
				orderAddedIssue = !ObjectUtil.isBlank(orderAddedIssues) ? orderAddedIssues.get(0) : null;
			}
		}
		if (ObjectUtil.isBlank(orderBaseInfoBO)) {
			logger.error("订单不存在，订单号为：" + orderCode + "，订单流程信息不插入");
			return;
		}
		// 验证订单状态
		boolean result = checkOrderStatus(orderFlowInfoBO.getStatus(), orderBaseInfoBO, orderAddedIssue);
		if (!result) {
			if (OrderEnum.BuyType.BUY_CHASE_PLAN.getValue() != orderBaseInfoBO.getBuyType().shortValue()) {
				logger.error("传入状态与订单状态不符，订单号为：{}, status:{}, payStatus:{}, orderStatus:{}, winningStatus:{}", orderCode,
						orderFlowInfoBO.getStatus(), orderBaseInfoBO.getPayStatus(), orderBaseInfoBO.getOrderStatus(),
						orderBaseInfoBO.getWinningStatus());
			} else {
				logger.error("传入状态与订单状态不符，订单号为：{}, status:{}, payStatus:{}, addStatus:{}", orderCode, orderFlowInfoBO.getStatus(),
						orderBaseInfoBO.getPayStatus(), orderBaseInfoBO.getAddStatus());
			}
			return;
		}
		// 验证订单流程是否已记录
		result = checkOrderFlowExist(orderFlowInfoBO, orderBaseInfoBO, orderAddedIssue);
		if (result) {
			logger.error("订单流程重复，订单号为：" + orderCode + "，订单流程信息不插入");
			return;
		}
		// 插入订单流程日志
		String message = getMessage(orderFlowInfoBO, orderBaseInfoBO, orderAddedIssue);
		OrderFlowInfoPO orderFlowInfoPO = new OrderFlowInfoPO();
		orderFlowInfoPO.setStatus(orderFlowInfoBO.getStatus());
		orderFlowInfoPO.setBuyType(orderBaseInfoBO.getBuyType());
		orderFlowInfoPO.setCreateTime(orderFlowInfoBO.getCreateTime());
		orderFlowInfoPO.setMessage(message);
		orderFlowInfoPO.setUserId(orderBaseInfoBO.getUserId());
		orderFlowInfoPO.setOrderCode(orderBaseInfoBO.getOrderCode());
		orderFlowInfoMapper.insertOrderFlowInfo(orderFlowInfoPO);
	}

	/**
	 * 根据状态码获取展示内容
	 * 
	 * @param status
	 * @param orderBaseInfoBO
	 * @return
	 */
	private String getMessage(OrderFlowInfoBO orderFlowInfoBO, OrderBaseInfoBO orderBaseInfoBO, OrderAddedIssueBO orderAddedIssue) {
		Integer inputStatus = orderFlowInfoBO.getStatus();
		boolean isNotAddOrder = OrderEnum.BuyType.BUY_CHASE_PLAN.getValue() != orderBaseInfoBO.getBuyType().shortValue();
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.SUBMIT_FLOW.getKey()) {// 等待支付
			String orderTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getShowDate(), DateUtil.DATETIME_FORMAT_NO_SEC);
			String endSaleTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getEndSaleTime(), DateUtil.FORMAT_M_D_H_M_S);
			if (isNotAddOrder) {// 普通订单
				return PropertyUtil.getConfigValue(MessageCodeConstants.SUBMIT_ORDER, orderTimeStr, orderBaseInfoBO.getLotteryName(),
						endSaleTimeStr);
			} else {// 追号订单
				return PropertyUtil.getConfigValue(MessageCodeConstants.ADD_ORDER_WAIT_PAY, orderTimeStr, orderBaseInfoBO.getLotteryName(),
						orderBaseInfoBO.getTotalIssue(), endSaleTimeStr);
			}
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_SUCCESS.getKey()) {// 支付成功(等待出票)
			if (isNotAddOrder) {// 普通 订单
				Date transTime = getTransTime(orderBaseInfoBO);
				String transTimeStr = DateUtil.convertDateToStr(transTime, DateUtil.DATETIME_FORMAT_NO_SEC);
				String officalEndTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getEndTicketTime(), DateUtil.FORMAT_M_D_H_M_S);
				return PropertyUtil.getConfigValue(MessageCodeConstants.PAY_SUCCESS_IN_TIME, transTimeStr, officalEndTimeStr);
			} else {// 追号订单
				String orderTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getShowDate(), DateUtil.DATETIME_FORMAT_NO_SEC);
				return PropertyUtil.getConfigValue(MessageCodeConstants.ADD_ORDER_PAY_SUCCESS, orderTimeStr,
						orderBaseInfoBO.getLotteryName(), orderBaseInfoBO.getTotalIssue());
			}
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_FAIL.getKey()) {// 支付失败
			String transTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getUpdateTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.PAY_FAIL, transTimeStr);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.NO_PAY_OVERDUE.getKey()) {// 未支付过期
			String endSaleTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getEndSaleTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.NO_PAY_OVERDUE, endSaleTimeStr);
		}
		// 普通订单，非追号订单
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.IN_TICKET.getKey()) {// 出票中
			Date transTime = getTransTime(orderBaseInfoBO);
			String transTimeStr = DateUtil.convertDateToStr(transTime, DateUtil.DATETIME_FORMAT_NO_SEC);
			String officalEndTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getEndTicketTime(), DateUtil.FORMAT_M_D_H_M_S);
			return PropertyUtil.getConfigValue(MessageCodeConstants.TICKETING, transTimeStr, officalEndTimeStr);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_FAIL.getKey()) {// 出票失败
			String failTime = DateUtil.convertDateToStr(orderBaseInfoBO.getUpdateTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.TICKET_FIAL, failTime);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.CANCEL_ORDER.getKey()) {// 出票失败(已撤单)
			String failTime = DateUtil.convertDateToStr(orderBaseInfoBO.getUpdateTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.CANCEL_ORDER, failTime,
					orderBaseInfoBO.getRemark() == null ? "" : orderBaseInfoBO.getRemark());
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_SUCCESS.getKey()) {// 出票成功
			int lotteryCode = orderBaseInfoBO.getLotteryCode() == null ? 0 : orderBaseInfoBO.getLotteryCode();
			String tiketTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getComeOutTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			// 北京单场、胜负过关流程不记录预计开奖时间
			if (LotteryEnum.Lottery.BJDC.getName() == lotteryCode || LotteryEnum.Lottery.SFGG.getName() == lotteryCode) {
				return PropertyUtil.getConfigValue(MessageCodeConstants.TICKET_SUCCESS_BJDC, tiketTimeStr);
			} else {
				Date lotteryTime = getLotteryTime(orderBaseInfoBO);
				String lotteryTimeStr = DateUtil.convertDateToStr(lotteryTime, DateUtil.FORMAT_M_D_H_M_S);
				return PropertyUtil.getConfigValue(MessageCodeConstants.TICKET_SUCCESS, tiketTimeStr, lotteryTimeStr);
			}
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.LOSING_LOTTERY.getKey()) {// 未中奖
			Date lotteryTime = orderBaseInfoBO.getLotteryTime();
			String lotteryTimeStr = DateUtil.convertDateToStr(lotteryTime, DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_NO_WINNING, lotteryTimeStr);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.HAS_WINNING.getKey()) {// 已中奖
			Date lotteryTime = orderBaseInfoBO.getLotteryTime();
			String throwTimeStr = "";
			String lotteryTimeStr = DateUtil.convertDateToStr(lotteryTime, DateUtil.DATETIME_FORMAT_NO_SEC);
			if (!ObjectUtil.isBlank(lotteryTime)) {
				// 派奖时间取开奖时间+10分钟
				throwTimeStr = DateUtil.convertDateToStr(DateUtil.addMinute(lotteryTime, Constants.NUM_10), DateUtil.FORMAT_M_D_H_M_S);
			}
			return PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_WINNING, lotteryTimeStr, throwTimeStr);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.HAD_SENT.getKey()) {// 已派奖
			String sendTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getSendTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_SENDED_MONEY, sendTimeStr);
		}
		// 追号订单
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.EXEC_ONE_SUCCESS.getKey()) {// 执行一期追号成功后
			String execTime = DateUtil.convertDateToStr(orderAddedIssue.getAddTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ADD_ORDER_EXEC_ONE_SUCCESS, execTime, orderBaseInfoBO.getLotteryName(),
					orderAddedIssue.getIssueCode(), orderAddedIssue.getFlag(), orderBaseInfoBO.getTotalIssue());
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.EXEC_ONE_FAIL.getKey()) {// 执行一期追号失败后
			String updTime = DateUtil.convertDateToStr(orderAddedIssue.getUpdateTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ADD_ORDER_EXEC_ONE_FAIL, updTime, orderBaseInfoBO.getLotteryName(),
					orderAddedIssue.getIssueCode(), orderAddedIssue.getFlag(), orderBaseInfoBO.getTotalIssue());
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.AFTER_END.getKey()) {// 追号结束
			String execTime = DateUtil.convertDateToStr(orderBaseInfoBO.getAddEndTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.CHASE_NUMBER_END, execTime);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.WINNING_AFTER_STOP.getKey()) {// 中奖金额停追、中奖奖项停追
			String execTime = DateUtil.convertDateToStr(orderBaseInfoBO.getAddEndTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			// 中奖金额停追
			if (OrderAddStopType.AMOUNT.getValue() == orderBaseInfoBO.getStopType()) {
				return PropertyUtil.getConfigValue(MessageCodeConstants.WINNING_MONEY_END, execTime);
			}
			// 中奖奖项停追
			if (OrderAddStopType.AWARDS.getValue() == orderBaseInfoBO.getStopType()) {
				LotteryWinningVO lotteryWinningVO = new LotteryWinningVO();
				lotteryWinningVO.setCode(Integer.parseInt(orderBaseInfoBO.getStopCondition()));
				LotteryWinningBO lotteryWinningBO = lotteryWinningDaoMapper.findSingle(lotteryWinningVO);
				return PropertyUtil.getConfigValue(MessageCodeConstants.WINNING_PRIZE_END, execTime, lotteryWinningBO.getName());
			}
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.AFTER_NUMBER.getKey()) {// 追号撤单
			String updTime = DateUtil.convertDateToStr(orderBaseInfoBO.getAddEndTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.USER_CANCEL, updTime);
		}
		// 合买订单
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.RECRUITMENT.getKey()) {// 招募中
			Date transTime = getTransTime(orderBaseInfoBO);
			String transTimeStr = DateUtil.convertDateToStr(transTime, DateUtil.DATETIME_FORMAT_NO_SEC);
			String endSaleTimeStr = DateUtil.convertDateToStr(orderBaseInfoBO.getEndSaleTime(), DateUtil.FORMAT_M_D_H_M_S);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_FLOW_RECRUITMENT, transTimeStr, orderBaseInfoBO.getLotteryName(),
					endSaleTimeStr);
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.ABORTION_NOT_ENOUGH.getKey()) {// 合买未满员流产
			String failTime = DateUtil.convertDateToStr(orderFlowInfoBO.getCreateTime(), DateUtil.DATETIME_FORMAT_NO_SEC);
			return PropertyUtil.getConfigValue(MessageCodeConstants.ORDER_FLOW_ABORTION_NOT_ENOUGH, failTime);
		}
		return "";
	}

	/**
	 * 获取开奖时间
	 * 
	 * @param orderBaseInfoBO
	 * @param lotteryType
	 * @return
	 */
	private Date getLotteryTime(OrderBaseInfoBO orderBaseInfoBO) {
		LotteryEnum.LotteryPr lott = LotteryEnum.getLottery(orderBaseInfoBO.getLotteryCode());
		NewIssueBO newIssueBO = null;
		switch (lott) {
		case BJDC:// 北单
		case JJC:// 竞技彩
			if (!ObjectUtil.isBlank(orderBaseInfoBO.getMaxBuyScreen())) {// 根据最晚比赛时间取获取开奖时间
				SportAgainstInfoBO sportAgainstInfoBO = lotteryInfoMapper.querySportMatchInfo(orderBaseInfoBO.getLotteryCode(),
						orderBaseInfoBO.getMaxBuyScreen());
				if (!ObjectUtil.isBlank(sportAgainstInfoBO)) {
					return DateUtil.addMinute(sportAgainstInfoBO.getStartTime(), Constants.NUM_120);
				}
			}
			break;
		case GPC:// 高频彩
			newIssueBO = lotteryInfoMapper.findLotteryIssue(orderBaseInfoBO.getLotteryCode(), orderBaseInfoBO.getLotteryIssue());
			if (!ObjectUtil.isBlank(newIssueBO)) {
				return DateUtil.addSecond(newIssueBO.getLotteryTime(), Constants.NUM_30);
			}
			break;
		default:// 数字彩 足彩
			newIssueBO = lotteryInfoMapper.findLotteryIssue(orderBaseInfoBO.getLotteryCode(), orderBaseInfoBO.getLotteryIssue());
			if (!ObjectUtil.isBlank(newIssueBO)) {
				return newIssueBO.getLotteryTime();
			}
			break;
		}
		return null;
	}

	// 获取订单支付成功时间，没有支付的使用最后修改日期
	private Date getTransTime(OrderBaseInfoBO orderBaseInfoBO) {
		Date transTime = null;
		// 追号代购没有支付成功时间，取订单创建时间
		if (OrderEnum.BuyType.BUY_CHASE.getValue() == orderBaseInfoBO.getBuyType().shortValue()) {
			transTime = orderBaseInfoBO.getShowDate();
		} else {
			TransUserBO transUserBO = orderInfoDaoMapper.getOrderTrans(orderBaseInfoBO.getOrderCode(),
					UserTransStatusEnum.TRADE_SUCCESS.getKey());
			transTime = transUserBO != null ? transUserBO.getTransTime() : null;
		}
		if (transTime == null) {
			transTime = orderBaseInfoBO.getUpdateTime();
		}
		return transTime;
	}

	/**
	 * 验证订单状态和传进来的状态是否一致
	 * 
	 * @param inputStatus
	 * @param orderBaseInfoBO
	 * @param orderAddedIssue
	 * @return
	 * @author YiJian
	 * @date 2017年7月31日 下午2:57:31
	 */
	private boolean checkOrderStatus(Integer inputStatus, OrderBaseInfoBO orderBaseInfoBO, OrderAddedIssueBO orderAddedIssue) {
		Short payStatus = orderBaseInfoBO.getPayStatus().shortValue();
		short buyType = orderBaseInfoBO.getBuyType() == null ? 0 : orderBaseInfoBO.getBuyType().shortValue();
		if (buyType != OrderEnum.BuyType.BUY_TOGETHER.getValue()) {// 代购、追号订单记录支付流程
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.SUBMIT_FLOW.getKey()) {// 等待支付，支付状态为待支付
				return payStatus == PayStatusEnum.WAITTING_PAYMENT.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_FAIL.getKey()) {// 支付失败，支付状态为支付失败
				return payStatus == PayStatusEnum.PAYMENT_FAILURE.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.NO_PAY_OVERDUE.getKey()) {// 未支付过期，支付状态为未支付过期
				return payStatus == PayStatusEnum.OVERDUE_PAYMENT.getKey();
			}
		} else {// 合买类订单记录招募流程
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.RECRUITMENT.getKey()) {
				// 招募中，支付状态：待支付、支付中、支付成功
				return payStatus == PayStatusEnum.WAITTING_PAYMENT.getKey()
						|| payStatus == PayStatusEnum.BEING_PAID.getKey() | payStatus == PayStatusEnum.PAYMENT_SUCCESS.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.ABORTION_NOT_ENOUGH.getKey()) {
				// 合买未满员流产，支付状态：支付成功
				return payStatus == PayStatusEnum.PAYMENT_SUCCESS.getKey();
			}
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_SUCCESS.getKey()) {// 支付成功(等待出票)，支付状态为支付成功
			return payStatus == PayStatusEnum.PAYMENT_SUCCESS.getKey();
		}
		if (payStatus != PayStatusEnum.PAYMENT_SUCCESS.getKey()) {
			return false;
		}
		// 普通订单(代购、合买)，非追号订单
		if (OrderEnum.BuyType.BUY_CHASE_PLAN.getValue() != buyType) {
			Short orderStatus = orderBaseInfoBO.getOrderStatus().shortValue();
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.IN_TICKET.getKey()) {
				// 出票中，订单状态为待拆票、拆票中、待出票、出票中、已出票、出票失败、拆票失败、
				return orderStatus == OrderStatusEnum.PENDINGTICKET.getKey() || orderStatus == OrderStatusEnum.BILLOFFARE.getKey()
						|| orderStatus == OrderStatusEnum.TICKETPAYABLE.getKey() || orderStatus == OrderStatusEnum.DRAWNIN.getKey()
						|| orderStatus == OrderStatusEnum.DRAWN.getKey() || orderStatus == OrderStatusEnum.DRAWNERROR.getKey()
						|| orderStatus == OrderStatusEnum.SPLITING_FAIL.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_FAIL.getKey()) {
				// 出票失败，订单状态为出票失败、撤单中、已撤单
				return orderStatus == OrderStatusEnum.INCANCELLATION.getKey() || orderStatus == OrderStatusEnum.DRAWNERROR.getKey()
						|| orderStatus == OrderStatusEnum.CANCELLATIONOK.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.CANCEL_ORDER.getKey()) {// 已撤单，订单状态为出票失败、撤单中、已撤单
				return orderStatus == OrderStatusEnum.DRAWNERROR.getKey() || orderStatus == OrderStatusEnum.CANCELLATIONOK.getKey()
						|| orderStatus == OrderStatusEnum.INCANCELLATION.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_SUCCESS.getKey()) {// 出票成功，订单状态为已出票
				return orderStatus == OrderStatusEnum.DRAWNIN.getKey() || orderStatus == OrderStatusEnum.DRAWN.getKey();
			}
			if (orderStatus != OrderStatusEnum.DRAWN.getKey()) {//
				return false;
			}
			Short winningStatus = orderBaseInfoBO.getWinningStatus().shortValue();
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.LOSING_LOTTERY.getKey()) {// 未中奖，中奖状态为未中奖
				return winningStatus == OrderWinningStatusEnum.NOTWINNING.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.HAS_WINNING.getKey()) {// 已中奖，中奖状态为已中奖
				return winningStatus == OrderWinningStatusEnum.WINNING.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.HAD_SENT.getKey()) {// 已派奖，中奖状态为已派奖
				return winningStatus == OrderWinningStatusEnum.ACCPETEDPEIZE.getKey();
			}
			return false;
		} else {// 追号订单
			Short addIssueStatus = orderAddedIssue != null ? orderAddedIssue.getAddStatus() : 0;
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.EXEC_ONE_SUCCESS.getKey()) {// 执行一期追号成功后，追号详情状态为追号成功
				return addIssueStatus == OrderAddIssueStatusEnum.ADDSUCCESS.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.EXEC_ONE_FAIL.getKey()) {// 执行一期追号失败后，追号详情状态为追号失败
				return addIssueStatus == OrderAddIssueStatusEnum.ADDFAIL.getKey();
			}
			Short addStatus = orderBaseInfoBO.getAddStatus().shortValue();
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.AFTER_END.getKey()) {// 追号结束，追号状态为追号结束
				return addStatus == OrderAddStatusEnum.ADDEND.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.WINNING_AFTER_STOP.getKey()) {// 中奖金额停追、中奖奖项停追，追号状态为中奖停追
				return addStatus == OrderAddStatusEnum.WINNINGSTOPADD.getKey();
			}
			if (inputStatus == OrderFlowInfoEnum.StatusEnum.AFTER_NUMBER.getKey()) {// 追号撤单，追号状态为用户撤单或系统撤单
				return addStatus == OrderAddStatusEnum.CANCELLATIONSYSTEM.getKey()
						|| addStatus == OrderAddStatusEnum.CANCELLATIONUSER.getKey();
			}
		}
		return false;
	}

	/**
	 * 判断流程是否已记录
	 * 
	 * @param orderFlowInfoBO
	 * @param orderBaseInfoBO
	 * @param orderAddedIssue
	 * @return
	 */
	private boolean checkOrderFlowExist(OrderFlowInfoBO orderFlowInfoBO, OrderBaseInfoBO orderBaseInfoBO,
			OrderAddedIssueBO orderAddedIssue) {
		Integer inputStatus = orderFlowInfoBO.getStatus();
		String orderCode = orderBaseInfoBO.getOrderCode();
		// 等待支付、支付成功(等待出票)、支付失败、未支付过期、出票失败、出票中、出票成功、已撤单、招募中、合买未满员流产、合买撤单流产
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.SUBMIT_FLOW.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_SUCCESS.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.PAY_FAIL.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.NO_PAY_OVERDUE.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_FAIL.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.IN_TICKET.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.TICKET_SUCCESS.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.CANCEL_ORDER.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.RECRUITMENT.getKey()
				|| inputStatus == OrderFlowInfoEnum.StatusEnum.ABORTION_NOT_ENOUGH.getKey()) {
			return !ObjectUtil.isBlank(orderFlowInfoMapper.queryOrderFlowInfos(orderCode, inputStatus, null));
		}
		if (inputStatus == OrderFlowInfoEnum.StatusEnum.EXEC_ONE_FAIL.getKey() && orderAddedIssue != null) {// 执行一期追号失败后
			return !ObjectUtil.isBlank(orderFlowInfoMapper.queryOrderFlowInfos(orderCode, inputStatus, orderAddedIssue.getIssueCode()));
		}
		return false;
	}
}
