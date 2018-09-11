package com.hhly.lottomsg.common.enums;

import java.util.Objects;

/**
 * 
* @Description: 用户唤醒条件key
* @author HouXiangBao289
* @version V1.5.0
 */
public enum ConditionKey {
	CON1(1,"注册未登录"),
	CON2(2,"注册未下单"),
	CON3(3,"注册(未实名认证)有下单但未购买"),
	CON4(4,"注册并实名认证后未购买"),
	CON5(5,"注册(不区分实名)第N天未购买"),
	CON6(6,"首单第N天未二单"),
	CON7(7,"首单N-N天内无第二单"),
	CON8(8,"距上单N到N天未登录"),
	CON9(9,"距上单N到N天未购买"),
	CON10(10,"账户余额X元距离上单N天未购买"),
	CON11(11,"距上单N到N天未购买(低客单)"),
	CON12(12,"距上单N到N天未购买(高客单)"),
	CON13(13,"上月购彩金额X元N天未购买");
	
	ConditionKey(int code,String name){
		this.code = code;
		this.name = name;
	}
	
	private int code;
	private String name;
	
	/**
	 * @param lottery
	 *            彩种名
	 * @return 返回指定彩种结构
	 */
	public static ConditionKey getConditionKey(Integer code) {
	    if (code == null) {
            return null;
        }
		for (ConditionKey l : ConditionKey.values()){
			if (Objects.equals(l.getCode(), code)) {
				return l;
			}
		}
		return null;
	}

	public static String getNameByCode(int code){
		for(ConditionKey e: ConditionKey.values()){
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
