package com.hhly.lottomsg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.mapper.SingleUploadLogDaoMapper;
import com.hhly.lottomsg.po.SingleUploadLogPO;
import com.hhly.lottomsg.service.SingleUploadLogService;
@Service("singleUploadLogService")
public class SingleUploadLogServiceImpl implements SingleUploadLogService {

	@Autowired
	private SingleUploadLogDaoMapper singleUploadLogDaoMapper;
	
	@Override
	public void insert(SingleUploadLogPO singleUploadLogPO) {
         singleUploadLogDaoMapper.insertSingleUploadLog(singleUploadLogPO);  		
	}
}
