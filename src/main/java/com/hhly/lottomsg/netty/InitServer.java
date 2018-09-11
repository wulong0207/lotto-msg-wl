package com.hhly.lottomsg.netty;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.hhly.lottomsg.bo.OperateSendBatchBO;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.entity.SaleEndIssue;
import com.hhly.lottomsg.service.BatchMsgService;
import com.hhly.lottomsg.service.IssueService;

/**
 * 
* @Description:自动启动服务
* @author HouXiangBao289
* @date 2017年6月5日 下午4:15:43 
* @version V1.0.0
 */
@Component
public class InitServer implements ApplicationRunner{

	private Logger logger = Logger.getLogger(InitServer.class);
	
	@Autowired
	private BatchMsgService batchMsgService;
	
	@Autowired
	private NettySocketServer nettySocketServer;
	
	@Autowired
	private IssueService issueService;
	
	@Override
	public void run(ApplicationArguments var1)throws Exception 
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run()
			{
				try 
				{
					// 启动竞彩SP推送服务
					new Thread(nettySocketServer).start();
					
					//初始化队列
					batchMsgService.findNoSendMsgToQueue();
					//当天截止彩期加入队列
					issueService.addIssueToQueue();
					
					// 启动任务线程
					startTaskThread();
					
				} 
				catch (Exception e) 
				{
					logger.error("【初始化消息服务】发送异常：");
					e.printStackTrace();
				}
			}
		},10000);
	}
	
	/**
	 * 
	 * @Description 启动执行
	 * @author HouXiangBao289
	 */
	private void startTaskThread(){
		// 批量消息发送
		batchMsgSendTask();
		
		// 销售截止前1小时通知购彩提醒
		saleEndBeforeNoticeTask();
	}
	
	/**
	 * @Description 批量消息发送 (后台手动发送消息)
	 * @author HouXiangBao289
	 */
	private void batchMsgSendTask(){
		new Thread(new Runnable(){
			@Override
			public void run() 
			{
				logger.info("【后台手动发送信息处理服务】服务启动...");
				while(true)
				{
					try 
					{
						OperateSendBatchBO bo = batchMsgService.getQueue().take();
						logger.info("【后台手动发送信息处理服务】后台手动发送批次号：" + bo.getCode() + "开始处理...");
						batchMsgService.sendManualMsg(bo.getCode());
					} 
					catch (Exception e) {
						logger.info("【后台手动发送信息处理服务】发生异常");
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	/**
	 * 
	 * @Description 执行购彩提醒任务
	 * @author HouXiangBao289
	 */
	private void saleEndBeforeNoticeTask(){
		new Thread(new Runnable(){
			@Override
			public void run() 
			{
				while(true)
				{
					try 
					{
						SaleEndIssue issue = issueService.getQueue().take();
						logger.info("【购彩截止提醒服务】" + LotteryEnum.Lottery.getLottery(issue.getLotCode()).getDesc() + issue.getIssueCode() + "期即将截止，开始提醒用户..." );
						issueService.saleEndBeforeNotice(issue);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
