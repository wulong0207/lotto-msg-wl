package com.hhly.lottomsg.bo;

/**
 * 
* @Description: 彩种 
* @author HouXiangBao289
* @date 2017年6月21日 下午12:13:15 
* @version V1.0.0
 */
public class LotTypeBO extends NodeBaseBO{
	private Integer lotCode;
	private String lotName="";
	private Integer status;
	private String statusName="";
	private Integer lotPlayCode;
	private String lotPlayName="";
	private Integer playSaleStatus;
	private String playStatusName="";
	
	/**
	 * 
	 * @Description 彩种编号 
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getLotCode() {
		return lotCode;
	}
	/**
	 * 
	 * @Description 彩种编号 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotCode(Integer lotCode) {
		this.lotCode = lotCode;
	}
	
	/**
	 * 
	 * @Description 彩种名称
	 * @author HouXiangBao289
	 * @return
	 */
	public String getLotName() {
		return lotName;
	}
	/**
	 * 
	 * @Description 彩种名称
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}
	
	/**
	 * 
	 * @Description 状态
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 
	 * @Description 状态
	 * @author HouXiangBao289
	 * @return
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 
	 * @Description 状态
	 * @author HouXiangBao289
	 * @return
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * 
	 * @Description 状态
	 * @author HouXiangBao289
	 * @return
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * 
	 * @Description 子玩法编号
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getLotPlayCode() {
		return lotPlayCode;
	}
	/**
	 * 
	 * @Description 子玩法编号
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotPlayCode(Integer lotPlayCode) {
		this.lotPlayCode = lotPlayCode;
	}
	/**
	 * 
	 * @Description 子玩法名称
	 * @author HouXiangBao289
	 * @return
	 */
	public String getLotPlayName() {
		return lotPlayName;
	}
	/**
	 * 
	 * @Description 子玩法名称
	 * @author HouXiangBao289
	 * @return
	 */
	public void setLotPlayName(String lotPlayName) {
		this.lotPlayName = lotPlayName;
	}
	/**
	 * 
	 * @Description 子玩法销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getPlaySaleStatus() {
		return playSaleStatus;
	}
	/**
	 * 
	 * @Description 子玩法销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public void setPlaySaleStatus(Integer playSaleStatus) {
		this.playSaleStatus = playSaleStatus;
	}
	/**
	 * 
	 * @Description 子玩法销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public String getPlayStatusName() {
		return playStatusName;
	}
	/**
	 * 
	 * @Description 子玩法销售状态
	 * @author HouXiangBao289
	 * @return
	 */
	public void setPlayStatusName(String playStatusName) {
		this.playStatusName = playStatusName;
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
		if("lotName".equals(name))
		{
			return lotName;
		}
		else if("statusName".equals(name))
		{
			return statusName;
		}
		else if("lotPlayName".equals(name))
		{
			return lotPlayName;
		}
		else if("playStatusName".equals(name))
		{
			return playStatusName;
		}
		else
		{
			return "";
		}
	}
}
