package com.hhly.lottomsg.common.enums;

import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @author YiJian
 * @version 1.0
 * @desc
 * @date 2017/5/25.
 * @company 益彩网络科技有限公司
 */
public class CancellationConstants {

	public enum OrderTypeEnum {
		INDENTORDER((short) 1, "代购订单"), ADDEDORDER((short) 2, "追号订单");
		private Short key;
		private String value;

		OrderTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderTypeEnum orderTypeEnum : CancellationConstants.OrderTypeEnum.values()) {
					if (key.equals(orderTypeEnum.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取值
		public static CancellationConstants.OrderTypeEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderTypeEnum orderTypeEnum : CancellationConstants.OrderTypeEnum.values()) {
					if (key.equals(orderTypeEnum.getKey())) {
						return orderTypeEnum;
					}
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum RefundTypeEnum {
		WINNINGSTOPREFUND((short) 1, "中奖停追退款"), CURISSUEREFUND((short) 2, "单期撤单退款"), USERCANCELREFUND((short) 3,
				"用户撤单退款"), MULTIISSUEREFUND((short) 4, "多期撤单退款");
		private Short key;
		private String value;

		RefundTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取值
		public static CancellationConstants.RefundTypeEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.RefundTypeEnum refundTypeEnum : CancellationConstants.RefundTypeEnum.values()) {
					if (key.equals(refundTypeEnum.getKey())) {
						return refundTypeEnum;
					}
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum RefundTagetEnum {
		REFUNDTOHANDSEL((short) 1, "退款至彩金"), REFUNDTO80BALANCE((short) 2, "退款至余额80%"), REFUNDTO20BALANCE((short) 3,
				"退款至余额20%"), REFUNDTOOLDPAYMENT((short) 4, "原支付方式退回");
		private Short key;
		private String value;

		RefundTagetEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.RefundTagetEnum refundTagetEnum : CancellationConstants.RefundTagetEnum.values()) {
					if (key.equals(refundTagetEnum.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取值
		public static CancellationConstants.RefundTagetEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.RefundTagetEnum refundTagetEnum : CancellationConstants.RefundTagetEnum.values()) {
					if (key.equals(refundTagetEnum.getKey())) {
						return refundTagetEnum;
					}
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum OrderAddIssueStatusEnum {
		ADDSUCCESS((short) 1, "追号成功"), ADDFAIL((short) 2, "追号失败"), CANCELLATIONSYSTEM((short) 3, "系统撤单"), CANCELLATIONUSER((short) 4,
				"用户撤单"), WAITINGADD((short) 5, "等待追号"), INCANCELLATION((short) 6,
						"撤单中"), INSTOPADDCANCELLATION((short) 7, "停追撤单中"), INUSERCANCELLATION((short) 8, "用户撤单中");
		private Short key;
		private String value;

		OrderAddIssueStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取值
		public static CancellationConstants.OrderAddIssueStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderAddIssueStatusEnum orderStatusEnum : CancellationConstants.OrderAddIssueStatusEnum
						.values()) {
					if (key.equals(orderStatusEnum.getKey())) {
						return orderStatusEnum;
					}
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum OrderAddStatusEnum {
		INADD((short) 1, "追号中"), WINNINGSTOPADD((short) 2, "中奖停追"), ADDEND((short) 3, "追号结束"), CANCELLATIONSYSTEM((short) 4,
				"用户撤单"), CANCELLATIONUSER((short) 5, "系统撤单");
		private Short key;
		private String value;

		OrderAddStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}

		// 根据key获取值
		public static CancellationConstants.OrderAddStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderAddStatusEnum addStatusEnum : CancellationConstants.OrderAddStatusEnum.values()) {
					if (key.equals(addStatusEnum.getKey())) {
						return addStatusEnum;
					}
				}
			}
			return null;
		}
	}

	public enum OrderStatusEnum {
		WAITINGUPLOAD((short) 1, "待上传"), PENDINGTICKET((short) 2, "待拆票"), BILLOFFARE((short) 3, "拆票中"), //
		TICKETPAYABLE((short) 4, "待出票"), DRAWNIN((short) 5, "出票中"), DRAWN((short) 6, "已出票"), //
		DRAWNERROR((short) 7, "出票失败"), CANCELLATIONOK((short) 8, "已撤单"), SPLITING_FAIL((short) 9, "拆票失败"), //
		INCANCELLATION((short) 10, "撤单中");
		private Short key;
		private String value;

		OrderStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderStatusEnum orderStatusEnum : CancellationConstants.OrderStatusEnum.values()) {
					if (key.equals(orderStatusEnum.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取值
		public static CancellationConstants.OrderStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderStatusEnum orderStatusEnum : CancellationConstants.OrderStatusEnum.values()) {
					if (key.equals(orderStatusEnum.getKey())) {
						return orderStatusEnum;
					}
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum OrderWinningStatusEnum {
		NOTDRAWLOTTERY((short) 1, "未开奖"), NOTWINNING((short) 2, "未中奖"), WINNING((short) 3, "已中奖"), ACCPETEDPEIZE((short) 4, "已派奖");
		private Short key;
		private String value;

		OrderWinningStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}

		// 根据key获取值
		public static CancellationConstants.OrderWinningStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (CancellationConstants.OrderWinningStatusEnum winningStatusEnum : CancellationConstants.OrderWinningStatusEnum
						.values()) {
					if (key.equals(winningStatusEnum.getKey())) {
						return winningStatusEnum;
					}
				}
			}
			return null;
		}
	}

	/**
	 * @desc 代购订单退款类型
	 * @author xiongJinGang
	 * @date 2017年8月3日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum OrderRefundTypeEnum {
		AGENT_REFUND((short) 1, "代购订单撤单"), // 代购订单撤单
		CHASE_REFUND((short) 2, "追号订单撤单");// 追号订单撤单
		private Short key;
		private String value;

		OrderRefundTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

}
