package com.hhly.lottomsg.base.bo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huangb 
 * 业务实体基类，统一序列化
 */
@JsonInclude(value=JsonInclude.Include.NON_NULL)
public abstract class BaseBO implements Serializable {

	public static final long serialVersionUID = 9156277792571826246L;
	
}
