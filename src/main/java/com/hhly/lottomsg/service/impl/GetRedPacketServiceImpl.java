package com.hhly.lottomsg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.DoBusinessBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.DoBusinessDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 红包到账提醒 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:17:32 
* @version V1.0.0
 */
@Service("getRedPacketService")
public class GetRedPacketServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	@Autowired
	private DoBusinessDaoMapper doBusinessDaoMapper;
	private Logger logger = Logger.getLogger(GetRedPacketServiceImpl.class.getName());

	//运营管理信息
	private String[] redPacketKeys = {"redName","redTypeName","redMoney","redOutTime"};
	private String[] redPacketNames = {"${红包名称}$","${红包类型}$","${红包金额}$","${有效期}$"};

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data) throws Exception{
		getRedPackNotice(template,data);
	}
	
	/**
	 * 
	 * @Description 红包到账提醒 
	 * @author HouXiangBao289
	 * @param data 格式：用户Id;红包编号
	 * @param template
	 */
	private void getRedPackNotice(OperateMsgTemplateBO template,String[] data)throws Exception {
		if(data.length != 2){
			logger.warn("【通知信息管理】红包到账提醒节点自动通知信息服务收到非法请求数据");
			return;
		}
		Integer userId = Integer.parseInt(data[0]);
		UserInfoBO user = userInfoMapper.findUserInfoById(userId);
		if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
			logger.info("【通知信息管理】该用户渠道已设置不发送获得红包提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
			return;
		}
		DoBusinessBO userRedPacket = doBusinessDaoMapper.findRedPackByCode(userId, data[1]);
		Map<String,String> variables = handleVariable(user,userRedPacket);
		NodeInfo nodeInfo = new NodeInfo();
		nodeInfo.setVariables(variables);
		//APP附近字段数据
		String appFieldsData = getPublicFields(template);
		nodeInfo.setAppFieldsData(appFieldsData);
		List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,true,true,true);
		if(msgs != null){
			msgInfoDaoMapper.addMsgInfo(msgs);
		}
	}
	
	private Map<String,String> handleVariable(UserInfoBO user,DoBusinessBO redPack){
		Map<String,String> map = new HashMap<String,String>();
		map.putAll(getUserVariable(user));
		for(int i=0;i<redPacketKeys.length;i++){
			map.put(redPacketNames[i], redPack.getValueByName(redPacketKeys[i]));
		}
		return map;
	}
}
