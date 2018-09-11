package com.hhly.lottomsg.vo;

import java.util.Date;

import com.hhly.lottomsg.base.vo.BaseVO;

/**
 * 
 * @author longguoyou
 * @date 2017年6月10日
 * @compay 益彩网络科技有限公司
 */
public class SingleUploadLogVO extends BaseVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自增ID
	 */
	private String id;
	/**
	 * 用户编号
	 */
	private Integer userId;
	/**
	 * 彩种编号
	 */
	private Integer lotteryCode;
	/**
	 * 子玩法编号
	 */
	private Integer lotteryChildCode;
	/**
	 * 文件路径(包括文件名)
	 */
	private String fileUrl;
	/**
	 * 1,成功;2,失败 。默认:1
	 */
	private Short uploadResult;
	/**
	 * 1,选择场次;2,包含场次
	 */
	private Short sessionType;
	/**
	 * 1,首次上转;2,重新上传;3,修改订单总倍数;4,修改投注方式;5,修改条目倍数;
	 */
	private Short operationType;
	/**
	 * 格式转换;1,有;0,无 默认:0
	 */
	private Short shiftType;
	/**
	 * 转换的对应关系(格式规定) 如: 3,1,0 ->a,b,c
	 */
	private String shift;
	/**
	 * 1,txt;2,zip;3,rar
	 */
	private Short fileFormat;
	/**
	 * 如.正常条数和错误条数
	 */
	private String describe;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLotteryCode() {
		return lotteryCode;
	}
	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}
	public Integer getLotteryChildCode() {
		return lotteryChildCode;
	}
	public void setLotteryChildCode(Integer lotteryChildCode) {
		this.lotteryChildCode = lotteryChildCode;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Short getUploadResult() {
		return uploadResult;
	}
	public void setUploadResult(Short uploadResult) {
		this.uploadResult = uploadResult;
	}
	public Short getSessionType() {
		return sessionType;
	}
	public void setSessionType(Short sessionType) {
		this.sessionType = sessionType;
	}
	public Short getOperationType() {
		return operationType;
	}
	public void setOperationType(Short operationType) {
		this.operationType = operationType;
	}
	public Short getShiftType() {
		return shiftType;
	}
	public void setShiftType(Short shiftType) {
		this.shiftType = shiftType;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public Short getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(Short fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
