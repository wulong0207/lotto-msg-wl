package com.hhly.lottomsg.common.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.hhly.lottomsg.common.util.ObjectUtil;

/**
 * @desc 支付相关的常量
 * @author xiongjingang
 * @date 2017年3月1日 下午3:53:12
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayConstants {

	/************************************ 用户交易流水常量 *************************************/

	/**
	 * @desc 交易类型枚举
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:04:14
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TransTypeEnum {
		RECHARGE((short) 1, "充值"), // 充值
		LOTTERY((short) 2, "购彩"), // 购彩
		RETURN_AWARD((short) 3, "返奖"), // 返奖
		REFUND((short) 4, "退款"), // 退款
		DRAWING((short) 5, "提款"), // 提款
		OTHER((short) 6, "其它"), // 其它
		ACTIVITY_GIVE((short) 7, "活动赠送"), // 活动赠送
		ACTIVITY_CONSUME((short) 8, "活动消费"), // 活动消费
		DEDUCT((short) 9, "扣款"), // 扣款
		REBATE((short) 10, "返佣");// 返佣

		private Short key;
		private String value;

		TransTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TransTypeEnum transTypeEnum : TransTypeEnum.values()) {
					if (key.equals(transTypeEnum.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取值
		public static TransTypeEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TransTypeEnum transTypeEnum : TransTypeEnum.values()) {
					if (key.equals(transTypeEnum.getKey())) {
						return transTypeEnum;
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

	/**
	 * @desc 用户交易状态（2017-08-04 加了2、3、4几个状态，用于区分提款记录的）
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:09:17
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum UserTransStatusEnum {
		TRADE_FAIL((short) 0, "交易失败"), // 交易失败
		TRADE_SUCCESS((short) 1, "交易成功"), // 交易成功
		WAIT_AUDIT((short) 2, "待审核"), // 待审核
		AUDIT_SUCCESS((short) 3, "审核通过"), // 审核通过
		AUDIT_FAIL((short) 4, "审核不通过");// 审核不通过

		private Short key;
		private String value;

		UserTransStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取值
		public static UserTransStatusEnum getEnum(Short key) {
			for (UserTransStatusEnum transTypeEnum : UserTransStatusEnum.values()) {
				if (key.equals(transTypeEnum.getKey())) {
					return transTypeEnum;
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

	/**
	 * @desc 银行卡开通快捷支付
	 * @author xiongJinGang
	 * @date 2017年4月8日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BandCardQuickEnum {
		NOT_OPEN((short) 0, "未开通"), // 未开通快捷支付
		HAD_OPEN((short) 1, "已开通");// 已开通快捷支付
		private Short key;
		private String value;

		BandCardQuickEnum(Short key, String value) {
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

	/**
	 * @desc 用户交易时间类型（供查询切换）
	 * @author xiongjingang
	 * @date 2017年3月3日 下午12:35:52
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum UserTransTimeTypeEnum {
		CREATE_TIME((short) 1, "创建时间"), // 创建时间
		TRADE_TIME((short) 2, "交易时间");// 交易时间
		private Short key;
		private String value;

		UserTransTimeTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (UserTransTimeTypeEnum userTransMoneyFlowEnum : UserTransTimeTypeEnum.values()) {
					if (key.equals(userTransMoneyFlowEnum.getKey())) {
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

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	public enum MoneyFlowEnum {
		IN((short) 1, "收入"), // 出入
		OUT((short) 2, "支出");// 支出
		private Short key;
		private String value;

		MoneyFlowEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (MoneyFlowEnum moneyFlowEnum : MoneyFlowEnum.values()) {
					if (key.equals(moneyFlowEnum.getKey())) {
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

		public Short getKey() {
			return key;
		}

		public void setKey(Short key) {
			this.key = key;
		}
	}

	/**
	 * @desc 账户钱包拆分类型。80%，20%，80%>20%，奖金，可用红包，奖金>20%>80%
	 * @author xiongJinGang
	 * @date 2017年5月26日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum WalletSplitTypeEnum {
		EIGHTY_PERCENT((short) 1, "百分之80"), // 百分之80，只操作80%字段
		TWENTY_PERCENT((short) 2, "百分之20"), // 百分之20，只操作20%字段
		TWENTY_EIGHTY_PERCENT_RATE((short) 3, "先20%、后80%"), // 按比例操作20%、80%字段
		WINNING((short) 4, "中奖账户"), // 中奖，只操作中奖字段
		RED_COLOR((short) 5, "红包账户"), // 可用红包
		WINNING_TWENTY_EIGHTY((short) 6, "中奖账户、20%、80%"), // 奖金、百分之20、百分之80按顺序减
		WINNING_EIGHTY_TWENTY((short) 7, "中奖账户、80%、20%"), // 奖金、百分之80、百分之20按顺序减
		TWENTY_EIGHTY_WINNING((short) 8, "先20%、后80%、再中奖"); // 按比例操作20%、80%、中奖字段

		private Short key;
		private String value;

		WalletSplitTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (WalletSplitTypeEnum splitType : WalletSplitTypeEnum.values()) {
					if (key.equals(splitType.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		public static WalletSplitTypeEnum getEnum(Short type) {
			for (WalletSplitTypeEnum splitType : WalletSplitTypeEnum.values()) {
				if (type.equals(splitType.getKey())) {
					return splitType;
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

	// 用户交易资金流向
	public enum UserTransMoneyFlowEnum {
		RECHARGE((short) 1, "充值", MoneyFlowEnum.IN.getKey()), // 充值
		LOTTERY((short) 2, "购彩", MoneyFlowEnum.OUT.getKey()), // 购彩
		RETURN_AWARD((short) 3, "返奖", MoneyFlowEnum.IN.getKey()), // 返奖
		REFUND((short) 4, "退款", MoneyFlowEnum.IN.getKey()), // 退款
		DRAWING((short) 5, "提款", MoneyFlowEnum.OUT.getKey()), // 提款
		OTHER((short) 6, "其它", MoneyFlowEnum.OUT.getKey()), // 其它
		ACTIVITY_GIVE((short) 7, "活动赠送", MoneyFlowEnum.IN.getKey()), // 活动赠送
		ACTIVITY_CONSUME((short) 8, "活动消费", MoneyFlowEnum.OUT.getKey()), // 活动消费
		DEDUCT((short) 9, "扣款", MoneyFlowEnum.OUT.getKey()), // 扣款
		REBATE((short) 10, "还佣", MoneyFlowEnum.IN.getKey());// 还佣

		private Short key;
		private String value;
		private Short type;// 资金流向，1收入、2支出

		UserTransMoneyFlowEnum(Short key, String value, Short type) {
			this.key = key;
			this.value = value;
			this.type = type;
		}

		/**
		 * 方法说明: 根据资金流向获取具体交易类型
		 * 
		 * @param type
		 * @time: 2017年3月3日 下午12:23:27
		 * @return: Object[]
		 */
		public static Object[] getTransTypeByFlowType(Short type) {
			List<Short> transTypeList = new ArrayList<Short>();
			for (UserTransMoneyFlowEnum userTransMoneyFlowEnum : UserTransMoneyFlowEnum.values()) {
				if (type.equals(userTransMoneyFlowEnum.getType())) {
					transTypeList.add(userTransMoneyFlowEnum.key);
				}
			}
			Object[] Shorts = null;
			if (null != transTypeList && transTypeList.size() > 0) {
				Shorts = transTypeList.toArray();
			}
			return Shorts;
		}

		// 根据key获取值
		public static UserTransMoneyFlowEnum getTransTypeByKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (UserTransMoneyFlowEnum userTransMoneyFlowEnum : UserTransMoneyFlowEnum.values()) {
					if (key.equals(userTransMoneyFlowEnum.getKey())) {
						return userTransMoneyFlowEnum;
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

		public Short getType() {
			return type;
		}

		public void setType(Short type) {
			this.type = type;
		}

	}

	/************************************ 用户提款信息常量 *************************************/

	/**
	 * @desc 支付渠道枚举
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:21:39
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayChannelEnum {
		ALIPAY_RECHARGE((short) 1, "支付宝充值", "ALIPAY"), // 支付宝充值
		WECHAT_RECHARGE((short) 2, "微信支付", "WECHAT"), // 微信支付
		LIANLIAN_RECHARGE((short) 3, "连连支付", "LIANLIAN"), // 连连支付
		BAIDU_RECHARGE((short) 4, "百度支付", "BAIDU"), // 百度支付
		ARTIFICIAL_RECHARGE((short) 5, "人工充值", "PERSON"), // 人工充值
		YEEPAY_RECHARGE((short) 6, "易宝支付", "YEEPAY"), // 易宝支付
		AGENT_RECHARGE((short) 7, "代理系统充值", "AGENT"), // 代理系统充值
		JUHEPAY_RECHARGE((short) 8, "聚合支付", "JUHEPAY"), // 聚合支付
		NOWPAY_RECHARGE((short) 9, "现在支付", "NOWPAY"), // 现在支付
		DIVINEPAY_RECHARGE((short) 10, "神州支付", "DIVINEPAY"), // 神州支付
		PALMPAY_RECHARGE((short) 11, "掌宜付支付", "PALMPAY"), // 掌宜付支付
		SWIFTPASS_RECHARGE((short) 12, "一比分威富通支付", "SWIFTPASS"), // 威富通支付
		XINGYE_RECHARGE((short) 13, "兴业银行", "XINGYE"), // 兴业越秀分行
		HAODIANA_RECHARGE((short) 14, "好店啊支付", "HAODIANA"), // 好店啊支付
		PUFA_RECHARGE((short) 15, "浦发支付", "PUFA"), // 浦发支付
		WEIFUTONG_RECHARGE((short) 16, "威富通支付", "WEIFUTONG"), // 威富通支付（原生的）
		WEIFUTONGGD_RECHARGE((short) 17, "威富通光大支付", "WEIFUTONGGD"), // 威富通光大支付（原生的）
		WEIFUTONGZX1_RECHARGE((short) 18, "威富通中信1支付", "WEIFUTONGZX1"), // 威富通中信支付（原生的）
		WEIFUTONGZX2_RECHARGE((short) 19, "威富通中信2支付", "WEIFUTONGZX2"), // 威富通中信支付（原生的）
		HUICHAO_RECHARGE((short) 20, "汇潮支付", "HUICHAO"), // 汇潮支付
		HUAYI_RECHARGE((short) 21, "华移支付", "HUAYI"),// 华移支付
		HONGYUE_RECHARGE((short) 22, "鸿粤支付", "HONGYUE");// 鸿粤支付

		private Short key;
		private String value;
		private String type;

		PayChannelEnum(Short key, String value, String type) {
			this.key = key;
			this.value = value;
			this.type = type;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (PayChannelEnum payChannel : PayChannelEnum.values()) {
					if (key.equals(payChannel.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取枚举对象
		public static PayChannelEnum getByKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (PayChannelEnum payChannel : PayChannelEnum.values()) {
					if (key.equals(payChannel.getKey())) {
						return payChannel;
					}
				}
			}
			return null;
		}

		// 根据key获取枚举对象
		public static PayChannelEnum getByType(String type) {
			if (!ObjectUtil.isBlank(type)) {
				for (PayChannelEnum payChannel : PayChannelEnum.values()) {
					if (type.equals(payChannel.getType())) {
						return payChannel;
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

	/**
	 * @desc 提款、充值交易状态枚举
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:35:43
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TransStatusEnum {
		TRADE_UNDERWAY((short) 1, "进行中"), // 进行中
		TRADE_SUCCESS((short) 2, "交易成功"), // 交易成功
		TRADE_FAIL((short) 3, "交易失败"), // 交易失败
		TRADE_CLOSED((short) 4, "订单已关闭");// 订单已关闭

		private Short key;
		private String value;

		TransStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取枚举对象
		public static TransStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TransStatusEnum statusEnum : TransStatusEnum.values()) {
					if (key.equals(statusEnum.getKey())) {
						return statusEnum;
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

	/**
	 * @desc 提款平台枚举 1PC、2WAP、3ANDROID、4IOS、5未知、6H5
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:38:54
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TakenPlatformEnum {
		WEB((short) 1, "本站WEB", "WEB", "PC"), // 本站WEB
		WAP((short) 2, "本站WAP", "WAP", "WAP"), // 本站WAP
		ANDROID((short) 3, "Android客户端", "APP", "ANDROID"), // Android客户端
		IOS((short) 4, "IOS客户端", "APP", "IOS"), // IOS客户端
		UNKNOWN((short) 5, "未知", "", ""), // 未知
		AGENT((short) 6, "代理系统", "", ""), // 代理系统
		JSAPI((short) 7, "微信公众号", "JSAPI", "WECHAT");// 微信公众号支付

		private Short key;
		private String value;
		private String type;// 类型，支付选择平台用
		private String platForm;// 平台

		TakenPlatformEnum(Short key, String value, String type, String platForm) {
			this.key = key;
			this.value = value;
			this.type = type;
			this.platForm = platForm;
		}

		/**  
		* 方法说明: 获取所有的平台
		* @auth: xiongJinGang
		* @time: 2018年1月25日 下午3:36:36
		* @return: Map<Short,TakenPlatformEnum> 
		*/
		public static Map<Short, TakenPlatformEnum> getPlatform() {
			Map<Short, TakenPlatformEnum> map = new HashMap<Short, TakenPlatformEnum>();
			for (TakenPlatformEnum platform : TakenPlatformEnum.values()) {
				if (platform.getKey().equals(TakenPlatformEnum.UNKNOWN.getKey()) || platform.getKey().equals(TakenPlatformEnum.AGENT.getKey()) || platform.getKey().equals(TakenPlatformEnum.JSAPI.getKey())) {
					continue;
				}
				map.put(platform.getKey(), platform);
			}
			return map;
		}

		/** 根据key获取枚举对象 */
		public static TakenPlatformEnum getByKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TakenPlatformEnum platformEnum : TakenPlatformEnum.values()) {
					if (key.equals(platformEnum.getKey())) {
						return platformEnum;
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPlatForm() {
			return platForm;
		}

		public void setPlatForm(String platForm) {
			this.platForm = platForm;
		}
	}

	/**
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:38:54
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum JuhePlatformEnum {
		TRADE_QUERY("hhly.unified.trade.query"), // 交易查询
		WEIXIN_NATIVE("hhly.pay.weixin.native"), // 微信二维码扫码支付
		WEIXIN_WAP("hhly.pay.weixin.wap"), // 微信wap支付
		ALIPAY_NATIVE("hhly.pay.alipay.native"), // 支付宝二维码扫码支付
		TRADE_PAY("hhly.weixin.oa.trade.pay"), // 微信公众号支付
		QQ_PAY("hhly.pay.tenpay.native"), // QQ钱包支付
		JD_PAY("hhly.pay.jdpay.native"), // 京东支付
		JD_WAP("hhly.pay.jdpay.wap"), // 京东H5
		JD_APP("hhly.pay.jdpay.app");// 京东app

		private String value;

		JuhePlatformEnum(String value) {
			this.value = value;
		}

		/** 根据key获取枚举对象 */
		public static JuhePlatformEnum getByKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (JuhePlatformEnum platformEnum : JuhePlatformEnum.values()) {
					if (key.equals(platformEnum.getValue())) {
						return platformEnum;
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
	}

	/**
	 * @desc 兴业支付类型
	 * @author xiongJinGang
	 * @date 2017年10月12日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum XingYeTradeTypeEnum {
		QQ_SCANCODE("pay.tenpay.native"), // QQ二维码扫码支付
		QQ_SCANCODE2("pay.qq.jspay"), // QQ扫码后通知返回的是这个
		QQ_WAP("pay.tenpay.wappay"), // QQ Wap支付
		WX_APP("unified.trade.pay"), // 微信APP支付
		WX_WAP("pay.weixin.wappay"), // 微信wap支付
		WX_WAP2("pay.tenpay.wappay"), // 微信wap支付
		WX_JSAPI("pay.weixin.jspay"), // 微信公众号支付
		WX_SCANCODE("pay.weixin.native"), // 微信扫码支付
		ALIPAY_SCANCODE("pay.alipay.native"), // 支付宝二维码扫码支付
		ALIPAY_WAP("pay.alipay.jspay"), // 支付宝wap支付
		TRADE_QUERY("unified.trade.query"), // 交易查询
		REFUND("unified.trade.refund"), // 退款
		REFUND_QUERY("unified.trade.refundquery");// 退款查询

		private String value;

		XingYeTradeTypeEnum(String value) {
			this.value = value;
		}

		/** 根据key获取枚举对象 */
		public static XingYeTradeTypeEnum getEnum(String value) {
			if (!ObjectUtil.isBlank(value)) {
				for (XingYeTradeTypeEnum platformEnum : XingYeTradeTypeEnum.values()) {
					if (value.equals(platformEnum.getValue())) {
						return platformEnum;
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
	}

	/**
	 * @desc 客户端
	 * @author xiongJinGang
	 * @date 2017年7月10日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum ClientTypeEnum {
		PC("p", "PC"), // PC
		IOS("i", "IOS"), // IOS
		ANDROID("a", "ANDROID"), // ANDROID
		HIVE("h", "H5");// H5

		private String key;
		private String value;

		ClientTypeEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 提款状态 1审核通过; 2审核不通过; 3银行处理成功; 4银行处理失败; 5已到帐;6待审核;7银行处理中
	 * @author xiongJinGang
	 * @date 2017年4月21日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TakenStatusEnum {
		AUDIT_THROUGH((short) 1, "审核通过"), // 审核通过
		AUDIT_NOT_APPROVED((short) 2, "审核不通过"), // 审核不通过
		BANK_HANDLING_SUCCESS((short) 3, "银行处理成功"), // 银行处理成功
		BANK_HANDLING_FAIL((short) 4, "银行处理失败"), // 银行处理失败
		ARRIVAL_ACCOUNT((short) 5, "已到账"), // 已到账
		PENDING_AUDIT((short) 6, "待审核"), // 待审核
		BANK_PROCESSING((short) 7, "银行处理中");// 银行处理中

		private Short key;
		private String value;

		TakenStatusEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		/** 根据key获取枚举对象 */
		public static TakenStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TakenStatusEnum takenStatusEnum : TakenStatusEnum.values()) {
					if (key.equals(takenStatusEnum.getKey())) {
						return takenStatusEnum;
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

	/**
	 * @desc 提款批次状态枚举
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:42:54
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TakenBatchStatusEnum {
		OPERATE_FAIL((short) 0, "处理失败"), // 处理失败
		OPERATE_SUCCESS((short) 1, "处理成功");// 处理成功

		private Short key;
		private String value;

		TakenBatchStatusEnum(Short key, String value) {
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

	/**
	 * @desc 银行卡类型枚举
	 * @author xiongjingang
	 * @date 2017年3月1日 下午4:47:52
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BankCardTypeEnum {
		BANK_CARD((short) 1, "储蓄卡"), // 储蓄卡
		CREDIT((short) 2, "信用卡"), // 信用卡
		OTHER((short) 3, "其它");// 信用卡

		private Short key;
		private String value;

		BankCardTypeEnum(Short key, String value) {
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

	/**
	 * @desc 红包来源
	 * @author xiongJinGang
	 * @date 2017年7月18日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RedSourceEnum {
		ACTIVITY((short) 1, "活动"), // 活动
		VOUCHER((short) 2, "券"), // 券
		BACK_ORDER((short) 3, "撤单生成");// 撤单生成

		private Short key;
		private String value;

		RedSourceEnum(Short key, String value) {
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

	/**
	 * @desc 支付方式
	 * @author xiongjingang
	 * @date 2017年3月14日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayTypeEnum {
		BANK_PAYMENT((short) 1, "网银支付", "BANK"), // 网银支付
		QUICK_PAYMENT((short) 2, "快捷支付", "QUICK"), // 快捷支付
		THIRD_PAYMENT((short) 3, "第三方支付", "THIRD"), // 第三方支付
		ALIPAY_PAYMENT((short) 4, "支付宝", "THIRD"), // 支付宝
		WECHART_PAYMENT((short) 5, "微信", "THIRD"), // 微信
		QQ_PAYMENT((short) 6, "QQ", "THIRD"), // QQ
		CARD_PAYMENT((short) 7, "充值卡", "THIRD"), // 充值卡
		HAND_PAYMENT((short) 8, "人工充值", "THIRD"), // 人工充值
		AGENT_PAYMENT((short) 9, "代理充值", "THIRD"), // 代理充值
		JD_PAYMENT((short) 10, "京东", "THIRD"); // 京东支付

		private Short key;
		private String value;
		private String typeName;

		PayTypeEnum(Short key, String value, String typeName) {
			this.key = key;
			this.value = value;
			this.typeName = typeName;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (PayTypeEnum payType : PayTypeEnum.values()) {
					if (key.equals(payType.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		public static PayTypeEnum getEnum(Short key) {
			for (PayTypeEnum payType : PayTypeEnum.values()) {
				if (key.equals(payType.getKey())) {
					return payType;
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

		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}
	}

	// 支付方式 1:网银支付(借记卡) 2:快捷支付(借记卡) 3:快捷支付(信用卡)8:网银支付(信用卡)9:B2B企业网银支付 10：支付宝 11：微信支付 12：QQ钱包支付 13：充值卡支付 14：京东支付
	public enum PayTypeThirdEnum {
		BANK_DEBIT_CARD_PAYMENT("1", "借记卡网银支付"), // 借记卡网银支付
		QUICK_DEBIT_CARD_PAYMENT("2", "借记卡快捷支付"), // 借记卡快捷支付
		QUICK_CREDIT_CARD_PAYMENT("3", "信用卡快捷支付"), // 信用卡快捷支付
		BANK_CREDIT_CARD_PAYMENT("8", "信用卡网银支付"), // 信用卡网银支付
		B2B_CARD_PAYMENT("9", "B2B企业网银支付"), // B2B企业网银支付
		ALIPAY_PAYMENT("10", "支付宝支付"), // 易宝支付，区分支付宝还是快捷
		WEIXIN_PAYMENT("11", "微信支付"), // 易宝支付，区分微信还是快捷
		QQ_PAYMENT("12", "QQ钱包支付"), // QQ钱包支付
		RECHARGE_CARD_PAYMENT("13", "充值卡支付"), // 充值卡支付
		JD_PAYMENT("14", "京东支付");// 京东支付

		private String key;
		private String value;

		PayTypeThirdEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public static PayTypeThirdEnum getEnum(String key) {
			for (PayTypeThirdEnum payTypeThird : PayTypeThirdEnum.values()) {
				if (key.equals(payTypeThird.getKey())) {
					return payTypeThird;
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

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 支付类型枚举，加一个支付渠道，都要在这里新加
	 * @author xiongjingang
	 * @date 2017年3月6日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum ChannelTypeEnum {
		LIANLIAN_WEB("lianlianWeb", "连连网银", "WEB", "com.hhly.paycore.paychannel.lianlianpay.web.LLPayBankService"), // 连连网银支付
		LIANLIAN_FAST("lianlianFast", "连连网银", "FAST", "com.hhly.paycore.paychannel.lianlianpay.web.LLPayFastService"), // 连连快捷支付
		LIANLIAN_WAP("lianlianWap", "连连网银", "WAP", "com.hhly.paycore.paychannel.lianlianpay.web.LLPayWapService"), // 连连WAP
		LIANLIAN_APP("lianlianApp", "连连网银", "APP", "com.hhly.paycore.paychannel.lianlianpay.web.LLPayAppService"), // 连连APP

		ALIPAY_WEB("aliWeb", "支付宝", "WEB", "com.hhly.paycore.paychannel.alipay.web.AlipayWebService"), // 支付宝WEB
		ALIPAY_APP("aliApp", "支付宝", "APP", "com.hhly.paycore.paychannel.alipay.wap.AlipayWapService"), // 支付宝APP
		ALIPAY_WAP("aliWap", "支付宝", "WAP", "com.hhly.paycore.paychannel.alipay.wap.AlipayWapService"), // 支付宝WAP

		WECHAT_WEB("wechatWeb", "微信", "NATIVE", "com.hhly.paycore.paychannel.wechatpay.web.WeChatWebPayService"), // 微信WEB
		WECHAT_APP("wechatApp", "微信", "APP", "com.hhly.paycore.paychannel.wechatpay.wap.WeChatAppPayService"), // 微信APP
		WECHAT_WAP("wechatWap", "微信", "WAP", "com.hhly.paycore.paychannel.wechatpay.wap.WeChatAppPayService"), // 微信WAP
		WECHAT_JSAPI("wechatJs", "微信", "JSAPI", "com.hhly.paycore.paychannel.wechatpay.wap.WeChatPayJsapiService"), // 微信公众号

		YEEPAY_FAST("yeeFast", "易宝", "FAST", "com.hhly.paycore.paychannel.yeepay.web.YeepayFastService"), // 易宝WEB（支持快捷、扫码、支付宝微信支付）
		YEEPAY_WEB("yeeWeb", "易宝", "WEB", "com.hhly.paycore.paychannel.yeepay.web.YeepayWebService"), // 易宝网银支付（只有PC端的网银支付，不包括快捷支付）

		JUHEPAY_WEB("juheWeb", "聚合", "WEB", "com.hhly.paycore.paychannel.juhepay.web.JuhePayWebService"), // 聚合WEB(支持扫码)
		JUHEPAY_WAP("juheWap", "聚合", "WAP", "com.hhly.paycore.paychannel.juhepay.web.JuhePayWapService"), // 聚合WAP
		JUHEPAY_APP("juheApp", "聚合", "APP", "com.hhly.paycore.paychannel.juhepay.web.JuhePayAppService"), // 聚合App

		NOWPAY_APP("nowApp", "现在", "APP", "com.hhly.paycore.paychannel.nowpay.app.NowAppPayService"), // 现在支付app
		NOWPAY_WAP("nowWap", "现在", "WAP", "com.hhly.paycore.paychannel.nowpay.wap.NowWapPayService"), // 现在支付WAP

		DIVINEPAY_WAP("divineWap", "神州", "WAP", "com.hhly.paycore.paychannel.shenzhoupay.wap.DivineWapPayService"), // 神州支付wap
		DIVINEPAY_APP("divineApp", "神州", "APP", "com.hhly.paycore.paychannel.shenzhoupay.app.DivineAppPayService"), // 神州支付app
		DIVINEPAY_CARDWEB("divineCardWeb", "神州", "WEB", "com.hhly.paycore.paychannel.shenzhoupay.web.SZCardWebService"), // 神州充值卡web支付
		DIVINEPAY_CARDWAP("divineCardWap", "神州", "WEB", "com.hhly.paycore.paychannel.shenzhoupay.wap.SZCardWapService"), // 神州充值卡web支付

		PALMPAY_WAP("palmWap", "掌宜付", "WAP", "com.hhly.paycore.paychannel.palmpay.web.PalmPayWapService"), // 掌宜付wap
		PALMPAY_WEB("palmWeb", "掌宜付", "WAP", "com.hhly.paycore.paychannel.palmpay.web.PalmPayWebService"), // 掌宜付web

		SWIFTPASS_WAP("swiftpssWap", "一比分威富通", "WAP", "com.hhly.paycore.paychannel.swiftpass.web.SwiftpassWapService"), // 一比分威富通wap

		WEIFUTONG_WEB("weifutongWeb", "威富通兴业", "WEB", "com.hhly.paycore.paychannel.weifutong.xingye.web.WeifutongWebService"), // 原生威富通兴业web
		WEIFUTONG_WAP("weifutongWap", "威富通兴业", "WAP", "com.hhly.paycore.paychannel.weifutong.xingye.web.WeifutongWapService"), // 原生威富通兴业wap
		WEIFUTONG_APP("weifutongApp", "威富通兴业", "APP", "com.hhly.paycore.paychannel.weifutong.xingye.web.WeifutongAppService"), // 原生威富通兴业app
		WEIFUTONG_JSAPI("weifutongJs", "威富通兴业", "JSAPI", "com.hhly.paycore.paychannel.weifutong.xingye.web.WeifutongJsapiService"), // 原生威富通微信公众号

		WEIFUTONGGD_WEB("weifutonggdWeb", "威富通光大", "WEB", "com.hhly.paycore.paychannel.weifutong.guangda.web.WeifutongWebService"), // 原生威富通光大web
		WEIFUTONGGD_WAP("weifutonggdWap", "威富通光大", "WAP", "com.hhly.paycore.paychannel.weifutong.guangda.web.WeifutongWapService"), // 原生威富通光大wap
		WEIFUTONGGD_APP("weifutonggdApp", "威富通光大", "APP", "com.hhly.paycore.paychannel.weifutong.guangda.web.WeifutongAppService"), // 原生威富通光大app
		WEIFUTONGGD_JSAPI("weifutonggdJs", "威富通光大", "JSAPI", "com.hhly.paycore.paychannel.weifutong.guangda.web.WeifutongJsapiService"), // 原生威富通光大微信公众号

		WEIFUTONGZX1_WEB("weifutongzx1Web", "威富通中信", "WEB", "com.hhly.paycore.paychannel.weifutong.zxsz1.web.WeifutongWebService"), // 原生威富通中信1web
		WEIFUTONGZX1_WAP("weifutongzx1Wap", "威富通中信", "WAP", "com.hhly.paycore.paychannel.weifutong.zxsz1.web.WeifutongWapService"), // 原生威富通中信1wap
		WEIFUTONGZX1_APP("weifutongzx1App", "威富通中信", "APP", "com.hhly.paycore.paychannel.weifutong.zxsz1.web.WeifutongAppService"), // 原生威富通中信1app
		WEIFUTONGZX1_JSAPI("weifutongzx1Js", "威富通中信", "JSAPI", "com.hhly.paycore.paychannel.weifutong.zxsz1.web.WeifutongJsapiService"), // 原生威富通中信1微信公众号

		WEIFUTONGZX2_WEB("weifutongzx2Web", "威富通中信", "WEB", "com.hhly.paycore.paychannel.weifutong.zxsz2.web.WeifutongWebService"), // 原生威富通中信2web
		WEIFUTONGZX2_WAP("weifutongzx2Wap", "威富通中信", "WAP", "com.hhly.paycore.paychannel.weifutong.zxsz2.web.WeifutongWapService"), // 原生威富通中信2wap
		WEIFUTONGZX2_APP("weifutongzx2App", "威富通中信", "APP", "com.hhly.paycore.paychannel.weifutong.zxsz2.web.WeifutongAppService"), // 原生威富通中信2app
		WEIFUTONGZX2_JSAPI("weifutongzx2Js", "威富通中信", "JSAPI", "com.hhly.paycore.paychannel.weifutong.zxsz2.web.WeifutongJsapiService"), // 原生威富通中信2微信公众号

		XINGYE_WAP("xingyeWap", "兴业", "WAP", "com.hhly.paycore.paychannel.xingye.web.XingYeWapService"), // 兴业Wap支付
		XINGYE_WEB("xingyeWeb", "兴业", "WEB", "com.hhly.paycore.paychannel.xingye.web.XingYeWebService"), // 兴业web支付

		HAODIANA_WAP("haodianaWap", "好店啊", "WAP", "com.hhly.paycore.paychannel.hdapay.web.HaoDianAWapService"), // 好店啊wap支付
		HAODIANA_WEB("haodianaWeb", "好店啊", "WEB", "com.hhly.paycore.paychannel.hdapay.web.HaoDianAWebService"), // 好店啊web支付

		PUFA_WAP("pufaWap", "浦发", "WAP", "com.hhly.paycore.paychannel.pufa.web.PuFaWapService"), // 浦发银行WAP
		PUFA_APP("pufaApp", "浦发", "APP", "com.hhly.paycore.paychannel.pufa.web.PuFaAppService"), // 浦发银行APP

		HUICHAO_WEB("huichaoWeb", "汇潮", "WEB", "com.hhly.paycore.paychannel.huichao.web.HuiChaoWebService"), // 汇潮支付

		HUAYI_WEB("huayiWeb", "华移", "WEB", "com.hhly.paycore.paychannel.huayi.web.HuayiWebService"), // 华移PC支付
		HUAYI_WAP("huayiWap", "华移", "WAP", "com.hhly.paycore.paychannel.huayi.web.HuayiWapService"), // 华移Wap支付
		HUAYI_JSAPI("huayiJs", "华移", "JSAPI", "com.hhly.paycore.paychannel.huayi.web.HuayiJsapiService"),// 华移jsapi支付

		HONGYUE_WEB("hongyueWeb", "鸿粤", "WEB", "com.hhly.paycore.paychannel.hongyuepay.web.HongYueWebService"); // 鸿粤PC支付

		private String channel; // 渠道
		private String channelName; // 渠道名称
		private String type; // 类型
		private String clazz; // 类全限定名

		ChannelTypeEnum(String channel, String channelName, String type, String clazz) {
			this.channel = channel;
			this.channelName = channelName;
			this.type = type;
			this.clazz = clazz;
		}

		public static ChannelTypeEnum getEnum(String channel) {
			for (ChannelTypeEnum channelType : ChannelTypeEnum.values()) {
				if (channel.equals(channelType.getChannel())) {
					return channelType;
				}
			}
			return null;
		}

		public static ChannelTypeEnum from(String name) {
			if (StringUtils.isBlank(name)) {
				throw new IllegalArgumentException("ChannelType name can not be empty.");
			}
			return Enum.valueOf(ChannelTypeEnum.class, name);
		}

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getChannelName() {
			return channelName;
		}

		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getClazz() {
			return clazz;
		}

		public void setClazz(String clazz) {
			this.clazz = clazz;
		}
	}

	/**
	 * @desc 订单的支付状态
	 * 1等待支付；2支付成功；3未支付过期；4支付失败；5用户取消
	 * @author xiongjingang
	 * @date 2017年3月16日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayStatusEnum {
		/**等待支付**/
		WAITTING_PAYMENT((short) 1, "等待支付"), // 等待支付
		/**支付成功**/
		PAYMENT_SUCCESS((short) 2, "支付成功"), // 支付成功
		/**未支付过期**/
		OVERDUE_PAYMENT((short) 3, "未支付过期"), // 未支付过期
		/**支付失败**/
		PAYMENT_FAILURE((short) 4, "支付失败"), // 支付失败
		/**用户取消**/
		USER_CANCELLED_PAYMENT((short) 5, "用户取消"), // 用户取消
		/**退款**/
		REFUND((short) 6, "退款"), // 退款
		/**支付中**/
		BEING_PAID((short) 7, "支付中");// 支付中

		private Short key;
		private String value;

		PayStatusEnum(Short key, String value) {
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
		public static PayConstants.PayStatusEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (PayConstants.PayStatusEnum payStatusEnum : PayConstants.PayStatusEnum.values()) {
					if (key.equals(payStatusEnum.getKey())) {
						return payStatusEnum;
					}
				}
			}
			return null;
		}
	}

	/**
	 * @desc 第三方接口退款返回状态
	 * @author xiongJinGang
	 * @date 2017年5月6日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RefundStatusEnum {
		REFUND_PROCESSING((short) 1, "退款处理中"), // 退款处理中
		REFUND_SUCCESS((short) 2, "退款成功"), // 退款成功
		REFUND_FAIL((short) 3, "退款失败"), // 退款失败
		REFUND_COLSED((short) 4, "退款关闭"), // 未支付过期
		REFUND_NOTSURE((short) 5, "未确定"), // 需要商户用原退款单号重新发起退款申请
		REFUND_CHANGE((short) 6, "退款异常"); // 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，商户可以发起异常退款处理的申请，可以退款到用户的新卡或者退款商户，商户自行处理

		private Short key;
		private String value;

		RefundStatusEnum(Short key, String value) {
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

	/**
	 * @desc 红包类型，1：充值红包；2：满减红包；3：彩金红包；4：加奖红包；5：大礼包；6：随机红包
	 * @author xiongJinGang
	 * @date 2017年3月27日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RedTypeEnum {
		RECHARGE_DISCOUNT((short) 1, "充值红包", "recharge"), // 充值红包
		CONSUMPTION_DISCOUNT((short) 2, "满减红包", "pay"), // 满减红包
		RED_COLOR((short) 3, "彩金红包", "pay"), // 彩金红包
		BONUS_RED((short) 4, "加奖红包", "pay"), // 加奖红包
		BIG_PACKAGE((short) 5, "大礼包", "pay"), // 大礼包
		RANDOM_RED((short) 6, "随机红包", "pay");// 随机红包

		private Short key;
		private String value;
		private String useType;// 使用类型

		RedTypeEnum(Short key, String value, String useType) {
			this.key = key;
			this.value = value;
			this.useType = useType;
		}

		public static RedTypeEnum getEnum(Short type) {
			for (RedTypeEnum redTypeEnum : RedTypeEnum.values()) {
				if (type.equals(redTypeEnum.getKey())) {
					return redTypeEnum;
				}
			}
			return null;
		}

		// 根据使用类型，获取红包类型
		public static Object[] getRedByUseType(String useType) {
			List<Short> redTypeList = new ArrayList<Short>();
			for (RedTypeEnum redTypeEnum : RedTypeEnum.values()) {
				if (useType.equals(redTypeEnum.getUseType())) {
					redTypeList.add(redTypeEnum.getKey());
				}
			}
			Object[] redTypes = null;
			if (!ObjectUtil.isBlank(redTypeList)) {
				redTypes = redTypeList.toArray();
			}
			return redTypes;
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

		public String getUseType() {
			return useType;
		}

		public void setUseType(String useType) {
			this.useType = useType;
		}

	}

	/**
	 * @desc 红包状态 1：待激活；2：待派发；3：可使用；4：已过期；5：已作废；6：已使用
	 * @author xiongJinGang
	 * @date 2017年3月27日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RedStatusEnum {
		WAITTING_ACTIVATION("1", "待激活"), // 待激活
		WAITTING_DISTRIBUTE("2", "待派发"), // 待派发
		NORMAL("3", "可使用"), // 可使用
		EXPIRED("4", "已过期"), // 已过期
		INVALID("5", "已作废"), // 已作废
		ALREADY_USE("6", "已使用 ");// 已使用

		private String key;
		private String value;

		RedStatusEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取值
		public static RedStatusEnum getEnumByKey(String key) {
			if (!ObjectUtil.isBlank(key)) {
				for (RedStatusEnum redStatusEnum : RedStatusEnum.values()) {
					if (key.equals(redStatusEnum.getKey())) {
						return redStatusEnum;
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

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 支付请求生成表单结果 1 form表单内容、2二维码链接、3不需要调用第三方支付（用的余额或者彩金支付）
	 * @author xiongJinGang
	 * @date 2017年3月31日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayReqResultEnum {
		/**form表单**/
		FORM((short) 1, "form表单"), // form表单
		/**二维码链接**/
		LINK((short) 2, "二维码链接"), // 二维码链接
		/**用的余额或者彩金支付**/
		SHOW((short) 3, "用的余额或者彩金支付"), // 不需要调用第三方支付（用的余额或者彩金支付）
		/**支付的URL**/
		URL((short) 4, "支付的URL"), // 直接跳转的URL
		/**请求参数进行MD5密钥加密**/
		ENCRYPTION((short) 5, "密钥加密请求参数");// 针对App

		private Short key;
		private String value;

		PayReqResultEnum(Short key, String value) {
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

	/**
	 * @desc 红包类别 1：实体；2：虚拟
	 * @author xiongJinGang
	 * @date 2017年4月11日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RedCategoryEnum {
		ENTITY((short) 1, "实体"), // 实体
		VIRTUAL((short) 2, "虚拟"); // 虚体

		private Short key;
		private String value;

		RedCategoryEnum(Short key, String value) {
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

	/**
	 * @desc 是否绑定快捷支付 0：否，1：是
	 * @author xiongJinGang
	 * @date 2017年4月12日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BindFlagEnum {
		FALSE((short) 0, "否"), // 未绑定
		TRUE((short) 1, "是"); // 绑定

		private Short key;
		private String value;

		BindFlagEnum(Short key, String value) {
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

	/**
	 * @desc 银行状态:0停用,1可用
	 * @author xiongJinGang
	 * @date 2017年4月8日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BankStatusEnum {
		DISABLE((short) 0, "停用"), // 停用
		OPEN((short) 1, "可用"), // 可用
		EXPIRED((short) 2, "过期"); // 过期

		private Short key;
		private String value;

		BankStatusEnum(Short key, String value) {
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

	/**
	 * @desc 账户中，中奖金额的状态
	 * @author xiongJinGang
	 * @date 2017年6月23日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum WinStatusEnum {
		DISABLE((short) 0, "停用"), // 停用
		OPEN((short) 1, "可用"); // 可用

		private Short key;
		private String value;

		WinStatusEnum(Short key, String value) {
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

	/**
	 * @desc 支付类型:1 银行卡,2 第三方支付
	 * @author xiongJinGang
	 * @date 2017年4月8日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayBankPayTypeEnum {
		BANK_CARD((short) 1, "银行卡"), // 银行卡
		THIRD((short) 2, "第三方支付");// 第三方支付
		private Short key;
		private String value;

		PayBankPayTypeEnum(Short key, String value) {
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

	/**
	 * @desc 支付渠道的支付类型
	 * @author xiongJinGang
	 * @date 2017年4月10日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayChannelCardTypeEnum {
		BANK_CARD((short) 1, "银行卡"), // 银行卡
		CREDIT((short) 2, "信用卡"), // 信用卡
		THIRD((short) 3, "第三方支付");// 第三方支付

		private Short key;
		private String value;

		PayChannelCardTypeEnum(Short key, String value) {
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

	/**
	 * @desc 是默认卡 0：否，1：是
	 * @author xiongJinGang
	 * @date 2017年4月18日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum IsDefaultEnum {
		FALSE(0, "否"), // 不是默认
		TRUE(1, "是");// 是默认

		private Integer key;
		private String value;

		IsDefaultEnum(Integer key, String value) {
			this.key = key;
			this.value = value;
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
	}

	/**
	 * @desc 提款验证方式 1、身份证号码 2、银行卡号码 3、手机号码 4、邮箱
	 * @author xiongJinGang
	 * @date 2017年4月18日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TakenValidateTypeEnum {
		IDCARD((short) 1, "身份证号码"), // 身份证号码
		BANKCARD((short) 2, "银行卡号码"), // 银行卡号码
		MOBILE((short) 3, "手机号码"), // 手机号码
		EMAIL((short) 4, "邮箱");// 邮箱

		private Short key;
		private String value;

		TakenValidateTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 根据key获取值
		public static TakenValidateTypeEnum getEnumByKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TakenValidateTypeEnum takenValidateTypeEnum : TakenValidateTypeEnum.values()) {
					if (key.equals(takenValidateTypeEnum.getKey())) {
						return takenValidateTypeEnum;
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

	/**
	 * @desc 申请提款时，提款金额的状态（正常提款、异常提款）
	 * @author xiongJinGang
	 * @date 2017年4月19日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum TakenAmountStatusEnum {
		NORMAL((short) 1, "正常"), // 正常
		EXCEPTION((short) 2, "原路返回"), // 原路返回
		NOT_ALLOW((short) 3, "不能提");// 不能提
		private Short key;
		private String value;

		TakenAmountStatusEnum(Short key, String value) {
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

	/**
	 * @desc 订单购买类型：0:全部； 1：代购；2：追号代购；3：合买；4：追号计划
	 * @author xiongJinGang
	 * @date 2017年4月25日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BuyTypeEnum {
		PURCHASING(1, "代购"), // 代购
		CHASE_NUMBER(2, "追号"), // 追号
		JOINT_PURCHASE(3, "合买"), // 合买
		TRACKING_PLAN(4, "追号计划");// 追号计划

		private Integer key;
		private String value;

		BuyTypeEnum(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Integer key) {
			if (!ObjectUtil.isBlank(key)) {
				for (BuyTypeEnum buyType : BuyTypeEnum.values()) {
					if (key.equals(buyType.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		public static BuyTypeEnum getEnum(Integer key) {
			for (BuyTypeEnum buyType : BuyTypeEnum.values()) {
				if (key.equals(buyType.getKey())) {
					return buyType;
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

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}
	}

	/**
	 * @desc 是否批量支付
	 * @author xiongJinGang
	 * @date 2017年5月10日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BatchPayEnum {
		SINGLE(0, "单个支付"), // 单个支付
		BATCH(1, "批量支付"), // 批量支付
		PUSH(2, "推单支付"); // 推单支付

		private Integer key;
		private String value;

		BatchPayEnum(Integer key, String value) {
			this.key = key;
			this.value = value;
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
	}

	/**
	 * @desc 银行类型
	 * @author xiongJinGang
	 * @date 2017年5月12日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayBankCodeEnum {
		WECHAT("WECHAT", "微信"), // 单个支付
		ALIPAY("ALIPAY", "支付宝"), //
		QQ("QQ", "QQ钱包"), // QQ钱包
		JD("JD", "京东支付"), // 京东支付
		CARD("CARD", "充值卡"), // 充值卡
		PBC("PBC", "中国人民银行"), //
		CCB("CCB", "中国建设银行"), //
		ABC("ABC ", "中国农业银行"), //
		ICBC("PBC", "中国工商银行"), //
		BOC("BOC", "中国银行"), //
		CMBC("CMBC", "中国民生银行"), //
		CMB("CMB", "招商银行"), //
		CIB("CIB ", "兴业银行"), //
		BCM("BCM", "交通银行"), //
		CEB("CEB", "中国光大银行"), //
		GDB("GDB", "广东发展银行"); // 批量支付

		private String key;
		private String value;

		public static PayBankCodeEnum getEnum(String key) {
			for (PayBankCodeEnum payBankCode : PayBankCodeEnum.values()) {
				if (key.equals(payBankCode.getKey())) {
					return payBankCode;
				}
			}
			return null;
		}

		private PayBankCodeEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 浏览器类型  1微信、2支付宝、3QQ。
	 * @author xiongJinGang
	 * @date 2018年2月28日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum BrowerTypeEnum {
		WECHAT("1", "微信"), // 单个支付
		ALIPAY("2", "支付宝"), //
		QQ("3", "QQ钱包"); // QQ钱包

		private String key;
		private String value;

		public static BrowerTypeEnum getEnum(String key) {
			for (BrowerTypeEnum payBankCode : BrowerTypeEnum.values()) {
				if (key.equals(payBankCode.getKey())) {
					return payBankCode;
				}
			}
			return null;
		}

		private BrowerTypeEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 订单支付结果
	 * @author xiongJinGang
	 * @date 2017年6月5日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PayResultEnum {
		SUCCESS("success", "支付成功"), //
		FAIL("fail", "支付失败"), //
		BALANCE_SUCCESS("balanceSuccess", "余额支付成功"); //

		private String key;
		private String value;

		private PayResultEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 渠道类型：2、本站PC；4、本站android；5、本站IOS；6、本站WAP；7、未知渠道;其它市场渠道没有列出
	 * @author xiongJinGang
	 * @date 2017年7月4日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum ChannelEnum {
		PC("2", "本站PC"), // 本站PC
		ANDROID("4", "本站android"), // 本站android
		IOS("5", "本站IOS"), // 本站IOS
		WAP("6", "本站WAP"), // 本站WAP
		AGENT("33", "代理系统"), // 本站WAP
		UNKNOWN("7", "未知渠道");// 未知渠道

		private String key;
		private String value;

		private ChannelEnum(String key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(String key) {
			if (!ObjectUtil.isBlank(key)) {
				for (ChannelEnum channelEnum : ChannelEnum.values()) {
					if (key.equals(channelEnum.getKey())) {
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

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/**
	 * @desc 订单支付结果
	 * @author xiongJinGang
	 * @date 2017年6月5日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum CmsRechargeTypeEnum {
		CASH((short) 1, "现金"), // 现金
		RED((short) 2, "红包"); // 红包

		private Short key;
		private String value;

		private CmsRechargeTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public static CmsRechargeTypeEnum getEnum(Short key) {
			for (CmsRechargeTypeEnum type : CmsRechargeTypeEnum.values()) {
				if (key.equals(type.getKey())) {
					return type;
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

	// 1审核、2提交银行、3银行处理结果
	public enum TakenOperateTypeEnum {
		AUDIT((short) 1, "审核"), // 审核，审核通过、审核不过
		SUBMIT((short) 2, "提交银行"), // 提交银行，银行处理中（暂时不需要这个方法）
		BANK_COMPLETE((short) 3, "银行完成"), // 银行处理完成，银行处理成功、银行处理失败
		CMS_COMPLETE((short) 4, "cms完成"), // cms完成，已到账
		SUCCESS_TO_FAIL((short) 5, "cms完成，银行处理成功改成银行处理失败");// cms完成，银行处理成功改成银行处理失败

		private Short key;
		private String value;

		private TakenOperateTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public static TakenOperateTypeEnum getEnum(Short key) {
			for (TakenOperateTypeEnum type : TakenOperateTypeEnum.values()) {
				if (key.equals(type.getKey())) {
					return type;
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

	/**
	 * @desc 支付、充值时，是否切换银行卡类型（网银切快捷、快捷切网银）
	 * @author xiongJinGang
	 * @date 2017年7月24日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum ChangeEnum {
		NO((short) 0, "不切换"), // 不切换
		YES((short) 1, "切换"); // 切换

		private Short key;
		private String value;

		private ChangeEnum(Short key, String value) {
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

	/**
	 * @desc 活动校验类型
	 * @author xiongJinGang
	 * @date 2017年8月11日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum ActivityValidateTypeEnum {
		ORDER(1, "订单校验"), // 订单校验
		PAY(2, "支付校验"); // 支付校验

		private Integer key;
		private String value;

		private ActivityValidateTypeEnum(Integer key, String value) {
			this.key = key;
			this.value = value;
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
	}

	/**
	 * @desc 充值类型： 0充值、1即买即付
	 * @author xiongJinGang
	 * @date 2017年8月21日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RechargeTypeEnum {
		RECHARGE((short) 0, "充值"), // 充值
		PAY((short) 1, "支付"); // 即买即付

		private Short key;
		private String value;

		private RechargeTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		public static String getEnum(Short key) {
			for (RechargeTypeEnum type : RechargeTypeEnum.values()) {
				if (key.equals(type.getKey())) {
					return type.getValue();
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

	/**
	 * @desc  充值提款状态：0不可提、1可提 、2已提 
	 * @author xiongJinGang
	 * @date 2017年8月21日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum RechargeTakenStatusEnum {
		NOT_ALLOW((short) 0, "不可提"), // 不可提
		ALLOW((short) 1, "可提"), // 可提
		FINISHED((short) 2, "已提"); // 已提

		private Short key;
		private String value;

		private RechargeTakenStatusEnum(Short key, String value) {
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

	/**
	 * @desc app调起第三方支付方式
	 * @author xiongJinGang
	 * @date 2017年10月19日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum AppPayTypeEnum {
		H5((short) 0, "H5支付"), // H5支付
		SDK((short) 1, "SDK支付"); // SDK支付

		private Short key;
		private String value;

		private AppPayTypeEnum(Short key, String value) {
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

	/**
	 * @desc 交易流水的来源，直接充值和即买即付要用来合并展示
	 * @author xiongJinGang
	 * @date 2017年11月8日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum SourceTypeEnum {
		RECHARGE((short) 1, "直接充值"), // 直接充值
		LOTTERY((short) 2, "即买即付"), // 即买即付
		PERSON((short) 3, "人工充值"), // 人工充值
		AGENT((short) 4, "代理充值"); // 代理充值

		private Short key;
		private String value;

		SourceTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}

		// 判断key是否存在
		public static boolean containsKey(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TransTypeEnum transTypeEnum : TransTypeEnum.values()) {
					if (key.equals(transTypeEnum.getKey())) {
						return true;
					}
				}
			}
			return false;
		}

		// 根据key获取值
		public static TransTypeEnum getEnum(Short key) {
			if (!ObjectUtil.isBlank(key)) {
				for (TransTypeEnum transTypeEnum : TransTypeEnum.values()) {
					if (key.equals(transTypeEnum.getKey())) {
						return transTypeEnum;
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

	/**
	 * @desc 操作类型 1、CMS后台作废 ; 2、红包过期作废
	 * @author xiongJinGang
	 * @date 2018年3月10日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum OperateTypeEnum {
		CANCEL((short) 1, "CMS后台作废"), // CMS后台作废
		OVERDUE((short) 2, "红包过期作废"); // 红包过期作废

		private Short key;
		private String value;

		private OperateTypeEnum(Short key, String value) {
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
