/**
 * 推送数据类型模型
 * @author scott
 * @date   2017-05-20
 * @company 深圳益彩网络科技
 * 
 */
package com.hhly.lottomsg.entity;

import java.io.Serializable;

/**
 * 
* @Description: 更新数据通知
* @author HouXiangBao289
* @date 2017年7月3日 下午4:08:18 
* @version V1.0.0
 */
public class UpdateDataNotice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5061265159473845256L;
	
	private Integer lotteryCode;//彩种编号
	private Integer updateDataType;//更新数据类型：彩期切换1;开奖2;后台彩期更新3;限号4;子玩法销售状态更新5
	
	public Integer getLotteryCode() {
		return lotteryCode;
	}
	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}
	public Integer getUpdateDataType() {
		return updateDataType;
	}
	public void setUpdateDataType(Integer updateDataType) {
		this.updateDataType = updateDataType;
	}
	
	

}
