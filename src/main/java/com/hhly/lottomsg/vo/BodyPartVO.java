package com.hhly.lottomsg.vo;

import java.io.Serializable;

/**
 * 
* @Description: 邮件附件
* @author HouXiangBao289
* @date 2017年12月19日 下午3:01:16 
* @version V1.0.0
 */
public class BodyPartVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9151173189797575917L;
	
	private String fileName;
	private String mimeType;
	private byte[] is;
	

	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getIs() {
		return is;
	}
	public void setIs(byte[] is) {
		this.is = is;
	}

}
