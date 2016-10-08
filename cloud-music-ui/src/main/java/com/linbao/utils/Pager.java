/**
 * 
 */
package com.linbao.utils;

import java.util.List;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年11月29日
 * @version 
 * @param <T>
 * @ToDo 
 */
public class Pager {

	private List<?> records;
	
	private int currentPage;
	
	private int pageSize;
	
	private int totalPage;
	
	private int pageCode;
	
	private int startPage;

	private PageShow pageShow;
	
	public Pager() {
	}

	/**
	 * @param currentPage
	 * @param pageSize
	 * @param startPage
	 */
	public Pager(int currentPage, int pageSize, int startPage) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.startPage = startPage;
	}

	/**
	 * @return the records
	 */
	public List<?> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<?> records) {
		this.records = records;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the pageCode
	 */
	public int getPageCode() {
		return pageCode;
	}

	/**
	 * @param pageCode the pageCode to set
	 */
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	/**
	 * @return the startPage
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	/**
	 * @return the pageShow
	 */
	public PageShow getPageShow() {
		return pageShow;
	}
	/**
	 * @param pageShow the pageShow to set
	 */
	public void setPageShow(PageShow pageShow) {
		this.pageShow = pageShow;
	}
	
}
