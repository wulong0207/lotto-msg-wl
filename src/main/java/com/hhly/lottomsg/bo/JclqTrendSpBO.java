package com.hhly.lottomsg.bo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author lgs on
 * @version 1.0
 * @desc 竞彩篮球sp值变化
 * @date 2017/5/11.
 * @company 益彩网络科技有限公司
 */
public class JclqTrendSpBO extends BaseBO {

    private Long id;

    /**
     * 胜负/让分胜负
     */
    private String[] wf;

    /**
     * 分差变化
     */
    private Map ws;
    /**
     * 大小分变化
     */
    private String[] bs;

    /**
     * 即时比分
     */
    private BasketBallScoreBO score;

    public JclqTrendSpBO() {
    }

    public JclqTrendSpBO(Long id, String[] wf, Map ws, String[] bs) {
        this.id = id;
        this.wf = wf;
        this.ws = ws;
        this.bs = bs;
    }

    public BasketBallScoreBO getScore() {
        return score;
    }

    public void setScore(BasketBallScoreBO score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getWf() {
        return wf;
    }

    public void setWf(String[] wf) {
        this.wf = wf;
    }

    public Map getWs() {
        return ws;
    }

    public void setWs(Map ws) {
        this.ws = ws;
    }

    public String[] getBs() {
        return bs;
    }

    public void setBs(String[] bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("wf", wf)
                .append("ws", ws)
                .append("bs", bs)
                .toString();
    }
}
