package com.hhly.lottomsg.entity;

import java.util.Map;

/**
 * 
* @Description: 各执行节点自动通知消息
* @author HouXiangBao289
* @date 2017年5月17日 下午3:01:24 
* @version V1.0.0
 */
public class NodeInfo {
	
	private Map<String,String> variables;
	private String AppFieldsData;//APP附加字段数据,格式：name1:value1;name2:value2
//	private String WechatFieldsData;//微信公众号数据,格式：name1:value1;name2:value2
	
	public NodeInfo(){}

	/**
	 * 
	 * @Description 模板消息动态变量 
	 * @author HouXiangBao289
	 * @return
	 */
	public Map<String, String> getVariables() {
		return variables;
	}

	/**
	 * 
	 * @Description 模板消息动态变量 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}


	/**
	 * 
	 * @Description APP附加字段数据,格式：name1:value1;name2:value2 
	 * @author HouXiangBao289
	 * @return
	 */
	public String getAppFieldsData() {
		return AppFieldsData;
	}
	/**
	 * 
	 * @Description APP附加字段数据,格式：name1:value1;name2:value2 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setAppFieldsData(String appFieldsData) {
		AppFieldsData = appFieldsData;
	}
//	/**
//	 * 
//	 * @Description 微信公众号数据,格式：name1:value1;name2:value2 
//	 * @author HouXiangBao289
//	 * @return
//	 */
//	public String getWechatFieldsData() {
//		return WechatFieldsData;
//	}
//	/**
//	 * 
//	 * @Description 微信公众号数据,格式：name1:value1;name2:value2 
//	 * @author HouXiangBao289
//	 * @return
//	 */
//	public void setWechatFieldsData(String wechatFieldsData) {
//		WechatFieldsData = wechatFieldsData;
//	}
	
}
