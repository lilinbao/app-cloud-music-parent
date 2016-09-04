/**
 * 
 */
package com.linbao.listener;

import java.util.Map;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.struts2.ServletActionContext;




/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月25日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class UploadingListener implements ProgressListener{
	
	UploadStatus ups ;

	public UploadingListener(UploadStatus ups){
		this.ups = ups;
		//System.out.println(this.getClass().getSimpleName()+" init completed!");
	}
	/* (non-Javadoc)
	 * @see org.apache.commons.fileupload.ProgressListener#update(long, long, int)
	 */
	@Override
	public void update(long readbytes, long contentLengh, int itemIndex) {
		// TODO Auto-generated method stub
		ups.setContentLengh(contentLengh);
		ups.setReadbytes(readbytes);
		ups.setItem(itemIndex);
		Map<String,Object> session = ServletActionContext.getContext().getSession();
		session.put("processStatus", ups);
		//System.out.println("====================update completed ======================");
	}
	/**
	 * @return the ups
	 */
	public UploadStatus getUps() {
		return ups;
	}
	/**
	 * @param ups the ups to set
	 */
	public void setUps(UploadStatus ups) {
		this.ups = ups;
	}

}
