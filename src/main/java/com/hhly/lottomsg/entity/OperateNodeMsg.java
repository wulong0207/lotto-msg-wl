package com.hhly.lottomsg.entity;

/**
 * 
* @Description: 各执行节点自动通知消息
* @author HouXiangBao289
* @date 2017年5月17日 下午3:01:24 
* @version V1.0.0
 */
public class OperateNodeMsg {
	
	private Integer nodeId;// 执行节点
	private String nodeData;//节点数据,格式：value1;value2;value3
	
	public OperateNodeMsg(){}

	public OperateNodeMsg(Integer nodeId, String nodeData){
		this.nodeId = nodeId;
		this.nodeData = nodeData;
	}
	/**
	 * 
	 * @Description 节点Id
	 * @author HouXiangBao289
	 * @return
	 */
	public Integer getNodeId() {
		return nodeId;
	}

	/**
	 * 
	 * @Description 节点Id
	 * @author HouXiangBao289
	 * @return
	 */
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	
	/**
	 * 
	 * @Description 节点数据 ，格式：name1:value1;name2:value2
	 * @author HouXiangBao289
	 * @return
	 */
	public String getNodeData() {
		return nodeData;
	}

	/**
	 * 
	 * @Description 节点数据，格式：name1:value1;name2:value2
	 * @author HouXiangBao289
	 * @return
	 */
	public void setNodeData(String nodeData) {
		this.nodeData = nodeData;
	}

	
}
