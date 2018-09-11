/**
 * 
 */
package com.hhly.lottomsg.common.enums;

import java.util.Objects;

/**
 * @desc 订单枚举类
 * @author Bruce
 * @date 2017年1月19日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OrderEnum {

	/**
	 * @desc 订单单号生成
	 * @author jiangwei
	 * @date 2017-1-22
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum NumberCode {
		ORDER_D("D", "代购方案订单"), ORDER_H("H", "合买方案订单"), ORDER_Z("Z", "追号方案订单"), ORDER_JZ("JZ", "追号计划订单"), //
		RUNNING_WATER_IN("I", "流水号收入"), RUNNING_WATER_OUT("O", "流水号支出"), COUPON_A("HA", "充值红包"), COUPON_CR("CR", "充值红包"), //
		COUPON_CC("CC", "消费红包"), COUPON_CM("CM", "彩金红包"), COUPON_CP("CP", "加奖红包"), COUPON_CL("CL", "随机减红包"), //
		COUPON_CA("CA", "大礼包红包"), COUPON("HB", "默认红包"), MESSAGE("MC", "添加消息"), SEND_BATCH("SC", "发送批次号"), //
		CDKEY_COUNPN("R", "红包兑换码"), CDKEY_INTEGRAL("J", "积分兑换码"),;
		NumberCode(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		private String code;

		private String desc;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * @author huangb
	 * 
	 * @Date 2016年12月1日
	 * 
	 * @Desc 支付状态
	 */
	public enum PayStatus {

		WAITING_PAY("等待支付", (short) 1), SUCCESS_PAY("支付成功", (short) 2), OVERDUE_PAY("未支付过期", (short) 3), FAILING_PAY("支付失败",
				(short) 4), USER_CANCLE_PAY("用户取消", (short) 5), REFUNDMENT("退款", (short) 6), PAYING("支付中", (short) 7);

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 状态值
		 */
		private short value;

		PayStatus(String desc, short value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public short getValue() {
			return value;
		}

		public void setValue(short value) {
			this.value = value;
		}

		public static PayStatus parsePayStatus(short value) {
			for (PayStatus payStatus : PayStatus.values()) {
				if (payStatus.value == value) {
					return payStatus;
				}
			}
			return null;
		}

	}

	/**
	 * @author huangb
	 * 
	 * @Date 2016年12月1日
	 * 
	 * @Desc 订单状态
	 */
	public enum OrderStatus {
		/**
		 * 待上传
		 */
		WAITING_UPLOAD("待上传", (short) 1),
		/**
		 * 待拆票
		 */
		WAITING_SPLIT_TICKET("待拆票", (short) 2),
		/**
		 * 拆票中
		 */
		SPLITING_TICKET("拆票中", (short) 3),
		/**
		 * 待出票
		 */
		WAITING_TICKET("待出票", (short) 4),
		/**
		 * 出票中
		 */
		TICKETING("出票中", (short) 5),
		/**
		 * 已出票
		 */
		TICKETED("已出票", (short) 6),
		/**
		 * 出票失败
		 */
		FAILING_TICKET("出票失败", (short) 7),
		/**
		 * 已撤单
		 */
		WITHDRAW("已撤单", (short) 8),
		/**
		 * 拆票失败
		 */
		SPLITING_FAIL("拆票失败", (short) 9),
		/**
		 * 撤单中
		 */
		WITHDRAWING("撤单中", (short) 10);

		/**
		 * 状态值
		 */
		private short value;
		/**
		 * 
		 */
		private String desc;

		OrderStatus(String desc, short value) {
			this.value = value;
			this.desc = desc;
		}

		public short getValue() {
			return value;
		}

		public void setValue(short value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public static OrderStatus parseOrderStatus(int status) {
			for (OrderStatus orderStatus : OrderStatus.values()) {
				if (orderStatus.getValue() == status) {
					return orderStatus;
				}
			}
			return null;
		}

	}

	/**
	 * @author huangb
	 * 
	 * @Date 2016年12月1日
	 * 
	 * @Desc 订单购买类型
	 */
	public enum BuyType {

		BUY("代购", (short) 1), BUY_CHASE("追号", (short) 2), BUY_TOGETHER("合买", (short) 3), BUY_CHASE_PLAN("追号计划", (short) 4);

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 类型值
		 */
		private short value;

		BuyType(String desc, short value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public short getValue() {
			return value;
		}

		public void setValue(short value) {
			this.value = value;
		}

		/**
		 * @param value
		 * @return
		 * @Desc 是否包含指定类型
		 */
		public static boolean contain(short value) {
			for (BuyType temp : BuyType.values()) {
				if (temp.getValue() == value) {
					return true;
				}
			}
			return false;
		}

		public static BuyType parseBuyType(short value) {
			for (BuyType temp : BuyType.values()) {
				if (temp.getValue() == value) {
					return temp;
				}
			}
			return null;
		}
	}

	/**
	 * @author huangb
	 *
	 * @Date 2016年12月1日
	 *
	 * @Desc 投注的内容类型
	 */
	public enum BetContentType {
		// 1：单式；2：复式；3：胆拖；4：混合；5：上传；6：和值
		SINGLE("单式", 1), MULTIPLE("复式", 2), DANTUO("胆拖", 3), MIX("混合", 4), UPLOAD("上传", 5), SUM("和值", 6);

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 类型值
		 */
		private int value;

		BetContentType(String desc, int value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * @param value
		 *            类型值
		 * @return true/false
		 * @Desc 是否包含指定类型
		 */
		public static boolean contain(Integer value) {
			if (null == value)
				return false;
			for (BetContentType temp : BetContentType.values()) {
				if (temp.getValue() == value) {
					return true;
				}
			}
			return false;
		}

		/**
		 * @desc 获取指定内容类型
		 * @author huangb
		 * @date 2017年3月14日
		 * @param contentType
		 *            内容类型
		 * @return 获取指定内容类型
		 */
		public static BetContentType getContentType(Integer contentType) {
			if (contentType == null) {
				return null;
			}
			for (BetContentType tmp : BetContentType.values()) {
				if (tmp.getValue() == contentType.intValue()) {
					return tmp;
				}
			}
			return null;
		}

		/**
		 * @param value
		 *            类型值
		 * @return true/false
		 * @Desc 是否是双色球的类型
		 */
		public static boolean isSSQ(int value) {
			return BetContentType.SINGLE.getValue() == value || BetContentType.MULTIPLE.getValue() == value
					|| BetContentType.DANTUO.getValue() == value;
		}

		/**
		 * 是否为单式或复式
		 * 
		 * @param value
		 * @return
		 */
		public static boolean isDsOrFs(int value) {
			return BetContentType.SINGLE.getValue() == value || BetContentType.MULTIPLE.getValue() == value;
		}
	}

	/**
	 * @desc 选号方式
	 * @author Tony Wang
	 * @date 2017年2月5日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum CodeWay {
		// 选号方式 1：手选；2：机选；3：上传；
		HAND("手选", 1), MACHINE("机选", 2), UPLOAD("上传", 3);
		// 描述
		private final String desc;
		// 类型值
		private final int value;

		CodeWay(String desc, int value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public int getValue() {
			return value;
		}

		public static boolean contain(Integer value) {
			if (value == null)
				return false;
			for (CodeWay temp : CodeWay.values()) {
				if (Objects.equals(value, temp.getValue())) {
					return true;
				}
			}
			return false;
		}

		public static CodeWay parseCodeWay(Integer value) {
			for (CodeWay temp : CodeWay.values()) {
				if (temp.getValue() == value) {
					return temp;
				}
			}
			return null;
		}
	}

	/**
	 * @desc 大乐透追号表示
	 * @author Bruce
	 * @date 2017年2月14日
	 * @company 益彩网络科技有限公司
	 * @version 1.0
	 */
	public enum DltAdd {
		// 是否大乐透追号 0：否；1：是；
		YES("是", (short) 1), NO("否", (short) 0);
		// 描述
		private final String desc;
		// 类型值
		private final short value;

		DltAdd(String desc, short value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public short getValue() {
			return value;
		}

		public static boolean contain(Short value) {
			if (value == null) {
				return false;
			}
			for (DltAdd temp : DltAdd.values()) {
				if (Objects.equals(value, temp.getValue())) {
					return true;
				}
			}
			return false;
		}
	}

	public enum TicketStatus {
		/**
		 * 出票异常
		 */
		ERROR("出票失败", -2),
		/**
		 * 送票失败
		 */
		SEND_FAIL("送票失败", -1),
		/**
		 * 不出票
		 */
		NO_OUT("不出票", 0),
		/**
		 * 待分配
		 */
		NO_ALLOCATION("待分配", 1),
		/**
		 * 已分配
		 */
		ALLOCATION("已分配", 2),
		/**
		 * 已送票
		 */
		SEND("已送票", 3),
		/**
		 * 已出票
		 */
		OUT_TICKET("已出票", 4),;
		TicketStatus(String desc, int value) {
			this.desc = desc;
			this.value = value;
		}

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 类型值
		 */
		private int value;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	/**
	 * 追号订单追停条件
	 */
	public enum OrderAddStopType {
		/**
		 * 奖项
		 */
		AWARDS("奖项", 1),
		/**
		 * 送票失败
		 */
		AMOUNT("金额", 2),
		/**
		 * 永追
		 */
		NEVER_CHASE("永追", 3),;

		OrderAddStopType(String desc, int value) {
			this.desc = desc;
			this.value = value;
		}

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 类型值
		 */
		private int value;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	/**
	 * 订单开奖状态 1：未开奖；2：未中奖；3：已中奖；4：已派奖
	 */
	public enum OrderWinningStatus {
		/**
		 * 未开奖
		 */
		NOT_DRAW_WINNING("未开奖", (short) 1),
		/**
		 * 未中奖
		 */
		NOT_WINNING("未中奖", (short) 2),
		/**
		 * 已中奖
		 */
		WINNING("已中奖", (short) 3),
		/**
		 * 已派奖
		 */
		GET_WINNING("已派奖", (short) 4),;

		OrderWinningStatus(String desc, short value) {
			this.desc = desc;
			this.value = value;
		}

		/**
		 * 状态描述
		 */
		private String desc;
		/**
		 * 类型值
		 */
		private short value;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public short getValue() {
			return value;
		}

		public void setValue(short value) {
			this.value = value;
		}
	}

	/**
	 * @desc 追号状态； 1：追号中；2：中奖停追；3：追号结束；4：用户撤单；5：系统撤单；
	 * @author xiongJinGang
	 * @date 2017年4月27日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum AddStatus {
		CHASING((short) 1, "追号中"), // 追号中
		CHASE_STOP((short) 2, "中奖停追"), // 中奖停追
		CHASE_FINISH((short) 3, "追号结束"), // 追号结束
		USER_CANCEL((short) 4, "用户撤单"), // 用户撤单
		SYSTEM_UNDO((short) 5, "系统撤单");// 系统撤单
		private Short key;
		private String value;

		AddStatus(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * @desc 平台类型:1：Web,2:Wap;3:Android;4:IOS;
	 * @author huangb
	 * @date 2017年6月7日
	 * @company 益彩网络
	 * @version v1.0
	 */
	public enum PlatformType {

		WEB("Web端", (short) 1), WAP("Wap端", (short) 2), ANDROID("Android端", (short) 3), IOS("Ios端", (short) 4);

		/**
		 * 描述
		 */
		private String desc;
		/**
		 * 值
		 */
		private short value;

		PlatformType(String desc, short value) {
			this.desc = desc;
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public short getValue() {
			return value;
		}

		public void setValue(short value) {
			this.value = value;
		}

		/**
		 * @param value
		 * @return
		 * @Desc 是否包含类型
		 */
		public static boolean contain(Short value) {
			if (value == null) {
				return false;
			}
			for (PlatformType temp : PlatformType.values()) {
				if (temp.getValue() == value.shortValue()) {
					return true;
				}
			}
			return false;
		}

		/**
		 * @desc 获取平台类型
		 * @author huangb
		 * @date 2017年6月7日
		 * @param value
		 *            类型值
		 * @return 获取平台类型
		 */
		public static PlatformType getPlatformType(Short value) {
			if (value == null) {
				return null;
			}
			for (PlatformType tmp : PlatformType.values()) {
				if (tmp.getValue() == value.shortValue()) {
					return tmp;
				}
			}
			return null;
		}
	}

	/**
	 * 撤单类型 1:中心通讯故障;2:中心限号原因;0:手动输入;
	 * 
	 * @desc
	 * @author cheng chen
	 * @date 2017年6月11日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum CancelType {

		MANUAL((short) 0, "手动输入"), TRANS((short) 1, "中心通讯故障"), LIMIT((short) 2, "中心限号原因");

		private Short value;

		private String desc;

		private CancelType(Short value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public static CancelType valueOf(Short target) {
			if (null == target)
				return null;
			for (CancelType cancelType : CancelType.values()) {
				if (Objects.equals(cancelType.getValue(), target))
					return cancelType;
			}
			return null;
		}

		public Short getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 普通订单统一状态，（三个订单相关状态合并为一个）前端专用
	 * 
	 * @desc
	 * @author yuanshangbing
	 * @date 2017年6月13日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum OrderUnityStatus {
		NO_PAY(1, "待支付"), NO_PAY_OVERDUE(2, "未支付过期"), WAITING_TICKET(3, "等待出票"), TICKETTING(4, "出票中"),
		//
		BET_FAIL(5, "投注失败"), BET_SUCCESS(6, "投注成功");

		private Integer value;

		private String desc;

		OrderUnityStatus(Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Integer getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 普通订单统一状态，（三个订单相关状态合并为一个）前端(订单详情时)专用
	 * 
	 * @desc
	 * @author huangcf
	 * @date 2017年8月11日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum OrderFlowUnityStatus {
		NO_PAY(1, "待支付"), NO_PAY_OVERDUE(2, "未支付过期"), NO_PAY_USER_CANCEL(3, "用户取消"), PAY_FAIL(4, "支付失败"), //
		WAITING_TICKET(5, "等待出票"), TICKETTING(6, "出票中"), TICKET_FAIL(7, "出票失败"), TICKET_REFUND(8, "已退款"), //
		WAITING_WINNING(9, "等待开奖"), NOT_WINNING(10, "未中奖"), WAITING_SEND(11, "等待派奖"), SENDED(12, "已派奖");
		private Integer value;
		private String desc;

		OrderFlowUnityStatus(Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Integer getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 追号订单统一状态 前端专用
	 * 
	 * @desc
	 * @author yuanshangbing
	 * @date 2017年6月13日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum AddOrderUnityStatus {
		NO_PAY(1, "待支付"), NO_PAY_OVERDUE(2, "未支付过期"), ADDING(3, "追号中"), ADDED_STOP(4, "追号结束"),
		//
		WINNING_STOP(5, "中奖停追"), ADDED_REVOKE(6, "追号撤单"), BET_FAIL(7, "投注失败");

		private Integer value;

		private String desc;

		AddOrderUnityStatus(Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Integer getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 追号订单统一状态 前端订单详情专用
	 * 
	 * @desc
	 * @author huangcf1219
	 * @date 2017年8月11日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum AddOrderFlowUnityStatus {
		NO_PAY(1, "待支付"), NO_PAY_OVERDUE(2, "未支付过期"), NO_PAY_USER_CANCEL(3, "用户取消"), PAY_FAIL(4, "支付失败"),
		//
		ADDING(5, "追号中"), ADDED_STOP(6, "追号结束"), WINNING_STOP(7, "中奖停追"), ADDED_REVOKE(8, "追号撤单");

		private Integer value;

		private String desc;

		AddOrderFlowUnityStatus(Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Integer getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 投注类型
	 *
	 * @author longguoyou
	 * @date 2017年7月24日
	 * @compay 益彩网络科技有限公司
	 */
	public enum Category {
		DG_SPF((short) 1, "单关胜平负"), DCZS((short) 2, "单场致胜"), BONUS((short) 3, "奖金优化"), ODD_EVEN((short) 4, "猜单双"), BIG_SMALL((short) 5,
				"猜大小球"), SINGLE_UPLOAD((short) 6, "单式上传");

		private Short value;

		private String desc;

		Category(Short value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Short getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 订单类型， '1、未推单 2、已推单 3、已跟单'
	 *
	 * @author longguoyou
	 * @date 2017年7月24日
	 * @compay 益彩网络科技有限公司
	 */
	public enum OrderTypeEnum {
		WTD((short) 1, "未推单"), YTD((short) 2, "已推单"), YDD((short) 3, "已跟单");

		private Short value;

		private String desc;

		OrderTypeEnum(Short value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public Short getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * @desc 追号状态； 1：追号中；2：中奖停追；3：追号结束；4：用户撤单；5：系统撤单；
	 * @author 袁尚兵
	 * @date 2017年12月20日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum AddShowStatus {
		WAITTING_CHASE((short) 1, "等待追号"), // 等待追号
		CHASE_SUCCESS((short) 2, "追号成功"), // 追号成功
		CHASE_FAIL((short) 3, "追号失败"), // 追号失败
		SYSTEM_UNDO((short) 4, "系统撤单"), // 系统撤单
		USER_CANCEL((short) 5, "用户撤单"); // 用户撤单
		private short key;
		private String value;

		AddShowStatus(short key, String value) {
			this.key = key;
			this.value = value;
		}

		public short getKey() {
			return key;
		}

		public void setKey(short key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
