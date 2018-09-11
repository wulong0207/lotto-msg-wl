/**
 * @desc    消息Model
 * @author  scott
 * @company 益彩科技
 * @version 1.0
 * 
 */
package com.hhly.lottomsg.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
* @Description: 消息实体 
* @author HouXiangBao289
* @date 2017年11月24日 上午10:44:09 
* @version V1.0.0
 */
public class MessageModel {
    
	/** 消息来源系统名称 :比如lotto-cms  **/
	private String messageSource ;
	
	/** 消息类型key :msgBatchSend(后台手动发送)、msgReSend(后台消息重新发送)、nodeMsgSend(节点自动发送消息)**/
	private String key ;
	
	/** 消息内容   **/
	private Object message ;

	public MessageModel(){}
	
	public MessageModel(String messageSource, String key, Object message){
		this.messageSource = messageSource;
		this.key = key;
		this.message = message;
	}
	/**
	 * @return the messageSource消息来源系统名称
	 */
	public String getMessageSource() {
		return messageSource;
	}

	/**
	 * @param messageSource the messageSource to set 消息来源系统名称
	 */
	public void setMessageSource(String messageSource) {
		this.messageSource = messageSource;
	}

	

	/**
	 * @return 消息类型 the key :msgBatchSend(后台手动发送)、msgReSend(后台消息重新发送)、nodeMsgSend(节点自动发送消息)
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param 消息类型 key the key to set:msgBatchSend(后台手动发送)、msgReSend(后台消息重新发送)、nodeMsgSend(节点自动发送消息)
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the message
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Object message) {
		this.message = message;
	}
	
	@Override  
    public String toString() {  
        return ToStringBuilder.reflectionToString(this,  
               ToStringStyle.DEFAULT_STYLE);  
    }  
	
}
