package com.hhly.lottomsg.msg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hhly.lottomsg.bo.OperateMsgConfigBO;
import com.hhly.lottomsg.bo.OperateMsgInfoBO;
import com.hhly.lottomsg.bo.OperateMsgNewBO;
import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OperateWechatTemplateBO;
import com.hhly.lottomsg.bo.UserInfoBO;
import com.hhly.lottomsg.common.enums.OrderEnum.NumberCode;
import com.hhly.lottomsg.common.util.DateUtil;
import com.hhly.lottomsg.common.util.OrderNoUtil;
import com.hhly.lottomsg.mapper.MsgInfoDaoMapper;
import com.hhly.lottomsg.mapper.MsgTemplateDaoMapper;
import com.hhly.lottomsg.mapper.NewMsgDaoMapper;
import com.hhly.lottomsg.mapper.UserInfoDaoMapper;
import com.hhly.lottomsg.mapper.UserMsgConfigDaoMapper;
import com.hhly.lottomsg.po.OperateMsgInfoPO;

/**
 * 通知信息DAO方法测试
* @Description: 
* @author HouXiangBao289
* @date 2017年6月5日 上午10:41:27 
* @version V1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})  
//@Transactional  
//@TransactionConfiguration(transactionManager = "transactionManager")  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class MsgDaoMapperTest {
	
	@Autowired
	private MsgInfoDaoMapper msgDaoMapper;
	
	@Autowired
	private MsgTemplateDaoMapper msgTemplateMapper;
	
	@Autowired
	private NewMsgDaoMapper newMsgMapper;
	
	@Autowired
	private UserInfoDaoMapper userInfoMapper;
	
	@Autowired
	private UserMsgConfigDaoMapper userMsgConfigMapper;
	
	/**
	 * 
	 * @Description 更新通知信息发送状态
	 * @author HouXiangBao289
	 */
	@Test
	public void testUpdateMsgSendStatus(){
		int sum = msgDaoMapper.updateMsgSendStatus("SC1705261701122001",188,1,1,"");
		System.out.println("【通知消息系统】更新通知信息状态，返回结果：" + sum);
	}
	
	/**
	 * 
	 * @Description 根据批次号查询发送信息详情
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindNewMsgByBatch(){
		OperateMsgNewBO bo = newMsgMapper.findNewMsgByBatch("SC1705232110211001");
		if(bo != null){
			System.out.println("【通知消息系统】 查询发送信息详情，id：" + bo.getId());	
		}else{
			System.out.println("【通知消息系统】 查询发送信息详情提示 没有找到相关记录");
		}
	}
	
	/**
	 * 
	 * @Description 根据Id更新状态
	 * @author HouXiangBao289
	 */
	@Test
	public void testUpdateNewMsgStatus(){
		int num = newMsgMapper.updateNewMsgStatus(1,1);
		System.out.println("【通知消息系统】 根据Id更新状态，返回结果：" + num); 
	}
	
	/**
	 * 
	 * @Description 查询有效用户数
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindValidUserInfoCount(){
		int num = userInfoMapper.findValidUserInfoCount();
		System.out.println("【通知消息系统】 查询有效用户数：" + num);
	}
	
	/**
	 * 
	 * @Description 查询有效用户
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindValidUserInfo(){
		List<UserInfoBO> list = userInfoMapper.findValidUserInfo(1,10);
		System.out.println("【通知消息系统】 查询有效用户，list size：" + list.size());
	}
	
	/**
	 * 
	 * @Description 根据用户id集合分次查询用户列表
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindUserInfoByIds(){
		List<Integer> userIds = new ArrayList<Integer>();
		userIds.add(98);
		userIds.add(99);
		userIds.add(100);
		userIds.add(101);
		List<UserInfoBO> list = userInfoMapper.findUserInfoByIds(userIds);
		System.out.println("【通知消息系统】 批次查询用户(userId：98、99、100、101)的信息详情，list size：" + list.size());
	}
	
	/**
	 * 
	 * @Description 新增通知消息
	 * @author HouXiangBao289
	 */
	@Test
	public void testAddMsgInfo(){
		List<OperateMsgInfoPO> msgs = new ArrayList<OperateMsgInfoPO>();
		OperateMsgInfoPO po = new OperateMsgInfoPO();
		po.setCusMobile(Long.parseLong("15811821078"));
		po.setMsgBatch(OrderNoUtil.getOrderNo(NumberCode.SEND_BATCH));
		po.setMsgContent("junit test");
		po.setMsgTitle("test");
		po.setMsgType(1);
		po.setPreSendTime(DateUtil.getAfterDayHour(2, 0));
		po.setUserId(99);
		po.setTemplateId(25);
		po.setSendType((short)1);
		msgs.add(po);
		int num = msgDaoMapper.addMsgInfo(msgs);
		System.out.println("【通知消息系统】 批量插入通知信息，返回结果：" + num);
	}
	
	/**
	 * 
	 * @Description 查询用户接收设置信息
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindUserConfig(){
		OperateMsgConfigBO bo = userMsgConfigMapper.findUserConfig(302,19);
		if(bo != null)
			System.out.println("【通知消息系统】 查询用户接收设置信息，返回Id：" + bo.getId());
	}
	
	/**
	 * 
	 * @Description 查询信息模板详情
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindMsgTemplateById(){
		OperateMsgTemplateBO bo = msgTemplateMapper.findMsgTemplateById(15);
		if(bo != null)
			System.out.println("【通知消息系统】查询信息模板详情，返回Id：" + bo.getId());
	}
	
	/**
	 * 
	 * @Description 根据模板编号查询信息模板详情
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindMsgTemplateByTypeId(){
		OperateMsgTemplateBO bo = msgTemplateMapper.findMsgTemplateByTypeId(100);
		System.out.println("【通知消息系统】根据模板编号查询信息模板详情，返回Id：" + bo.getId());
	}
	
	/**
	 * 
	 * @Description 查询微信公众号模板设置详情
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindWechatTemplateById(){
		OperateWechatTemplateBO bo = msgTemplateMapper.findWechatTemplateById(25);
		if(bo != null)
			System.out.println("【通知消息系统】查询微信公众号模板设置详情，返回Id：" + bo.getId());
	}
	
	/**
	 * 
	 * @Description 查询通知信息详情
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindMsgInfoById(){
		OperateMsgInfoBO bo = msgDaoMapper.findMsgInfoById(6721);
		if(bo != null)
			System.out.println("【通知消息系统】查询通知信息详情，返回Id：" + bo.getId());
	}

}
