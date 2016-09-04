/**
 * 
 */
package com.linbao.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月18日 
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public class Common {

	/**
	 * @param s 
	 * @type String
	 * @return boolean 		Empty : true | not Empty: false
	 * @author 
	 */
	public static boolean isEmpty(String s){
		if(null == s ||"".equals(s)||"".equals(s.trim())||"null".equalsIgnoreCase(s)) return true;
		else return false;
	}
	public static String generateSecurityCode(int len){
		StringBuffer s = new StringBuffer();
		String[] charater = {"a","b","c","d","e",
							 "f","g","h","i","j",
							 "k","l","m","n","o",
							 "p","q","r","s","t",
							 "u","v","w","x","y",
							 "z","0","1","2","3",
							 "4","5","6","7","8",
							 "9"};
		Random r = new Random();
		for(int i=0;i<len;i++){
			s.append(charater[r.nextInt(35)]);
		}
		r.nextInt();
		return s.toString();
	}
	public static File CreateFile(String parent,String fileName) throws IOException{
		File file = new File(parent);
		if(!file.exists()){
			file.mkdirs();
		}
		file = new File(parent,fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		return file;
	}
}
