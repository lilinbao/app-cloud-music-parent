
package com.linbao.api.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linbao.api.model.User;
import com.linbao.api.model.support.ResponseWrapper;
import com.linbao.api.service.IUserService;

/**
 * Single Object of User
 * 
 */
@Path("users")
public class UsersResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersResource.class);
	@Inject
	private IUserService userService;
	/**
	 * This requests require authentication
	 * 
	 * @param accessToken
	 * 
	 */
	@POST
	@Consumes("multipart/form-data")
	@Produces({ "application/json" })
	public Response postUsers(@HeaderParam("access_token") String accessToken, User user) throws Exception{
		LOGGER.info("assessTocken is {}",accessToken);
		userService.add(user);
		return ResponseWrapper.withJsonCreated(null);
	}

	/**
	 * To edit or update a User
	 * 
	 * @param accessToken
	 * 
	 */
	@PUT
	@Consumes("multipart/form-data")
	public Response putUsers(@HeaderParam("access_token") String accessToken, User entity) throws Exception{
		return ResponseWrapper.ok(null).build();
	}

	/**
	 * Delete a User by given id
	 * 
	 * @param id
	 *            The identification of User
	 */
	@DELETE
	@Produces({ "application/json" })
	public Response deleteUsers(@QueryParam("id") String id) throws Exception{
		LOGGER.info("the id in request is {}",id);
		return ResponseWrapper.ok().build();
	}

	/**
	 * Get User object
	 * 
	 * @param id
	 *            The identification of the User
	 */
	@GET
	public Response getUsers(@QueryParam("id") String id) throws Exception{
		LOGGER.info("the id from parameter is {}",id);
		if(StringUtils.isNotBlank(id)){
			int userId = Integer.valueOf(id);
			User u = userService.getById(userId);
			return ResponseWrapper.withJsonOK(u);
		}
		return ResponseWrapper.noContent().build();
	}

	/**
	 * get collection of User
	 * 
	 * @param limit
	 *            The number of items per page
	 * @param page
	 *            The page to be requested
	 */
	@GET
	@Path("list")
	@Produces({ "application/json" })
	public Response getUsersList(@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("limit") @DefaultValue("10") int limit) throws Exception{
		LOGGER.info("the parameters from request are {0}, {1}",page,limit);
		List<User> list = new ArrayList<User>();
		list = userService.query(page, limit);
		return ResponseWrapper.withJsonOK(list);
	}

	/**
	 * Specify the page that you want to retrieve
	 * 
	 * @param name
	 * 
	 * @param limit
	 *            The number of items per page
	 * @param page
	 *            The page to be requested
	 */
	@GET
	@Path("search")
	@Produces({ "application/json" })
	public Response getUsersSearch(@QueryParam("name") String name, @QueryParam("page") @DefaultValue("1") int page,
			@QueryParam("limit") @DefaultValue("10") int limit) throws Exception{
		List<User> list = new ArrayList<User>();
		Map<String,String> obj = new HashMap<String,String>();
		obj.put("name", name);
		list = userService.getByProperty(obj, page, limit, true);
		return ResponseWrapper.withJsonOK(list); 
	}

	/**
	 * 
	 * @param id
	 *            Uri parameter, path parameter start with any numberic will
	 *            take the call into this method
	 */
	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public Response getUsersById(@PathParam("id") String id) throws Exception{
		return getUsers(id);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
