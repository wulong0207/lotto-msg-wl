package com.hhly.lottomsg.common.constants;

import java.util.HashMap;
import java.util.Map;

import com.hhly.lottomsg.common.enums.LotteryEnum;

/**
 * 
 * @desc 用户信息常量类
 * @author zhanglei
 * @date 2017-2-9
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class UserConstants {
    
    /**
     * 微信登录常量配置
     */
    public interface WxLoginConstans{
        /**获取微信用户信息接口地址*/
        String WX_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
        /**ACCESS_TOKEN地址*/
        String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String APPID = "wxda24076bd33c8e15";
        String APPSECRET = "b7a9e5e12d79c0f6a98b728ee2b0668b";
        String GRANT_TYPE = "authorization_code";
        String QQ_USER_INFO_URL = "https://graph.qq.com/user/get_user_info";
        String QQ_OPEN_ID_URL = "https://graph.qq.com/oauth2.0/me?access_token={0}&unionid=1";
        String QQ_APPID = "101380144";
    }
    
    /**彩种开奖消息描述*/
    private static final Map<Integer, String> messageDescMapForLottery = new HashMap<>();
    /**彩种购彩消息描述*/
    private static final Map<Integer, String> messageDescMapForBuyLottery = new HashMap<>();
    
    public static final Map<String, Map<Integer,String>> messageDescMap = new HashMap<>();
    
    private static final String MESSAGE_DESC_COMM_LOTTERY = "您将收到比赛的赛果通知";
    private static final String MESSAGE_DESC_COMM_BUY_1= "每日 17:00提醒";
    private static final String MESSAGE_DESC_COMM_BUY_2= "彩期截止前2小时提醒";
    
    /**开奖消息模板表{OPERATE_MSG_TEMPLATE}ID*/
    private static final String OPERATE_MSG_TEMPLATE_ID_LOTTERY= "17";
    private static final String OPERATE_MSG_TEMPLATE_ID_BUY= "";
    
    static{
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.SSQ.getName(), "每周二、四、日 17:00提醒");
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.DLT.getName(), "每周一、三、六 17:00提醒");
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.QLC.getName(), "每周一、三、五 17:00提醒");
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.QXC.getName(), "每周二、五、日 17:00提醒");
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.F3D.getName(), MESSAGE_DESC_COMM_BUY_1);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.PL3.getName(), MESSAGE_DESC_COMM_BUY_1);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.PL5.getName(), MESSAGE_DESC_COMM_BUY_1);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.ZC6.getName(), MESSAGE_DESC_COMM_BUY_2);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.JQ4.getName(), MESSAGE_DESC_COMM_BUY_2);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.SFC.getName(), MESSAGE_DESC_COMM_BUY_2);
        messageDescMapForBuyLottery.put(LotteryEnum.Lottery.ZC_NINE.getName(), MESSAGE_DESC_COMM_BUY_2);
        
        
        messageDescMapForLottery.put(LotteryEnum.Lottery.SSQ.getName(), "每周二、四、日 21:15开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.DLT.getName(), "每周一、三、六 20:30开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.QLC.getName(), "每周一、三、五 21:15开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.QXC.getName(), "每周二、五、日 20:30开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.F3D.getName(), "每日 21:15开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.PL3.getName(), "每天 20:30开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.PL5.getName(), "每天 20:30开奖");
        messageDescMapForLottery.put(LotteryEnum.Lottery.ZC6.getName(), MESSAGE_DESC_COMM_LOTTERY);
        messageDescMapForLottery.put(LotteryEnum.Lottery.JQ4.getName(), MESSAGE_DESC_COMM_LOTTERY);
        messageDescMapForLottery.put(LotteryEnum.Lottery.SFC.getName(), MESSAGE_DESC_COMM_LOTTERY);
        messageDescMapForLottery.put(LotteryEnum.Lottery.ZC_NINE.getName(), MESSAGE_DESC_COMM_LOTTERY);
        
    
        messageDescMap.put(OPERATE_MSG_TEMPLATE_ID_BUY, messageDescMapForBuyLottery);
        messageDescMap.put(OPERATE_MSG_TEMPLATE_ID_LOTTERY, messageDescMapForLottery);
    }
    
    /**消息分类，对应字典表里的dic_code*/
    public static final String MESSAGE_TYPE_CODE = "2101";
    /**开奖号码彩种，对应字典表里的dic_code ,二级开关 */
    public static final String THE_LOTTERY_CODE = "2301";
    /**购彩提醒彩种，对应字典表里的dic_code，二级开关 */
    public static final String SHOPPING_REMINDER_CODE = "2302";
    
    /**
     * 消息设置开关类型
     * 1开奖号码;2购彩提醒
     */
    public interface switch_type{
        /**1开奖号码;2购彩提醒 */
        int LOTTERY_NUMBER = 1;
        int SHOPPING_REMINDER = 2;
    }
    
    /**
     *
     * @desc 银行卡类型:1储蓄卡;2信用卡
     * @author chenkangning
     * @date 2017.03.03
     * @company 益彩网络科技公司
     * @version 1.0
     */
    public enum BankCardType{
        DEPOSIT_CARD((short)1,"储蓄卡"),
        CREDIT_CARD((short)2,"信用卡");
        private short key;
        private String value;
        BankCardType(short key,String value){
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

    /**
     *
     * @desc 银行卡状态
     * @author chenkangning
     * @date 2017.03.03
     * @company 益彩网络科技公司
     * @version 1.0
     */
    public enum BankCardStatusEnum{
        DELETE(0,"删除"),
        EFFECTIVE(1,"有效");

        private Integer key;
        private String value;
        BankCardStatusEnum(Integer key,String value){
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum ModifyTypeEnum{
    	NO_MODIFY((short)0, "都没改"),
		MODIFY_ACCOUNT((short)1,"帐户名"),
		MODIFY_NICKNAME((short)2,"昵称"),
		MODIFY_ALL((short)3,"全部");

		private Short key;
		private String value;
		ModifyTypeEnum(Short key,String value){
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

	public enum SendTypeEnum{
		MOBLE((short)1, "手机号"),
		ID_CARD((short)2,"身份证号码"),
		REAL_NAME((short)3,"真实姓名");

		private Short key;
		private String value;
		SendTypeEnum(Short key,String value){
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

	public enum IconEnum{
		NO((short)0, "无"),
		NEW((short)1,"新"),
		HOT((short)2,"热"),
		ADD((short)3,"加奖"),
		OTHER((short)4,"其它"),
		RECOMMEND((short)5,"推荐");

		private Short key;
		private String value;
		IconEnum(Short key,String value){
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
	 * 
	 * @desc 消息类别
	 * @author zhanglei
	 * @date 2017-2-9
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum  MessageTypeEnum {
		LOG_MSG((short)1,"免密登录") , //登录
		REG_MSG((short)2,"注册"),//注册
		WS_USER_MOBILE_MSG((short)3,"绑定手机号码"),//完善资料绑定手机号码
		FOUND_MSG((short)4,"找回密码"),//找回密码需要验证的手机号或邮箱
		ADD_MSG((short)5,"登记或修改"),//登记/修改手机号或邮箱时验证
		DRAW_MSG((short)6,"提款"),//用户提款时需要验证的手机号或邮箱
		BIND_MSG((short)7,"验证信息"),//验证已绑定的手机号或者邮箱
		FAST_LOGIN_MSG((short)8,"快速登录"),//快速登录
		OTHER_MSG((short)9,"其它");//其它
		private Short key;
		private String value;
		
	    MessageTypeEnum(Short key, String value) {
	    	this.key = key;
			this.value = value;
		}
	    
	    public static MessageTypeEnum getMessageTypeEnum(Short type){
	    	for(MessageTypeEnum messageTypeEnum : MessageTypeEnum.values()){
	    		if(type == messageTypeEnum.getKey())
	    			return messageTypeEnum;
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
	 * 
	 * @desc 用户操作类别
	 * @author zhanglei
	 * @date 2017-2-9
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	
	public enum  UserOperationEnum {
		REGISTER_SUCCESS((short)1,"注册成功"),
		LOGIN_SUCCESS((short)2,"登录成功"),

		
		ADD_BANKCARD((short)5,"添加银行卡"),
		UPDATE_BANKCARD((short)6,"修改银行卡"),
		DELETE_BANKCARD((short)7,"删除银行卡"),
		ENABLED_BANKCARD((short)8,"激活银行卡"),
		OTHER_OPERATION((short)9,"其它"),//其它
		ACCOUNT_PASSWORD_SET_SUCCESS((short)10,"帐户名密码设置成功"),
		PASSWORD_UPDATE_SUCCESS((short)11,"密码修改成功"),
		ACCOUNT_UPDATE_SUCCESS((short)12,"帐户名修改成功"),
		MOBILE_UPDATE_SUCCESS((short)13,"手机号修改成功"),
		EMAIL_UPDATE_SUCCESS((short)14,"邮箱地址修改成功"),
		MOBILE_LOGIN_OPEN_SUCCESS((short)15,"手机号登录开启成功"),
		MOBILE_LOGIN_CLOSE_SUCCESS((short)16,"手机号登录关闭成功"),
		EMAIL_LOGIN_OPEN_SUCCESS((short)17,"邮箱登录开启成功"),
		EMAIL_LOGIN_CLOSE_SUCCESS((short)18,"邮箱登录关闭成功"),
		REAL_NAME_AUTHENTICATION_SUCCESS((short)19,"实名认证成功"),
		USERNAME_ERROR_FOUND_PASS((short)20,"找回密码，帐号错误"),
		USERNAME_ERROR_LOGIN((short)21,"找回密码，帐号错误"),
		LOGIN_FAIL_MOBILE((short)22,"手机验证码登录失败"),
		LOGIN_FAIL_EMAIL((short)23,"邮箱验证码登录失败"),
		LOGIN_FAIL_PASSWORD((short)24,"帐号密码登录失败"),
		SET_PASSWORD_SUCCESS((short)25, "密码设置成功"),
		BANKCARD_VALIDATE_FAIL((short)26, "银行卡号验证失败"),
		BIND_QQOPENID_SUCCESS((short)27, "绑定QQ成功"),
		BIND_WECHATOPENID_SUCCESS((short)28, "绑定微信成功"),
		REMOVE_QQ_BIND_SUCCESS((short)29, "解除QQ绑定成功"),
		REMOVE_WECHAT_BIND_SUCCESS((short)30, "解除微信绑定成功"),
		CHECK_BANKCARD_FAIL((short)31, "验证银行卡失败"),
		CHECK_IDCARD_FAIL((short)32, "验证身份证号失败"),
		CHECK_PASSWORD_FAIL((short)33, "验证密码失败"),
		NICKNAME_UPDATE_SUCCESS((short)34, "昵称修改成功"),
		BIND_SINA_BLOG_OPENID_SUCCESS((short)35, "绑定微博成功"),
		REMOVE_SINA_BLOG_OPENID_SUCCESS((short)36, "解除微博绑定成功"),
		USER_IS_FORBIT((short)37,"账号禁用");
		
		private Short key;
		private String value;
		
	    UserOperationEnum(Short key,String value) {
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
	 * 用户密码等级-类型
	 * @desc
	 * @author zhouyang
	 * @date 2017年2月14日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum PsswordGradeEnum {
		PASSWORD_GRADE_LOW((short)1,"低级"),	//密码安全等级-低级
		PASSWORD_GRADE_CENTER((short)2,"中级"),	//密码安全等级-中级
		PASSWORD_GRADE_HIGH((short)3,"高级");	//密码安全等级-高级		
		private Short key;
		private String value;
		PsswordGradeEnum(Short key, String value) {
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
	 * 注册途径来源
	 */
	public enum PlatformEnum {
		PLATFORM_WEB((short)1,"web"),
		PLATFORM_WAP((short)2,"wap"),
		PLATFORM_ANDROID((short)3,"android"),
		PLATFORM_IOS((short)4,"ios");
		private Short key;
		private String value;
		PlatformEnum(Short key, String value) {
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
	 * 验证码类型
	 * @desc
	 * @author zhouyang
	 * @date 2017年2月22日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum VerifyCodeTypeEnum {
		SMS((short)1,"短信"),
		MAIL((short)2,"邮件"),
		COMMON((short)3,"普通验证");
		private Short key;
		private String value;
		VerifyCodeTypeEnum(Short key, String value) {
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
	 * 帐号登录类型枚举
	 * @desc
	 * @author zhouyang
	 * @date 2017年3月9日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public enum LoginTypeEnum {
		MOBILE((short)1,"手机号"),
		EMAIL((short)2,"邮箱"),
		ACCOUNT((short)3,"帐户名"),
		QQ((short)4,"QQ"),
		WECHAT((short)5,"WECHAT"),
		CHANNEL((short)6, "渠道");
		private Short key;
		private String value;
		LoginTypeEnum(Short key, String value) {
			this.key = key;
			this.value = value;
		}
		public short getKey() {
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

	public enum UserTypeEnum {
		
		USER((short)1,"用户"),
		AGENT((short)2,"代理");
		
		private Short value;
		private String name;
		
		UserTypeEnum(Short value, String name) {
			this.value = value;
			this.name = name;
		}
		public Short getValue() {
			return value;
		}
		public String getName() {
			return name;
		}	
	}

	public enum MsgTypeEnum {

		WIN((short)1,"中奖通知"),
		ACTIVITY((short)2,"优惠活动"),
		RECOMMEND((short)3,"推荐服务"),
		REMIND((short)4,"提醒"),
		SYS((short)5,"系统通知");

		private Short value;
		private String name;

		MsgTypeEnum(Short value, String name) {
			this.value = value;
			this.name = name;
		}
		public Short getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
	}

	public enum MsgSendTypeEnum {

		SITE("1","站内信"),
		MOBILE("2","手机短信"),
		APP("3","app"),
		WECHAT("4","微信");

		private String value;
		private String name;

		MsgSendTypeEnum(String value, String name) {
			this.value = value;
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
	}

	/**
	 * 修改成功
	 */
	public static final String UPDATE_SUCCESS = "修改成功";

	/**
	 * 登记成功
	 */
	public static final String ADD_SUCCESS="登记成功";

	public static final Integer TWO_HUNDRED = 200;

	public static final Integer TEN= 10;

	/**
	 * token统一参数key
	 */
	public static final String TOKEN_KEY = "_token";

	/**
	 * 零 - double
	 */
	public static final Double ZERO = 0.00;

	/**
	 * 零 - 整形
	 */
	public static final  Integer ZERO_INTEGER = 0;
	/**
	 * SN帐号
	 */
	public static final String SN = "SDK-SYO-010-00027";
	
	/**
	 * MD5加密后密码
	 */
	public static final String PWD = "3F6A0775286F3D15858A379697F24E12";
	
	/**
	 * 一彩网标签
	 */
	public static final String TWONCAI = "【2N彩票】";
	
	/**
	 * 短信内容 - 前缀‘验证码为：’
	 */
	public static final String VERIFYCODE = "验证码为：";
	
	/**
	 * 短信内容 - 后缀‘，您正在验证手机号码’
	 */
	public static final String VALIDATE_MOBILE = " ，您正在验证手机号码";
	
	/**
	 * 短信内容 - 后缀‘，您正在验证邮箱地址’
	 */
	public static final String VALIDATE_EMAIL = " ，您正在验证邮箱地址";

	/**
	 * 图片大小
	 */
	public static final Long PHOTO_SIZE = 1024*1024l;

	/**
	 * 验证最大
	 */
	public static final Integer CHECK_MAX = 7;
	
	/**
	 * 短信最大请求次数
	 */
	public static final Integer SEND_MAX = 9;

	/**
	 * 帐户名最大长度
	 */
	public static final Integer ACCOUNT_MAX = 20;

	/**
	 * 帐户名最小长度
	 */
	public static final Integer ACCOUNT_MIN = 4;
	
	/**
	 * 身份证号绑定账号最大数量
	 */
	public static final Integer IDCARD_BIND_MAX = 5;
	
	/**
	 * 用户状态-否/禁用/失败/未使用
	 */
	public static final Short IS_FALSE = 0;
	
	/**
	 * 用户状态-是/启用/成功/已使用
	 */
	public static final Short IS_TRUE = 1;
	
	/**
	 * 银行卡后八位
	 */
	public static final Integer BANKCARD_AFTER_EIGHT = 8;

	/**
	 * 银行卡后六位
	 */
	public static final Integer BANKCARD_AFTER_SIX = 6;

	/**
	 * 三个月
	 */
	public static final long THREE_MONTH = 3 * 30 * 24 * 60 * 60 * 1000l;

	/**
	 * 其它渠道
	 */
	public static final String OTHER_CHANNEL = "7";
	
	/**
	 * 益彩网络
	 */
	public static final String YICAI_NET = "益彩网络";
	
	/**
	 * 益彩网络邮箱地址
	 */
	public static final String YICAI_EMAIL = "yc@2ncai.com";
	
	/**
	 * 公司email服务器地址
	 */
	public static final String YICAI_HOST = "mail.2ncai.com";
	
	/**
	 * 编码格式
	 */
	public static final String UTF_8 = "utf-8";
	
	/**
	 * 浏览器名称分类.
	 */
	public static final String USERAGENT_NAME_TYPE_PASSPORT_WEB = "firefox,bidubrowser,maxthon,qqbrowser,se 2.x metasr,opera,lbbrowser,theworld,msie,chrome";
	
	/**
	 * 操作系统版本分类.
	 * xp:windows nt 5.1;
	 * vista:windows nt 6.0;
	 * win7:windows nt 6.1;
	 * win8:windows nt 6.2;
	 */
	public static final String SYSTEM_NAME_TYPE_PASSPORT_WEB = "windows nt 5.1,windows nt 6.0,windows nt 6.1,windows nt 6.2";
	
	/**
	 * 短信服务器url地址
	 */
	public static final String SMS_SERVICE_URL = "http://sdk.entinfo.cn:8061/webservice.asmx";

	public static final String CONGRATULATION = "恭喜！";

	public static final String IN = "在";

	public static final String WIN = "中奖";

	public static final String YUAN = "元！";

	public static final String FOOTBALL = "竞彩足球";

	public static final String BASKETBALL = "竞彩篮球";

	public static final String TEN_THOUSANT_STR= "万";

	public static final Integer TEN_THOUSANT = 10000;

	public static final Long HUNDRED_MILLIONS = 100000000l;

	public static final String HUNDRED_MILLIONS_STR = "亿";

	public static final String DOWNLOAD_TAIL = "?attname=";
	
}
