package com.hhly.lottomsg.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @desc 用户银行卡数据返回实体类
 * @author chenkangning
 * @date 2017年3月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class BankCardDetailBO extends BaseBO{

    
	private static final long serialVersionUID = -8370621989446106762L;

	/**
     * ID主键
     */
	@JsonProperty("p_id")
    private Integer id;

    /**
     * 用户id
     */
	@JsonProperty("u_id")
    private Integer userid;

    /**
     * 真实姓名
     */
	@JsonProperty("re_nm")
    private String realname;

    /**
     * 银行id
     */
	@JsonProperty("bk_id")
    private Integer bankid;

    /**
     * 开户行名称
     */
	@JsonProperty("bk_nm")
    private String bankname;

    /**
     * 是默认卡 0：否，1：是
     */
	@JsonProperty("is_df")
    private Short isdefault;

    /**
     * 是否开启快捷支付 0：否，1：是
     */
	@JsonProperty("op_bk")
    private Short openbank;

    /**
     * 省份
     */
	@JsonProperty("prvc")
    private String province;

    /**
     * 城市
     */
	@JsonProperty("ct")
    private String city;

    /**
     * 银行卡号
     */
	@JsonProperty("cc")
    private String cardcode;

    /**
     * 银行卡类型:1储蓄卡;2信用卡
     */
	@JsonProperty("bk_tp")
    private Short banktype;

    /**
     * 针对信用卡(有效期,年,月字串)
     */
	@JsonProperty("ov")
    private String overdue;

    /**
     * 是否绑定 0：否，1：是
     */
	@JsonProperty("bd_flg")
    private Short bindflag;

    /**
     * 针对信用卡(安全码)
     */
	@JsonProperty("sf_cd")
    private String safecode;

    /**
     *  ip地址
     */
	@JsonProperty("ip")
    private String ip;

    /**
     * null
     */
	@JsonProperty("ext")
    private String ext;

    /**
     * 更新时间
     */
	@JsonProperty("up_tm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 创建时间
     */
	@JsonProperty("ct_tm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 卡状态:0:删除;1:有效
     */
	@JsonProperty("sts")
    private Short status;
	
    @JsonProperty("ed_tm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    
    /**
     * 银行大logo
     */
    @JsonProperty("blg")
    private String blogo;
    
    /**
     * 银行小logo
     */
    @JsonProperty("slg")
    private String slogo;

    /**
     * 银行名称
     */
    @JsonProperty("nm")
    private String name;

    /**
     * 银行简称
     */
    @JsonProperty("c_nm")
    private String cName;

    /**
     * 银行编码
     */
    @JsonProperty("bk_code")
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Short getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Short isdefault) {
        this.isdefault = isdefault;
    }

    public Short getOpenbank() {
        return openbank;
    }

    public void setOpenbank(Short openbank) {
        this.openbank = openbank;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCardcode() {
        return cardcode;
    }

    public void setCardcode(String cardcode) {
        this.cardcode = cardcode;
    }

    public Short getBanktype() {
        return banktype;
    }

    public void setBanktype(Short banktype) {
        this.banktype = banktype;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public Short getBindflag() {
        return bindflag;
    }

    public void setBindflag(Short bindflag) {
        this.bindflag = bindflag;
    }

    public String getSafecode() {
        return safecode;
    }

    public void setSafecode(String safecode) {
        this.safecode = safecode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBlogo() {
        return blogo;
    }

    public void setBlogo(String blogo) {
        this.blogo = blogo;
    }

    public String getSlogo() {
        return slogo;
    }

    public void setSlogo(String slogo) {
        this.slogo = slogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
