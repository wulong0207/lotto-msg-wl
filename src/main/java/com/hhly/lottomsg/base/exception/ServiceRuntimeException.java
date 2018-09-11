package com.hhly.lottomsg.base.exception;

import com.hhly.lottomsg.bo.ResultBO;

/**
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-12-19 下午3:27:58
 * @Desc 服务异常
 */
public class ServiceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -755444734708675361L;

	public ServiceRuntimeException(String msg) {
		super(msg);
		this.code = "";
		this.msg = msg;
	}

	public ServiceRuntimeException(String code, String msg) {
		super(code + "----" + msg);
		this.code = code;
		this.msg = msg;
	}

	public ServiceRuntimeException(String msg, Throwable t) {
		super(msg, t);
		this.code = "";
		this.msg = msg;
	}

	public ServiceRuntimeException(String code, String msg, Throwable t) {
		super(code + "----" + msg, t);
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 异常结果
	 */
	private ResultBO<?> result;

	/**
	 * @param result
	 *            异常结果
	 */
	public ServiceRuntimeException(ResultBO<?> result) {
		super(result.getMessage());
		this.result = result;
		this.code = result.getErrorCode();
	}

	private String code;

	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultBO<?> getResult() {
		return result;
	}

	public void setResult(ResultBO<?> result) {
		this.result = result;
	}

}
