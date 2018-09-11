package com.hhly.lottomsg.common.constants;

/**
 * @author zhanglei
 * @version 1.0
 * @desc 提示消息编号常量
 * @date 2017-2-10
 * @company 益彩网络科技公司
 */
public class MessageCodeConstants {
	// 后缀规则
	// _SYS 系统 1系统的编号
	// _FIELD 字段 2开头的编号
	// _SERVICE 业务 3开头的编号S
	// _HTTP_ERROR_CODE http异常返回

	/******************************
	 * 字段验证提示 开始 以 _SYS开始
	 ****************************************/
	public static final String TRUE = "10001";

	/**
	 * hessian接口异常
	 */
	public static final String HESSIAN_ERROR_SYS = "10004";

	/**
	 * 系统异常
	 */
	public static final String SYS_ERROR_SYS = "10005";

	/**
	 * 短信发送失败
	 */
	public static final String SMS_SEND_DEFEAT_SYS = "10006";

	/**
	 * 邮件发送失败
	 */
	public static final String MAIL_SEND_DEFEAT_SYS = "10007";

	/**
	 * 数据不存在、查询不到数据
	 */
	public static final String DATA_NOT_FOUND_SYS = "10008";

	/**
	 * 初始化加载缓存失败
	 */
	public static final String CACHE_INIT_ERROR_SYS = "10009";
	/**
	 * 用户信息异常
	 */
	public static final String USER_INFO_ERROR_SYS = "10010";

	/******************************
	 * 字段验证提示 开始 以 _SYS结尾
	 ****************************************/

	/******************************
	 * 字段验证提示 开始 以 _FIELD结尾
	 ****************************************/

	/**
	 * 参数错误
	 */
	public static final String PARAM_IS_FIELD = "20001";

	/**
	 * 基于注解的方式验证参数有效性
	 */
	public static final String VALIDATE_PARAM_ERROR_FIELD = "20003";
	/**
	 * 查询行数不能为空
	 */
	public static final String ROW_IS_NULL_FIELD = "20004";

	/**
	 * 查询行数不能超过{0}行
	 */
	public static final String ROW_MAX_FIELD = "20005";

	/**
	 * 参数为空或不合法
	 */
	public static final String PARAM_INVALID = "20006";

	/**
	 * 参数为空或不合法
	 */
	public static final String ASSERT_NOT_PASS = "20007";
	/**
	 * 更新信息失败
	 */
	public static final String UPDATE_MESSAGE_FAIL = "20008";
	/**
	 * token为空
	 */
	public static final String TOKEN_IS_NULL_FIELD = "20100";

	/**
	 * 对象为空
	 */
	public static final String OBJECT_IS_NULL_FIELD = "20101";

	/**
	 * 交易编号为空
	 */
	public static final String TRANS_CODE_IS_NULL_FIELD = "20321";

	/**
	 * 资金流向错误
	 */
	public static final String TRANS_MONEY_FLOW_FIELD = "20322";

	/**
	 * 投注内容为空
	 */
	public static final String BET_CONTENT_IS_NULL_FIELD = "20326";

	/******************************
	 * 字段验证提示 结束 以 _FIELD结尾
	 ****************************************/

	/*****************************
	 * 任务验证提示 开始 以_SERVICE结尾
	 ********************************************************/

	/**
	 * 对象为空
	 */
	public static final String OBJECT_IS_NULL = "30294";

	/**
	 * 不存在开奖供应商
	 */
	public static final String NO_DEALER = "30005";
	/**
	 * 不能抓取该彩种开奖号码
	 */
	public static final String NOT_DRAW_CODE = "30006";
	/**
	 * 彩种为空或不存在
	 */
	public static final String LOTTERY_CODE_IS_NULL_FIELD = "40298";
	/**
	 * 彩期为空
	 */
	public static final String LOTTERY_ISSUE_IS_NULL_FIELD = "40299";
	/**
	 * 订单总额为空
	 */
	public static final String ORDER_ACCOUNT_IS_NULL_FIELD = "40300";
	/**
	 * 方案内容为空
	 */
	public static final String PLAN_CONTENT_IS_NULL_FIELD = "40233";
	/**
	 * 子玩法:{0}，不存在！
	 */
	public static final String LOTTERY_CHILD_CODE_IS_NULL_FIELD = "40234";
	/**
	 * 投注验证不通过,请检查投注信息
	 */
	public static final String VALIDATE_ERROR_FIELD = "40235";

	/**
	 * 赛事不存在（或没有销售）
	 */
	public static final String MATCH_DOES_NOT_EXIST_OR_STOP_SELLING = "40236";
	/**
	 * 渠道为空
	 */
	public static final String CHANNEL_ID_IS_NULL_FIELD = "40260";
	/**
	 * 用户TOKEN为空
	 */
	public static final String USER_TOKEN_IS_NULL_FIELD = "40261";
	/**
	 * 订单详情空
	 */
	public static final String ORDER_DETAIL_IS_NULL_FIELD = "40262";
	/**
	 * 订单详情金额空
	 */
	public static final String ORDER_DETAIL_AMOUNT_IS_NULL_FIELD = "40289";
	/**
	 * 订单详情注数空
	 */
	public static final String ORDER_DETAIL_BETNUM_IS_NULL_FIELD = "40290";
	/**
	 * 订单详情倍数空
	 */
	public static final String ORDER_DETAIL_MULTIPLE_IS_NULL_FIELD = "40291";
	/**
	 * 订单编号空
	 */
	public static final String ORDER_CODE_IS_NULL_FIELD = "40292";
	/**
	 * 选号方式为空或不存在
	 */
	public static final String BET_CODE_WAY_ILLEGAL = "40296";

	/**
	 * 投注方式为空
	 */
	public static final String ORDER_DETAIL_CONTENT_TYPE_IS_NULL_FIELD = "40301";

	/**
	 * 竞彩tab为空
	 */
	public static final String TAB_TYPE_IS_NULL_FIELD = "40304";
	/**
	 * 投注内容包含已截止赛事（主要用于竞足、竞篮、北单）
	 */
	public static final String BET_CONTENT_CONTAIN_END_MATCH = "40305";
	/**
	 * 购买方式为空
	 */
	public static final String BUY_TYPE_IS_NULL_FIELD = "40306";
	/**
	 * 是否大乐透追号为空
	 */
	public static final String IS_DLT_ADD_NULL_FIELD = "40307";
	/**
	 * 平台类型为空
	 */
	public static final String PLATFORM_IS_NULL_FIELD = "40322";
	/**
	 * 上传类型为空
	 */
	public static final String UPLOADTYPE_IS_NULL_FIELD = "40323";
	/**
	 * 是否第一次上传文件标志为空
	 */
	public static final String IF_FIRST_TIME_FLAG_IS_NULL_FIELD = "40324";

	/**
	 * 选择的赛事编号为空
	 */
	public static final String SELECTED_MATCH_INFO_IS_NULL_FIELD = "40499";
	/**
	 * 上传文件路径为空
	 */
	public static final String FILE_PATH_IS_NULL_FIELD = "40498";
	/**
	 * 预计奖金金额为空
	 */
	public static final String MAX_BONUS_IS_NULL_FIELD = "40355";

	/**
	 * 此订单状态不能查看出票明细
	 */
	public static final String ORDER_STATUS_CAN_NOT_SEE_TICKET = "40438";

	/**
	 * 对不起，该彩种已暂停销售
	 */
	public static final String PLATFORM_LIMIT = "40356";

