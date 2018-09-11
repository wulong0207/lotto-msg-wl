package com.hhly.lottomsg.bo;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.hhly.lottomsg.base.bo.BaseBO;

/**
 * @author lgs on
 * @version 1.0
 * @desc 竞彩足球sp值变化BO
 * @date 2017/5/11.
 * @company 益彩网络科技有限公司
 */
public class JczqTrendSpBO extends BaseBO {

	private static final long serialVersionUID = 1945474301667723716L;

	private Long id;

    /**
     * 胜平负和让球胜平负的SP值变化
     */
    private String[] wdf;
    
	/*********** 20171020 add 即时比分数据 *************/
	/**
	 * 即时比分数据
	 */
	private String score;
	
	/**
	 * 比赛进行时间
	 */
	private Integer min;
	
	/**
	 * 比赛状态
	 */
    private Integer status;

    public JczqTrendSpBO() {
    }

    public JczqTrendSpBO(Long id, String[] wdf) {
        this.wdf = wdf;
        this.id = id;
    }

	public JczqTrendSpBO(Long id, String[] wdf, String score) {
		this(id, wdf);
		this.score = score;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getWdf() {
        return wdf;
    }

    public void setWdf(String[] wdf) {
        this.wdf = wdf;
    }

    public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("wdf", wdf)
                .append("score", score)
                .append("min", min)
                .append("status", status)
                .toString();
    }
}
