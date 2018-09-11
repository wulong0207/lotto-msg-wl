package com.hhly.lottomsg.vo;

import java.util.List;

import com.hhly.lottomsg.base.vo.BaseVO;

@SuppressWarnings("serial")
public class SendInfoVO extends BaseVO {
	private String mobile;// 手机号
	private String content;//发送内容
	private String to;//邮箱地址
	private String[] tos;//邮箱地址(多个)
	private String[] filePaths;//文件路径
	private List<BodyPartVO> fileBodyParts;//文件

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getTos() {
		return tos;
	}
	public void setTos(String[] tos) {
		this.tos = tos;
	}
	public String[] getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(String[] filePaths) {
		this.filePaths = filePaths;
	}
	public List<BodyPartVO> getFileBodyParts() {
		return fileBodyParts;
	}
	public void setFileBodyParts(List<BodyPartVO> fileBodyParts) {
		this.fileBodyParts = fileBodyParts;
	}
	
	
}
