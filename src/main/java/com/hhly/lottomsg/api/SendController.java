package com.hhly.lottomsg.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhly.lottomsg.base.controller.BaseController;
import com.hhly.lottomsg.bo.ResultBO;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.common.util.StringUtil;
import com.hhly.lottomsg.service.ISendService;
import com.hhly.lottomsg.vo.SendInfoVO;

@RestController
public class SendController extends BaseController{
	
	private Logger logger = Logger.getLogger(SendController.class);
	
	@Autowired
	private ISendService sendService;
	
	/**
	 * 
	 * @Description 把今日数字彩截止的期信息加入队列(定时任务调度)
	 * @author HouXiangBao289
	 * @throws Exception
	 */
	@RequestMapping(value = "/send")
	public Object send(SendInfoVO vo){
		logger.info("【发送服务】收到信息：" + JsonUtil.objectToJson(vo));
		try{
			
			if(!StringUtil.isBlank(vo.getMobile())){
				sendService.doSendSms(vo.getMobile(), vo.getContent());
			}
			else if(!StringUtil.isBlank(vo.getTo())){
				sendService.doSendMail(vo.getTo(), vo.getContent());
			}
			else if(vo.getTos().length>0){
				if(vo.getFilePaths().length > 0){
					sendService.doSendFilePathMail(vo.getTos(), vo.getContent(), vo.getFilePaths());
				}
				else if(vo.getFileBodyParts().size() > 0){
					sendService.doSendBodyPartMail(vo.getTos(), vo.getContent(), vo.getFileBodyParts());
				}
			}
			return ResultBO.ok();
		}
		catch(Exception e){
			logger.error("【发送服务】处理发生异常：");
			e.printStackTrace();
			return ResultBO.err();
		}
	}
	
	
}
