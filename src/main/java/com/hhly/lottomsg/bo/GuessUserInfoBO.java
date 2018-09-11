package com.hhly.lottomsg.bo;

import java.util.Date;

/**
 * 
* @Description: 用户信息 
* @author HouXiangBao289
* @date 2017年6月21日 上午9:59:46 
* @version V1.0.0
 */
@SuppressWarnings("serial")
public class GuessUserInfoBO extends UserInfoBO{
	
	private Date guessTime;
	private Double bonus;

	public Date getGuessTime() {
		return guessTime;
	}

	public void setGuessTime(Date guessTime) {
		this.guessTime = guessTime;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
}
