package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OperateMsgInfoBO;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

public interface MsgInfoDaoMapper {
 
	/**
	 * 更新通知信息发送状态
	 * @param msgBatch
	 * @param userId
	 * @param sendType
	 * @param status
	 * @return
	 */
	int updateMsgSendStatus(@Param("msgBatch") String msgBatch,@Param("userId") Integer userId,@Param("sendType") Integer sendType,@Param("status") Integer status,@Param("sendError") String sendError);
	
	/**
	 * 
	 * @Desc   新增通知消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:13
	 * @param po
	 * @return
	 */
	int addMsgInfo(@Param("list")List<OperateMsgInfoPO> list);
	
	
	/**
	 * 
	 * @Desc   查询通知信息详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:20
	 * @param id
	 * @return
	 */
	OperateMsgInfoBO findMsgInfoById(@Param("id") Integer id);
	
	/**
	 * 
	 * @Desc   查询通知信息详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:20
	 * @param id
	 * @return
	 */
	List<OperateMsgInfoBO> findMsgsByBatch(@Param("batchCode") String batchCode);
	
	/**
	 * 
	 * @Description 查询模板待发送消息
	 * @author HouXiangBao289
	 * @param templateCode
	 * @return
	 */
	List<OperateMsgInfoBO> findMsgsByTemplateCode(@Param("templateCode") Integer templateCode);
	
	/**
	 * 
	 * @Description 根据模板查询待发送消息(只查询手机短信和APP通知近一天消息)
	 * @author HouXiangBao289
	 * @param templateId
	 * @return
	 */
	List<OperateMsgInfoBO> findMsgsByTemplate(@Param("templateId") Integer templateId);
	
}
