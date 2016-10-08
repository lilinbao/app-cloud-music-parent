/**
 * 
 */
package com.linbao.listener;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月30日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class UploadStatus {

	private long readbytes;
	private long contentLengh;
	private int item;
	/**
	 * @return the readbytes
	 */
	public long getReadbytes() {
		return readbytes;
	}
	/**
	 * @param readbytes the readbytes to set
	 */
	public void setReadbytes(long readbytes) {
		this.readbytes = readbytes;
	}
	/**
	 * @return the contentLengh
	 */
	public long getContentLengh() {
		return contentLengh;
	}
	/**
	 * @param contentLengh the contentLengh to set
	 */
	public void setContentLengh(long contentLengh) {
		this.contentLengh = contentLengh;
	}
	/**
	 * @return the item
	 */
	public int getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(int item) {
		this.item = item;
	}
	
}
