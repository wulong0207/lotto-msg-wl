package com.hhly.lottomsg.service.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.service.TemplateMsgService;

/**
 * 
* @Description: 各类消息处理服务工厂
* @author HouXiangBao289
* @date 2017年6月19日 下午4:20:18 
* @version V1.0.0
 */
@Component
public class ServiceFactory {
	
	@Autowired
	private TemplateMsgService openCodeService;
	
	@Autowired
	private TemplateMsgService userInfoUpdateService;
	
	@Autowired
	private TemplateMsgService rechargeMoneyService;
	
	@Autowired
	private TemplateMsgService getRedPacketService;
	
	@Autowired
	private TemplateMsgService extractMoneySubmitService;
	
	@Autowired
	private TemplateMsgService userIpUpdateService;
	
	@Autowired
	private TemplateMsgService userMobileUpdateService;
	
	@Autowired
	private TemplateMsgService cancelOrderService;
	
	@Autowired
	private TemplateMsgService chaseCodeEndService;
	
	@Autowired
	private TemplateMsgService userFollowService;
	
	@Autowired
	private TemplateMsgService recommendOrderService;
	
	@Autowired
	private TemplateMsgService forbiddenNoticeService;
	
	@Autowired
	private TemplateMsgService exchangeErrNoticeService;
	
	@Autowired
	private TemplateMsgService obsoletedNoticeService;
	
	@Autowired
	private TemplateMsgService activityObsoletedService;
	
	@Value("${get_red_packet}")
	private int getRedPacketTypeId;//红包到账提醒模板编号
	
	@Value("${racharge_money}")
	private int rachargeMoney;//充值提醒模板编号
	
	@Value("${open_code}")
	private int openCode;//开奖号码通知模板编号
	
	@Value("${user_info_update}")
	private int userInfoUpdate;//修改会员资料提醒模板编号
	
	@Value("${extract_money}")
	private int extractMoney;//提交提款申请提醒模板编号
	
	@Value("${user_ip_update}")
	private int userIpUpdate;//会员换IP登录模板编号
	
	@Value("${user_mobile_update}")
	private int userMobileUpdate;//会员换手机登录提醒模板编号
	
	@Value("${cancel_order}")
	private int cancelOrder;//撤单通知
	
	@Value("${zhuihao_end}")
	private int zhuiHaoEnd;//追号结束提醒
	
	@Value("${user_follow}")
	private int userFollow;//追号结束提醒
	
	@Value("${recommend_order}")
	private int recommendOrder;//追号结束提醒
	
	@Value("${forbidden_notice}")
	private int forbiddenNotice;//用户禁用提醒
	
	@Value("${exchange_err_notice}")
	private int exchangeErrNotice;//积分兑换失败提醒
	
	@Value("${obsoleted_notice}")
	private int obsoletedNotice;//用户购买已淘汰球队订单提醒
	
	@Value("${activity_obsoleted}")
	private int activityObsoleted;//用户竞猜活动已淘汰球队提醒
	
	public TemplateMsgService getServiceImpl(int typeId) throws Exception{
		if(typeId == openCode){
			return openCodeService;
		}
		else if(typeId == getRedPacketTypeId){
			return getRedPacketService;
		}
		else if(typeId == rachargeMoney){
				return rechargeMoneyService;
		}
		else if(typeId == userInfoUpdate){
			return userInfoUpdateService;
		}
		else if(typeId == extractMoney){
			return extractMoneySubmitService;
		}
		else if(typeId == userIpUpdate){
			return userIpUpdateService;
		}
		else if(typeId == userMobileUpdate){
			return userMobileUpdateService;
		}
		else if(typeId == cancelOrder){
			return cancelOrderService;
		}
		else if(typeId == zhuiHaoEnd){
			return chaseCodeEndService;
		}
		else if(typeId == userFollow){
			return userFollowService;
		}
		else if(typeId == recommendOrder){
			return recommendOrderService;
		}
		else if(typeId == forbiddenNotice){
			return forbiddenNoticeService;
		}
		else if(typeId == exchangeErrNotice){
			return exchangeErrNoticeService;
		}
		else if(typeId == obsoletedNotice){
			return obsoletedNoticeService;
		}
		else if(typeId == activityObsoleted){
			return activityObsoletedService;
		}
		else{
			throw new Exception("未知消息类型");
		}		
	}
}
