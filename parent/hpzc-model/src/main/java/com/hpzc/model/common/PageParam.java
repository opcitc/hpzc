package com.hpzc.model.common;

import java.util.List;
import java.util.Map;

public class PageParam {

	private int page;// 当前页
	private int pageSize;// 每页显示的个数
	private Map<String, Object> searchContent;// 查询map
	//private List<Order> sort;// 排序集合

	// 存储用户信息 放到查询map中
	// public void setActorInfo(ActorInfo pf){
	// if(searchContent.get("sokey")!=""&&searchContent.get("sokey")!=null)
	// {
	// searchContent.put("loginName", pf.getLoginName());
	// }
	//
	//
	// }

	public Map<String, Object> getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(Map<String, Object> searchContent) {
		if (searchContent.get("filter") != "" && searchContent.get("filter") != null) {
			System.out.println(searchContent.get("filter"));
		}
		this.searchContent = searchContent;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

/*	public List<Order> getSort() {
		return sort;
	}

	public void setSort(List<Order> sort) {
		this.sort = sort;
	}*/

}
