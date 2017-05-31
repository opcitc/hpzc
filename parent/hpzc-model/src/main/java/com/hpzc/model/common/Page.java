package com.hpzc.model.common;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: 分页
 * @Author caolini
 * @Date 2015年12月15日 上午10:39:14 
 *
 */
public class Page<T> {

	 /** 总信息条数. */
    private long total;
    /** 总页数  */
    private int pages;
    /** 一页显示条数. */
    private int pageSize;
    /** 当前页 */
    private int page;  
    /** 从第几条开始**/
	private int startRow;  
	/** 到第几条结束**/
	private int endRow;  
	/** 排序列 **/
	private List<Order> orderList;
	
	 /** 结果集**/
	private List<T> result; 

	public Page(int pageNum, int pageSize) {  
		this.page = pageNum;  
		this.pageSize = pageSize;  
		this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;  
		this.endRow = pageNum * pageSize;  
	}  

	public Page(int pageNum, int pageSize, List<Order> orderList) 
	{
		this(pageNum, pageSize);
		this.setOrderList(orderList);
	} 

	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int pageNum) {
		this.page = pageNum;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public List<T> getResult() {
		return result;
	}


	public void setResult(List<T> result) {
		this.result = result;
	}


	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
     * @param totalCount
     *            The totalCount to set.
     */
    public void setTotalCount(long total) {
        this.total = total;
    }

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
}