	/******** 交易相关 ********/
	/**
	 * 查询数据异常
	 */
	public static final String FIND_DATA_EXCEPTION_SERVICE = "30500";
	/**
	 * 支付渠道为空
	 */
	public static final String TRANS_PAY_CHANNEL_IS_NULL_FIELD = "30501";
	/**
	 * 未获取到具体的银行支付信息
	 */
	public static final String TRANS_TAKEN_BANK_IS_NULL_FIELD = "30502";
	/**
	 * 提款平台为空
	 */
	public static final String TRANS_TAKEN_PLATFORM_IS_NULL_FIELD = "30503";
	/**
	 * 交易金额为空（提款、充值）
	 */
	public static final String TRANS_AMOUNT_IS_NULL_FIELD = "30504";
	/**
	 * 充值渠道为空
	 */
	public static final String TRANS_RECHARGE_CHANNEL_IS_NULL_FIELD = "30505";
	/**
	 * 银行卡类型为空
	 */
	public static final String TRANS_BANK_CARD_TYPE_IS_NULL_FIELD = "30506";
	/**
	 * 支付方式为空
	 */
	public static final String TRANS_PAY_TYPE_IS_NULL_FIELD = "30507";
	/**
	 * 支付渠道错误
	 */
	public static final String TRANS_PAY_CHANNEL_IS_ERROR_SERVICE = "30508";
	/**
	 * 订单编号错误
	 */
	public static final String TRANS_ORDER_CODE_IS_ERROR_SERVICE = "30509";
	/**
	 * 客户端IP为空
	 */
	public static final String CLIENT_IP_IS_NULL_FIELD = "30510";
	/**
	 * 支付平台为空
	 */
	public static final String TRANS_PLATFORM_IS_NULL_FIELD = "30511";
	/**
	 * 支付方式错误
	 */
	public static final String TRANS_PAY_TYPE_ERROR_SERVICE = "30512";
	/**
	 * 支付状态不是等待支付（该订单已不能支付）
	 */
	public static final String PAY_STATUS_ERROR_SERVICE = "44513";
	/**
	 * 账户余额不足
	 */
	public static final String PAY_USER_WALLET_ERROR_SERVICE = "44514";
	/**
	 * 信用卡有效期格式错误
	 */
	public static final String PAY_CREDIT_FORMAT_ERROR_SERVICE = "44515";
	/**
	 * 信用卡已过有效期（已失效）
	 */
	public static final String PAY_CREDIT_INVALID_ERROR_SERVICE = "44516";
	/**
	 * 余额金额错误
	 */
	public static final String PAY_BALANCE_ERROR_SERVICE = "44517";
	/**
	 * 未获取到银行卡信息
	 */
	public static final String PAY_BANKCARD_NOT_FOUND_SERVICE = "44518";
	/**
	 * 交易正在进行中
	 */
	public static final String PAY_RECHARGEING_SERVICE = "30519";
	/**
	 * 交易金额错误
	 */
	public static final String PAY_AMOUNT_ERROR_SERVICE = "44520";
	/**
	 * 折扣类型错误
	 */
	public static final String PAY_DISCOUNT_TYPE_ERROR_SERVICE = "30521";
	/**
	 * 交易类型错误
	 */
	public static final String PAY_TRADE_TYPE_ERROR_SERVICE = "30522";
	/**
	 * 交易状态错误
	 */
	public static final String PAY_TRADE_STATUS_ERROR_SERVICE = "30523";
	/**
	 * 查询时间类型错误
	 */
	public static final String PAY_QUERY_DATE_TYPE_ERROR_SERVICE = "30524";
	/**
	 * 查询时间格式错误
	 */
	public static final String PAY_QUERY_DATE_FORMAT_ERROR_SERVICE = "30525";
	/**
	 * 查询当前页码错误
	 */
	public static final String PAY_QUERY_CURRENT_PAGE_ERROR_SERVICE = "30526";
	/**
	 * 查询每页显示条数错误
	 */
	public static final String PAY_QUERY_SHOW_COUNT_ERROR_SERVICE = "30527";
	/**
	 * 查询每页条数超出限制
	 */
	public static final String PAY_QUERY_SHOW_COUNT_LIMIT_ERROR_SERVICE = "30528";
	/**
	 * 红包编号错误
	 */
	public static final String PAY_RED_CODE_ERROR_SERVICE = "30529";
	/**
	 * 未查询到红包详细信息
	 */
	public static final String PAY_RED_DETAIL_NOT_FOUND_ERROR_SERVICE = "30530";
	/**
	 * 红包余额不足
	 */
	public static final String PAY_RED_BALANCE_NOT_ENOUGH_ERROR_SERVICE = "44531";
	/**
	 * 系统异常，支付失败
	 */
	public static final String PAY_FAIL_ERROR_SERVICE = "30532";
	/**
	 * 红包金额错误
	 */
	public static final String PAY_RED_BALANCE_ERROR_SERVICE = "30533";
	/**
	 * 充值金额为空
	 */
	public static final String PAY_RECHARGE_BALANCE_IS_NULL_FIELD = "44534";
	/**
	 * 资金流向与交易类型不匹配
	 */
	public static final String PAY_MONEYFLOW_NOT_SUIT_ERROR_SERVICE = "30535";
	/**
	 * 银行卡号为空
	 */
	public static final String PAY_BANK_CARD_IS_NULL_FIELD = "30536";
	/**
	 * 银行卡号码段信息获取失败
	 */
	public static final String PAY_BANK_CARD_SEGMENT_NOT_FOUND_ERROR_SERVICE = "30537";
	/**
	 * 红包使用平台错误
	 */
	public static final String PAY_RED_LIMIT_PLATFORM_ERROR_SERVICE = "30538";
	/**
	 * 红包使用彩种错误
	 */
	public static final String PAY_RED_LIMIT_LOTTORY_ERROR_SERVICE = "30539";
	/**
	 * 平台为空
	 */
	public static final String PAY_PLATFORM_IS_NULL_FIELD = "30540";
	/**
	 * 超过银行卡单笔最大限额
	 */
	public static final String PAY_BANK_CARD_LIMIT_ERROR_SERVICE = "44541";
	/**
	 * 充值金额不能小于10元
	 */
	public static final String PAY_RECHARGE_AMOUNT_ERROR_SERVICE = "44542";
	/**
	 * 银行卡ID错误
	 */
	public static final String PAY_BANK_CARD_ID_ERROR_SERVICE = "30543";
	/**
	 * 银行暂停使用
	 */
	public static final String PAY_BANK_DISABLE_ERROR_SERVICE = "44544";
	/**
	 * 暂无可用支付渠道
	 */
	public static final String PAY_BANK_CHANNEL_NOT_FOUND_ERROR_SERVICE = "44545";
	/**
	 * 交易已完成
	 */
	public static final String PAY_TRANS_HAD_FINISH_ERROR_SERVICE = "30546";
	/**
	 * 红包待激活
	 */
	public static final String PAY_RED_WAITTING_ACTIVATION_ERROR_SERVICE = "30547";
	/**
	 * 红包待派发
	 */
	public static final String PAY_RED_WAITTING_DISTRIBUTE_ERROR_SERVICE = "30548";
	/**
	 * 红包已过期
	 */
	public static final String PAY_RED_EXPIRED_ERROR_SERVICE = "30549";
	/**
	 * 红包已作废
	 */
	public static final String PAY_RED_INVALID_ERROR_SERVICE = "30550";
	/**
	 * 红包已使用
	 */
	public static final String PAY_RED_ALREADY_USE_ERROR_SERVICE = "30551";
	/**
	 * 红包暂时不可使用
	 */
	public static final String PAY_RED_BAND_USE_ERROR_SERVICE = "30552";
	/**
	 * 充值金额必须为整数
	 */
	public static final String PAY_RECHARGE_BALANCE_ERROR_SERVICE = "44553";
	/**
	 * 支付金额错误
	 */
	public static final String PAY_PAY_AMOUNT_ERROR_SERVICE = "44554";
	/**
	 * 支付同步返回地址为空
	 */
	public static final String PAY_RETURN_URL_IS_NULL_FIELD = "30555";
	/**
	 * 支付同步返回地址错误
	 */
	public static final String PAY_RETURN_URL_ERROR_SERVICE = "30556";
	/**
	 * 更新订单支付状态失败
	 */
	public static final String PAY_UPDATE_ORDER_PAYSTATUS_ERROR_SERVICE = "30557";
	/**
	 * 充值状态已完成
	 */
	public static final String PAY_RECHARGE_STATUS_FINISHED_ERROR_SERVICE = "30558";
	/**
	 * 提款验证方式错误
	 */
	public static final String TAKEN_VALIDATE_TYPE_ERROR_SERVICE = "30559";
	/**
	 * 邮箱验证码为空
	 */
	public static final String TAKEN_EMAIL_VALIDATE_CODE_IS_NULL_FIELD = "30560";
	/**
	 * 手机验证码为空
	 */
	public static final String TAKEN_MOBILE_VALIDATE_CODE_IS_NULL_FIELD = "30561";
	/**
	 * 身份证后8位为空
	 */
	public static final String TAKEN_IDCARD_VALIDATE_CODE_IS_NULL_FIELD = "44000";
	/**
	 * 银行卡后8位为空
	 */
	public static final String TAKEN_BANKCARD_VALIDATE_CODE_IS_NULL_FIELD = "44563";
	/**
	 * 邮箱验证码错误
	 */
	public static final String TAKEN_EMAIL_VALIDATE_CODE_ERROR_SERVICE = "44564";
	/**
	 * 手机验证码错误
	 */
	public static final String TAKEN_MOBILE_VALIDATE_CODE_ERROR_SERVICE = "44565";
	/**
	 * 身份证后8位错误
	 */
	public static final String TAKEN_IDCARD_VALIDATE_CODE_ERROR_SERVICE = "44001";
	/**
	 * 银行卡后8位错误
	 */
	public static final String TAKEN_BANKCARD_VALIDATE_CODE_ERROR_SERVICE = "44567";
	/**
	 * 提款验证方式获取失败
	 */
	public static final String TAKEN_VALIDATE_TYPE_NOT_FOUNE_ERROR_SERVICE = "44568";
	/**
	 * 未获取到可用提款银行卡信息
	 */
	public static final String TAKEN_BANK_CARD_NOT_FOUNE_ERROR_SERVICE = "44569";
	/**
	 * 银行卡ID为空
	 */
	public static final String PAY_BANK_CARD_ID_IS_NULL_FIELD = "44570";
	/**
	 * 提款金额为空
	 */
	public static final String TAKEN_AMOUNT_IS_NULL_FIELD = "44571";
	/**
	 * 提款金额不能大于可提金额 XXXX.XX元
	 */
	public static final String TAKEN_AMOUNT_LARGER_ERROR_SERVICE = "44572";
	/**
	 * 确认提款信息为空
	 */
	public static final String TAKEN_CONFIRM_IS_NULL_FIELD = "44573";
	/**
	 * 提款请求超时，请重新申请
	 */
	public static final String TAKEN_CONFIRM_TIME_OUT_ERROR_SERVICE = "44574";
	/**
	 * 账户余额有变动
	 */
	public static final String WALLET_TOTAL_CASH_CHANGE_ERROR_SERVICE = "44575";
	/**
	 * 确认提款信息错误
	 */
	public static final String TAKEN_CONFIRM_ERROR_SERVICE = "44576";
	/**
	 * 提款请求失败
	 */
	public static final String TAKEN_REQUEST_ERROR_SERVICE = "44577";
	/**
	 * 每天最多只能发起3笔提款
	 */
	public static final String TAKEN_TIMES_ERROR_SERVICE = "44578";
	/**
	 * 充值金额计算错误
	 */
	public static final String TAKEN_RECHARGE_COUNT_ERROR_SERVICE = "44579";
	/**
	 * 购买类型为空
	 */
	public static final String PAY_BUY_TYPE_IS_NULL_FIELD = "30580";
	/**
	 * 购买类型错误
	 */
	public static final String PAY_BUY_TYPE_ERROR_SERVICE = "30581";
	/**
	 * 追号状态错误
	 */
	public static final String PAY_ORDER_ADD_STATUS_ERROR_SERVICE = "30582";
	/**
	 * 订单状态错误
	 */
	public static final String PAY_ORDER_STATUS_ERROR_SERVICE = "30583";
	/**
	 * 开奖状态错误
	 */
	public static final String PAY_ORDER_WINNING_STATUS_ERROR_SERVICE = "30584";
	/**
	 * 退款金额为空
	 */
	public static final String REFUND_AMOUNT_IS_NULL_FIELD = "30585";
	/**
	 * 退款金额错误
	 */
	public static final String REFUND_AMOUNT_ERROR_SERVICE = "30586";
	/**
	 * 支行名称为空
	 */
	public static final String BANK_NAME_IS_NULL_FIELD = "30587";
	/**
	 * 订单号和交易流水号为空
	 */
	public static final String PAY_QUERY_PARAM_IS_NULL_FIELD = "44588";
	/**
	 * 订单号或交易流水号错误
	 */
	public static final String PAY_QUERY_PARAM_ERROR_SERVICE = "44589";
	/**
	 * 第三方支付接口返回空
	 */
	public static final String THIRD_PARTY_PAYMENT_RETURN_EMPTY = "30590";
	/**
	 * 查询交易详情错误
	 */
	public static final String QUERY_TRANSACTION_DETAILS_ERROR_SERVICE = "30591";
	/**
	 * 退款请求失败
	 */
	public static final String REFUND_REQUEST_FAIL_ERROR_SERVICE = "30592";
	/**
	 * 红包编号为空
	 */
	public static final String PAY_RED_CODE_IS_NULL_FIELD = "30593";
	/**
	 * 订单号对应的购买方式错误
	 */
	public static final String PAY_ORDER_BUYTYPE_ERROR_SERVICE = "30594";
	/**
	 * 已过支付截止时间
	 */
	public static final String PAY_DEADLINE_HAS_PASSED = "44595";
	/**
	 * 未查询到充值记录
	 */
	public static final String QUERY_RECHARGE_RECORD_FAIL_ERROR_SERVICE = "30596";
	/**
	 * 红包不满足使用条件
	 */
	public static final String PAY_RED_NOT_SUIT_ERROR_SERVICE = "44597";
	/**
	 * 账户余额足够支付
	 */
	public static final String PAY_USER_WALLET_ENOUTH_ERROR_SERVICE = "44598";
	/**
	 * 彩金红包余额足够支付
	 */
	public static final String PAY_RED_COLOR_ENOUTH_ERROR_SERVICE = "44599";
	/**
	 * 支付结束时间为空
	 */
	public static final String PAY_END_TIME_IS_NULL_FIELD_SERVICE = "31500";
	/**
	 * 订单类型为空
	 */
	public static final String ORDER_TYPE_IS_NULL_FIELD = "31501";
	/**
	 * 订单找不到
	 */
	public static final String ORDER_CANNOT_FIND_SERVICE = "31502";
	/**
	 * 获取订单异常
	 */
	public static final String GET_ORDER_ERROR_SERVICE = "31503";
	/**
	 * 订单状态错误
	 */
	public static final String ORDER_STATUS_ERROR_SERVICE = "31504";
	/**
	 * 追号期数表记录不存在
	 */
	public static final String ORDER_ADDED_ISSUE_CANNOT_FIND_SERVICE = "31505";
	/**
	 * 彩期期号为空
	 */
	public static final String ISSUE_CODE_IS_NULL_FIELD = "31506";

