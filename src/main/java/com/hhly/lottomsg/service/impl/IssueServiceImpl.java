package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.IssueBO;
import com.hhly.lottomsg.bo.OperateMsgConfigLotteryBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.LotMsgType;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.ObjectUtil;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.entity.SaleEndIssue;
import com.hhly.lottomsg.mapper.IssueDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.IssueService;
import com.hhly.lottomsg.service.manage.ThreadPoolManager;
import com.hhly.lottomsg.vo.IssueVO;

/**
 * 
* @Description: 彩期业务处理 
* @author HouXiangBao289
* @date 2017年7月7日 下午3:30:37 
* @version V1.0.0
 */
@Service("issueService")
public class IssueServiceImpl extends NodeMsgServiceBaseImpl implements IssueService {

	@Autowired
	private IssueDaoMapper issueDaoMapper;
	
	private static DelayQueue<SaleEndIssue> queue = new DelayQueue<SaleEndIssue>();
	
	@Value("${sale_end_before_buy}")
	private int endBeforeBuy;
	
	@Override
	public void addIssueToQueue() {
		 List<IssueBO> list = issueDaoMapper.selectTodaySaleEndIssues();
		 if(!ObjectUtil.isBlank(list) && list.size() > 0){
			 queue.clear();
		 }
		 for(IssueBO bo:list){
			 queue.add(new SaleEndIssue(bo));
			 logger.info("【购彩截止提醒服务】彩种："+bo.getLotName()+",期号："+bo.getIssueCode()+",截止时间：" + bo.getSaleEndTime()+" 已添加到通知队列");
		 }
	}

	/**
	 * 销售截止前一个小时购彩提醒
	 */
	@Override
	public void saleEndBeforeNotice(SaleEndIssue queueIssue) {
		IssueBO issue = issueDaoMapper.selectIssue(new IssueVO(queueIssue));
		if(issue != null){
			//通知所有用户
			int allUserCount=userInfoMapper.findValidUserInfoCount();
			int num = 0;
			Map<String,String> map = handleVariable(issue);
			NodeInfo nodeInfo = new NodeInfo();
			nodeInfo.setVariables(map);
			List<UserInfoBO> list =new ArrayList<UserInfoBO>();
			OperateMsgTemplateBO template = msgTemplateMapper.findMsgTemplateByTypeId(endBeforeBuy);
			nodeInfo.setAppFieldsData(getPublicFields(template) + ";lotteryCode:" + issue.getLotCode());
			if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
				logger.warn("【购彩截止提醒服务】购彩提醒模板未添加或已禁用！");
				return;
			}
			List<String> mobiles = userInfoMapper.findUserSameMobile();
			List<String> noMobiles = new ArrayList<String>();
			for (int i=1;i<=allUserCount;i++) 
			{
				if (i % 1000 == 0 || i ==allUserCount) 
				{
					int begin = num * 1000;
					list = userInfoMapper.findValidUserInfo(begin, 1000);
					handleMsgSend(list,nodeInfo,template,issue,mobiles,noMobiles);
					list =new ArrayList<UserInfoBO>();
					num++;
				}
			}
		}
	}

	private void handleMsgSend(final List<UserInfoBO> list,final NodeInfo nodeInfo,final OperateMsgTemplateBO template,final IssueBO issue,final List<String> mobiles,final List<String> noMobiles){
		
		ThreadPoolManager.execute(new Runnable()
		{
			@Override
			public void run()
			{
				List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
				try 
				{
					for (UserInfoBO user : list) 
					{
						if(isNoSendChannel(template.getNoSendChannel(),user.getChannelId())){
							logger.info("【通知信息管理】该用户渠道已设置不发送购彩提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
							continue;
						}
						boolean appLotNotice = false;
						int lotCode = issue.getLotCode();
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
						if(msgs != null){
							msgInfoList.addAll(msgs);
						}
					}
					//保存发送给用户的消息记录
					if(msgInfoList.size() > 0){
						msgInfoDaoMapper.addMsgInfo(msgInfoList);	
					}
				} 
				catch (Exception e)
				{
					logger.error("【购彩截止提醒服务】发生异常：");
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * @Description 
	 * @author HouXiangBao289
	 * @param issue
	 * @return
	 */
	private Map<String,String> handleVariable(IssueBO issue){
		Map<String,String> map = new HashMap<String,String>();
		map.put("${彩种}$", issue.getLotName());
		map.put("${彩期}$", issue.getIssueCode());
		map.put("${彩期销售状态}$", issue.getStatusName());
		map.put("${开奖号码}$", issue.getDrawCode());
		map.put("${滚存}$", issue.getJackpotAmount()==null?"":issue.getJackpotAmount().toString());
		map.put("${本站截止时间}$", DateUtil.convertDateToStr(issue.getSaleEndTime()));
		return map;
	}

	@Override
	public DelayQueue<SaleEndIssue> getQueue() {
		return queue;
	}

//	@Override
//	public List<Integer> findSalingMatchs() {
//		return issueDaoMapper.findSalingMatchs();
//	}
}
