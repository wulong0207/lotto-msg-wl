package com.hhly.lottomsg.rabbitmq.consume;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.bo.OrderFlowInfoBO;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.service.OrderFlowInfoService;


/**
 * 消息监听者
 *
 * @author yuanshangbing
 * @create 2017/5/22 17:06
 */
@Component("orderFlowMessageListener")
public class OrderFlowMessageListener{

    /*private static ExecutorService exec = new ThreadPoolExecutor(10, 10, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100000),
            new ThreadPoolExecutor.CallerRunsPolicy());*/

	private Logger logger = LoggerFactory.getLogger(OrderFlowMessageListener.class);

	@Bean
	public Object creteOrderFlowQueue() {    
		logger.info("create queue orderflow_queue ........................");
		Map<String,Object> arguments = new  HashMap<String,Object>();
		arguments.put("x-max-priority", 10);
		return new Queue("orderflow_queue",false,false,false,arguments);
	}
	
    @Autowired
    private OrderFlowInfoService orderFlowInfoService;

    @RabbitListener(queues="orderflow_queue", containerFactory="rabbitmqContainerFactory")
    public void onMessage(Message message) {
    	OrderFlowInfoBO orderFlowInfoBO = new OrderFlowInfoBO();
        try {
        	String msg = new String(message.getBody(),"UTF-8");
        	logger.info("订单流程queue收到消息:"+msg);
        	orderFlowInfoBO = (OrderFlowInfoBO) JsonUtil.json2Object(msg, OrderFlowInfoBO.class);
            orderFlowInfoService.insert(orderFlowInfoBO);
        } catch (Exception e) {
            logger.error("订单流程信息插入失败，订单号："+orderFlowInfoBO.getOrderCode(),e);
        }
    }

    /*class OrderFlowThread implements  Runnable{
        OrderFlowInfoBO orderFlowInfoBO;
        OrderFlowInfoService orderFlowInfoService;
        public OrderFlowThread(OrderFlowInfoBO orderFlowInfoBO,OrderFlowInfoService orderFlowInfoService){
            this.orderFlowInfoBO = orderFlowInfoBO;
            this.orderFlowInfoService = orderFlowInfoService;
        }
        @Override
        public void run() {
            synchronized (orderFlowInfoBO.getOrderCode()){
                try {
                    orderFlowInfoService.insert(orderFlowInfoBO);
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
                this.notifyAll();
            }
        }
    }*/
    
    

}