	/**
	 * 撤单-退款类型为空
	 */
	public static final String REFUND_TYPE_IS_NULL_FIELD = "31507";
	/**
	 * 该订单正在支付中
	 */
	public static final String ORDER_IS_BEING_PAID = "31511";
	/**
	 * 订单投注金额与票投注金额不一致
	 */
	public static final String ORDER_AND_TICKET_BETTINGAMT_IS_NOT_SAME = "31512";
	/**
	 * 订单中奖金额与票中奖金额不一致
	 */
	public static final String ORDER_AND_TICKET_WINNINGAMT_IS_NOT_SAME = "31513";
	/**
	 * 订单中奖状态错误
	 */
	public static final String ORDER_WINNING_STATUS_ERROR_SERVICE = "31514";
	/**
	 * 银行卡未实名绑定
	 */
	public static final String PAYBANK_NOT_REALNAME_ERROR_SERVICE = "31515";
	/**
	 * 账户可用红包金额错误
	 */
	public static final String PAY_RED_AMOUNT_ERROR_SERVICE = "31516";
	/**
	 * 申请的提款金额不能低于1元
	 */
	public static final String TAKEN_AMOUNT_LOWEST_ERROR_SERVICE = "31517";
	/**
	 * 账户金额错误
	 */
	public static final String USER_WALLET_AMOUNT_ERROR_SERVICE = "31518";
	/**
	 * 申请的提款金额不够扣除手续费
	 */
	public static final String TAKEN_AMOUNT_NOT_ENOUGH_ERROR_SERVICE = "44519";
	/**
	 * 操作人不能为空
	 */
	public static final String OPERATE_IS_NULL_ERROR_SERVICE = "31520";
	/**
	 * 支付接口超时
	 */
	public static final String THIRD_API_READ_TIME_OUT = "41531";
	/**
	 * 查询支付接口返回错误
	 */
	public static final String THIRD_API_QUERY_ERROR = "31522";
	/**
	 * 签名错误
	 */
	public static final String THIRD_API_SIGN_ERROR = "31523";
	/**
	 * 提款审核状态不对
	 */
	public static final String TAKEN_AUDIT_STATUS_ERROR = "31524";
	/**
	 * 批量支付不允许有活动订单
	 */
	public static final String BATCH_PAY_NOT_ALLOW_ACTIVITY_ORDER = "31525";
	/**
	 * 更新账户金额失败
	 */
	public static final String UPDATE_USER_WALLET_ERROR = "31526";
	/**
	 * 中奖金额错误
	 */
	public static final String WINNING_AMOUNT_ERROR = "31527";
	/**
	 * 上传accesskey、secretKey、bucketName不能为空
	 */
	public static final String UPLOAD_PARAM_IS_NULL_FIELD = "31528";
	/**
	 * 批量处理文件数量超过限制
	 */
	public static final String UPLOAD_NUM_OVER_FIELD = "31529";
	/**
	 * 需要删除的文件为空
	 */
	public static final String DELETE_FILE_IS_NULL = "31530";
	/**
	 * 上传的文件名不能为空
	 */
	public static final String UPLOAD_FILE_NAME_IS_NULL = "31531";
	/**
	 * 文件访问路径不能为空
	 */
	public static final String UPLOAD_URL_IS_NULL = "31532";
	/**
	 * 同名文件不能修改
	 */
	public static final String FILE_NAME_IS_SAME = "31533";
	/**
	 * 重命名文件失败
	 */
	public static final String RENAME_FILE_NAME_ERROR = "31534";
	/**
	 * {0}金额小于单笔最低支付金额{1}
	 */
	public static final String PAY_MONEY_LESS_THAN_LIMIT = "44535";
	/**
	 * {0}金额高于单笔最高支付金额{1}
	 */
	public static final String PAY_MONEY_HIGHER_THAN_LIMIT = "44536";
	/**
	 * 正在维护，请使用其它支付方式
	 */
	public static final String PAY_CHANNEL_IS_REPAIRING = "44537";
	/**
	 * 订单号为空
	 */
	public static final String PAY_ORDER_NO_IS_NULL = "44538";
	/**
	 * 活动类型为空
	 */
	public static final String PAY_ACTIVITY_TYPE_IS_NULL = "44539";
	/**
	 * 本站加奖金额错误
	 */
	public static final String WEBSIT_ADD_BONUS_IS_ERROR = "31535";
	/**
	 * 未获取到方案详情信息
	 */
	public static final String FIND_ISSUE_INFO_FAIL = "44540";
	/**
	 * 配置信息未获取到
	 */
	public static final String BASE_DATA_INFO_NOT_CONFIG = "31536";
	/**
	 * 未获取到需要自动审核的提款记录
	 */
	public static final String AUTO_CHECK_DATA_NOT_FOUND = "31537";

	/**
	 * 账号已设置帐户名密码
	 */
	public static final String ACCOUNT_ALREADY_SET_USERNAME_AND_PASSWORD_SERVICE = "30600";

	/**
	 * 帐户名已修改过
	 */
	public static final String ACCOUNT_IS_MODIFIED_SERVICE = "30601";

	/**
	 * 未通过验证
	 */
	public static final String VALIDATE_FAILED_SERVICE = "30603";

	/**
	 * 没有找到该验证码记录
	 */
	public static final String NOT_FIND_THIS_VERFYCODE = "30604";

	/**
	 * 真实身份已完善
	 */
	public static final String REAL_IDENTITY_IS_DONE = "30605";

	/**
	 * 手机号已登记
	 */
	public static final String MOBILE_IS_EXISTING = "30607";

	/**
	 * 邮箱地址已登记
	 */
	public static final String EMAIL_IS_EXISTING = "30608";

	/**
	 * 帐号未登记该手机号码
	 */
	public static final String ACCOUNT_IS_NOT_ADD_THIS_MOBILE_SERVICE = "30609";

	/**
	 * 帐号未登记该邮箱地址
	 */
	public static final String ACCOUNT_IS_NOT_ADD_THIS_EMAIL_SERVICE = "30610";

	/**
	 * 手机号码未验证
	 */
	public static final String MOBILE_IS_NOT_VALIDATE_SERVICE = "30611";

	/**
	 * 邮箱地址未验证
	 */
	public static final String EMAIL_IS_NOT_VALIDATE_SERVICE = "30612";

	/**
	 * 您已设置密码，请选择用使用密码登录
	 */
	public static final String PLEASE_CHANGE_PASSWORD_LOGIN = "30613";

	/**
	 * 您还未绑定银行卡
	 */
	public static final String NOT_BIND_BANK_CARD = "30614";

	/**
	 * 发送类型错误
	 */
	public static final String SEND_TYPE_ERROR = "30617";

	/**
	 * 您提交方案内容重复,请确认
	 */
	public static final String RESUBMIT_BET_SERVICE = "40353";

	/**
	 * 帐号为空
	 */
	public static final String ACCOUNT_IS_NULL_FIELD = "40100";

	/**
	 * 帐号格式错误
	 */
	public static final String ACCOUNT_FORMAT_ERROR_FILED = "40101";

	/**
	 * 手机号码为空
	 */
	public static final String MOBILE_IS_NULL_FIELD = "40102";

	/**
	 * 手机号码格式错误
	 */
	public static final String MOBILE_FORMAT_ERROR_FIELD = "40103";

	/**
	 * 邮箱地址为空
	 */
	public static final String EMAIL_IS_NULL_FIELD = "40104";

	/**
	 * 邮箱格式错误
	 */
	public static final String EMAIL_FORMAT_ERROR_FIELD = "40105";

	/**
	 * 用户名为空
	 */
	public static final String USERNAME_IS_NULL_FIELD = "40106";

	/**
	 * 帐户名格式不规范，帐户名为4-20位中文、数字、字母和标点符号".、_"
	 */
	public static final String ACCOUNT_FORMAT_ERROR_FIELD = "40107";

	/**
	 * 密码为空
	 */
	public static final String PASSWORD_IS_NULL_FIELD = "40108";

	/**
	 * 密码格式错误
	 */
	public static final String PASSWORD_FORMAT_ERROR_FIELD = "40109";

	/**
	 * 两次密码输入不一致
	 */
	public static final String ENTERED_PASSWORDS_DIFFER_FIELD = "40110";

	/**
	 * 真实姓名为空
	 */
	public static final String REALNAME_IS_NULL_FIELD = "40111";

	/**
	 * 领奖人姓名错误，请确认后重新输入
	 */
	public static final String REALNAME_FORMAT_ERROR_FIELD = "40112";

	/**
	 * 身份证号码为空
	 */
	public static final String IDCARD_IS_NULL_FIELD = "40113";

	/**
	 * 领奖人身份证错误，请确认后重新输入
	 */
	public static final String IDCARD_FORMAT_ERROR_FIELD = "40114";

	/**
	 * 一张身份证最多只能绑定六个帐号
	 */
	public static final String THE_IDCARD_BIND_MAX_IS_SEX_FIELD = "40115";

	/**
	 * 验证码为空
	 */
	public static final String VERIFYCODE_IS_NULL_FIELD = "40116";

	/**
	 * 验证码一天最多只能发送十次
	 */
	public static final String THE_VERIFYCODE_SEND_MAX_IS_TEN_FIELD = "40117";

	/**
	 * 请重新登录
	 */
	public static final String TOKEN_LOSE_SERVICE = "40118";

	/**
	 * 该账号未注册或未开启手机号码登录
	 */
	public static final String ACCOUNT_IS_NOT_FOUND_SERVICE = "40119";

