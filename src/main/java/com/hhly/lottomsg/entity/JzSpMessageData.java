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

import com.hhly.lottomsg.bo.JczqTrendSpBO;

/**
 * 
* @Description: 竞足SP更新数据 
* @author HouXiangBao289
* @date 2017年7月3日 下午4:08:18 
* @version V1.0.0
 */
public class JzSpMessageData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5061265159473845256L;
	/** 推送数据Data json格式 **/
	private List<JczqTrendSpBO> list;

	public List<JczqTrendSpBO> getList() {
		return list;
	}


	public void setList(List<JczqTrendSpBO> list) {
		this.list = list;
	}

}
