package com.hhly.lottomsg.base.service;

import java.util.List;

import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

/**
 * 
* @Description:节点消息接口 
* @author HouXiangBao289
* @date 2017年12月20日 下午2:12:30 
* @version V1.0.0
 */
public interface NodeMsgServiceBase extends MsgServiceBase{
	/**
	 * 
	 * @Description 处理节点通知数据 
	 * @author HouXiangBao289
	 * @param template
	 * @param user
	 * @param nodeMsg
	 * @param appLotNotice 用户彩种相关消息提醒是否通知
	 * @param isSmsSend 是否发送手机短信
	 * @param isSend 发送开关
	 * @return
	 * @throws Exception
	 */
	List<OperateMsgInfoPO> handleSendInfo(OperateMsgTemplateBO template,
			UserInfoBO user,NodeInfo nodeMsg,boolean appLotNotice,boolean isSmsSend,boolean isSend) throws Exception;
}