	/**
	 * 手机号已注册
	 */
	public static final String MOBILE_IS_REGISTERED_SERVICE = "40120";

	/**
	 * 手机号不存在
	 */
	public static final String MOBILE_IS_NOT_FOUND_SERVICE = "40121";

	/**
	 * 未开启手机登录
	 */
	public static final String MOBILE_LOGIN_IS_NOT_OPEN_SERVICE = "40122";

	/**
	 * 邮箱已注册
	 */
	public static final String EMAIL_IS_REGISTERED_SERVICE = "40123";

	/**
	 * 邮箱号不存在
	 */
	public static final String EMAIL_IS_NOT_FOUND_SERVICE = "40124";

	/**
	 * 未开启邮箱登录
	 */
	public static final String EMAIL_LOGIN_IS_NOT_OPEN_SERVICE = "40125";

	/**
	 * 帐户名已存在
	 */
	public static final String USERNAME_IS_REGISTERED_SERVICE = "40126";

	/**
	 * 帐户名不存在
	 */
	public static final String USERNAME_IS_NOT_FOUND_SERVICE = "40127";

	/**
	 * 帐号与密码不匹配
	 */
	public static final String ACCOUNT_AND_PASSWORD_IS_NOT_MATCH_SERVICE = "40128";

	/**
	 * 帐号已禁用
	 */
	public static final String ACCOUNT_IS_FORBIDDEN_SERVICE = "40129";

	/**
	 * 帐号未设置密码
	 */
	public static final String ACCOUNT_IS_NOT_SET_PASSWORD_SERVICE = "40130";

	/**
	 * 验证码输入有误,,确认后重新输入.
	 */
	public static final String VERIFYCODE_ERROR_SERVICE = "40131";

	/**
	 * 帐号已实名认证
	 */
	public static final String ACCOUNT_ALREADY_REALNAME_AUTHENTICTION_SERVICE = "40132";

	/**
	 * 账号未实名认证
	 */
	public static final String ACCOUNT_NOT_REALNAME_AUTHENTICTION_SERVICE = "40133";

	/**
	 * 密码错误
	 */
	public static final String PASSWORD_ERROR_SERVICE = "40134";

	/**
	 * 已开启手机登录
	 */
	public static final String MOBILE_LOGIN_IS_OPENED_SERVICE = "40135";

	/**
	 * 已开启邮箱登录
	 */
	public static final String EMAIL_LOGIN_IS_OPENED_SERVICE = "40136";

	/**
	 * 已关闭手机登录
	 */
	public static final String MOBILE_LOGIN_IS_CLOSED_SERVICE = "40137";

	/**
	 * 已关闭邮箱登录
	 */
	public static final String EMAIL_LOGIN_IS_CLOSED_SERVICE = "40138";

	/**
	 * 真实姓名和身份证不符
	 */
	public static final String REALNAME_OR_IDCARD_SERVICE = "40139";

	/**
	 * 您输入的帐号已超过10次
	 */
	public static final String USERNAME_ERROR_OUT_OF_TEN_TIMES = "40140";

	/**
	 * 您输入的密码与帐号不匹配已超过10次
	 */
	public static final String ACCOUNT_AND_PASSWORD_IS_NOT_MATCH_SERVICE_OUT_OF_TEN_TIMES = "40141";

	/**
	 * 验证手机号码失败已超过10次
	 */
	public static final String VALIDATE_MOBILE_LOSE_OUT_OF_TEN_TIMES = "40142";

	/**
	 * 验证邮箱地址失败已超过10次
	 */
	public static final String VALIDATE_EMAIL_LOSE_OUT_OF_TEN_TIMES = "40143";

	/**
	 * 纯数字帐户名不能超出9位
	 */
	public static final String ACCOUNT_IS_NUMBER_CON_NOT_OUT_OF_NINE = "40145";

	/**
	 * 帐户名不能为纯符号
	 */
	public static final String ACCOUNT_IS_NOT_ALL_SYMBOLS = "40146";

	/**
	 * 帐号已登记过邮箱地址
	 */
	public static final String ACCOUNT_REGISTERED_EMAIL = "40148";

	/**
	 * 帐号已登记过手机号码
	 */
	public static final String ACCOUNT_REGISTERED_MOBILE = "40149";

	/**
	 * 你的名字超出了系统识别的长度，你可联系在线客服协助完成
	 */
	public static final String YOUR_NAME_OUT_OF_SYSTEM_LENGTH = "40150";

	/**
	 * 修改成功
	 */
	public static final String UPDATE_SUCCESS = "40151";

	/**
	 * 帐号已设置密码
	 */
	public static final String ACCOUNT_IS_HAVE_SET_PASSWORD = "40152";

	/**
	 * 银行卡号不能为空
	 */
	public static final String BANKCARD_IS_NULL = "40153";

	/**
	 * 银行卡信息不正确，请确认卡号或更换其他银行卡
	 */
	public static final String BANKCARD_IS_ERROR = "40154";

	/**
	 * 你今天已输错银行卡号码10次！次数已用完，请明天再试！
	 */
	public static final String BANKCARD_VALIDATE_FAIL_TIME_OUT_OF_TEN = "40155";

	/**
	 * 银行卡号格式错误
	 */
	public static final String BANKCARD_FORMAT_ERROR = "40156";

	/**
	 * 手机登录开启失败，帐号已存在
	 */
	public static final String MOBILE_LOGIN_OPEN_FAIL = "40157";

	/**
	 * 邮箱登录开启失败，帐号已存在
	 */
	public static final String EMAIL_LOGIN_OPEN_FAIL = "40158";

	/**
	 * 帐号已绑定QQ
	 */
	public static final String ACCOUNT_IS_BIND_QQ = "40159";

	/**
	 * 帐号已绑定微信
	 */
	public static final String ACCOUNT_IS_BIND_WECHAT = "40160";

	/**
	 * 帐号未绑定QQ
	 */
	public static final String ACCOUNT_IS_NOT_BIND_QQ = "40161";

	/**
	 * 帐号未绑定微信
	 */
	public static final String ACCOUNT_IS_NOT_BIND_WECHAT = "40162";

	/**
	 * 该QQ已被绑定过
	 */
	public static final String QQ_IS_BIND_ACCOUNT = "40163";

	/**
	 * 该微信号已被绑定过
	 */
	public static final String WECHAT_IS_BIND_ACCOUNT = "40164";

	/**
	 * 头像地址不能为空
	 */
	public static final String HEAD_PORTRAIT_IS_NULL = "40165";

	/**
	 * 昵称长度限制为4-20字符，中文为2个字符
	 */
	public static final String THE_ACCOUNT_LENGTH_JUST_BETWEEN_FOUR_AND_TWENTY = "40168";

	/**
	 * 该账号未注册或未开启手机号码登录
	 */
	public static final String ACCOUNT_IS_NOT_FOUND_OR_NOT_OPEN_MOBILE_LOGIN = "40169";

	/**
	 * 该账号未注册或未开启邮箱地址登录
	 */
	public static final String ACCOUNT_IS_NOT_FOUND_OR_NOT_OPEN_EMAIL_LOGIN = "40170";

	/** 一分钟之类，同一手机同一类型只能发送一条短信 */
	public static final String ONE_MINUTE_TIPS = "40171";

	/** {0}秒内只能获取一次验证码 */
	public static final String CODE_SECOUND_TIPS = "40198";

	/**
	 * 一个手机号码最多只能绑定5个帐号
	 */
	public static final String A_MOBILE_CAN_ONLY_BE_BINDING_FIVE_ACCOUNT = "40172";

	/**
	 * 一个邮箱地址最多只能绑定5个帐号
	 */
	public static final String A_EMAIL_CAN_ONLY_BE_BINDING_FIVE_ACCOUNT = "40173";

	/**
	 * 每天只能操作两次关闭
	 */
	public static final String YOU_CAN_OPERATION_TWO_TIMES_EVERYDAY = "40174";

	/**
	 * 身份证号码错误
	 */
	public static final String IDCARD_ERROR = "40175";

	/**
	 * 银行卡验证错误8次
	 */
	public static final String BANKCARD_ERROR_OUT_OF_EIGHT = "40176";

	/**
	 * 身份证号码验证错误8次
	 */
	public static final String IDCARD_ERROR_OUT_OF_EIGHT = "40177";

	/**
	 * 密码验证错误8次
	 */
	public static final String PASSWORD_ERROR_OUT_OF_EIGHT = "40178";

	/**
	 * 头像大小超过最大限制
	 */
	public static final String HEADPORTRAIT_OUT_OF_MEMORY = "40179";

	/**
	 * 您尚未设置密码，设置密码后才能关闭手机号登录
	 */
	public static final String COULD_SET_PASSWORD_WHEN_CLOSE_THE_MOBILE_LOGIN = "40180";

	/**
	 * 您尚未设置密码，设置密码后才能关闭邮箱登录
	 */
	public static final String COULD_SET_PASSWORD_WHEN_CLOSE_THE_EMAIL_LOGIN = "40181";

	/**
	 * 当前身份证未满18周岁,暂不能使用。
	 */
	public static final String YOU_ARE_UNDER_AGE = "40182";

	/**
	 * 昵称已被占用
	 */
	public static final String NICKNAME_IS_REGISTER = "40183";

	/**
	 * 昵称已修改过
	 */
	public static final String NICKNAME_IS_MODIFIED = "40184";

	/**
	 * 昵称不能为空
	 */
	public static final String NICKNAME_IS_NOT_NULL = "40185";

	/**
	 * 昵称支持中文、字母、数字、"_"的组合，4-20个字符
	 */
	public static final String NICKNAME_FORMAT_ERROR = "40186";

	/**
	 * 纯数字昵称不能超出9位
	 */
	public static final String NICKNAME_NOT_OUT_OF_NINE = "40187";

	/**
	 * 昵称不能为纯符号
	 */
	public static final String NICKNAME_IS_NOT_ALL_SYMBOL = "40188";

	/**
	 * 昵称长度限制为4-20字符，中文为2个字符
	 */
	public static final String NICKNAME_LENGTH_UNMATCHED = "40189";

	/**
	 * 该用户名已绑定手机号
	 */
	public static final String HAVE_SET_MOBILE = "40190";

	public static final String NOW_USEING_THE_MOBILE_LOGIN = "立即手机号免密登录";

	/**
	 * 该用户名已绑定邮箱地址
	 */
	public static final String HAVE_SET_EMAIL = "40191";

	public static final String NOW_USEING_THE_EMAIL_LOGIN = "立即邮箱地址免密登录";

	/**
	 * 该用户名第三方登录，立即使用QQ登录
	 */
	public static final String NOW_USEING_THE_QQ_LOGIN = "40192";

	/**
	 * 该用户名第三方登录，立即使用微信登录
	 */
	public static final String NOW_USEING_THE_WECHAT_LOGIN = "40193";

