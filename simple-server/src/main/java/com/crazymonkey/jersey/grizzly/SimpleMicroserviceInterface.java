package com.crazymonkey.jersey.grizzly;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public interface SimpleMicroserviceInterface {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public String sayHello();

	@POST
	@Path("/getsetjson")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSetTestJson(TestJson request);
	
	@PUT
	@Path("/putjson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putTestJson(TestJson request);
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTestJson();
}
