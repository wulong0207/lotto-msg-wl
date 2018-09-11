package com.hhly.lottomsg.bo;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author lgs on
 * @version 1.0
 * @desc 竞彩篮球比分BO
 * @date 2017/11/14.
 * @company 益彩网络科技有限公司
 */
public class BasketBallScoreBO extends BaseBO {

    private static final long serialVersionUID = 1L;

    /**
     * 对阵id
     */
    private String id;

    /**
     * 状态值
     */
    private Integer status;

    /**
     * 比赛还剩余多少分钟
     */
    private String time;

    /**
     * 主队第一节比分
     */
    private Integer hOne;
    /**
     * 主队第二节比分
     */
    private Integer hTwo;
    /**
     * 主队第三节比分
     */
    private Integer hThree;
    /**
     * 主队第四节比分
     */
    private Integer hFour;
    /**
     * 主队加时比分
     */
    private Integer hOut;
    /**
     * 主队比分
     */
    private Integer hScore;

    /**
     * 客队第一节比分
     */
    private Integer gOne;
    /**
     * 客队第二节比分
     */
    private Integer gTwo;
    /**
     * 客队第三节比分
     */
    private Integer gThree;
    /**
     * 客队第四节比分
     */
    private Integer gFour;
    /**
     * 客队加时比分
     */
    private Integer gOut;
    /**
     * 客队比分
     */
    private Integer gScore;
    /**
     * 主队上场比分
     */
    private Integer hTop;
    /**
     * 主队下场比分
     */
    private Integer hDown;
    /**
     * 客队上场比分
     */
    private Integer gTop;
    /**
     * 客队队下场比分
     */
    private Integer gDown;


    public Integer gethTop() {
        return hTop;
    }

    public void sethTop(Integer hTop) {
        this.hTop = hTop;
    }

    public Integer gethDown() {
        return hDown;
    }

    public void sethDown(Integer hDown) {
        this.hDown = hDown;
    }

    public Integer getgTop() {
        return gTop;
    }

    public void setgTop(Integer gTop) {
        this.gTop = gTop;
    }

    public Integer getgDown() {
        return gDown;
    }

    public void setgDown(Integer gDown) {
        this.gDown = gDown;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer gethOne() {
        return hOne;
    }

    public void sethOne(Integer hOne) {
        this.hOne = hOne;
    }

    public Integer gethTwo() {
        return hTwo;
    }

    public void sethTwo(Integer hTwo) {
        this.hTwo = hTwo;
    }

    public Integer gethThree() {
        return hThree;
    }

    public void sethThree(Integer hThree) {
        this.hThree = hThree;
    }

    public Integer gethFour() {
        return hFour;
    }

    public void sethFour(Integer hFour) {
        this.hFour = hFour;
    }

    public Integer gethOut() {
        return hOut;
    }

    public void sethOut(Integer hOut) {
        this.hOut = hOut;
    }

    public Integer gethScore() {
        return hScore;
    }

    public void sethScore(Integer hScore) {
        this.hScore = hScore;
    }

    public Integer getgOne() {
        return gOne;
    }

    public void setgOne(Integer gOne) {
        this.gOne = gOne;
    }

    public Integer getgTwo() {
        return gTwo;
    }

    public void setgTwo(Integer gTwo) {
        this.gTwo = gTwo;
    }

    public Integer getgThree() {
        return gThree;
    }

    public void setgThree(Integer gThree) {
        this.gThree = gThree;
    }

    public Integer getgFour() {
        return gFour;
    }

    public void setgFour(Integer gFour) {
        this.gFour = gFour;
    }

    public Integer getgOut() {
        return gOut;
    }

    public void setgOut(Integer gOut) {
        this.gOut = gOut;
    }

    public Integer getgScore() {
        return gScore;
    }

    public void setgScore(Integer gScore) {
        this.gScore = gScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
