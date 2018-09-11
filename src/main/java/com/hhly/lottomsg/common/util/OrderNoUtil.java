package com.hhly.lottomsg.common.util;

import java.util.Date;

import org.springframework.util.Assert;

import com.hhly.lottomsg.base.exception.ServiceRuntimeException;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.enums.OrderEnum.NumberCode;

/**
 * @desc 订单生成编号
 * @author jiangwei
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public abstract class OrderNoUtil {
	// 订单
	private static final Number ORDER = new Number(99999, 5);
	// 流水
	private static final Number WATER = new Number(99999, 5);
	// 消息
	private static final Number MESSAGE = new Number(99999, 5);
	// 发送批次号
	private static final Number SEND = new Number(999, 3);

	private static final Number COUPON = new Number(99999, 5);

	private static final String SERVICE_ID;

	static {
		//服务ip取本机ip第4段，不足3位用0填充
		String ip = IpUtil.getLocalIP();
		ip = ip.substring(ip.lastIndexOf(".") + 1);
		if (ip.length() == 1) {
			ip = "00" + ip;
		} else if (ip.length() == 2) {
			ip = "0" + ip;
		}
		SERVICE_ID = ip;
	}

	/**
	 * 获取唯一订单编号
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月9日 下午3:59:35
	 * @param code
	 *            订单编号类型
	 * @param serviceId
	 *            服务器ID,多台服务器时此ID不能重复（建议2位整数）
	 * @return
	 */
	public static String getOrderNo(NumberCode code) {
		Assert.hasText(SERVICE_ID);
		switch (code) {
		case ORDER_D:
		case ORDER_H:
		case ORDER_Z:
		case ORDER_JZ:
			return code.getCode() + ORDER.getNo(SERVICE_ID);
		case COUPON_CR:
		case COUPON_CC:
		case COUPON_CM:
		case COUPON_CP:
		case COUPON_CL:
		case COUPON_CA:
			throw new ServiceRuntimeException("优惠券需要采用数据库序列递增");
		case COUPON:
			return code.getCode() + COUPON.getNo(SERVICE_ID);
		case COUPON_A:
			return code.getCode() + COUPON.getNo(SERVICE_ID);
		case RUNNING_WATER_IN:
		case RUNNING_WATER_OUT:
			return code.getCode() + WATER.getNo(SERVICE_ID);
		case MESSAGE:
			return code.getCode() + MESSAGE.getNo(SERVICE_ID);
		case SEND_BATCH:
			return code.getCode() + SEND.getNo(SERVICE_ID);
		case CDKEY_COUNPN:
		case CDKEY_INTEGRAL:
			// 兑换码生成的随机码不一定唯一，需要自行判断
			return code.getCode()+EncryptUtil.getRandomUpperString(Constants.NUM_11).toUpperCase();
		default:
			throw new ServiceRuntimeException("不能生成该类型订单号");
		}
	}

	/**
	 * @desc 生成唯一数
	 * @author jiangwei
	 * @date 2017年3月9日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	private static class Number {
		/**
		 * 填充数
		 */
		private final String ZERO = "0";
		/**
		 * 最大递增数
		 */
		private final int MAX;
		/**
		 * 上次递增数替换时间
		 */
		private long lastTime;
		/**
		 * 递增数
		 */
		private int num = 0;
		/**
		 * 数字长度，判断是否需要填充
		 */
		private int length;
		/**
		 * 是否添加格式化日期
		 */
		private boolean addDate;

		public Number(int max, int length) {
			this(max, true, length);
		}

		public Number(int max, boolean addDate, int length) {
			super();
			this.MAX = max;
			lastTime = System.currentTimeMillis() / 1000;
			this.length = length;
			this.addDate = addDate;
		}

		/**
		 * 同步生成唯一订单号
		 * 
		 * @author jiangwei
		 * @Version 1.0
		 * @CreatDate 2017年3月9日 下午4:03:01
		 * @param serviceId
		 * @return
		 */
		public synchronized String getNo(String serviceId) {
			int mantissa = 0;
			long nowTime = 0;
			synchronized (this) {
				mantissa = ++num;
				nowTime = System.currentTimeMillis() / 1000;
				if (num > MAX) {
					mantissa = num = 1;
					// 需要判断本次递增周期与上次是否相同，相同需要循环等待下个周期
					while (nowTime == lastTime) {
						nowTime = System.currentTimeMillis() / 1000;
					}
					lastTime = nowTime;
				}
			}
			String str = String.valueOf(mantissa);
			for (int i = str.length(); i < length; i++) {
				str = ZERO + str;
			}
			if (addDate) {
				return DateUtil.convertDateToStr(new Date(nowTime * 1000), "yyMMddHHmmss") + serviceId + str;
			}
			return serviceId + str;
		}
	}

	public static void main(String[] args) {
		// final Number number = new Number(99999,5);
		/*
		 * long start = System.currentTimeMillis(); Set<String> set = new
		 * HashSet<>(); for(int i = 0; i<1000_000;i++){
		 * set.add(number.getNo("88")); }
		 * System.out.println(System.currentTimeMillis() - start);
		 * System.out.println(set.size());
		 */
		// final Set<String> set = new ConcurrentSkipListSet<>();
		// for (int i = 0; i < 100; i++) {
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 0; i < 10000; i++) {
		// String string = OrderNoUtil.getOrderNo(NumberCode.ORDER_D);
		// set.add(string);
		// System.out.println(string);
		// }
		// System.out.println(set.size());
		// }
		// }).start();
		// }
	}
}