	/**
	 * 该帐号未开启，其它登录方式，开启失败
	 */
	public static final String ACCOUNT_HVAE_NOT_NOTHING_LOGIN_METHOD = "40194";

	/**
	 * 该用户名第三方登录，立即使用微博登陆
	 */
	public static final String NOW_USEING_THE_WEIBO_LOGIN = "40195";

	/**
	 * 此微博账号已被其它账户绑定
	 */
	public static final String WEIBO_IS_BIND_ACCOUNT = "40196";

	/**
	 * 该账户未绑定微博帐号
	 */
	public static final String ACCOUNT_IS_NOT_BIND_WEIBO = "40197";

	/**
	 * 当日验证码错误次数已达上限，账户已被禁用，请于次日再试
	 */
	public static final String VERIFY_ERR_COUNT_THREE = "40199";

	public static final String VERIFY_ERR_COUNT_EIGHT = "40200";

	public static final String VERIFY_ERR_COUNT_TEN = "40201";

	/******************************************* 活动页面提示 *************************************************/

	/**
	 * 账号未绑定手机号
	 */
	public static final String ACCOUNT_NOT_BIND_MOBILE = "41100";
	/**
	 * 银行卡号错误
	 */
	public static final String BANKCARD_ERROR_SERVICE = "40328";

	/**
	 * 交易编号错误
	 */
	public static final String TRANS_CODE_ERROR_SERVICE = "30325";
	/**
	 * 查询的开始日期错误
	 */
	public static final String TRANS_QUERY_STARTDATE_ERROR_SERVICE = "30326";
	/**
	 * 查询的结束日期错误
	 */
	public static final String TRANS_QUERY_ENDDATE_ERROR_SERVICE = "30327";
	/**
	 * 查询的开始日期大于结束日期
	 */
	public static final String TRANS_QUERY_DATE_ERROR_SERVICE = "30328";
	/**
	 * 彩期销售已截止
	 */
	public static final String LOTTERY_ISSUE_IS_ENDING_SALE_SERVICE = "40308";

	/**
	 * 彩期暂停销售
	 */
	public static final String LOTTERY_ISSUE_IS_STOP_SALE_SERVICE = "40309";
	/**
	 * 彩期暂未开售
	 */
	public static final String LOTTERY_ISSUE_IS_NOT_START_SALE_SERVICE = "40310";
	/**
	 * 彩种销售已截止
	 */
	public static final String LOTTERY_TYPE_IS_ENDING_SALE_SERVICE = "40279";

	/**
	 * 彩种停止销售
	 */
	public static final String LOTTERY_TYPE_IS_STOP_SALE_SERVICE = "40311";

	/**
	 * 彩种暂停销售
	 */
	public static final String LOTTERY_TYPE_IS_SUSPEND_SALE_SERVICE = "40357";

	/**
	 * 请勿重复操作
	 */
	public static final String OPERATION_NO_REPEAT_SERVICE = "40358";

	/**
	 * 对阵销售已截止
	 */
	public static final String AGAINST_IS_ENDING_SALE_SERVICE = "40295";

	/**
	 * 彩种不存在
	 */
	public static final String LOTTERY_TYPE_NOT_EXIST_SERVICE = "40298";

	/**
	 * 彩期不存在
	 */
	public static final String LOTTERY_ISSUE_NOT_EXIST_SERVICE = "40299";

	/**
	 * 超投注倍数最高限制
	 */
	public static final String MULTIPLE_LIMIT_SERVICE = "40263";
	/**
	 * 超单期单方案最高限制额度
	 */
	public static final String SINGLE_ISSUE_ACCOUNT_LIMIT_SERVICE = "40264";
	/**
	 * 超拆票总数最高限度
	 */
	public static final String SPLIT_COUNT_LIMIT_SERVICE = "40265";
	/**
	 * 根据投注内容，最高串关数不允许
	 */
	public static final String PASSWAY_LIMIT_SERVICE = "40266";
	/**
	 * 根据投注内容，过关方式不允许
	 */
	public static final String PASSWAY_PERMIT_SERVICE = "40267";
	/**
	 * 投注总注数与计算不符
	 */
	public static final String BET_NUM_CAL_SERVICE = "40268";
	/**
	 * 投注总金额与计算不符
	 */
	public static final String BET_AMOUNT_CAL_SERVICE = "40269";
	/**
	 * 过关方式内容不合法
	 */
	public static final String PASS_CONTENT_ILLEGAL_SERVICE = "40270";
	/**
	 * 过关方式格式不合法
	 */
	public static final String PASS_FORMAT_ILLEGAL_SERVICE = "40271";
	/**
	 * 投注内容与玩法不符
	 */
	public static final String BET_CONTENT_ILLEGAL_WITH_PASSWAY_SERVICE = "40272";
	/**
	 * 超单期单方案最高限制场次
	 */
	public static final String SINGLE_ISSUE_GAME_NUM_LIMIT_SERVICE = "40273";
	/**
	 * 投注方案包含不合法子玩法!
	 */
	public static final String LOTTERY_CHILD_ILLEGAL_SERVICE = "40274";

	/**
	 * 系统编号的场次不能超过销售截止时间
	 */
	public static final String SYSTEM_CODE_IS_STOP_SALE_SERVICE = "40275";
	/**
	 * 最高投注注数限制
	 */
	public static final String BET_NUM_LIMIT_SERVICE = "40276";
	/**
	 * 投注内容不合法
	 */
	public static final String BET_CONTENT_ILLEGAL_SERVICE = "40277";

	/**
	 * 该彩种没配置注数和倍数
	 */
	public static final String LOTTERY_BETING_CONFIG_NOT_EXIST_SERVICE = "40280";
	/**
	 * 彩种订单金额超限制
	 */
	public static final String LOTTERY_ORDER_AMOUNT_LIMIT_SERVICE = "40281";
	/**
	 * 彩种订单详情注数超限制
	 */
	public static final String LOTTERY_ORDER_DETAIL_BETNUM_LIMIT_SERVICE = "40282";
	/**
	 * 彩种订单详情倍数超限制
	 */
	public static final String LOTTERY_ORDER_DETAIL_MULTIPLE_LIMIT_SERVICE = "40283";
	/**
	 * 订单总金额与订单详情总金额不一致
	 */
	public static final String ORDER_AMOUNT_NOT_EQUAL_ORDER_DETAIL_AMOUNT = "40284";
	/**
	 * 大小彩种关系验证不合法
	 */
	public static final String LOTTERY_CODE_CHILD_CODE_ILLEGAL_SERVICE = "40286";
	/**
	 * 方案限制条目数不存在
	 */
	public static final String ORDER_DETAIL_CTL_BETNUM_NOT_EXIST_SERVICE = "40287";
	/**
	 * 方案条目数超限制
	 */
	public static final String ORDER_DETAIL_BETNUM_LIMIT_SERVICE = "40288";
	/**
	 * 方案详情投注解析注数与传参注数不符
	 */
	public static final String ORDER_DETAIL_BETNUM_NOT_EQUAL_PARAM_BET_NUM_SERVICE = "40293";
	/**
	 * 方案详情投注解析倍数与传参倍数不一致
	 */
	public static final String ORDER_DETAIL_MULTIPLE_NOT_EQUAL_PARAM_MULTIPLE_SERVICE = "40318";
	/**
	 * 方案详情投注内容倍数或传参倍数不合法
	 */
	public static final String ORDER_DETAIL_MULTIPLE_IS_ILLEGAL_SERVICE = "40319";
	/**
	 * 方案详情金额、倍数、注数计算关系不符
	 */
	public static final String ORDER_PARAM_CAL_NOT_EQUAL_SERVICE = "40297";
	/**
	 * 子玩法停止销售
	 */
	public static final String LOTTERY_CHILD_CODE_IS_STOP_SALE_SERVICE = "40302";

	/**
	 * 撤单彩期不存在或不符合撤单条件
	 */
	public static final String REPEAL_ISSUE_CAN_NOT_FIND = "30115";

	/**
	 * 赛事不允许投注
	 */
	public static final String AGAINST_MATCH_IS_ILLEGAL_SERVICE = "40303";

	/**
	 * 未支付订单数超限制
	 */
	public static final String ORDER_NOT_PAY_COUNT_BEYONG = "40312";

	/**
	 * 包含子玩法的销售状态不合法
	 */
	public static final String LOTTERY_CHILD_CODE_STATUS_IS_ILLEGAL_SERVICE = "40313";

	/**
	 * 单个方案超赛事场数最高限制：15
	 */
	public static final String SINGLE_PLAN_BET_MATCH_LIMIT_SERVICE = "40314";

	/**
	 * 赛事编号传参不合法
	 */
	public static final String SYSTEM_CODE_PARAM_ILLEGAL_SERVICE = "40315";

	/**
	 * 重置redis缓存有效时间异常
	 */
	public static final String RESET_REDIS_EXCEPTION_SERVICE = "40316";

	/**
	 * 已过注数或倍数规定提前时间限制
	 */
	public static final String PRE_BUY_BETNUM_LIMIT_SERVICE = "40317";
	/**
	 * 订单总金额超限制
	 */
	public static final String ORDER_AMOUNT_LIMIT_SERVICE = "40320";
	/**
	 * 赛事不属于单关投注
	 */
	public static final String ORDER_DETAIL_SINGLE_PASS_ILLEGAL_SERVICE = "40321";
	/**
	 * 上传文件大小已超限制
	 */
	public static final String UPLOAD_FILE_SIZE_LIMIT_SERVICE = "40325";
	/**
	 * 上传文件类型不合法
	 */
	public static final String UPLOAD_FILE_TYPE_LIMIT_SERVICE = "40326";
	/**
	 * 用户转换格式传参不合法！
	 */
	public static final String USER_CHAR_TRAN_ILIEGAL_SERVICE = "40327";

	/**
	 * 转换字符不能重复
	 */
	public static final String SHIFTCONTENT_IS_REPEAT_SERVICE = "40500";
	/**
	 * 不能同时使用#和*占位
	 */
	public static final String BET_CONTENT_CONTAINS_NUMBER_SIGN_STAR_SERVICE = "40350";
	/**
	 * 彩种传参有误，请确认!
	 */
	public static final String LOTTERY_CODE_IS_ILIEGAL_SERVICE = "40351";
	/**
	 * 子玩法不存在，请确认！
	 */
	public static final String LOTTERY_CHILD_CODE_IS_ILIEGAL_SERVICE = "40352";

	/**
	 * 已过支付截止时间
	 */
	public static final String PAY_TIME_END = "40354";

