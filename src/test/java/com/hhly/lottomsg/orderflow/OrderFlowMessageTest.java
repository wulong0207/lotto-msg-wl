package com.hhly.lottomsg.orderflow;

import java.util.Date;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hhly.lottomsg.bo.OrderFlowInfoBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.constants.PayConstants.UserTransStatusEnum;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.mapper.OrderInfoDaoMapper;
import com.hhly.lottomsg.rabbitmq.provider.impl.OrderCopyMessageProvider;
import com.hhly.lottomsg.rabbitmq.provider.impl.OrderFlowMessageProvider;
import com.hhly.lottomsg.service.CopyOrderService;
import com.hhly.lottomsg.service.OrderFlowInfoService;
import com.hhly.lottomsg.vo.CopyOrderMsgModel;

import net.sf.json.JSONObject;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/6/2 14:32
 * @company 益彩网络科技公司
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class OrderFlowMessageTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private OrderFlowInfoService orderFlowInfoService;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private OrderInfoDaoMapper orderInfoDaoMapper;

	@Autowired
	private CopyOrderService copyOrderService;

	@Autowired
	private OrderFlowMessageProvider orderFlowMessageProvider;

	@Autowired
	private OrderCopyMessageProvider orderCopyMessageProvider;

	@Test
	public void testSendOrderFlowMessage() {
		// 1：提交方案2:支付成功3：支付失败4:未支付过期
		// 代购专有：（等待出票）5：出票中 6 出票失败7.已撤单8：等待开奖9：已中奖10：未中奖11：已派奖
		// 追号专有：12：追号中13：追号结束14：中奖追停15：追号撤单
		try {
			// JSONObject jsonObject = new JSONObject();
			// jsonObject.put("orderCode","Z2017011810434800093");
			// jsonObject.put("", "2017002");
			// jsonObject.put("createTime", DateUtil.getNow());
			// jsonObject.put("status",18);
			OrderFlowInfoBO orderFlowInfoBO = new OrderFlowInfoBO();
			orderFlowInfoBO.setOrderAddCode("JZ17081015110716600023");
			orderFlowInfoBO.setCreateTime(new Date());
			orderFlowInfoBO.setStatus(6);
			orderFlowInfoBO.setOrderAddIssue("17093");
			orderFlowInfoService.insert(orderFlowInfoBO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSendRabbitMessage() {
		MessageProperties properties = new MessageProperties();
		properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
		properties.setPriority(new Random().nextInt(10));
		JSONObject json = new JSONObject();
		json.accumulate("status", 19);
		json.accumulate("orderAddCode", "JZ17083115195816600138");
		json.accumulate("orderAddIssue", "17083142");
		json.accumulate("buyType", 2);
		json.accumulate("createTime", DateUtil.convertDateToStr(new Date()));
		Message message = new Message(json.toString().getBytes(), properties);
		amqpTemplate.send("orderflow_queue_test", message);
		System.out.println("发送消息成功");
	}

	@Test
	public void testMyBatis() {
		Object obj = orderInfoDaoMapper.getOrderTrans("123", UserTransStatusEnum.TRADE_SUCCESS.getKey());
		System.out.println(obj == null);
	}

	@Test
	public void testCopyOrder() throws Exception{
		CopyOrderMsgModel copyOrderMsgModel = new CopyOrderMsgModel();
		copyOrderMsgModel.setType(1);
		copyOrderMsgModel.setOrderCodeStr("D1707201127025200096");

		/*copyOrderMsgModel.setType(2);
		copyOrderMsgModel.setOrderCodeStr("D1706130948490100005");*/
		copyOrderService.execute(copyOrderMsgModel);
	}


	@Test
	public void testSendOrderFlowMessage1(){

		//1：提交方案2:支付成功3：支付失败4:未支付过期
		//代购专有：（等待出票）5：出票中 6 出票失败7.已撤单8：等待开奖9：已中奖10：未中奖11：已派奖
		// 追号专有：12：追号中13：追号结束14：中奖追停15：追号撤单

		try {
			for(int i=1;i<=15 ;i++){
				com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
				jsonObject.put("orderCode","D1705151804000100002");
				jsonObject.put("createTime", DateUtil.getNow());
				jsonObject.put("status",i);
				orderFlowMessageProvider.sendMessage(Constants.QUEUE_NAME_FOR_ORDER_FLOW,jsonObject.toJSONString());
			}

		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test
	public void testSendOrderCopyMessage(){
		try {
			com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
			//jsonObject.put("type",1);//1:出票成功；2：开奖成功
			//jsonObject.put("orderCodeStr", "D1707201127025200096"); //推单 订单编号串，多个以,分割
			//jsonObject.put("orderCodeStr", "D1706130948490100005");//跟单


			jsonObject.put("type",2);//1:出票成功；2：开奖成功
			jsonObject.put("orderCodeStr", "D1707201127025200096"); //推单 订单编号串，多个以,分割
			orderCopyMessageProvider.sendMessage(Constants.QUEUE_NAME_FOR_ORDER_COPY,jsonObject.toJSONString());
		}catch (Exception e){
			e.printStackTrace();
		}

	}



}
