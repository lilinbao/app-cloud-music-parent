/**
 * 
 */
package com.linbao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年1月6日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class CommonEmail {

	private String from;
	private String mailTo;
	public static void main(String[] args) throws AddressException, IOException, MessagingException{
		CommonEmail ce = new CommonEmail();
		Properties properties = new Properties();
		InputStream in = Common.class.getResourceAsStream("config/utilConfig.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ce.send(ce.getFrom(), "timelift@126.com","TEST MY EMSIL","Please ignore");
	}
	public static boolean isEmail(String emailAddress){
		if(Common.isEmpty(emailAddress)) return false;
		Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		String email = emailAddress.toLowerCase();
		if(email.endsWith(".con")) return false;
		if(email.endsWith(".xon")) return false;
		if(email.endsWith(".cm")) return false;
		if(email.endsWith(".xm")) return false;
		if(email.endsWith("gmai.com"))return false;
		if(email.endsWith(".xom")) return false;
		if(email.endsWith(".cim")) return false;
		if(email.endsWith(".cim")) return false;
		
		return emailer.matcher(email).matches();
	}
	public void send(String from,String to,String title,String content) throws IOException, AddressException, MessagingException{
		Properties config = new Properties();
		InputStream in = this.getPropertyFile(null);
		config.load(in);
		
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", config.getProperty("mail.transport.protocol"));// 设置传输协议
		properties.put("mail.smtp.host", config.getProperty("mail.smtp.host"));// 设置发信邮箱的smtp地址
		properties.put("mail.smtp.auth", config.getProperty("mail.smtp.auth")); // 验证
		
		Authenticator auth = new MyAuthenticator(config.getProperty("emailUserName"), config.getProperty("emailPassword")); // 使用验证，创建一个Authenticator
		Session session = Session.getDefaultInstance(properties, auth);// 根据Properties，Authenticator创建Session
		
		Message message = new MimeMessage(session);// Message存储发送的电子邮件信息
		message.setFrom(new InternetAddress(config.getProperty("from")));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));// 设置收信邮箱
		
		message.setContent(content, config.getProperty("mail.contentType"));
		message.setSubject(title);// 设置主题
		message.setSentDate(new Date());// 设置发信时间
		Transport.send(message);// 发送
	}
	private InputStream getPropertyFile(String location){
		return Common.class.getResourceAsStream(Common.isEmpty(location)?"config/utilConfig.properties":location);
	}
	
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the mailTo
	 */
	public String getMailTo() {
		return mailTo;
	}
	/**
	 * @param mailTo the mailTo to set
	 */
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	
}
class MyAuthenticator extends Authenticator {
	private String user;
	private String pwd;

	public MyAuthenticator(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pwd);
	}
}
