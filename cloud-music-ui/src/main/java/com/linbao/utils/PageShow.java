/**
 * 
 */
package com.linbao.utils;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年11月29日
 * @version 
 * @param <T>
 * @ToDo 
 */
public class PageShow {

	private int startPageIndex;
	private int endPageIndex;
	
	
	/**
	 * 
	 */
	public PageShow() {
		super();
	}
	/**
	 * @param startPageIndex
	 * @param endPageIndex
	 */
	public PageShow(int startPageIndex, int endPageIndex) {
		this.startPageIndex = startPageIndex;
		this.endPageIndex = endPageIndex;
	}
	/**
	 * @return the startPageIndex
	 */
	public int getStartPageIndex() {
		return startPageIndex;
	}
	/**
	 * @param startPageIndex the startPageIndex to set
	 */
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	/**
	 * @return the endPageIndex
	 */
	public int getEndPageIndex() {
		return endPageIndex;
	}
	/**
	 * @param endPageIndex the endPageIndex to set
	 */
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
}
