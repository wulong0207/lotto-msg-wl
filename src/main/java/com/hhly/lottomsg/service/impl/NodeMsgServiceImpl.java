package com.hhly.lottomsg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.OperateNodeMsg;
import com.hhly.lottomsg.mapper.MsgTemplateDaoMapper;
import com.hhly.lottomsg.service.NodeMsgService;
import com.hhly.lottomsg.service.TemplateMsgService;
import com.hhly.lottomsg.service.manage.PrizeNoticeManager;
import com.hhly.lottomsg.service.manage.ServiceFactory;
import com.hhly.lottomsg.vo.OperateMsgTemplateVO;

@Service("nodeMsgService")
public class NodeMsgServiceImpl extends NodeMsgServiceBaseImpl implements NodeMsgService {

	@Autowired
	private MsgTemplateDaoMapper msgTemplateMapper;
	
	@Resource
	private ServiceFactory serviceFactory;
	
	@Resource
	private PrizeNoticeManager prizeNoticeManager;
	
	
	@Override
	public void handleNodeMsg(OperateNodeMsg nodeMsg) throws Exception {
		OperateMsgTemplateVO vo = new OperateMsgTemplateVO();
		if(nodeMsg.getNodeId() == null){
			logger.warn("【通知信息服务】通知节点标识ID不能为空");
			return;
		}
		vo.setTypeNode(nodeMsg.getNodeId() + "");
		if(nodeMsg.getNodeId() == Constants.ORDER_PRIZE_NODEID){
			String[] codes = nodeMsg.getNodeData().split(",");
			for(String code:codes){
				// 订单中奖派奖通知节点处理
				prizeNoticeManager.prizeNotice(code);
			}
		}
		else if(nodeMsg.getNodeId() == Constants.PRIZE_STOP_NODEID){
			prizeNoticeManager.prizeStopNotice(nodeMsg.getNodeData());
		}
		else
		{
			// 查询节点对应的模板
			List<OperateMsgTemplateBO> templateList = msgTemplateMapper.findMsgTemplate(vo);
			for(OperateMsgTemplateBO template : templateList){
				if(template.getStatus().equals(UseStatus.VALID.getCode()))
					shuntNodeMsg(nodeMsg,template);
			}
		}
	}
	
	/**
	 * 
	 * @Description 
	 * @author HouXiangBao289
	 * @param nodeMsg
	 * @param template
	 */
	private void shuntNodeMsg(OperateNodeMsg nodeMsg,OperateMsgTemplateBO template){
		String[] data = nodeMsg.getNodeData().split(";");
		try 
		{
			TemplateMsgService service = serviceFactory.getServiceImpl(template.getTypeId());
			service.handleTemplateMsg(template, data);
		} 
		catch (Exception e)
		{
			logger.error("【通知信息管理】节点自动通知信息服务发生异常:");
			e.printStackTrace();
		}
	}
	
	

}
