package com.hhly.lottomsg.vo;

import java.util.Date;
import java.util.List;

import com.hhly.lottomsg.base.vo.PageVO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 订单查询对象
 * @date 2017/3/13 15:18
 * @company 益彩网络科技公司
 */
public class OrderQueryVo extends PageVO {
    /**
     *
     */
    private static final long serialVersionUID = -7975089020583708089L;

    /**
     * 彩种编号，全部为null 参考LotteryEnum 枚举
     */
    private Integer lotteryCode;
    
    private String lotteryIssue;

    /**
     * 方案  1：代购；2：追号计划；3：合买;4:推单
     */
    private Integer buyType=0;

    /**
     * 开始时间 字符串
     */
    private String beginDate;

    /**
     * 结束时间 字符串
     */
    private String endDate;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date finishDate;

    /**
     *  1：进行中方案；2：中奖方案；3：待开奖
     */
    private Integer type=0;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 用户token
     */
    private String token;


    //用户首页订单查询专用
    /**
     * 1:未完成，2，已完成
     */
    private Integer status;

    /**
     * 请求来源，默认是PC端 0：Pc端,1:移动端
     */
    private Integer source=0;
    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 总条数
     */
    private Integer total;
    
    /**
     * 查询统计数
     */
    private Boolean totalFlag = false;

    /**
     * 追号查询类型 1：查询全部追号活动订单,activityCode为空 2：根据活动ID查询活动追号订单
     */
    private Integer addQueryType;

    /**
     * 活动编号多个以,号分割
     */
    private String activityCode;

    /**
     * activityCode后端装换成的集合
     */
    private List<String> activityCodes;

    /**
     * 渠道ID
     */
    private String channelId;

    public String getLotteryIssue() {
		return lotteryIssue;
	}

	public void setLotteryIssue(String lotteryIssue) {
		this.lotteryIssue = lotteryIssue;
	}

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getLotteryCode() {
        return lotteryCode;
    }

    public void setLotteryCode(Integer lotteryCode) {
        this.lotteryCode = lotteryCode;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

	public Boolean getTotalFlag() {
		return totalFlag;
	}

	public void setTotalFlag(Boolean totalFlag) {
		this.totalFlag = totalFlag;
	}

    public Integer getAddQueryType() {
        return addQueryType;
    }

    public void setAddQueryType(Integer addQueryType) {
        this.addQueryType = addQueryType;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public List<String> getActivityCodes() {
        return activityCodes;
    }

    public void setActivityCodes(List<String> activityCodes) {
        this.activityCodes = activityCodes;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
