package com.hhly.lottomsg.bo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OperateSendBatchBO implements Delayed {
	
	private String code;
	private long time;
	
	public OperateSendBatchBO(){}

	public OperateSendBatchBO(String code,long time){  
        this.code=code;  
        this.time=time;
    }

	@Override
	public int compareTo(Delayed o) {
		OperateSendBatchBO that = (OperateSendBatchBO)o;  
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
