package com.hhly.lottomsg.common.enums;

/**
 * @author lgs on
 * @version 1.0
 * @desc 红包礼品枚举
 * @date 2017/4/14.
 * @company 益彩网络科技有限公司
 */
public class OperateCouponEnum {

    /**
     * 红包类别
     */
    public enum RedTypeEnum {
        ALL_RED(0, "全部红包", 0),
        HANDSEL_RED_PACKAGE(3, "彩金红包", 0),
        FULL_CUT_RED_PACKAGE(2, "满减红包", 0),
        RECHARGE_RED_PACKAGE(1, "充值红包", 0),
        PLUS_AWARDS_RED_PACKAGE(4, "加奖红包", 0),
        //        SPREE(5, "大礼包", 0),
        RANDOM_RED_PACKAGE(6, "随机红包", 0);
        //1：充值红包；2：满减红包；3：彩金红包；4：加奖红包；5：大礼包；6：随机红包
        private int type;
        private String text;
        private int total;

        RedTypeEnum(int type, String text, int total) {
            this.type = type;
            this.text = text;
            this.total = total;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    /**
     * 红包状态
     */
    public enum RedStatusEnum {
        //1：待激活；2：待派发；3：可使用；4：已过期；5：已作废；6：已使用
        AVAILABLE(3, "可使用", 0),
        ALREADY_IN_USE(6, "已使用", 0),
        WAIT_ACTIVATION(1, "待激活", 0),
        EXPIRED(4, "已过期", 0),
        //        OBSOLETE(5, "已作废", 0),
        WAIT_DISTRIBUTED(2, "待派发", 0);

        private int value;
        private String text;
        private int total;

        RedStatusEnum(int value, String text, int total) {
            this.value = value;
            this.text = text;
            this.total = total;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    /**
     * 红包状态
     */
    public enum RedClassEnum {
        //1：最优惠，2，新到账，3即将过期
        RED_OVERDUE(3, "即将过期", 0),
        MOST_FAVORABLE(1, "最优惠", 0),
        OBTAIN(2, "新到账", 0);


        private int value;
        private String text;
        private int total;

        RedClassEnum(int value, String text, int total) {
            this.value = value;
            this.text = text;
            this.total = total;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
    /**
     * 来源类型:1：活动；2：券'
     * @author lidecheng
     * @date 2017年7月3日
     * @company 益彩网络科技公司
     * @version 1.0
     */
    public enum RedSourceEnum{
        //1：活动；2：券
    	ACTIVITY((short)1, "活动"),
    	VOUCHER((short)2, "券");


        private short value;
        private String text;

        RedSourceEnum(short value, String text) {
            this.value = value;
            this.text = text;
        }

        public short getValue() {
            return value;
        }

        public void setValue(short value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
    
    /**
     * 1：活动配置(对应表operate_activity_config)；2：唤醒模板红包配置;3活动规则（对应operate_activity_rule）
     * @author lidecheng
     * @date 2017年7月3日
     * @company 益彩网络科技公司
     * @version 1.0
     */
    public enum CouponConfigTypeEnum{
        //1：活动配置(主表operate_activity_config)；2：唤醒模板红包配置;3活动规则（表operate_activity_rule）
    	ACTIVITY((short)1, "活动配置"),
    	WAKEUP((short)2, "唤醒模板红包配置"),
    	ACTIVITY_RULE((short)3, "唤醒模板红包配置");


        private short value;
        private String text;

        CouponConfigTypeEnum(short value, String text) {
            this.value = value;
            this.text = text;
        }

        public short getValue() {
            return value;
        }

        public void setValue(short value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
