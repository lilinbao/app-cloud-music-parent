/**
 * 
 */
package com.linbao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.linbao.exception.AuthorizationException;
import com.linbao.listener.UploadStatus;
import com.linbao.service.IFileService;
import com.linbao.utils.Common;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月17日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class FileUploadAction extends BaseAction{

	//private static final String classname = FileUploadAction.class.getName();
/**
	 * 
	 */
	public FileUploadAction() {
		//System.out.println( classname + " init completed" );
	}
private static final long serialVersionUID = 1L;
	
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;
	private IFileService fileService;
	public String upload() throws AuthorizationException, IOException{
		String flag = "decline";
		for (int i=0;i<upload.size();i++){
			System.out.println("=======content type is " +getRequest().getContentType()+"=======");;
			if(this.getUploadContentType().get(i).startsWith("image")){
				flag = imgupload();
			}else if(this.getUploadContentType().get(i).startsWith("application")){
				flag = fileupload();
			}else{
				flag = "fileupload";
			}
		}
		return flag;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String fileupload() throws AuthorizationException ,IOException{
		String root = ServletActionContext.getServletContext().getRealPath("/uploads");
		InputStream is = null;
		OutputStream os = null;
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < upload.size(); i++){
			String str = uploadFileName.get(i).substring(uploadFileName.get(i).lastIndexOf("\\")+1);
			File f = Common.CreateFile(root, str);
			is = new FileInputStream(upload.get(i));
			os = new FileOutputStream(f);
			int len = 0;
			byte[] buffer = new byte[1024];
			while(len != -1){
				len = is.read(buffer, 0, buffer.length);
				os.write(buffer);
				//System.out.println("*******************content = " + buffer.toString()+"******************");
			}
			is.close();
			os.close();
			list.add(root.substring(root.lastIndexOf("\\")+1)+"\\"+str);
		}
		getSession().put("uploadList", list);
		return SUCCESS;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String imgupload() throws AuthorizationException ,IOException{
		String root = ServletActionContext.getServletContext().getRealPath("/uploads/img");
		InputStream is = null;
		OutputStream os = null;
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < upload.size(); i++){
			String str = uploadFileName.get(i).substring(uploadFileName.get(i).lastIndexOf("\\")+1);
			File f = Common.CreateFile(root, str);
			is = new FileInputStream(upload.get(i));
			os = new FileOutputStream(f);
			int len = 0;
			byte[] buffer = new byte[1024];
			while(len != -1){
				len = is.read(buffer, 0, buffer.length);
				os.write(buffer);
				//System.out.println("*******************content = " + buffer.toString()+"******************");
			}
			is.close();
			os.close();
			list.add(root.substring(root.lastIndexOf("\\")+1)+"\\"+str);
		}
		getSession().put("uploadList", list);
		return SUCCESS;
	}
	public void uploadStatus() throws Exception{
		BigDecimal read ;
		BigDecimal total;
		BigDecimal bdpercent;
		double percent = 0.00;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UploadStatus ups = (UploadStatus) getSession().get("processStatus");
		if(null!=ups){
			if(0 != ups.getReadbytes()){
				read = new BigDecimal(ups.getReadbytes());
				//System.out.println("convert to BigDecimal : read is " + read.toString());
				total = new BigDecimal(ups.getContentLengh());
				//System.out.println("convert to BigDecimal : total is " + total.toString());
				bdpercent = read.divide(total, 2, BigDecimal.ROUND_UP);
				percent = bdpercent.doubleValue();
			}
		}else{
			System.out.println("ups is null");
		}
		out.print((int)(percent*100));
		out.flush();
		out.close();
		
		//return null;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#addActionError(java.lang.String)
	 */
	@Override
	public void addActionError(String anErrorMessage) {
		System.out.println(anErrorMessage);
		if(anErrorMessage.startsWith("the request was rejected because its size")){
			this.addFieldError("tooLarge", this.getText("struts.upload.too.large"));
		}
		//super.addActionError(anErrorMessage);
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#addActionMessage(java.lang.String)
	 */
	@Override
	public void addActionMessage(String aMessage) {
		// TODO Auto-generated method stub
		super.addActionMessage(aMessage);
	}
	/**
	 * @return the fileService
	 */
	public IFileService getFileService() {
		return fileService;
	}
	/**
	 * @param fileService the fileService to set
	 */
	public void setFileService(IFileService fileService) {
		this.fileService = fileService;
	}
	/**
	 * @return the upload
	 */
	public List<File> getUpload() {
		return upload;
	}
	/**
	 * @param upload the upload to set
	 */
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	/**
	 * @return the uploadFileName
	 */
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	/**
	 * @return the uploadContentType
	 */
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
}
