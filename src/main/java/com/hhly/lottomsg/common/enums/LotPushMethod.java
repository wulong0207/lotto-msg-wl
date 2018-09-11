package com.hhly.lottomsg.common.enums;

public enum LotPushMethod {
	// 江苏快3
	JSK3(233,"jsk3UpdateData"),
	// 江西快3
	JXK3(234,"jxk3UpdateData"),
	// 广东11选5
	GD11X5(210,"gd11x5UpdateData"),
	// 江西11选5
	JX11X5(213,"jx11x5UpdateData"),
	// 新疆11选5
	XJ11X5(273,"xj11x5UpdateData"),
	// 山东11选5
	SD11X5(215,"sd11x5UpdateData"),
	// 广西11选5
	GX11X5(271,"gx11x5UpdateData");
	
	LotPushMethod(Integer code,String name){
		this.code = code;
		this.name = name;
	}
	
	private Integer code;
	private String name;
	
	public static String getNameByCode(int code){
		for(LotPushMethod e: LotPushMethod.values()){
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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
