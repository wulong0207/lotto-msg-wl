package com.hhly.lottomsg.bo;

import java.util.Date;

import com.hhly.lottomsg.common.constants.PayConstants;
import com.hhly.lottomsg.common.util.NumberFormatUtil;
/**
 * 
* @Description:运营管理 
* @author HouXiangBao289
* @date 2017年6月21日 下午2:39:58 
* @version V1.0.0
 */
public class DoBusinessBO extends NodeBaseBO{
	private String nickName = "";
	private String redName = "";
	private Integer redType;
	private String redTypeName = "";
	private Double redMoney = 0.00;
	private Date redOutTime;
	
	public DoBusinessBO(){}
	
	public DoBusinessBO(OperateCouponTempBO coupon) {
		this.redName = coupon.getRedName();
		this.redType = coupon.getRedType().intValue();
		this.redMoney = coupon.getRedValue();
		this.redTypeName = PayConstants.RedTypeEnum.getEnum(coupon.getRedType()).getValue();
	}
	/**
	 * 
	 * @Description 昵称 
	 * @author HouXiangBao289
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 
	 * @Description 昵称 
	 * @author HouXiangBao289
	 * @return
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 
	 * @Description 红包名称
	 * @author HouXiangBao289
	 * @return
	 */
	public String getRedName() {
		return redName;
	}
	/**
	 * 
	 * @Description 红包名称
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedName(String redName) {
		this.redName = redName;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getRedType() {
		return redType;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedType(Integer redType) {
		this.redType = redType;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public String getRedTypeName() {
		return redTypeName;
	}
	/**
	 * 
	 * @Description 红包类型
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedTypeName(String redTypeName) {
		this.redTypeName = redTypeName;
	}
	/**
	 * 
	 * @Description 红包金额
	 * @author HouXiangBao289
	 * @return
	 */
	public Double getRedMoney() {
		return redMoney;
	}
	/**
	 * 
	 * @Description 红包金额
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedMoney(Double redMoney) {
		this.redMoney = redMoney;
	}
	/**
	 * 
	 * @Description 红包过期时间
	 * @author HouXiangBao289
	 * @return
	 */
	public Date getRedOutTime() {
		return redOutTime;
	}
	/**
	 * 
	 * @Description 红包过期时间
	 * @author HouXiangBao289
	 * @return
	 */
	public void setRedOutTime(Date redOutTime) {
		this.redOutTime = redOutTime;
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
		if("nickName".equals(name))
		{
			return nickName==null?"":nickName;
		}
		else if("redName".equals(name))
		{
			return redName;
		}
		else if("redTypeName".equals(name))
		{
			return redTypeName;
		}
		else if("redMoney".equals(name))
		{
			return NumberFormatUtil.format(redMoney==null?0.00:redMoney,"0.00");
		}
		else if("redOutTime".equals(name))
		{
			return redOutTime==null?"":redOutTime.toString();
		}
		else
		{
			return "";
		}
	}
	
	
}