	/**
	 * 信用卡有效期为空
	 */
	public static final String BANK_CARD_OVERDUE_IS_NULL_FIELD = "40334";
	/** 信用卡已过期 */
	public static final String CREDIT_CARD_EXPIRED = "40336";
	/** 信用卡有效期格式错误 */
	public static final String INVALID_CREDIT_CARD_FORMAT = "40337";
	/** 信用卡卡号错误 */
	public static final String INVALID_CREDIT_CARD_ERROR = "40338";
	/** 银行错误 */
	public static final String INVALID_BANK_ID_ERROR = "40339";
	/** 银行卡名称为空 */
	public static final String BANK_NAME_IS_NULL = "40340";
	/** 银行卡类型为空或错误 */
	public static final String BANK_TYPE_IS_NULL_OR_ERROR = "40341";
	/** 快捷支付参数错误 */
	public static final String OPEN_BANK_PARAM_ERROR = "40342";

	/** 消息设置无效数据 */
	public static final String MESSAGE_CENTER_PARAMS_ERROR = "40343";

	/**
	 * 卡号为空
	 */
	public static final String CARD_CODE_IS_NULL_FIELD = "40335";

	/**
	 * 银行卡不存在
	 */
	public static final String BANKCARD_IS_VALIDATION_SERVICE = "40329";
	/**
	 * 银行卡已经存在
	 */
	public static final String IS_USER_BANKCARD_EXIST_SERVICE = "40330";
	/**
	 * 添加数据失败
	 */
	public static final String ADD_DATA_FAIL_SERVICE = "30331";
	/**
	 * 已有设置默认银行卡
	 */
	public static final String DEFAULT_BANK_CARD_EXIST_SERVICE = "40332";
	/**
	 * 没有相关卡信息
	 */
	public static final String NOT_FIND_USER_CARD_SERVICE = "40333";

	/**
	 * 参数为空
	 */
	public static final String PARAM_IS_NULL_FIELD = "40400";

	/**
	 * 订单不存在
	 */
	public static final String ORDER_IS_NOT_EXIST = "40441";

	/**
	 * 订单状态不可取消
	 */
	public static final String ORDER_CAN_NOT_CANCEL = "40442";

	/**
	 * 没有查到对应的票信息
	 */
	public static final String TICKET_NOT_EXIST = "40443";

	/**
	 * 部分订单不是待支付订单或者不存在
	 */
	public static final String ORDER_NOT_EXIST_OR_INVALILD = "40444";

	/**
	 * 最大可查询一年的订单数据
	 */
	public static final String MAX_ORDER_LIST_NUM = "40445";

	/**
	 * 内容类型不存在
	 */
	public static final String BET_CONTENT_TYPE_FIELD = "40401";
	/**
	 * 投注内容与内容类型不匹配
	 */
	public static final String BET_CONTENT_NOT_MATCH = "40402";
	/**
	 * 该彩种目前暂停销售
	 */
	public static final String LOTTERY_STOP_SALE = "40511";

	/**
	 * 40698=投注方案:{0},已限号,限号号码:{1}
	 */
	public static final String BET_CONTENT_LIMIT = "40698";

	/*****************************
	 * 高频彩验证相关 start
	 ********************************************************/
	/**
	 * 选号有重复
	 */
	public static final String HIGH_BET_NUM_REPEAT = "40701";
	/**
	 * 选号个数不符合规则
	 */
	public static final String HIGH_BET_NUM_LENGTH = "40702";
	/**
	 * 包含限号内容
	 */
	public static final String HIGH_BET_NUM_LIMIT = "40703";
	/**
	 * 查询遗漏出错
	 */
	public static final String HIGH_QUERY_OMIT = "40704";
	/**
	 * 日期格式错误
	 */
	public static final String QUERY_DATE = "40705";
	/**
	 * 当前期不可销售
	 */
	public static final String CURRENT_ISSUE_NOT_SALE = "40706";
	/**
	 * 不是当前期
	 */
	public static final String NOT_CURRENT_ISSUE = "40707";
	/**
	 * 当前期为空
	 */
	public static final String CURRENT_ISSUE_EMPTY = "40708";
	/**
	 * 不支持此操作
	 */
	public static final String OPERATION_NOT_SUPPORTED = "40709";
	/**
	 * 遗漏类型:{0}不存在或不支持！
	 */
	public static final String QRY_FLAG_NOT_INVALID = "40710";
	/**
	 * 40711=追号期号超出范围！
	 */
	public static final String ISSUE_OVERDUE = "40711";
	/**
	 * 40712=追号期号有重复！
	 */
	public static final String ISSUE_REPEAT = "40712";

	public static final String OMIT_IS_NULL = "40713";
	/*****************************
	 * 高频彩验证相关 end
	 **********************************************************/

	/**
	 * 必传参数不能为空
	 */
	public static final String PARAM_NULL = "40000";
	/**
	 * 数据不存在
	 */
	public static final String DATA_NOT_EXIST = "40003";
	/**
	 * 上传失败：文件为空
	 */
	public static final String UPLOAD_NULL_FAIL = "40005";
	/**
	 * 上传失败：文件大小不能超过{0}
	 */
	public static final String UPLOAD_MAX_SIZE_FAIL = "40006";

	/**
	 * 上传失败
	 */
	public static final String UPLOAD_FAIL = "40007";
	/**
	 * 上传文件太频繁
	 */
	public static final String UPLOAD_MAX_PAGE_FAIL = "40008";
	/**
	 * 添加信息失败
	 */
	public static final String ADD_MESSAGE_FAIL = "40009";
	/**
	 * 操作信息太频繁
	 */
	public static final String ADD_MAX_MESSAGE_FAIL = "40010";

	/******************************** 订单详情流程消息模版start ****************************************************/
	/**
	 * 等待支付 2014-09-20 16:41 发起超级大乐透代购方案。出票截止时间09-20 19:55
	 */
	public static final String SUBMIT_ORDER = "40801";
	/**
	 * 支付失败 2014-09-20 16:41 订单支付失败，如有疑问请联系客服。
	 */
	public static final String PAY_FAIL = "40802";

	/**
	 * 未支付已过期 2014-09-20 16:41 订单未支付过期。
	 */
	public static final String NO_PAY_OVERDUE = "40803";

	/**
	 * 2014-11-09 20:45 方案正在等待出票。方案官方截止出票时间11-09 20:45:09 支付成功
	 */
	public static final String PAY_SUCCESS_IN_TIME = "40804";

	/**
	 * 2014-11-09 20:45 方案官方截止出票时间11-09 20:45:09 出票中
	 */
	public static final String TICKETING = "40805";

	/**
	 * 出票成功，等待开奖
	 */
	public static final String TICKET_SUCCESS = "40806";

	/**
	 * 出票失败
	 */
	public static final String TICKET_FIAL = "40807";

	/**
	 * 已中奖
	 */
	public static final String ORDER_WINNING = "40808";

	/**
	 * 没中奖
	 */
	public static final String ORDER_NO_WINNING = "40809";

	/**
	 * 已派奖
	 */
	public static final String ORDER_SENDED_MONEY = "40810";

	/**
	 * 出票失败, 已撤单
	 */
	public static final String CANCEL_ORDER = "40811";

	/**
	 * 单式上传日志 remark信息
	 */
	public static final String SINGLE_UPLOAD_LOG_MSG = "40812";

	/********** 追号状态 **********/

	/**
	 * 执行一期追号成功后
	 */
	public static final String ADD_ORDER_EXEC_ONE_SUCCESS = "40813";

	/**
	 * 执行一期追号失败后
	 */
	public static final String ADD_ORDER_EXEC_ONE_FAIL = "40814";

	/**
	 * 追号结束后
	 */
	public static final String CHASE_NUMBER_END = "40815";

	/**
	 * 中奖金额停追
	 */
	public static final String WINNING_MONEY_END = "40816";

	/**
	 * 中奖奖项停追
	 */
	public static final String WINNING_PRIZE_END = "40817";

	/**
	 * 用户撤单
	 */
	public static final String USER_CANCEL = "40818";

	/**
	 * 系统撤单
	 */
	public static final String SYSTEM_CANCEL = "40819";

	/**
	 * 追号订单-等待支付
	 */
	public static final String ADD_ORDER_WAIT_PAY = "40820";

	/**
	 * 追号订单-支付成功
	 */
	public static final String ADD_ORDER_PAY_SUCCESS = "40821";

	/**
	 * 招募中
	 */
	public static final String ORDER_FLOW_RECRUITMENT = "40822";

	/**
	 * 合买未满员流产
	 */
	public static final String ORDER_FLOW_ABORTION_NOT_ENOUGH = "40823";
	
	/**
	 * 北京单场、胜负过关出票成功，等待开奖
	 */
	public static final String TICKET_SUCCESS_BJDC = "40824";

	/******************************** 订单详情流程消息模版end ****************************************************/

	public static final String USERID_IS_NULL_FIELD = "30999";
	/*****************************
	 * 任务验证提示 结尾 以_SERVICE结尾
	 ********************************************************/

	public static final String PARTNERNO_IS_NULL_FIELD = "30998";

	public static final String PARTNERNO_NOT_EXISTS = "30997";

	/******************************** HTTP异常返回信息begin ****************************************************/

	/**
	 * 2014-11-09 20:45 中心于19日9点开始出票。方案官方截止出票时间11-09 20:45:09 支付成功,不在出票时间内
	 */
	public static final String NOT_FOUND_VIEW_HTTP_ERROR_CODE = "404";

	/************************ 代理系统接口异常返回开始 **********************/
	public static final String RUNTIME_HTTP_ERROR_CODE = "31000";
	public static final String USER_ID_IS_NULL_HTTP_ERROR_CODE = "31010";
	public static final String RECHARGE_AMOUNT_IS_NULL_HTTP_ERROR_CODE = "31011";
	public static final String AGENT_CODE_IS_NULL_HTTP_ERROR_CODE = "31012";
	public static final String AGENT_TRADE_NO_IS_NULL_HTTP_ERROR_CODE = "31013";
	public static final String RSA_ENCRYPT_ERROR_CODE = "31014";
	public static final String USER_NOT_FOUND_HTTP_ERROR_CODE = "31015";
	public static final String USER_IS_NOT_AGENTUSER_HTTP_ERROR_CODE = "31016";
	/************************ 代理系统接口异常返回结束 **********************/

	/******************************** HTTP异常返回信息end ****************************************************/
	/************************** 活动start *********************************/
	/**
	 * 您还没有充值哦，单笔充值金额需≥20元才可获得红包哦！
	 */
	public static final String FIRST_REC_SEND_NO_RECHARGE = "40950";
	/**
	 * 您已经充值了哦，不符合活动要求。感谢您的参与，祝您中奖！
	 */
	public static final String FIRST_REC_SEND_HAS_RECHARGE = "40951";
	/**
	 * 本活动每位用户仅限参与一次，您已经参与过活动了!感谢您的参与，祝您中奖！
	 */
	public static final String FIRST_REC_SEND_HAS_SEND_BY_NAME = "40952";
	/**
	 * 您已经有账户参与过该活动了,感谢您的参与，祝您中奖！
	 */
	public static final String FIRST_REC_SEND_HAS_SEND_BY_FHONE = "40953";
	/**
	 * 真实姓名为“刘惠”的已有多个用户参与活动，为了防止恶意用户套现，请联系客服人员核实信息后再给您赠送红包。感谢您的配合！
	 */
	public static final String FIRST_REC_SEND_HAS_MORE_SEND_BY_NAME = "40954";
	/**
	 * 非常遗憾，今日的红包已派完！感谢您的参与，祝您中奖！
	 */
	public static final String FIRST_REC_SEND_HAS_NO_ACTIVITY = "40955";
	/**
	 * 该活动已结束，感谢您的关注！
	 */
	public static final String FIRST_REC_ACTIVITY_END = "40956";

