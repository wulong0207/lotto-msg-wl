package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OperateMsgNewBO;
import com.hhly.lottomsg.vo.OperateMsgNewVO;

public interface NewMsgDaoMapper {
	
	/**
	 * 根据批次号查询
	 * @param msgBatch
	 * @return
	 */
	OperateMsgNewBO findNewMsgByBatch(@Param("msgBatch") String msgBatch);
	
	/**
	 * 根据Id更新状态
	 * @param status
	 * @param id
	 * @return
	 */
	int updateNewMsgStatus(@Param("status") int status,@Param("id") Integer id);
	
	/**
	 * 
	 * @Description 查询
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	List<OperateMsgNewBO> findNewMsgList(OperateMsgNewVO vo);
		
}
