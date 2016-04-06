
package com.linbao.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.linbao.api.model.Music;
import com.linbao.api.model.support.ResponseWrapper;

/**
 * This is a set of APIs that are in charge of managing the **Top** information
 * 
 */
@Path("top")
public class TopResource {

	/**
	 * Get all Top, optionally filtered
	 * 
	 * @param pages
	 *            how many page to return
	 * @param perPage
	 *            number of item in a page
	 * @param start
	 *            the start offest to query
	 */
	@GET
	public Response getTop(@QueryParam("start") Long start, @QueryParam("pages") Long pages,
			@QueryParam("per_page") Long perPage) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list );
	}

}
