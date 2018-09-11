package com.hhly.lottomsg.common.util;

/**
 * 正则表达式验证工具类
 * 
 * @desc
 * @author zhouyang
 * @date 2017年2月14日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class RegularValidateUtil {

	/***** 手机号码验证 ****/
	public static final String REGULAR_MOBILE = "^(1\\d{10}$)";
	/****** 邮箱验证 ******/
	public static final String REGULAR_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
	/******** URL地址验证 *******/
	public static final String REGULAR_URL = "^((https|http|ftp|rtsp|mms)?://)"
			+ "+(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?" + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" + "|"
			+ "([0-9a-zA-Z_!~*'()-]+\\.)*" + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\\." + "[a-zA-Z]{2,6})" + "(:[0-9]{1,4})?"
			+ "((/?)|" + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$";

	public static final String CHINESE = "^[\u4E00-\u9FA5]+$";

	public static final String SYMBOL = "^[a-zA-Z0-9_]";

	/******** 验证用户名 4-20位中文、字母、数字、"."、"、"、"_" ************/
	public static final String REGULAR_ACCOUNT = "^[\u4E00-\u9FA5a-zA-Z0-9_]+$";

	/************* 验证第三方姓名的昵称是否规范 *************/
	public static final String REGULAR_NICKNAME = "^[\u4E00-\u9FA5a-zA-Z0-9_]+$";

	/************** 验证银行卡号格式 **************/
	public static final String REGULAR_BANKCARD = "^[a-zA-Z0-9]{8}$";

	/************** CDK ****************/
	public static final String REGULAR_CDKEY = "^[a-zA-Z0-9]{12}$";

	/******** 纯数字 ********/
	public static final String REGULAR_ACCOUNT2 = "^[\\d]+$";

	/******** 小数 ***********/
	public static final String REGULAR_POINT_NUM = "([1-9][0-9]*\\.[0-9][0-9]*)|([1-9][0-9]*)";

	/******** 纯符号 ********/
	public static final String REGULAR_ACCOUNT3 = "^[_]+$";

	/******** 验证密码格式 *********/
	public static final String REGULAR_PASSWORD = "^[0-9a-zA-Z]{128}$";

	/******** 验证真实用户名 只可为汉字或 "·" ************/
	public static final String REGULAR_REALNAME = "^[\u4e00-\u9fa5][?·\u4e00-\u9fa5]{0,5}[\u4e00-\u9fa5]$";

	/******** 验证任意数字 ************/
	public static final String REGULAR_DIGIT = "\\d*";

	/******** 验证身份证号码规范 **********/
	public static final String REGULAR_IDCARD = "/^[1-9][0-9]{5}(19[0-9]{2}|200[0-9]|2010)(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[0-9]{3}[0-9xX]$/";

	/******** 验证日期格式 yyyyMMdd **********/
	public static final String REGULAR_DATE_NO_LINE = "^\\d{8}$";

}
