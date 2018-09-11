package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author chenkangning
 * @version 1.0
 * @desc 小开关BO
 * @date 2017.04.25
 * @company 益彩网络科技公司
 */
public class OperateMsgConfigLotteryBO extends BaseBO {

	/**
     * 主键ID
     */
    private Integer id;
    
    /**
     * 彩种编号
     */
    private Integer lotteryCode;
    
    /**
     * 彩种名称
     */
    private String lotteryName;
    
    /**
     * 类型:1开奖号码;2购彩提醒
     */
    private Integer type;
    
    /**
     * APP推送:0不接收;1接收
     */
    private Integer app;
    
    /**
     * 用户ID
     */
    private Integer userId;
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public Integer getLotteryCode () {
        return lotteryCode;
    }
    
    public void setLotteryCode (Integer lotteryCode) {
        this.lotteryCode = lotteryCode;
    }
    
    public Integer getType () {
        return type;
    }
    
    public void setType (Integer type) {
        this.type = type;
    }
    
    public Integer getApp () {
        return app;
    }
    
    public void setApp (Integer app) {
        this.app = app;
    }
    
    public Integer getUserId () {
        return userId;
    }
    
    public void setUserId (Integer userId) {
        this.userId = userId;
    }

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}
    
    
}