package com.hhly.lottomsg.bo;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 用户信息数据返回实体类
 * @author zhouyang
 * @date 2017年2月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class UserInfoBO extends BaseBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自增id（即帐号id）
	 */
	@JsonProperty("u_id")
	private Integer id;
	
	/**
	 * 账号综合平台id
	 */
	@JsonProperty("acc_id")
	private String accountId;
	
	/**
	 * 帐户名
	 */
	@JsonProperty("acc")
	private String account;
	
	/**
	 * 账户状态
	 */
	@JsonProperty("acc_sts")
	private Short accountStatus;

	/**
	 * 禁用结束时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date forbitEndTime;
	
	/**
	 * 密码
	 */
	@JsonProperty("pwd")
	private String password;
	
	/**
	 * 密码随机码
	 */
	@JsonProperty("r_cd")
	private String rCode;
	
	/**
	 * 用户昵称
	 */
	@JsonProperty("nk_nm")
	private String nickname;
	
	/**
	 * 头像URL
	 */
	@JsonProperty("hd_url")
	private String headUrl;
	
	/**
	 * 头像状态	0：禁用，1：启用
	 */
	@JsonProperty("hd_sts")
	private Short headStatus;
	
	/**
	 * 手机号
	 */
	@JsonProperty("mob")
	private String mobile;
	
	/**
	 * 手机号是否认证	0：未认证，1：已认证
	 */
	@JsonProperty("mob_sts")
	private Short mobileStatus;
	
	/**
	 * 是否开启手机号登录	0：禁用，1：启用
	 */
	@JsonProperty("mob_log")
	private Short isMobileLogin;
	
	/**
	 * 电子邮箱
	 */
	@JsonProperty("em")
	private String email;

	/**
	 * 邮箱是否认证	0：未认证，1：已认证
	 */
	@JsonProperty("em_sts")
	private Short emailStatus;
	
	/**
	 * 是否开启邮箱登录	0：禁用，1：启用
	 */
	@JsonProperty("em_log")
	private Short isEmailLogin;
	
	/**
	 * 姓名
	 */
	@JsonProperty("re_nm")
	private String realName;
	
	/**
	 * 身份证号码
	 */
	@JsonProperty("id_c")
	private String idCard;
	
	/**
	 * 居住地址
	 */
	@JsonProperty("ads")
	private String address;
	
	/**
	 * 性别	1：男，2：女
	 */
	@JsonProperty("sex")
	private Short sex;
	
	/**
	 * 注册时间
	 */
	@JsonProperty("reg_tm")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date registerTime;

	/**
	 * 上次登录时间 
	 */
	@JsonProperty("log_tm")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date lastLoginTime;
	
	/**
	 * 渠道ID
	 */
	@JsonProperty("cha_id")
	private String channelId;
	
	/**
	 * 帐号ip地址
	 */
	@JsonProperty("ip")
	private String ip;
	
	/**
	 * 昵称是否修改过 0：都未修改，1：修改帐户名，2：修改昵称，3：都已修改
	 */
	@JsonProperty("is_upd")
	private Short accountModify;
	
	/**
	 * 缓存key，用来存取用户信息
	 */
	@JsonProperty("tk")
	private String token;
	
	/**
	 * 登录方式	1：手机号，2：邮箱，3：帐户名
	 */
	@JsonProperty("log_tp")
	private Short loginType;
	
	/**
	 * 验证是否通过	0：否，1：是
	 */
	@JsonProperty("vd_ps")
	private Short validatePass;

	/**
	 * 用户最近一次支付方式id 存银行卡id
	 */
	@JsonIgnore
	private Integer userPayId;
	
	/**
	 * 是否设置密码，0：否，1：是
	 */
	@JsonProperty("set_pwd")
	private Short isSetPassword;
	
	/**
	 * 账户余额
	 */
	@JsonProperty("u_wlt_blc")
	private Double userWalletBalance;
	
	/**
	 * 红包余额
	 */
	@JsonProperty("u_pk_blc")
	private Double redPackBalance;

	/**
	 * 彩金红包余额
	 */
	@JsonProperty("l_u_pk_blc")
	private Double lottoRedPackBalance;

	/**
	 * 可用余额
	 */
	@JsonProperty("use_blc")
	private Double usableBalance;
	
	/**
	 * 过期红包个数
	 */
	@JsonProperty("pst_d_ct")
	private Integer expireCount;

	/**
	 * 有效红包个数
	 */
	@JsonProperty("v_ct")
	private Integer validCount;
	
	/**
	 * 账户安全积分
	 */
	@JsonProperty("sf_intgl")
	private Integer safeIntegral;
	
	/**
	 * 绑定银行卡数量
	 */
	@JsonProperty("bk_ct")
	private Integer bankCount;

	/**
	 * 随机显示绑定的银行卡号
	 */
	@JsonProperty("bk_c")
	private String bankCard;
	
	/**
	 * 是否实名认证
	 */
	@JsonProperty("att_rn")
	private Short attestationRealName;

	/**
	 * qqopenId
	 */
	@JsonProperty("qq_open_id")
	private String qqOpenID;

	/**
	 * 新浪openId
	 */
	@JsonProperty("sina_open_id")
	private String sinaBlogOpenID;

	/**
	 * 百度openId
	 */
	@JsonProperty("baidu_open_id")
	private String baiduOpenID;

	/**
	 * 微信openId
	 */
	@JsonProperty("wx_open_id")
	private String wechatOpenID;
	
	/**
	 * 微信unionId
	 */
	@JsonProperty("wx_union_id")
	private String wechatUnionID;	

	/**
	 * 支付宝openId
	 */
	@JsonProperty("ali_open_id")
	private String alipayOpenID;

	/**
	 * 京东openId
	 */
	@JsonProperty("jd_open_id")
	private String jdOpenID;
	
	/**
	 * 渠道openid
	 */
	@JsonProperty("channel_open_id")
	private String channelOpenID;

	/**
	 * QQ昵称
	 */
	@JsonProperty("qq_nm")
	private String qqName;

	/**
	 * 微信昵称
	 */
	@JsonProperty("wx_nm")
	private String wechatName;

	/**
	 * 新浪微博昵称
	 */
	@JsonProperty("wb_nm")
	private String sinaName;

	/**
	 *是否绑定微信
	 */
	@JsonProperty("is_bd_wx")
	private Short bindWechat;

	/**
	 * 是否绑定QQ
	 */
	@JsonProperty("is_bd_qq")
	private Short bindQQ;

	/**
	 * 是否绑定微博
	 */
	@JsonProperty("is_bd_wb")
	private Short bindWB;

	/**
	 * 注册平台 1.web, 2.wap, 3.android, 4.ios
	 */
	@JsonProperty("pfm")
	private Short platform;

	/**
	 * 第三方帐号是第一次
	 */
	@JsonProperty("fst_reg")
	private Short fristRegister;
	@JsonIgnore
	private String userPayCardcode;//最后一次使用的银行卡号
	
	private List<PayBankcardBO> bankList;

	private List<BankCardDetailBO> bankCardDetailBOList;

	private List<UserModifyLogBO> modifyLogList;
	
	@JsonIgnore
	private Short msgMob = 1;
	@JsonIgnore
	private Short msgSite = 1;
	@JsonIgnore
	private Short msgApp = 1;
	@JsonIgnore
	private Short msgWechat = 1;
	@JsonIgnore
	private String mobNotDisturb = "23:00-08:00";
	@JsonIgnore
	private String appNotDisturb = "23:00-08:00";
    @JsonProperty("as")
	private String appNotDisturbStart;
    @JsonProperty("ae")
	private String appNotDisturbEnd;
	
	@JsonProperty("ss")
	private Integer switchStatus;
	
	/**
	 * 登录平台
	 */
	@JsonIgnore
	@JsonProperty("log_plat")
	private Short loginPlatform;
	
	@JsonIgnore
	private Integer userType;//用户类型
	@JsonIgnore
	private String agentCode;//代理编码
	
	/**
	 * 是否是代理, 0:否,1:是
	 */
	@JsonProperty("is_agent")
	private Short isAgent;
    
    public String getAppNotDisturbStart () {
        return appNotDisturbStart;
    }
    
    public void setAppNotDisturbStart (String appNotDisturbStart) {
        this.appNotDisturbStart = appNotDisturbStart;
    }
    
    public String getAppNotDisturbEnd () {
        return appNotDisturbEnd;
    }
    
    public void setAppNotDisturbEnd (String appNotDisturbEnd) {
        this.appNotDisturbEnd = appNotDisturbEnd;
    }
    
    public Integer getSwitchStatus () {
        return switchStatus;
    }
    
    public void setSwitchStatus (Integer switchStatus) {
        this.switchStatus = switchStatus;
    }
    
    public Short getMsgMob() {
		return msgMob;
	}

	public void setMsgMob(Short msgMob) {
		this.msgMob = msgMob;
	}

	public Short getMsgSite() {
		return msgSite;
	}

	public void setMsgSite(Short msgSite) {
		this.msgSite = msgSite;
	}

	public Short getMsgApp() {
		return msgApp;
	}

	public void setMsgApp(Short msgApp) {
		this.msgApp = msgApp;
	}

	public Short getMsgWechat() {
		return msgWechat;
	}

	public void setMsgWechat(Short msgWechat) {
		this.msgWechat = msgWechat;
	}

	public String getMobNotDisturb() {
		return mobNotDisturb;
	}

	public void setMobNotDisturb(String mobNotDisturb) {
		this.mobNotDisturb = mobNotDisturb;
	}

	public String getAppNotDisturb() {
		return appNotDisturb;
	}

	public void setAppNotDisturb(String appNotDisturb) {
		this.appNotDisturb = appNotDisturb;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserInfoBO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getrCode() {
		return rCode;
	}

	public void setrCode(String rCode) {
		this.rCode = rCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Short getHeadStatus() {
		return headStatus;
	}

	public void setHeadStatus(Short headStatus) {
		this.headStatus = headStatus;
	}

	public Short getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(Short mobileStatus) {
		this.mobileStatus = mobileStatus;
	}

	public Short getIsMobileLogin() {
		return isMobileLogin;
	}

	public void setIsMobileLogin(Short isMobileLogin) {
		this.isMobileLogin = isMobileLogin;
	}

	public Short getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Short emailStatus) {
		this.emailStatus = emailStatus;
	}

	public Short getIsEmailLogin() {
		return isEmailLogin;
	}

	public void setIsEmailLogin(Short isEmailLogin) {
		this.isEmailLogin = isEmailLogin;
	}

	public Short getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Short accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getForbitEndTime() {
		return forbitEndTime;
	}

	public void setForbitEndTime(Date forbitEndTime) {
		this.forbitEndTime = forbitEndTime;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getAccountModify() {
		return accountModify;
	}

	public void setAccountModify(Short accountModify) {
		this.accountModify = accountModify;
	}

	public Short getLoginType() {
		return loginType;
	}

	public void setLoginType(Short loginType) {
		this.loginType = loginType;
	}

	public Short getValidatePass() {
		return validatePass;
	}

	public void setValidatePass(Short validatePass) {
		this.validatePass = validatePass;
	}

	public Integer getUserPayId() {
		return userPayId;
	}

	public void setUserPayId(Integer userPayId) {
		this.userPayId = userPayId;
	}

	public Short getIsSetPassword() {
		return isSetPassword;
	}

	public void setIsSetPassword(Short isSetPassword) {
		this.isSetPassword = isSetPassword;
	}

	public List<PayBankcardBO> getBankList() {
		return bankList;
	}

	public void setBankList(List<PayBankcardBO> bankList) {
		this.bankList = bankList;
	}

	public List<BankCardDetailBO> getBankCardDetailBOList() {
		return bankCardDetailBOList;
	}

	public void setBankCardDetailBOList(List<BankCardDetailBO> bankCardDetailBOList) {
		this.bankCardDetailBOList = bankCardDetailBOList;
	}

	public Double getUserWalletBalance() {
		return userWalletBalance;
	}

	public void setUserWalletBalance(Double userWalletBalance) {
		this.userWalletBalance = userWalletBalance;
	}

	public Double getRedPackBalance() {
		return redPackBalance;
	}

	public void setRedPackBalance(Double redPackBalance) {
		this.redPackBalance = redPackBalance;
	}

	public Double getLottoRedPackBalance() {
		return lottoRedPackBalance;
	}

	public void setLottoRedPackBalance(Double lottoRedPackBalance) {
		this.lottoRedPackBalance = lottoRedPackBalance;
	}

	public Double getUsableBalance() {
		return usableBalance;
	}

	public void setUsableBalance(Double usableBalance) {
		this.usableBalance = usableBalance;
	}

	public Integer getExpireCount() {
		return expireCount;
	}

	public void setExpireCount(Integer expireCount) {
		this.expireCount = expireCount;
	}

	public Integer getValidCount() {
		return validCount;
	}

	public void setValidCount(Integer validCount) {
		this.validCount = validCount;
	}

	public Integer getSafeIntegral() {
		return safeIntegral;
	}

	public void setSafeIntegral(Integer safeIntegral) {
		this.safeIntegral = safeIntegral;
	}

	public Integer getBankCount() {
		return bankCount;
	}

	public void setBankCount(Integer bankCount) {
		this.bankCount = bankCount;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public Short getAttestationRealName() {
		return attestationRealName;
	}

	public void setAttestationRealName(Short attestationRealName) {
		this.attestationRealName = attestationRealName;
	}

	public String getQqOpenID() {
		return qqOpenID;
	}

	public void setQqOpenID(String qqOpenID) {
		this.qqOpenID = qqOpenID;
	}

	public String getSinaBlogOpenID() {
		return sinaBlogOpenID;
	}

	public void setSinaBlogOpenID(String sinaBlogOpenID) {
		this.sinaBlogOpenID = sinaBlogOpenID;
	}

	public String getBaiduOpenID() {
		return baiduOpenID;
	}

	public void setBaiduOpenID(String baiduOpenID) {
		this.baiduOpenID = baiduOpenID;
	}

	public String getWechatOpenID() {
		return wechatOpenID;
	}

	public void setWechatOpenID(String wechatOpenID) {
		this.wechatOpenID = wechatOpenID;
	}
	
	public String getWechatUnionID() {
		return wechatUnionID;
	}

	public void setWechatUnionID(String wechatUnionID) {
		this.wechatUnionID = wechatUnionID;
	}

	public String getAlipayOpenID() {
		return alipayOpenID;
	}

	public void setAlipayOpenID(String alipayOpenID) {
		this.alipayOpenID = alipayOpenID;
	}

	public String getJdOpenID() {
		return jdOpenID;
	}

	public void setJdOpenID(String jdOpenID) {
		this.jdOpenID = jdOpenID;
	}
	
	public String getChannelOpenID() {
		return channelOpenID;
	}

	public void setChannelOpenID(String channelOpenID) {
		this.channelOpenID = channelOpenID;
	}

	public String getQqName() {
		return qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getSinaName() {
		return sinaName;
	}

	public void setSinaName(String sinaName) {
		this.sinaName = sinaName;
	}

	public Short getBindWechat() {
		return bindWechat;
	}

	public void setBindWechat(Short bindWechat) {
		this.bindWechat = bindWechat;
	}

	public Short getBindQQ() {
		return bindQQ;
	}

	public void setBindQQ(Short bindQQ) {
		this.bindQQ = bindQQ;
	}

	public Short getBindWB() {
		return bindWB;
	}

	public void setBindWB(Short bindWB) {
		this.bindWB = bindWB;
	}

	public Short getPlatform() {
		return platform;
	}

	public void setPlatform(Short platform) {
		this.platform = platform;
	}

	public Short getFristRegister() {
		return fristRegister;
	}

	public void setFristRegister(Short fristRegister) {
		this.fristRegister = fristRegister;
	}

	public List<UserModifyLogBO> getModifyLogList() {
		return modifyLogList;
	}

	public void setModifyLogList(List<UserModifyLogBO> modifyLogList) {
		this.modifyLogList = modifyLogList;
	}

	public Short getLoginPlatform() {
		return loginPlatform;
	}

	public void setLoginPlatform(Short loginPlatform) {
		this.loginPlatform = loginPlatform;
	}

	public String getUserPayCardcode() {
		return userPayCardcode;
	}

	public void setUserPayCardcode(String userPayCardcode) {
		this.userPayCardcode = userPayCardcode;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public Short getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(Short isAgent) {
		this.isAgent = isAgent;
	}

}
