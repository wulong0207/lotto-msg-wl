package com.hhly.lottomsg.common.enums;

/**
 * 
* @Description: 彩种相关消息类型 
* @author HouXiangBao289
* @date 2017年12月16日 下午5:04:24 
* @version V1.0.0
 */
public enum LotMsgType {
	// 开奖号码通知
	KJHMTZ(1,"100(开奖号码通知)"),
	// 购彩提醒
	GCTX(2,"102(购彩提醒)");
	
	LotMsgType(int code,String name){
		this.code = code;
		this.name = name;
	}
	
	private int code;
	private String name;
	
	public static String getNameByCode(int code){
		for(LotMsgType e: LotMsgType.values()){
			if(e.getCode() == code){
				return e.getName();
			}
		}
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
