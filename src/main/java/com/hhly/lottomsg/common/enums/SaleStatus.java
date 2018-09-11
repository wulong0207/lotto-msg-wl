package com.hhly.lottomsg.common.enums;

/**
 * @author huangb
 *
 * @Date 2016年12月1日
 *
 * @Desc 销售状态（包括彩种销售状态，子玩法销售状态等）
 */
public enum SaleStatus {

	SUSPEND_SALE("暂停销售", (short) 0), 
	NORMAL_SALE("正常销售", (short) 1),
	STOP_SALE("停止销售", (short) 2);

	/**
	 * 状态描述
	 */
	private String desc;
	/**
	 * 状态值
	 */
	private short value;

	SaleStatus(String desc, short value) {
		this.desc = desc;
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
	/**
	 * @param value
	 * @return
	 * @Desc 是否包含指定状态
	 */
	public static boolean contain(short value) {
		for (SaleStatus temp : SaleStatus.values()) {
			if (temp.getValue() == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否正常销售
	 * @param value
	 * @return
	 */
	public static boolean isSale( short value) {
		return NORMAL_SALE.getValue() == value;
	}
	
	/**
	 * 
	 * @Description 根据value获取对应name
	 * @author HouXiangBao289
	 * @param value
	 * @return
	 */
	public static String getNameByValue(short value){
		for(SaleStatus e: SaleStatus.values()){
			if(e.getValue() == value){
				return e.getDesc();
			}
		}
		return "";
	}
}
