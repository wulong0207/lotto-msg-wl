package com.hhly.lottomsg.common.enums;

import java.util.Objects;

import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @desc 方案进度
 * @author yuanshangbing
 * @date 2017年5月27日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OrderFlowInfoEnum {

	/**
	 * @desc
	 * @date 2017年5月3日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum StatusEnum {
		SUBMIT_FLOW(1, "等待支付"), // 等待支付
		PAY_SUCCESS(2, "支付成功(等待出票)"), // 支付成功(等待出票)
		PAY_FAIL(3, "支付失败"), // 支付失败
		NO_PAY_OVERDUE(4, "未支付过期"), // 未支付过期
		IN_TICKET(5, "出票中"), // 出票中
		TICKET_FAIL(6, "出票失败"), // 出票失败
		CANCEL_ORDER(7, "已撤单"), // 已撤单
		TICKET_SUCCESS(8, "出票成功"), // 出票成功
		HAS_WINNING(9, "已中奖"), // 已中奖
		LOSING_LOTTERY(10, "未中奖"), // 未中奖
		HAD_SENT(11, "已派奖"), // 已派奖
		// IN_CHASE( 12, "追号中"), // 追号中
		AFTER_END(13, "追号结束"), // 追号结束
		WINNING_AFTER_STOP(14, "中奖追停"), // 中奖追停
		AFTER_NUMBER(15, "追号撤单"), // 追号撤单
		// PAYOUT_AWARD_SUCC( 16, "派奖成功"),// 派奖成功
		// PAYOUT_AWARD_FAIL( 17, "派奖不成功"),//派奖失败
		EXEC_ONE_SUCCESS(18, "执行一期追号成功后"), //
		EXEC_ONE_FAIL(19, "执行一期追号失败后"), //
		RECRUITMENT(20, "招募中"), //
		ABORTION_NOT_ENOUGH(21, "合买未满员流产"), ;//

		private Integer key;
		private String value;

		StatusEnum(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Integer key) {
			if (!ObjectUtil.isBlank(key)) {
				for (StatusEnum status : StatusEnum.values()) {
					if (key.equals(status.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		/**
		 * 获取OrderFlow状态枚举
		 * 
		 * @param status
		 * @return
		 */
		public static OrderFlowInfoEnum.StatusEnum getOrderFlowEnum(Integer status) {
			if (status == null) {
				return null;
			}
			for (OrderFlowInfoEnum.StatusEnum statusEnum : OrderFlowInfoEnum.StatusEnum.values()) {
				if (Objects.equals(statusEnum.getKey(), status)) {
					return statusEnum;
				}
			}
			return null;
		}

	}

}