	/**
	 * 您已经有账户充值过了哦，不符合活动要求。感谢您的参与，祝您中奖！
	 */
	public static final String FIRST_REC_SEND_HAS_OTHER_RECHARGE = "40957";
	/**
	 * 该活动未开始，感谢您的关注！
	 */
	public static final String FIRST_REC_ACTIVITY_START = "40958";

	// ------------------------
	//
	//
	//
	// 竟足首单立减活动
	/**
	 * 活动未开始，敬请期待！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_NO_START = "41001";

	/**
	 * 该活动已过期，感谢您的关注！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_OVERDUE = "41002";

	/**
	 * 本活动每位用户仅限参与一次，您已参与了活动！将按原价进行购买：本次投注金额{0}元，祝您中奖！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_IS_JOIN_ONE = "41003";

	/**
	 * 您已经有账户参与过该活动了，将按原价进行购买：本次投注金额{0}元，祝您中奖！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_HAVA_ACCOUNT_JOIN = "41004";

	/**
	 * 您已经购买过竞彩足球了，将按原价进行购买：本次投注金额{0}元，祝您中奖！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_HAVE_BUY = "41005";

	/**
	 * 您已经有其他账户购买过竞彩足球了，将按原价进行购买：本次投注金额{0}元，祝您中奖！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_HAVA_ACCOUNT_BUY = "41006";

	/**
	 * 真实姓名为“{0}”的已有多个用户参与活动，为了防止恶意用户套现，请联系客服！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_OTHER_ACCOUNT_JOIN_IN = "41007";

	/**
	 * 您本次活动有未付款的订单，请您尽快支付！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_HAVE_NO_PAY = "41008";

	/**
	 * 您有其他账户参加本活动的未付款订单，请您尽快登录并支付！
	 */
	public static final String FOOTBALL_FIRST_DISCOUNT_OTHER_ACCOUNT_NO_PAY = "41009";

	/**
	 * 活动信息不存在！
	 */
	public static final String FOOTBALL_FIRST_ACTIVITY_NOT_EXIST = "41010";

	/**
	 * 竟足首单立减活动订单倍数不支持！
	 */
	public static final String FOOTBALL_FIRST_ORDER_MULTIPLENUM_IS_NOT_SUPPORT = "41011";

	/**
	 * 竟足首单立减活动只支持竞彩足球！
	 */
	public static final String FOOTBALL_FIRST_ORDER_LOTTERY_CODE_IS_NOT_SUPPORT = "41012";

	/**
	 * 竟足首单立减活动只支持竞彩足球2串1！
	 */
	public static final String FOOTBALL_FIRST_ORDER_BUNCH_IS_NOT_SUPPORT = "41013";

	/**
	 * 竟足首单立减活动只支持代购！
	 */
	public static final String FOOTBALL_FIRST_ORDER_BUY_TYPE_IS_NOT_SUPPORT = "41014";

	/**
	 * 竟足首单立减活动只支持投注两场赛事！
	 */
	public static final String FOOTBALL_FIRST_ORDER_TWO_MATCH = "41015";

	/**
	 * 竟足首单立减活动订单明细不合法！
	 */
	public static final String FOOTBALL_FIRST_ORDER_DETAIL = "41016";

	/**
	 * 您已参加本活动，活动红包下发到您的红包账户，您可通过本页面原价购买，付款页面可使用该红包！
	 */
	public static final String FOOTBALL_FIRST_ORDER_TICKET_FAIL = "41017";

	/**
	 * 您有其他账户已参加本活动，活动红包已下发到对应账户的红包账户，请您尽快登录使用！
	 */
	public static final String FOOTBALL_FIRST_HAVE_ACCOUNT_ORDER_TICKET_FAIL = "41018";

	// 1分钱购彩活动
	/**
	 * 活动投注只能选1注号码！
	 */
	public static final String YFGC_ONLY_ONE_BET = "41101";
	/**
	 * 本活动每位用户仅限参与一次,您已参与活动了!将按原价进行购买：本次投注金额{0}元,祝您中奖！
	 */
	public static final String YFGC_USER_PARTICIPATED = "41102";
	/**
	 * 您已经有账户参与过该活动了,将按原价进行购买：本次投注金额{0}元,祝您中奖！
	 */
	public static final String YFGC_ACCOUNT_PARTICIPATED = "41103";
	/**
	 * 您本次活动有未付款的订单，请您尽快支付！
	 */
	public static final String YFGC_USER_NOTPAY = "41104";
	/**
	 * 您有其他账户参加本活动的未付款订单，请您尽快登录并支付！
	 */
	public static final String YFGC_ACCOUNT_NOTPAY = "41105";
	/**
	 * 您已经购买过11选5了,将按原价进行购买：本次投注金额{0}元，祝您中奖！
	 */
	public static final String YFGC_11X5_USER_PARTICIPATED = "41106";
	/**
	 * 您已经有其它账户购买过11选5了,将按原价进行购买：本次投注金额{0}元,祝您中奖！
	 */
	public static final String YFGC_11X5_ACCOUNT_PARTICIPATED = "41107";
	/**
	 * 真实姓名为"{0}"的已有多个用户参与活动，为了防止恶意用户套现，请联系客服！
	 */
	public static final String YFGC_10_PARTICIPATED = "41108";
	/**
	 * 41109=活动只支持PC和H5端！
	 */
	public static final String YFGC_PLATFORM = "41109";
	/**
	 * 41110=活动只支持广东十一选五！
	 */
	public static final String YFGC_LOTTERY = "41110";
	/**
	 * 41111=活动只支持广东十一选五和江西11任八玩法！
	 */
	public static final String YFGC_LOTTERY_CHILD = "41111";
	/**
	 * 41112=活动只支持购买1期,2期或3期！
	 */
	public static final String YFGC_ISSUE_RANGE = "41112";
	/**
	 * 41113=追号列表与追号期数不一致！
	 */
	public static final String YFGC_ISSUE_LIST = "41113";
	/**
	 * 41114=活动投注追号类型只支持永追！
	 */
	public static final String YFGC_STOP_TYPE = "41114";
	/**
	 * 一分钱购彩不容许撤单
	 */
	public static final String YFGC_NOT_ALLOW_CANCEL = "41115";
	/**
	 * 追号套餐活动不容许撤单
	 */
	public static final String HD_NOT_ALLOW_CANCEL = "41116";

	/**
	 * 渠道判断不通过
	 */
	public static final String AWAED_NO_CHANNEL = "41201";
	/**
	 * 本活动每位用户仅限参与一次，您已经参与过抽奖了!感谢您的参与，祝您中奖！
	 */
	public static final String AWARD_IS_HAS_AWARD = "41202";
	/**
	 * 您已经参与过抽奖了哦，获得了{0}的机会！
	 */
	public static final String AWARD_IS_DO_ACTIVITY = "41203";
	/**
	 * 本活动每位用户仅限参与一次，您已经参与过抽奖了!感谢您的参与，祝您中奖！
	 */
	public static final String AWARD_IS_DO_AWARD = "41204";
	/**
	 * 您已经有账户参与过抽奖了哦,感谢您的参与，祝您中奖！
	 */
	public static final String AWARD_OTHER_USER_DO = "41205";
	/**
	 * 常遗憾，今日奖品已抽完，明天再来参与吧！
	 */
	public static final String AWARD_HAS_DONE_TODAY = "41206";
	/**
	 * 恭喜您，抽中了{0}的机会哦！
	 */
	public static final String AWARD_HAS_DO_ACTIVITY = "41207";
	/**
	 * 恭喜您，抽中了{0}
	 */
	public static final String AWARD_HAS_DO_AWARD = "41208";
	/**
	 * 很遗憾！您没有抽中活动奖品！买一注彩票试试运气吧！大奖在等着您~！
	 */
	public static final String AWARD_HAS_NOT_ACTIVITY = "41209";

	/************************** 活动end ***********************************/

	/************************** 抄单begin **********************************/

	/**
	 * 抄单订单号已经存在
	 */
	public static final String ORDER_COPY_ISSUE_TRUE = "42001";

	/**
	 * 抄单设置可见类型
	 */
	public static final String ORDER_COPY_ORDER_VISIBLE_TYPE = "42002";

	/**
	 * 抄单设置佣金比例
	 */
	public static final String ORDER_COPY_COMMISSION_RATE = "42003";

	/**
	 * 抄单不能是单式上传方案
	 */
	public static final String ORDER_COPY_IS_SINGLE = "42004";

	/**
	 * 抄单的订单必须已经支付
	 */
	public static final String ORDER_COPY_IS_PAY = "42005";

	/**
	 * 订单必须为胜平负/让球胜平负玩法
	 */
	public static final String ORDER_COPY_IS_SPF_OR_RSPF = "42006";

	/**
	 * 订单必须出票才能跟单
	 */
	public static final String ORDER_COPY_IS_NOT_TICK = "42007";

	/**
	 * 订单不存在
	 */
	public static final String ORDER_COPY_IS_NOT_FIND = "42008";

	/**
	 * 抄单的订单必须是普通代购
	 */
	public static final String ORDER_COPY_IS_NOT_BUY = "42009";

	/**
	 * 跟单不能够抄单
	 */
	public static final String ORDER_COPY_NOT_FOLLOW = "42010";

	/**
	 * 发单支付时间必须大于当前时间
	 */
	public static final String ORDER_COPY_PAY_TIME_GT_NOW = "42011";

	/**
	 * 发单不是竞技彩
	 */
	public static final String ORDER_COPY_IS_NOT_SPORT_LOTTERY = "42012";

	/**
	 * 竞彩篮球只能是胜负玩法
	 */
	public static final String ORDER_COPY_IS_NOT_JCZQ_SF = "42013";

	/**
	 * 回报率必须大于50%
	 */
	public static final String ORDER_COPY_GT_FIFTY = "42014";

	/**
	 * 订单不存在
	 */
	public static final String ORDER_COPY_IS_NOT_BY_USER = "42015";

	/**
	 * 订单没有回报率
	 */
	public static final String ORDER_COPY_IS_NOT_BY_MAX_BONUS = "42016";

