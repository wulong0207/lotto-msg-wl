package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.IssueBO;
import com.hhly.lottomsg.bo.OperateMsgConfigLotteryBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.LotMsgType;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.IssueDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.TemplateMsgService;
import com.hhly.lottomsg.vo.IssueVO;

/**
 * 
* @Description: 开奖号码通知 
* @author HouXiangBao289
* @date 2017年6月19日 下午4:15:41 
* @version V1.0.0
 */
@Service("openCodeService")
public class OpenCodeServiceImpl extends NodeMsgServiceBaseImpl implements TemplateMsgService{
	
	@Autowired
	protected IssueDaoMapper issueDaoMapper;
	
	private Logger logger = Logger.getLogger(OpenCodeServiceImpl.class.getName());
	
	// 
	private String[] keys = {"lotName","issueCode","statusName","drawCode","jackpotAmount"}; 
	
	private String[] names = {"${彩种}$","${彩期}$","${彩期销售状态}$","${开奖号码}$","${滚存}$"};

	@Override
	public void handleTemplateMsg(OperateMsgTemplateBO template,String[] data){
		try{
			openCodeNotice(template,data);
		}catch(Exception e){
			logger.warn("【通知信息管理】开奖号码通知提醒节点自动通知信息服务异常：");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description 处理开奖号码通知
	 * @author HouXiangBao289
	 * @param data 格式：彩种编号;期号;开奖结果
	 * @param template
	 * @throws Exception
	 */
	private void openCodeNotice(OperateMsgTemplateBO template,String[] data) throws Exception{
		if(template == null || template.getStatus().intValue() == UseStatus.INVALID.getCode().intValue()){
			logger.warn("【通知信息管理】开奖号码通知模板未添加或已禁用！");
			return;
		}
		if(data.length != 3){
			logger.warn("【通知信息管理】开奖号码通知节点自动通知信息服务收到非法请求数据");
			return;
		}
		
		String sendLotterys = template.getSendLotteryCode();
		if(isNoSendLot(sendLotterys,data[0])){
			logger.info("【通知信息管理】开奖号码通知模板已设置不支持此彩种开奖号码通知，彩种编号：" + data[0]);
			return;
		}
		int lotCode = Integer.parseInt(data[0]);
		IssueVO vo = new IssueVO();
		vo.setLotCode(lotCode);
		vo.setIssueCode(data[1]);
		// 查询彩期信息
		IssueBO bo = issueDaoMapper.selectIssue(vo);
		// 处理动态变量
		Map<String,String> variables= handleVariable(bo);
		NodeInfo nodeInfo = new NodeInfo();
		//APP附近字段数据
		String appFieldsData = getPublicFields(template)
				+ ";lotteryCode:" + bo.getLotCode();
		nodeInfo.setAppFieldsData(appFieldsData);
		nodeInfo.setVariables(variables);
		//通知所有用户
		int allUserCount=userInfoMapper.findValidUserInfoCount();
		List<String> mobiles = userInfoMapper.findUserSameMobile();
		List<String> noMobiles = new ArrayList<String>();
		int num = 0;
		// 组装开奖通知动态数据
		for (int i=1;i<=allUserCount;i++)
		{
			if (i % 1000 == 0 || i ==allUserCount)
			{
				int begin = num * 1000;
				List<UserInfoBO> list =new ArrayList<UserInfoBO>();
				list = userInfoMapper.findValidUserInfo(begin, 1000);
				List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
				for(UserInfoBO user:list)
				{
					if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
						logger.info("【通知信息管理】该用户渠道已设置不发送开奖号码通知消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
						continue;
					}
					boolean appLotNotice = false;
					// 1为开奖号码通知，2为购彩提醒，目前只有两种消息类型
					OperateMsgConfigLotteryBO lotMsgConfig = userMsgConfigMapper.findLotteryMsgConfig(user.getId(), lotCode,LotMsgType.KJHMTZ.getCode());
					if((lotMsgConfig != null && lotMsgConfig.getApp().equals((int)UseStatus.VALID.getCode()))
							|| (lotMsgConfig == null && (lotCode == 100 || lotCode == 102))){// 默认只打开双色球和大乐透发送开关
						appLotNotice = true;
					}
					
					boolean isSmsSend = true;// 多账号绑定同一手机号只发送一次
					String userMobile = user.getMobile();
					if(mobiles.contains(userMobile)){
						if(noMobiles.contains(userMobile)){
							isSmsSend = false;
						}else{
							noMobiles.add(userMobile);
						}
					}
					List<OperateMsgInfoPO> msgs = handleSendInfo(template,user,nodeInfo,appLotNotice,isSmsSend,true);
					if(msgs!=null){
						msgInfoList.addAll(msgs);
					}
				}
				if(msgInfoList.size() > 0)
					msgInfoDaoMapper.addMsgInfo(msgInfoList);
				num++;
			}
		}
	}
	
	private Map<String,String> handleVariable(IssueBO bo){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<keys.length;i++){
			map.put(names[i], bo.getValueByName(keys[i]));
		}
		return map;
	}

}
