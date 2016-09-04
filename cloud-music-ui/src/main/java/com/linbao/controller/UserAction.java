/**
 * 
 */
package com.linbao.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.NonUniqueObjectException;

import com.linbao.exception.InvalidInputException;
import com.linbao.model.Resources;
import com.linbao.model.Role;
import com.linbao.model.User;
import com.linbao.service.IResourcesService;
import com.linbao.service.IUserService;
import com.linbao.utils.Common;
import com.linbao.utils.CommonEmail;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月17日
 * @version 2.0
 * @param 
 * @ToDo 
 */
public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	private IResourcesService resourcesService;
	private User user;
	private Role role;
	private String extention;
	private String retrievePasswordContent;

	/**
	 * @target 
	 * @useage 
	 * @param 
	 * @return 
	 * @throws Exception 
	 */
	public String add() throws SQLException,NumberFormatException,NullPointerException{
		String flag = "";
		int i = 0;
		if(null!= user) i = userService.add(user);
		if(i>0) flag = SUCCESS;
		else if(i == 0) flag = INPUT;
		else if(i < 0)flag = ERROR;
		return flag;
	}
	
	public String delete() throws SQLException,NumberFormatException{
		int result = 0;
		String flag = ERROR;
		if(null!= user)result = userService.delete(user);
		if(result > 0) flag = SUCCESS;
		else if (result == 0) flag = INPUT;
		
		return flag;
	}
	public String edit() throws NonUniqueObjectException{
		if(null != user){
			user = userService.getById(user.getId());
			if(null == user || "".equals(user.getUsername())){
				return "list";
			}
			getSession().put("user", user);
		}
		return "edit";
	}
	public String update() throws SQLException,NullPointerException{
		int result = 0;
		String flag = INPUT;
		if(null!= user)
			try {
				result = userService.update(user);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(result > 0) flag = "list";
		else if(result == 0) flag = INPUT;
		else flag = ERROR;
		return flag;
	}
	
	public String getUserSingled() throws NonUniqueObjectException{
		System.out.println("0000.1");
		if(null != user){
			user = userService.getById(user.getId());
			getSession().put("user", user);
		}
		return SUCCESS;
	}
	public String getAdminUserList() throws IndexOutOfBoundsException,NumberFormatException{
		List<User> list = new ArrayList<User>();
		if(null != getPager()) {
			list = userService.getByPage(getPager());
		}
		getSession().put("userList", list);
		return SUCCESS;
	}
	public String getUserListByRole() throws NullPointerException,NumberFormatException{
		List<User> list = new ArrayList<User>();
		if(null != role)list = userService.getByRole(role.getId());
		getSession().put("userList", list);
		return SUCCESS;
	}
	
	/*public String getUserAll() throws Exception{
		Session.put("userList", userService.getAll());
		return SUCCESS;
	}*/
	public String login(){
		
		String flag = INPUT;
		User user_temp = null;
		if(null != user){
			if(Common.isEmpty(user.getUsername())) {
				this.addFieldError("usernameEmpty", "Username is required");
				this.setParameters("username=null");
				System.out.println("username is null;");
				return flag;
			}else if(Common.isEmpty(user.getPassword())){ 
				this.addFieldError("passwordEmpty", "Password is required");
				this.setParameters("password=null");
				System.out.println("password is null");
				return flag;
			}else{
				try {
					user_temp = userService.isExistUser(user.getUsername(), user.getPassword());
				} catch (Exception e) {
					flag = ERROR;
					e.printStackTrace();
					return flag;
				}
				if(null != user_temp){
					//Get More User Info
					getSession().put("currentUser", user_temp);
					try {
						List <Resources> list = userService.getResourcesByUser(user_temp.getId());
						System.out.println("begin to export the list "+list.size()+":");
						for(Resources r : list){
							boolean flags = false;
							if(!r.getIsLeaf()){
								System.out.println("+"+r.getName()+" : "+r.getDescription());
								flags = true;
							}
							if(flags){
								for(Resources subR : list){
									if(subR.getParent().getId() == r.getId()){
										System.out.println("--"+subR.getName()+" : "+subR.getDescription());
									}
								}
							}
						}
						getSession().put("userResources", list);
						getSession().put("something", "this is a test message");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "error";
					}
					this.setParameters("");
					flag = SUCCESS;
					return flag;
				}else {
					this.addFieldError("userEmpty", "User does not exist!");
					System.out.println("no user data from database, user_temp is unll");
					this.setParameters("user=nofound");
					return flag;
				}
			} 
		}
		System.out.println("begin to return");
		return flag;
	}
	public String logout(){
		String flag = ERROR;
		getSession().remove("currentUser");
		flag = INPUT;
		return flag;
	}
	public String retrievePwd() throws Exception{
		String flag = "empty";
		if(null != user && !"".equals(user.getEmail())){
			List<User> ul = new ArrayList<User> ();
			ul = userService.getByEmail(user.getEmail());
			if(ul.size()>0){
				user = ul.get(0);
			}
			if(null != user){
				flag = INPUT;
				getSession().put("email", user.getEmail());
				CommonEmail ce = new CommonEmail();
				ce.send(null, user.getEmail(), "Retrieve your Password", retrievePasswordContent+Common.generateSecurityCode(4));
			}else{
				this.setParameters("user=nofound");
			}
		}
		return flag;
	}
	public String register() throws Exception{
		String flag = INPUT;
		//&& !&&!)
		if( Common.isEmpty(user.getUsername())){
			this.setParameters("username_reg=null&pattern=reg");
		}else if(Common.isEmpty(user.getPassword())){
			this.setParameters("password_reg=null&pattern=reg");
		}else if(Common.isEmpty(user.getEmail())){
			this.setParameters("email=null&pattern=reg");
		}else if(!this.getExtention().equals(user.getPassword())){
			this.setParameters("password=different&pattern=reg");
		}else{
			if(CommonEmail.isEmail(user.getEmail())){
				if(userService.getByUserName(user.getUsername()).size() == 0){
					if(userService.getByEmail(user.getEmail()).size() == 0){
						userService.add(user);
					}else{
						this.setParameters("user=existed&pattern=reg");
					}
				}else{
					this.setParameters("user=existed&pattern=reg");
				}
			}else{
				this.setParameters("email=incorrect&pattern=reg");
			}
			
			
		}
		return flag;
	}
	public String right(){
		
		try {
			List <Resources> list = userService.getResourcesByUser(user.getId());
			System.out.println("begin to export the list "+list.size()+":");
			for(Resources r : list){
				boolean flag = false;
				if(!r.getIsLeaf()){
					System.out.println("+"+r.getName()+" : "+r.getDescription());
					flag = true;
				}
				if(flag){
					for(Resources subR : list){
						if(subR.getParent().getId() == r.getId()){
							System.out.println("--"+subR.getName()+" : "+subR.getDescription());
						}
					}
				}
			}
			getSession().put("userResources", list);
			getSession().put("something", "this is a test message");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "attrResources";
	}
	public String list(){
		List<User> users = new ArrayList<User>();
		
		users = userService.getByPage(pager);
		pager.setRecords(users);
		System.out.println("The list size in the Pager is "+pager.getRecords().size());
		getSession().put("user_list", pager);
		return "list";
	}
	
	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the extention
	 */
	public String getExtention() {
		if(null == this.extention) this.extention = "-_-null-_-";
		return extention;
	}

	/**
	 * @param extention the extention to set
	 */
	public void setExtention(String extention) {
		this.extention = extention;
	}

	/**
	 * @return the retrievePasswordContent
	 */
	public String getRetrievePasswordContent() {
		return retrievePasswordContent;
	}

	/**
	 * @param retrievePasswordContent the retrievePasswordContent to set
	 */
	public void setRetrievePasswordContent(String retrievePasswordContent) {
		this.retrievePasswordContent = retrievePasswordContent;
	}

	/**
	 * @return the resourcesService
	 */
	public IResourcesService getResourcesService() {
		return resourcesService;
	}

	/**
	 * @param resourcesService the resourcesService to set
	 */
	public void setResourcesService(IResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}
	
}
