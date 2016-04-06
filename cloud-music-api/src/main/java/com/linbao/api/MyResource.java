package com.linbao.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.linbao.api.model.User;
import com.linbao.api.model.support.ResponseWrapper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	User u = new User();
    	u.setEmail("linbao@gmail.com");
    	u.setId(new Integer(1));
    	u.setLevel(1.0);
    	u.setUsername("sss");
        return u.toString();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("{id:m\\d{3,5}}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response syaHello2Client(@PathParam("id") String ids) {
    	User u = new User();
    	u.setEmail("linbao@gmail.com");
    	u.setId(new Integer(1));
    	u.setLevel(1.0);
    	u.setUsername("sss");
        return ResponseWrapper.withJsonOK(u);
    }
}
