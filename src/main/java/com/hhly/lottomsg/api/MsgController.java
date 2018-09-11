package com.hhly.lottomsg.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hhly.lottomsg.base.controller.BaseController;
import com.hhly.lottomsg.bo.OperateCouponBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.UseStatus;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.BatchMsgService;
import com.hhly.lottomsg.service.CouponService;
import com.hhly.lottomsg.service.IssueService;
import com.hhly.lottomsg.service.MsgTemplateSerivce;
import com.hhly.lottomsg.service.NodeMsgService;
import com.hhly.lottomsg.service.UserAwakenService;
import com.hhly.lottomsg.service.UserInfoService;
import com.hhly.lottomsg.service.manage.ThreadPoolManager;

@RestController
public class MsgController extends BaseController{
	
	private Logger logger = Logger.getLogger(MsgController.class);
	
	// 竞彩代购中奖通知模板编号
	@Value("${jc_daigou_prize}")
	private int jcDaiGouPrize;
	
	@Value("${red_packet_out_time}")
	private int redPacketOuttimeTypeId;
	
	@Value("${birthday_benediction}")
	private int birthdayBenedictionTypeId;
	
	@Autowired
	private MsgTemplateSerivce msgTemplateService;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private NodeMsgService nodeMsgService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private UserAwakenService userAwakenService;
	
	@Autowired
	private BatchMsgService batchMsgService;
	
