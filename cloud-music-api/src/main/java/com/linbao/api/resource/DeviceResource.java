package com.linbao.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.linbao.api.model.Device;

@Path("/device")
public class DeviceResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Device getDeviceByIp(@QueryParam("ip") String ip){
		Device d = new Device(ip);
		d.setIp("127.0.0.1");
		d.setName("localhost");
		return d;
	}
}
