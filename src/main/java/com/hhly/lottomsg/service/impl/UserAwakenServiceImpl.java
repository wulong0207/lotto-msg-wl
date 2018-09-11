package com.hhly.lottomsg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hhly.lottomsg.base.service.impl.NodeMsgServiceBaseImpl;
import com.hhly.lottomsg.bo.DoBusinessBO;
import com.hhly.lottomsg.bo.IssueBO;
import com.hhly.lottomsg.bo.LotteryBO;
import com.hhly.lottomsg.bo.OperateCouponTempBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.ConditionKey;
import com.hhly.lottomsg.common.enums.OperateCouponEnum.CouponConfigTypeEnum;
import com.hhly.lottomsg.common.enums.SaleStatus;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.entity.NodeInfo;
import com.hhly.lottomsg.mapper.IssueDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;
import com.hhly.lottomsg.service.UserAwakenService;
import com.hhly.lottomsg.vo.CouponTempVO;
import com.hhly.lottomsg.vo.OperateCouponTempVO;

/**
 * 
 * @Description: 用户唤醒消息服务
 * @author HouXiangBao289
 * @date 2018年1月4日 上午10:09:47
 * @version V1.0.0
 */
@Service("userAwakenService")
public class UserAwakenServiceImpl extends NodeMsgServiceBaseImpl implements UserAwakenService {

	@Autowired
	private IssueDaoMapper issueDaoMapper;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${lotto_activity_url}")
    private String  lottoActivityUrl ;

	// 运营管理信息
	private String[] redPacketKeys = { "redName", "redTypeName", "redMoney", "redOutTime" };
	private String[] redPacketNames = { "${红包名称}$", "${红包类型}$", "${红包金额}$", "${有效期}$" };

	@Override
	public void handleUserAwakenMsg(Integer templateCode) throws Exception {
		OperateMsgTemplateBO msgTemplate = msgTemplateMapper.findMsgTemplateByTypeId(templateCode);
		if (StringUtil.isBlank(msgTemplate.getConditionKey())) {
			logger.warn("【用户唤醒服务】消息模板编号" + msgTemplate.getTypeId() + " 模板名称：" + msgTemplate.getTypeName() + "设置条件为空");
			return;
		} else {
			int code = Integer.parseInt(msgTemplate.getConditionKey());
			ConditionKey conditionKey = ConditionKey.getConditionKey(code);
			switch (conditionKey) {
			case CON1:
				handleCon1Msg(msgTemplate);
				break;
			case CON2:
				handleCon2Msg(msgTemplate);
				break;
			case CON3:
				handleCon3Msg(msgTemplate);
				break;
			case CON4:
				handleCon4Msg(msgTemplate);
				break;
			case CON5:
				handleCon5Msg(msgTemplate);
				break;
			case CON6:
				handleCon6Msg(msgTemplate);
				break;
			case CON7:
				handleCon7Msg(msgTemplate);
				break;
			case CON8:
				handleCon8Msg(msgTemplate);
				break;
			case CON9:
				handleCon9Msg(msgTemplate);
				break;
			case CON10:
				handleCon10Msg(msgTemplate);
				break;
			case CON11:
				handleCon11Msg(msgTemplate);
				break;
			case CON12:
				handleCon12Msg(msgTemplate);
				break;
			case CON13:
				handleCon13Msg(msgTemplate);
				break;
			default:
				logger.warn(
						"【用户唤醒服务】不支持消息模板编号" + msgTemplate.getTypeId() + " 模板名称：" + msgTemplate.getTypeName() + "设置条件");
				break;
			}
		}
	}