	/**
	 * 
	 * @Description 用户唤醒(定时任务调度)
	 * @author HouXiangBao289
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/task/userAwaken")
	public  Object userAwaken(@RequestParam(value = "templateCode", required = true) final Integer templateCode) {
		logger.info("用户唤醒消息通知接口开始处理，消息模板编号：" + templateCode);
		ThreadPoolManager.execute(new Runnable() {
			@Override
			public void run() {
				try {
					userAwakenService.handleUserAwakenMsg(templateCode);
				} catch (Exception e) {
					logger.error("定时任务用户唤醒消息通知接口处理异常：");
					e.printStackTrace();
				}
			}
		 });
		return ResultBO.ok();
	}
	
	/**
	 * 
	 * @Description 待发消息处理
	 * @author HouXiangBao289
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/task/sendWaitMsg")
	public  Object sendWaitMsg(@RequestParam(value = "templateCode", required = true) final Integer templateCode) {
		logger.info("待发消息通知接口开始处理，消息模板编号：" + templateCode);
		ThreadPoolManager.execute(new Runnable() {
			@Override
			public void run() {
				try {
					batchMsgService.sendWaitMsg(templateCode);
				} catch (Exception e) {
					logger.error("定时任务待发消息通知接口处理异常：");
					e.printStackTrace();
				}
			}
		 });
		return ResultBO.ok();
	}
	
	/**
	 * 
	 * @Description 竞彩代购中奖通知(定时任务调度)
	 * @author HouXiangBao289
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/task/jcPrizeNotice")
	public  Object jcPrizeNotice(HttpSession session) {
		logger.info("【通知信息服务】竞彩代购中奖通知任务开始处理...");
		ThreadPoolManager.execute(new Runnable() {
			@Override
			public void run() {
				try {
					msgTemplateService.sendTemplateMsgs(jcDaiGouPrize);
				} catch (Exception e) {
					logger.error("定时任务竞彩代购中奖通知接口处理发生异常：");
					e.printStackTrace();
				}
			}
		 });
		return ResultBO.ok();
	}
	
	/**
	 * 
	 * @Description 处理红包过期通知(定时任务调度)
	 * @author HouXiangBao289
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/task/redPacketOutTimeNotice")
	public  Object redPacketOutTimeNotice(HttpSession session) {
		logger.info("【通知信息服务】红包过期提醒任务开始处理...");
		ThreadPoolManager.execute(new Runnable() {
			@Override
			public void run() {
				// 处理
				try {
					// 查找三天后过期的红包
					List<OperateCouponBO> list = couponService.findList(0);
					// 查询红包过期提醒消息模板
					OperateMsgTemplateBO template = msgTemplateService.findMsgTemplateByTypeId(redPacketOuttimeTypeId);
					if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
							logger.warn("【通知信息服务】红包过期提醒模板未添加或已禁用！");
					}
					// 保存入库数据
					List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
					List<Integer> users = new ArrayList<Integer>();
					NodeInfo nodeInfo = new NodeInfo();
					nodeInfo.setAppFieldsData("activityUrl:" + (template.getActivityUrl()==null?"":template.getActivityUrl())  
				+ ";toBuyLotteryCode:" + (template.getToLotteryCode()==null?"":template.getToLotteryCode()));
					String noSendChannels= template.getNoSendChannel();
					for(OperateCouponBO coupon:list){
						logger.info("【通知信息服务】红包三天后过期提醒，红包编号：" + coupon.getRedCode());
						if(coupon.getUserId() == null || users.contains(coupon.getUserId()))
							continue;
						// 查询用户信息
						UserInfoBO  user = userInfoService.findUserInfoById(coupon.getUserId());
						if(user != null){
							if(!StringUtil.isBlank(noSendChannels)){
								noSendChannels = noSendChannels + ",";
								if(noSendChannels.contains(user.getChannelId() + ",")){
									logger.info("【通知信息管理】该用户渠道已设置不发送红包过期提醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
									continue;
								}
							}
							Map<String,String> paramValue = new HashMap<String,String>();
							paramValue.put("${昵称}$", user.getNickname()==null?"":user.getNickname());
							nodeInfo.setVariables(paramValue);
							List<OperateMsgInfoPO> msgs = nodeMsgService.handleSendInfo(template,user,nodeInfo,true,true,true);
							if(msgs != null){
								msgInfoList.addAll(msgs);
							}
						}
						users.add(coupon.getUserId());
					}
					// 通知信息入库
					nodeMsgService.addMsgInfo(msgInfoList);
					// 更新红包过期通知状态
					couponService.updCouponStatus(list, 1);
				} catch (Exception e) {
					logger.error("红包过期通知接口处理发生异常：");
					e.printStackTrace();
				}
			}
		 });
		return ResultBO.ok();
	}
	
	/**
	 * 
	 * @Description 生日祝福(定时任务调度)
	 * @author HouXiangBao289
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/task/userBirthdayNotice")
	public  Object userBirthdayNotice(HttpSession session) {
		logger.info("【通知信息服务】生日祝福任务开始处理...");
		ThreadPoolManager.execute(new Runnable() {
			@Override
			public void run() {
				// 处理
				try {
					// 查询红包过期提醒消息模板
					OperateMsgTemplateBO template = msgTemplateService.findMsgTemplateByTypeId(birthdayBenedictionTypeId);
					if(template == null || template.getStatus().equals(UseStatus.INVALID.getCode())){
						logger.warn("【通知信息服务】生日祝福模板未添加或已禁用！");
					}
					List<UserInfoBO> birthdayUserList = userInfoService.findBirthdayUser();
					// 保存入库数据
					List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
					if(birthdayUserList.size() > 0){
						NodeInfo nodeInfo = new NodeInfo();
						nodeInfo.setAppFieldsData("activityUrl:" + (template.getActivityUrl()==null?"":template.getActivityUrl())  
								+ ";toBuyLotteryCode:" + (template.getToLotteryCode()==null?"":template.getToLotteryCode()));
						String noSendChannels= template.getNoSendChannel();
						for(UserInfoBO user:birthdayUserList){
							if(!StringUtil.isBlank(noSendChannels)){
								noSendChannels = noSendChannels + ",";
								if(noSendChannels.contains(user.getChannelId() + ",")){
									logger.info("【通知信息管理】该用户渠道已设置不发送生日祝福消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
									continue;
								}
							}
							logger.info("【通知信息服务】生日祝福，生日用户：" + user.getNickname() + "用户Id：" + user.getId());
							Map<String,String> paramValue = new HashMap<String,String>();
							paramValue.put("${昵称}$", user.getNickname());
							nodeInfo.setVariables(paramValue);
							List<OperateMsgInfoPO> msgs = nodeMsgService.handleSendInfo(template,user,nodeInfo,true,true,true);
							if(msgs != null){
								msgInfoList.addAll(msgs);
							}
						}
					}
					nodeMsgService.addMsgInfo(msgInfoList);	// 通知信息入库
				} catch (Exception e) {
					logger.error("生日祝福接口处理发生异常：");
					e.printStackTrace();
				}
			}
		 });
		return ResultBO.ok();
	}
	
	/**
	 * 
	 * @Description 把今日数字彩截止的期信息加入队列(定时任务调度)
	 * @author HouXiangBao289
	 * @throws Exception
	 */
	@RequestMapping(value = "/task/loadSaleEndIssue")
	public Object loadSaleEndIssue(){
		try{
			issueService.addIssueToQueue();
		}
		catch(Exception e){
			logger.error("今日数字彩截止的期信息加入队列处理发生异常：");
			e.printStackTrace();
		}
		return ResultBO.ok();
	}
}
