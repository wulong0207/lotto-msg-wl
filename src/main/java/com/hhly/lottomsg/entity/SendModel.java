/**
 * @desc    消息Model
 * @author  scott
 * @company 益彩科技
 * @version 1.0
 * 
 */
package com.hhly.lottomsg.entity;

/**
 * 
* @Description: 发送实体类(支持手机短信和邮件)
* @author HouXiangBao289
* @date 2017年11月24日 上午10:44:09 
* @version V1.0.0
 */
public class SendModel {
    
	/**
	 * 手机号或邮箱地址
	 */
	private String account ;
	
	/**
	 * 发送方式，2手机短信，5邮件 
	 */
	private Short type;
	
	/** 消息内容   **/
	private String content;

	public SendModel(){}
	
	public SendModel(String account, Short type, String content){
		this.account = account;
		this.type = type;
		this.content = content;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
