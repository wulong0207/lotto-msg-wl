package com.hhly.lottomsg.common.constants;

/**
 * @desc 项目公用常量
 * @author jiangwei
 * @date 2017年4月1日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class Constants {
	
	// -----抄单相关
	public static final String ONE_TEN[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	public static final int NUM_1 = 1;
	public static final int NUM_2 = 2;
	public static final int NUM_3 = 3;
	public static final int NUM_7 = 7;
	public static final int NUM_10 = 10;
	public static final int NUM_11 = 11;
	public static final int NUM_30 = 30;
	public static final int NUM_120 = 120;
	
	/**
	 * APP发送附加字段
	 */
	public static final String APP_MSG_TYPE="typeId";
	
	/**
	 * APP附加字段数据
	 */
	public static final String APP_MSG_ADD_DATA = "data";
	
	/**
	 * 待发送状态
	 */
	public static final short NO_SEND_STATUS = 0;
	
	/**
	 * 订单中奖通知节点ID
	 */
	public static final Integer ORDER_PRIZE_NODEID = 7;
	
	/**
	 * 中奖停追节点ID
	 */
	public static final Integer PRIZE_STOP_NODEID = 10;
	
	/**
	 * 发送用户缓存KEY后缀
	 */
	public static final String REDIS_SEND_USER_KEY_AFTER = "_aliasList";
	
	/**
	 * 第三方推送消息类型：1—点对点，2—群发，5—主题
	 */
	public static final String  CHATTYPE = "2";
	
	/**
	 * 第三方推送消息参数常量
	 */
	public static final String THIRD_PUSH_USERID = "ycwl";
	
	/**
	 * 编码
	 */
	public static final String CHARACTER_ENCODING = "UTF-8";
	
	/**
	 * 消息批次发送
	 */
	public static final String MSG_BATCH_SEND = "msgBatchSend";
	/**
	 * 信息重新发送
	 */
	public static final String MSG_RESEND = "msgReSend";

	/**
	 * 节点通知信息发送
	 */
	public static final String MSG_NODE_RESEND = "nodeMsgSend";
	
	/**
	 * 订单流程队列名
	 */
	public static final String QUEUE_NAME_FOR_ORDER_FLOW = "orderflow_queue";
	/**
	 * 抄单队列列名
	 */
	public static final String QUEUE_NAME_FOR_ORDER_COPY = "copy_order_queue";

}
