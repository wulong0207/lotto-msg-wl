package com.hhly.lottomsg.entity;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.hhly.lottomsg.bo.IssueBO;
import com.hhly.lottomsg.common.util.DateUtil;

public class SaleEndIssue implements Delayed {
	
	private Integer lotCode;
	private String issueCode;
	private long time;
	
	public SaleEndIssue(){}

	public SaleEndIssue(IssueBO bo){  
        this.lotCode = bo.getLotCode();
        this.issueCode = bo.getIssueCode();
        // 提前1小时通知
        this.time=DateUtil.addHour(bo.getSaleEndTime(), -1).getTime();
    }

	public Integer getLotCode() {
		return lotCode;
	}

	public void setLotCode(Integer lotCode) {
		this.lotCode = lotCode;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	@Override
	public int compareTo(Delayed o) {
		SaleEndIssue that = (SaleEndIssue)o;  
        if(this.time > that.time){//过期时刻越靠后，越排在队尾.  
            return 1;  
        }
        else if(this.time==that.time){  
            return 0;  
        }
        else{  
            return -1;  
        }  
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.time-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
