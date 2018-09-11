package com.hhly.lottomsg.bo;

public abstract class NodeBaseBO {
	public abstract String getValueByName(String name);
	
	/**
	 * 
	 * @Description 模板购彩链接彩种路径
	 * @author HouXiangBao289
	 * @return
	 */
	public String getLotUrlName(Integer lotCode){
		switch(lotCode){
			case 300:
				return "jczq";
			case 301:
				return "jclq";
			case 100:
				return "ssq";
			case 215:
				return "sd11x5";
			case 304:
				return "sfc";
			case 213:
				return "jx11x5";
			case 273:
				return "xj11x5";
			default:
				return "";
		}
	}
}
