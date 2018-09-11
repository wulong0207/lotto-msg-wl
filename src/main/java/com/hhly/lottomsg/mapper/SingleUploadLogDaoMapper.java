package com.hhly.lottomsg.mapper;

import java.util.List;

import com.hhly.lottomsg.bo.SingleUploadLogBO;
import com.hhly.lottomsg.po.SingleUploadLogPO;
import com.hhly.lottomsg.vo.SingleUploadLogVO;

public interface SingleUploadLogDaoMapper {
	/**
	 * 新增单式上传日志
	 * @author longguoyou
	 * @date 2017年6月10日
	 * @param singleUploadPO
	 * @return
	 */
	int insertSingleUploadLog(SingleUploadLogPO singleUploadPO);
	/**
	 * 查询单式上传日志信息
	 * @author longguoyou
	 * @date 2017年6月28日
	 * @param singleUploadLogVO
	 * @return
	 */
	List<SingleUploadLogBO> findSingleUploadLogInfo(SingleUploadLogVO singleUploadLogVO);
}