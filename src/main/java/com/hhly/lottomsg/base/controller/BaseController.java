package com.hhly.lottomsg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhly.lottomsg.bo.ResultBO;

public class BaseController {
 
	protected  HttpServletRequest request;
	
	protected  HttpServletResponse response;
	
	private static final ResultBO<?> SUCCESS;
	
	private static final ResultBO<?> FAIL;
	static{
		SUCCESS = new ResultBO<>();
		SUCCESS.setErrorCode(ResultBO.SUCCESS_CODE);
		SUCCESS.setSuccess(1);
		FAIL = new ResultBO<>();
		FAIL.setErrorCode(ResultBO.FAIL_CODE);
		FAIL.setSuccess(0);
	}

	public HttpServletRequest getRequest() {
		return request; 
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public <T> ResultBO<T> getSuccessResultBO(T data){
		ResultBO<T> bo = new ResultBO<>();
		bo.setData(data);
		bo.setErrorCode(ResultBO.SUCCESS_CODE);
		bo.setSuccess(1);
		return bo;
	}
	public  ResultBO<?> getSuccessResultBO(){
		return SUCCESS;
	}
	public <T> ResultBO<T> getFailResultBO(T data){
		ResultBO<T> bo = new ResultBO<>();
		bo.setData(data);
		bo.setErrorCode(ResultBO.FAIL_CODE);
		bo.setSuccess(0);
		return bo;
	}
	public  ResultBO<?> getFailResultBO(){
		return FAIL;
	}
	
}