	/**
	 * 订单没有回报率
	 */
	public static final String ORDER_COPY_IS_NULL = "42017";

	/**
	 * 方案出票失败
	 */
	public static final String ORDER_COPY_TICKETED_ERROR = "42018";

	/**
	 * 方案出票失败
	 */
	public static final String ORDER_COPY_RECOMMEND_REASON_LENGTH = "42019";
	/************************** 抄单end ***********************************/

	/************************ 追号活动 *********************************/
	/***
	 * 当前彩种不参与活动
	 */
	public static final String LOTTO_NO_JOIN_ACTIVITY = "41301";
	/***
	 * 当前彩种子玩法不参与活动
	 */
	public static final String LOTTO_CHILD_NO_JOIN_ACTIVITY = "41302";
	/***
	 * 大乐透追加不参与活动
	 */
	public static final String DLT_ADD_NO_JOIN_ACTIVITY = "41303";
	/***
	 * 当前平台不参与活动
	 */
	public static final String PLATFORM_NO_JOIN_ACTIVITY = "41304";
	/***
	 * 对不起，您已购买过{0}期套餐了
	 */
	public static final String ADDED_HAS_JOIN_ACTIVITY = "41305";

	/************************ 倍投立减 ****************************************/
	/***
	 * 订单中包含多个过关方式,不参与活动
	 */
	public static final String ORDER_HAS_TWO_PASSTYPE = "41401";
	/***
	 * 投注的子玩法不参与活动
	 */
	public static final String CHIRD_NOT_JOIN_ACTIVITY = "41402";
	/***
	 * 投注的订单中包含多个子玩法,不参与活动
	 */
	public static final String ORDER_HAS_TWO_CHIRD = "41403";
	/***
	 * 投注方案中的玩法不参与活动
	 */
	public static final String WF_NOT_JOIN_ACTIVITY = "41404";

	/***
	 * 合买不参与活动
	 */
	public static final String JOIN_BUY_NOT_JOIN_ACTIVITY = "41405";

	/***
	 * 投注方案中的倍数不参与活动
	 */
	public static final String NUL_NOT_JOIN_ACTIVITY = "41406";
	/***
	 * 有一笔订单待支付
	 */
	public static final String HAS_ACTIVITY_NOT_BUY = "41407";

	/************************ 新用户活动 ****************************************/
	/**
	 * 本活动每位用户仅限参与{0}次，您已经参与过活动了！
	 */
	public static final String ACTIVITY_NEW_USER_EXIST_USER_ID = "41501";
	/**
	 * 本活动每个手机号码仅限参与{0}次，您已经参与过活动了！
	 */
	public static final String ACTIVITY_NEW_USER_EXIST_MOBILE = "41502";
	/**
	 * 本活动每个身份证仅限参与{0}次，您已经参与过活动了！
	 */
	public static final String ACTIVITY_NEW_USER_EXIST_ID_CARD = "41503";
	/**
	 * 真实姓名为“{0}”的已有多个用户参与活动，为了防止恶意用户套现，请联系客服！
	 */
	public static final String ACTIVITY_NEW_USER_EXIST_ACTUAL_NAME = "41504";
	/**
	 * 非常遗憾，{0}已经送完！感谢您的参与，祝您中奖！
	 */
	public static final String ACTIVITY_NEW_USER_DONE = "41505";
	/**
	 * 对不起，您的手机号码或身份证绑定多个账户，不能参与本活动！
	 */
	public static final String ACTIVITY_NEW_USER_EXIST_MULTI_ACCOUNT = "41506";
	/***
	 * 对不起，您没有符合绑定活动需要的银行卡，不能参与本活动！
	 */
	public static final String ACTIVITY_NEW_USER_BANK_CARD_NOT_ONE = "41507";
	/**
	 * 对不起，该活动不允许自选投注
	 */
	public static final String ACTIVITY_NEW_USER_NOT_HAND_LOTTO = "41520";
	/**
	 * 您还有未选择的投注内容
	 */
	public static final String ACTIVITY_NEW_USER_PARAM_ORDER_DETAIL_LOST = "41521";
	/**
	 * 投注方案重复
	 */
	public static final String ACTIVITY_NEW_USER_PARAM_ORDER_DETAIL_DUPLICATION = "41522";
	/**
	 * 投注方案不存在
	 */
	public static final String ACTIVITY_NEW_USER_PARAM_ORDER_DETAIL_NOT = "41523";

	/**
	 * 非领取活动
	 */
	public static final String ACTIVITY_NEW_USER_NOT_TAKE = "41524";

	/********************************** cdk兑换红包活动 *********************************************/
	public static final String CDK_IS_ERR = "41408";

	public static final String CDK_FORMAT_IS_ERROR = "41409";

	public static final String NO_MOBILE_AND_IDCARD = "41410";

	public static final String THE_CDK_IS_USED = "41411";

	public static final String YOU_JUST_EXCHANGE_THE_CDK = "41412";

	public static final String NO_MOBILE = "41413";

	public static final String NO_CERTIFICATION = "41414";

	public static final String CDK_IS_NOT_FIND = "41415";
	public static final String CDK_IS_OVERTIME = "41416";
	/**
	 * 投注内容个数不匹配
	 */
	public static final String CDK_PLAN_CONTENT_NOT_MATCH = "41417";

	/********************************** 世界杯冠军竞猜活动 *********************************************/
	/**
	 * 您已经有账户参与过该活动了,感谢您的参与，您还可以参与世界杯购彩！
	 */
	public static final String ACTIVITY_CHP_OTHER_JOIN = "41801";

	/**
	 * 非常遗憾您的竞猜的{0}队，已止步于{1}，被淘汰，您可以继续竞猜！
	 */
	public static final String ACTIVITY_CHP_OUT_MATCH = "41802";

	/**
	 * 您只能竞猜正在比赛中的赛事！
	 */
	public static final String ACTIVITY_CHP_MATCH_JOIN = "41803";
	/**
	 * 非常抱歉您的贡献值不足支持再次竞猜？
	 */
	public static final String ACTIVITY_CHP_HAS_NOT_AUTH = "41804";
	/**
	 * 您已经竞猜的球队未淘汰，不能进行竞猜
	 */
	public static final String ACTIVITY_CHP_HAS_MATCH_JOIN = "41805";
	/**
	 * 查询球队未淘汰不能进行开奖
	 */
	public static final String ACTIVITY_CHP_CANNOT_OPEN = "41806";
	/**
	 * 查询球队未开奖不能进行派奖
	 */
	public static final String ACTIVITY_CHP_CANNOT_SEND = "41807";
	/**
	 * 查询球队已派奖不能进行开奖
	 */
	public static final String ACTIVITY_CHP_HAS_SEND_CANNOT_OPEN = "41808";
	/********************************** 帮助中心 *********************************************/
	/**
	 * 您已评价过该文章，请勿重复评价！
	 */
	public static final String HELP_ABLE_REPEAT = "41600";

	/********************************** 代理系统 *********************************************/
	/**
	 * 未获取到代理用户信息
	 */
	public static final String AGENT_INFO_NOT_FOUND_ERROR = "45000";
	/**
	 * 提现金额不能为空
	 */
	public static final String AGENT_TAKEN_AMOUNT_IS_NULL = "45001";
	/**
	 * 钱包中的金额不够当前提现
	 */
	public static final String AGENT_TAKEN_AMOUNT_IS_ERROR = "45002";
	/**
	 * 劳务所得税计算有误
	 */
	public static final String AGENT_TAX_IS_ERROR = "45003";
	/**
	 * 代理钱包金额有误
	 */
	public static final String AGENT_WALLET_AMOUNT_IS_ERROR = "45004";
	/**
	 * 申请的提现的金额不能低于10元
	 */
	public static final String AGENT_LOWEST_TAKEN_AMOUNT_IS_ERROR = "45005";
	/**
	 * 充值账号不能为空
	 */
	public static final String AGENT_RECHARGE_ACCOUNT_IS_NULL = "45006";
	/**
	 * 充值账号不存在
	 */
	public static final String AGENT_RECHARGE_ACCOUNT_IS_ERROR = "45007";
	/**
	 * 您选择充值的账号与真实姓名不符，为避免充值错误，请重新确认再尝试
	 */
	public static final String AGENT_RECHARGE_ACCOUNT_REALNAME_IS_ERROR = "45008";
	/**
	 * 您选择充值的金额超出，请重新尝试。
	 */
	public static final String AGENT_RECHARGE_ACCOUNT_AMOUNT_IS_ERROR = "45009";
	/**
	 * 转账失败
	 */
	public static final String AGENT_TRANS_ACCOUNT_FAIL = "45010";
	/**
	 * 不能给自己转账
	 */
	public static final String AGENT_TRANS_ACCOUNT_ACCOUNT_ERROR = "45011";
	/**
	 * 修改账户金额失败
	 */
	public static final String AGENT_UPDATE_AMOUNT_ERROR = "45012";
	/**
	 * 结算金额不能为空
	 */
	public static final String AGENT_UPDATE_AMOUNT_IS_NULL = "45013";
	/**
	 * 代理用户信息已存在
	 */
	public static final String AGENT_INFO_EXIST = "45014";
	/**
	 * 每月仅限提现一次
	 */
	public static final String AGENT_TAKEN_COUNT_IS_ERROR = "45015";
	/**
	 * 仅支持借记卡提款
	 */
	public static final String AGENT_TAKEN_BANK_CARD_IS_ERROR = "45016";
	/**
	 * 当月已返佣
	 */
	public static final String AGENT_HAD_BACK_AMOUNT = "45017";
	/**
	 * 转账金额不能低于10元
	 */
	public static final String AGENT_TRANS_AMOUNT_IS_ERROR = "45018";

	/********************************** 积分兑换 *********************************************/
	/**
	 * 您输入的帐号不存在
	 */
	public static final String COOPERATE_CHANNEL_NOT_FOUND = "41700";
	/**
	 * 您输入的密码和账户名不匹配
	 */
	public static final String COOPERATE_CHANNEL_PASSWORD_ERROR = "41701";
	/**
	 * 您输入的密码和账户名不匹配已超10次，今天已不能再次尝试
	 */
	public static final String COOPERATE_CHANNEL_PASSWORD_ERROR_OVER = "41702";
	/**
	 * 您输入的帐号已禁用
	 */
	public static final String COOPERATE_CHANNEL_FORBID = "41703";
	/**
	 * 原密码输入不正确
	 */
	public static final String COOPERATE_CHANNEL_OLD_PASSOWRD_ERROR = "41705";
	/**
	 * 您的账户不是中介商户
	 */
	public static final String COOPERATE_CHANNEL_AGENCY_TYPE_ERROR = "41706";
	/**
	 * 您的账户没有权限查看渠道{0}
	 */
	public static final String COOPERATE_CHANNEL_AGENCY_AUTH_ERROR = "41707";

}
