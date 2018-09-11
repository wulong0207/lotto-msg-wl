package com.hhly.lottomsg.base.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


/**
 * @author Bruce
 *
 * @date 2016年11月5日
 *
 * @desc 业务实体基类，统一序列化
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public abstract class BaseVO implements Serializable {

	private static final long serialVersionUID = 9156277792571826246L;
	
}