	/**
	 * 
	 * @Description
	 * @author HouXiangBao289
	 * @param issue
	 * @return
	 */
	private NodeInfo handleMsgVariable(OperateMsgTemplateBO msgTemplate) {
		NodeInfo nodeMsg = new NodeInfo();
		Map<String, String> map = new HashMap<String, String>();
		Integer lotteryCode = msgTemplate.getToLotteryCode();
		if (lotteryCode != null) {
			IssueBO curIssue = issueDaoMapper.selectLotCurIssue(lotteryCode);
			if (curIssue != null) {
				map.put("${彩种}$", curIssue.getLotName());
				map.put("${彩期}$", curIssue.getIssueCode());
				map.put("${彩期销售状态}$", curIssue.getStatusName());
				map.put("${开奖号码}$", curIssue.getDrawCode());
				map.put("${滚存}$", curIssue.getJackpotAmount() == null ? "" : curIssue.getJackpotAmount().toString());
				map.put("${本站截止时间}$", DateUtil.convertDateToStr(curIssue.getSaleEndTime()));
			}
			LotteryBO lotteryInfo = issueDaoMapper.findLotteryInfo(lotteryCode);
			if (lotteryInfo != null) {
				map.put("${彩种销售状态}$", SaleStatus.getNameByValue(lotteryInfo.getSaleStatus()));
			}

		}
		nodeMsg.setVariables(map);
		nodeMsg.setAppFieldsData(getPublicFields(msgTemplate));
		return nodeMsg;
	}

	/**
	 * 
	 * @Description 处理发送用户通知消息
	 * @author HouXiangBao289
	 * @param msgTemplate
	 * @param users
	 */
	private void noticeUsersMsg(OperateMsgTemplateBO msgTemplate, List<UserInfoBO> users, OperateCouponTempVO vo) {
		if (users != null && users.size() > 0) {
			NodeInfo nodeInfo = handleMsgVariable(msgTemplate);
			List<OperateMsgInfoPO> msgInfoList = new ArrayList<OperateMsgInfoPO>();
			String url = lottoActivityUrl + "activityTemp/findCouponTemp";
			
			// 查询此模板优惠券
			@SuppressWarnings("unchecked")
			ResultBO<List<OperateCouponTempBO>> result = restTemplate.postForObject(url, vo, ResultBO.class);
			List<OperateCouponTempBO> coupons = result.getData();
			logger.info("【用户唤醒消息通知接口】查询此模板优惠券接口处理数据：" + coupons);
			for (UserInfoBO user : users) {
				if (isNoSendChannel(msgTemplate.getNoSendChannel(), user.getChannelId())) {
					logger.info(
							"【通知信息管理】该用户渠道已设置不发送用户唤醒消息，账户：" + user.getAccount() + ",用户注册渠道id：" + user.getChannelId());
					continue;
				}

				Map<String, String> variables = nodeInfo.getVariables();
				variables.putAll(getUserVariable(user));
				if (coupons != null && coupons.size() > 0) {
					for (OperateCouponTempBO coupon : coupons) {
						try {
							DoBusinessBO redPacket = new DoBusinessBO(coupon);
							if (redPacket != null) {
								for (int i = 0; i < redPacketKeys.length; i++) {
									variables.put(redPacketNames[i], redPacket.getValueByName(redPacketKeys[i]));
								}
							}
							List<OperateMsgInfoPO> msgs = handleSendInfo(msgTemplate, user, nodeInfo, true, true,true);
							if (msgs != null) {
								msgInfoList.addAll(msgs);
							}
						} catch (Exception e) {
							logger.error("【用户唤醒服务】发生异常：");
							e.printStackTrace();
						}
					}
				} else {
					List<OperateMsgInfoPO> msgs = handleSendInfo(msgTemplate, user, nodeInfo, true, true,true);
					if (msgs != null) {
						msgInfoList.addAll(msgs);
					}
				}
			}
			if (msgInfoList.size() > 0)
				msgInfoDaoMapper.addMsgInfo(msgInfoList);
		}
	}

	/**
	 * 
	 * @Description 转化
	 * @author HouXiangBao289
	 * @param users
	 * @return
	 */
	private List<Integer> toStrList(List<UserInfoBO> users) {
		List<Integer> ids = new ArrayList<Integer>();
		for (UserInfoBO user : users) {
			ids.add(user.getId());
		}
		return ids;
	}

