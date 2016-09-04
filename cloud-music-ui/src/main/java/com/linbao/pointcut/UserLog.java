/**
 * 
 */
package com.linbao.pointcut;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年1月2日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public class UserLog {

	private SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String fileLocation ;
    private String fileName;
    /** 
     * 将信息记录到日志到文件 
     * @param logFile 日志文件 
     * @param mesInfo 信息 
     * @throws IOException  
     */
    public void logMsg(final File logFile,final String mesInfo) throws IOException{ 
    	new Thread(){
			@Override
			public void run() {
				if(null == logFile) {
		            throw new IllegalStateException("logFile can not be found!");  
		        }
		        Writer txtWriter = null;
				try {
					System.out.println("logfile's location is "+logFile.getAbsolutePath());
					txtWriter = new FileWriter(logFile,true);
					txtWriter.append(dateFormat.format(new Date()) +"\t"+mesInfo+"\r\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(logFile.getPath());
					System.out.println("file can't be open");
					e1.printStackTrace();
				}finally{
						try{
							txtWriter.flush();
							txtWriter.close();
						}catch(IOException e){
							e.printStackTrace();
					}
				}
			}
    	}.start();
    }  
    public void before(JoinPoint p) throws IOException{
    	
    	System.out.println("before");
    }
    public void after(JoinPoint p)throws IOException,Exception{
    	String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    	StringBuffer folder = new StringBuffer(this.getFileLocation()+"\\"+date+"\\");
    	File logFile = this.createLogFile(folder.toString(), folder+this.getFileName());
    	String logMsg = this.formatedMessage(p);
    	this.logMsg(logFile, logMsg);
    	System.out.println("after");
    }
    /**
     * @functional 创建一个文件,若文件目录不存在，则创建文凭目录
     * @param String folder,String fileName
     * @return File 
     **/
    private File createLogFile(String folder,String fileName) throws IOException{
    	File file = new File(folder);
    	if(!file.exists()){
    		file.mkdirs();
    	}
    	file = new File(fileName);
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	return file;
    }
    /**
     * @functional 格式化一条日志信息
     * @param JoinPoint joinpPoint
     * @return String Message
     */
    private String formatedMessage(JoinPoint p) throws Exception{
    	StringBuffer className = new StringBuffer(p.getTarget().getClass().getName());
    	StringBuffer temp = new StringBuffer("Log : "+className.substring(className.lastIndexOf(".")+1)+"-");
    	Object[] args = p.getArgs();
    	if(null != args | 0 == args.length){
    		for(Object o : args){
    			temp.append(o);
    			temp.append("-");
    		}
    		temp.append("end");
    	}else{
    		System.out.println("Sorry ,Could not get the args from JoinPoint");
    	}
    	return temp.toString();
    }
    
	public String getFileLocation() {
		return fileLocation;
	}
	/**
	 * @param fileLocation
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}
