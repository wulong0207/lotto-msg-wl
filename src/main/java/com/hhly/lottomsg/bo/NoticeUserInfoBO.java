package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.bo.NodeBaseBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.util.DateUtil;

/**
 * 
* @Description: 用户信息 
* @author HouXiangBao289
* @date 2017年6月21日 上午9:59:46 
* @version V1.0.0
 */
public class NoticeUserInfoBO extends NodeBaseBO{
	private Integer id;
	private String nickName="";
	private String accountName="";
	private String mobile="";
	private String actualName="";
	private String idNumber="";
	private String password="";
	private String bankCardCode="";
	private String userGradeName="";
	private Integer userGrade;
	private String gradeTime="";
	private String email="";
	private Date forbitEndTime;
	
	public NoticeUserInfoBO(){}
	
	public NoticeUserInfoBO(UserInfoBO user){
		this.id = user.getId();
		this.nickName = user.getNickname();
		this.accountName = user.getAccount();
		this.mobile = user.getMobile();
		this.actualName = user.getRealName();
		this.idNumber = user.getIdCard();
		this.password = user.getPassword();
		this.bankCardCode = user.getBankCard();
		this.email = user.getEmail();
		this.forbitEndTime = user.getForbitEndTime();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @Description 根据字段名获取对应值 
	 * @author HouXiangBao289
	 * @param name
	 * @return
	 */
	@Override
	public String getValueByName(String name){
		if("nickName".equals(name))
		{
			return nickName==null?"":nickName;
		}
		else if("id".equals(name))
		{
			return id.toString();
		}
		else if("accountName".equals(name))
		{
			return accountName==null?"":accountName;
		}
		else if("mobile".equals(name))
		{
			return mobile==null?"":mobile;
		}
		else if("actualName".equals(name))
		{
			return actualName==null?"":actualName;
		}
		else if("idNumber".equals(name))
		{
			return idNumber==null?"":idNumber;
		}
		else if("password".equals(name))
		{
			return password;
		}
		else if("email".equals(name))
		{
			return email==null?"":email;
		}
		else if("bankCardCode".equals(name))
		{
			if(bankCardCode == null){
				return "";
			}else{
				int startIndex = 0;
				if(bankCardCode.length() > 4){
					startIndex = bankCardCode.length() - 4;
				}
				return bankCardCode.substring(startIndex);
			}
			
			
		}
		else if("userGradeName".equals(name))
		{
			return userGradeName;
		}
		else if("gradeTime".equals(name))
		{
			return gradeTime.toString();
		}
		else if("forbitEndTime".equals(name))
		{
			return forbitEndTime==null?"":DateUtil.convertDateToStr(forbitEndTime);
		}
		else
		{
			return "";
		}
	}
	
	public String getUserGradeName() {
		return userGradeName;
	}
	public void setUserGradeName(String userGradeName) {
		this.userGradeName = userGradeName;
	}
	/**
	 * 
	 * @Description 昵称
	 * @author HouXiangBao289
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 
	 * @Description 昵称
	 * @author HouXiangBao289
	 * @return
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 
	 * @Description 账号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 
	 * @Description 账号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	/**
	 * 
	 * @Description 手机号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 
	 * @Description 手机号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 
	 * @Description 真实姓名
	 * @author HouXiangBao289
	 * @return
	 */
	public String getActualName() {
		return actualName;
	}
	/**
	 * 
	 * @Description 真实姓名
	 * @author HouXiangBao289
	 * @return
	 */
	public void setActualName(String actualName) {
		this.actualName = actualName;
	}
	/**
	 * 
	 * @Description 身份证号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * 
	 * @Description 身份证号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * 
	 * @Description 密码
	 * @author HouXiangBao289
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @Description 密码
	 * @author HouXiangBao289
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @Description 银行卡号
	 * @author HouXiangBao289
	 * @return
	 */
	public String getBankCardCode() {
		return bankCardCode;
	}
	/**
	 * 
	 * @Description 银行卡号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setBankCardCode(String bankCardCode) {
		this.bankCardCode = bankCardCode;
	}
	/**
	 * 
	 * @Description 会员等级
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getUserGrade() {
		return userGrade;
	}
	/**
	 * 
	 * @Description 会员等级
	 * @author HouXiangBao289
	 * @return
	 */
	public void setUserGrade(Integer userGrade) {
		this.userGrade = userGrade;
	}
	/**
	 * 
	 * @Description 会员等级升级时间
	 * @author HouXiangBao289
	 * @return
	 */
	public String getGradeTime() {
		return gradeTime;
	}
	/**
	 * 
	 * @Description 会员等级升级时间
	 * @author HouXiangBao289
	 * @return
	 */
	public void setGradeTime(String gradeTime) {
		this.gradeTime = gradeTime;
	}
	
	
}
