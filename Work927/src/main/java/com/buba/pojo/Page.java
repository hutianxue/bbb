package com.buba.pojo;

import java.util.List;

public class Page {
	private int totalCount;//总数据量
	private int currentPageNo;//当前页
	private int totalPageCount;//总页数
	private int count;//每页数据量
	private List<Object> query;//要分页的数据列表
	private String url;//动态路径
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Object> getQuery() {
		return query;
	}
	public void setQuery(List<Object> query) {
		this.query = query;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", currentPageNo=" + currentPageNo + ", totalPageCount="
				+ totalPageCount + ", count=" + count + ", query=" + query + ", url=" + url + "]";
	}
	

	
}
