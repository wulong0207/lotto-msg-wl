package com.hhly.lottomsg.base.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hhly.lottomsg.common.valid.Group;
import com.hhly.lottomsg.common.valid.NotNull;

@SuppressWarnings("serial")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageVO extends BaseVO {
	
	/**
	 * 排序属性
	 */
	private String sortField;
	/**
	 * 排序方式
	 */
	private String sortOrder;
	
	/**
	 * group by xxx
	 */
	private String groupBy;
	
	/**
	 * 页数,页码从0开始
	 * 从0开始查询
	 */
	@Group("search")
	@NotNull(msg="页数不能为空")
    private Integer  pageIndex;
    /**
     * 页行数
     */
	@Group("search")
	@NotNull(msg="行数不能为空")
    private Integer pageSize;
    
    /**
     * 计算开始行
     * @return
     */
    public Integer getStartRow() {
    	if (pageIndex == null || pageSize == null) {
    		return null;
		}else{
			return pageIndex * pageSize;
		}
	}
    /**
     * 计算结束行
     * @return
     */
	public Integer getEndRow() {
		if (pageIndex == null || pageSize == null) {
			return null;
		}else{
			return pageIndex * pageSize + pageSize;
		}
	}
	
	public String getSortField() {
		return sortField;
	}


	public void setSortField(String sortField) {
		this.sortField = sortField;
	}


	public String getSortOrder() {
		return sortOrder;
	}


	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}


	public Integer getPageIndex() {
		return pageIndex;
	}
	
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

}
