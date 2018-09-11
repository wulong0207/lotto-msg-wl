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

import com.hhly.lottomsg.bo.JclqTrendSpBO;
/**
 * 
* @Description: 竞篮SP更新数据
* @author HouXiangBao289
* @date 2017年7月3日 下午4:07:14 
* @version V1.0.0
 */
public class JlSpMessageData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8386571928212662377L;
	/** 推送数据Data json格式 **/
	private List<JclqTrendSpBO> list;

	public List<JclqTrendSpBO> getList() {
		return list;
	}


	public void setList(List<JclqTrendSpBO> list) {
		this.list = list;
	}

}
