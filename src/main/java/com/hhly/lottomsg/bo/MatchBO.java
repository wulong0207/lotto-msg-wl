package com.hhly.lottomsg.bo;

/**
 * 
* @Description:对阵管理（竞彩、北单） 
* @author HouXiangBao289
* @date 2017年6月21日 下午2:54:35 
* @version V1.0.0
 */
public class MatchBO extends NodeBaseBO{
	private String match="";
	private String vs="";
	private Integer saleStatus;
	private String statusName="";
	private Integer playSaleStatus;
	private String playStatusName="";
	
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public String getVs() {
		return vs;
	}
	public void setVs(String vs) {
		this.vs = vs;
	}
	public Integer getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Integer getPlaySaleStatus() {
		return playSaleStatus;
	}
	public void setPlaySaleStatus(Integer playSaleStatus) {
		this.playSaleStatus = playSaleStatus;
	}
	public String getPlayStatusName() {
		return playStatusName;
	}
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
		if("match".equals(name))
		{
			return match;
		}
		else if("vs".equals(name))
		{
			return vs;
		}
		else if("statusName".equals(name))
		{
			return statusName;
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
