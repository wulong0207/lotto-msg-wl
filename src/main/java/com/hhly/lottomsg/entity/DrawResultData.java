/**
 * 推送数据类型模型
 * @author scott
 * @date   2017-05-20
 * @company 深圳益彩网络科技
 * 
 */
package com.hhly.lottomsg.entity;

import java.io.Serializable;
import java.util.List;

import com.hhly.lottomsg.bo.IssueLottBO;

/**
 * 
* @Description: 推送各彩种变更的开奖结果
* @author HouXiangBao289
* @date 2017年7月10日 上午10:06:15 
* @version V1.0.0
 */
public class DrawResultData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4345665151460481306L;
	/** 推送数据Data json格式 **/
	private List<IssueLottBO> list;

	public List<IssueLottBO> getList() {
		return list;
	}

	public void setList(List<IssueLottBO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DrawResultData [list=");
		for(IssueLottBO lot : list) {
			sb.append("{");
			sb.append(lot);
			sb.append("}");
		}
		sb.append("]");
		return sb.toString();
	}
}
