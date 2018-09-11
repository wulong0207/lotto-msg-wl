package com.hhly.lottomsg.service;

import java.util.List;

import com.hhly.lottomsg.vo.BodyPartVO;

/**
 * 
* @Description: 发送服务接口
* @author HouXiangBao289
* @date 2017年12月11日 下午4:52:54 
* @version V1.0.0
 */
public interface ISendService {

	/**
	 * 
	 * @Description 发送短信接口 
	 * @author HouXiangBao289
	 * @param mobile 手机号
	 * @param content短信内容
	 * @return
	 */
	public boolean doSendSms(String mobile,String content);
	
	/**
	 * 
	 * @Description 发送邮件接口 
	 * @author HouXiangBao289
	 * @param to 邮件地址
	 * @param content 邮件内容
	 * @return
	 */
	public boolean doSendMail(String to,String content);
	
	/**
	 * 
	 * @Description 发送邮件接口 
	 * @author HouXiangBao289
	 * @param toArr 邮件地址(群发)
	 * @param content 内容
	 * @param filePathArr 附件路径
	 * @return
	 */
	public boolean doSendFilePathMail(String[] toArr,String content,String[] filePathArr);
	
	/**
	 * 
	 * @Description 邮件发送(传递附件数据BodyPart)
	 * @author HouXiangBao289
	 * @param toArr
	 * @param content
	 * @param fileBodyPartList 
	 * @return
	 */
	public boolean doSendBodyPartMail(String[] toArr, String content, List<BodyPartVO> fileBodyPartList);
}