	/**
	 * 
	 * @Description 发送用户唤醒消息
	 * @author HouXiangBao289
	 * @param users
	 * @param msgTemplate
	 */
	private void sendUserAvakenMsg(OperateMsgTemplateBO msgTemplate, List<UserInfoBO> users) {
		logger.info("【用户唤醒消息通知接口】通知用户数：" + users.size());
		List<Integer> userIds = toStrList(users);
		OperateCouponTempVO vo = new OperateCouponTempVO();
		vo.setConfigId(msgTemplate.getId());
		vo.setConfigType(CouponConfigTypeEnum.WAKEUP.getValue());
		String url = lottoActivityUrl + "activityTemp/addCouponByTemp";
		CouponTempVO requestVO = new CouponTempVO();
		requestVO.setUserIds(userIds);
		requestVO.setOperateCouponTempvo(vo);
		// 查询此模板优惠券
		ResultBO<?> result = restTemplate.postForObject(url, requestVO, ResultBO.class);
		if (result.isOK()) {
			logger.info("【用户唤醒消息通知接口】优惠券接口处理返回成功，开始处理...");
			noticeUsersMsg(msgTemplate, users, vo);
		}
	}

	/**
	 * 
	 * @Description <1>注册第N天未登录：未实名认证用户注册第N天未进行登录
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon1Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon1Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <2>注册第N天未下单：未实名认证用户注册第N天未进行任何订单下单
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon2Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon2Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <3>注册（未实名认证）第N天有下单但未购买：未实名认证用户注册第N天有进行下单，但并未支付购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon3Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon3Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <4>注册并实名认证后第N天未购买：已实名认证用户注册第N天有下单，但并未支付购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon4Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon4Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <5>注册(不区分实名)第N天未购买：所有注册用户（不区分实名）第N天天有进行下单，但并未支付购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon5Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon5Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <6>首单第N天未二单：用户第一个订单成功后第N天未进行下一个成功订单
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon6Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon6Users(msgTemplate.getStartDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <7>首单15-30天内无第二单：用户第一个订单成功后第N天~第N天之间未进行下一个成功订单
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon7Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon7Users(msgTemplate.getStartDays(), msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <8>距上单30到50天未登录：用户距离上一个成功订单第N天~第N天未进行登录
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon8Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon8Users(msgTemplate.getLotteryCodeLimit(),
				msgTemplate.getStartDays(), msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <9>距上单30到50天未购买：用户距离上一个成功订单第N天~第N天未进行购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon9Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon9Users(msgTemplate.getLotteryCodeLimit(),
				msgTemplate.getStartDays(), msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <10>账户余额X元距离上单X天未购买：用户余额N元以上距离上一订单第N天未进行购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon10Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon10Users(msgTemplate.getLotteryCodeLimit(),
				msgTemplate.getStartDays(), msgTemplate.getSetBalance());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <11>距上单15到30天未购买（低客单）：上单金额N元以下用户，第N天~第N天未购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon11Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon11Users(msgTemplate.getSetMoney(),
				msgTemplate.getLotteryCodeLimit(), msgTemplate.getStartDays(), msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <12>距上单30到50天未购买（高客单）：上单金额N元以上用户，第N天~第N天未购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon12Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon12Users(msgTemplate.getSetMoney(),
				msgTemplate.getLotteryCodeLimit(), msgTemplate.getStartDays(), msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

	/**
	 * 
	 * @Description <13>购彩平均值X元X天未购买：上月度购彩金额平率N元以上用户，第N天~第N天未购买
	 * @author HouXiangBao289
	 * @param msgTemplate
	 */
	private void handleCon13Msg(OperateMsgTemplateBO msgTemplate) throws Exception {
		// 查询符合条件用户
		List<UserInfoBO> users = userInfoMapper.findCon13Users(msgTemplate.getSetMoney(), msgTemplate.getStartDays(),
				msgTemplate.getEndDays());
		sendUserAvakenMsg(msgTemplate, users);
	}

}
