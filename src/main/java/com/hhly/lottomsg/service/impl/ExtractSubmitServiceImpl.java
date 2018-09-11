package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.FinanceBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.FinanceDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 提交提款申请提醒 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:17:45 
* @version V1.0.0
 */
@Service("extractMoneySubmitService")
public class ExtractSubmitServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	@Autowired
	private FinanceDaoMapper financeDaoMapper;
	
	private Logger logger = Logger.getLogger(ExtractSubmitServiceImpl.class.getName());
		
	private String[] extractKeys = {"extractAmount","bankCardCode","failInfo"};
	private String[] extractNames = {"${提款金额}$","${提款卡号}$","${银行失败原因}$"};

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) throws Exception{
		drawMoneySubmitNotice(template,data);
	}
	
	/**
	 * 
	 * @Description 提交提款申请提醒
	 * @author HouXiangBao289
	 * @param data 格式：用户Id;提款金额;银卡卡尾号
	 * @param template
	 */
	private void drawMoneySubmitNotice( OperateMsgTemplateBO template,String[] data)throws Exception {
		if(data.length != 2){
			logger.warn("【通知信息管理】提交提款申请提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		UserInfoBO user = userInfoMapper.findUserInfoById(Integer.parseInt(data[0]));
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送提交提款申请提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		NodeInfo nodeInfo = new NodeInfo();
		FinanceBO takenInfo = financeDaoMapper.selectTakenLog(user.getId(), data[1]);
		Map<String,String> variables = handleVariable(user,takenInfo);
		nodeInfo.setVariables(variables);
		nodeInfo.setAppFieldsData(getPublicFields(template));
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}
	
	private Map<String,String> handleVariable(UserInfoBO user,FinanceBO extractInfo){		
		Map<String,String> map = new HashMap<String,String>();
		map.putAll(getUserVariable(user));
		for(int i=0;i<extractKeys.length;i++){
			map.put(extractNames[i], extractInfo.getValueByName(extractKeys[i]));
		}
		return map;
	}
}
