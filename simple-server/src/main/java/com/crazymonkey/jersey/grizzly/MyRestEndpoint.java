package com.crazymonkey.jersey.grizzly;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crazymonkey.jersey.grizzly.SimpleMicroserviceInterface;

// Depending on JAXRS implementation, a new instance may be created for every request, or a single instance shared.
public class MyRestEndpoint implements SimpleMicroserviceInterface {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRestEndpoint.class);
	
	@Override
	public String sayHello() {
		return "Hello1234501234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";
	}

	@Override
	public Response getSetTestJson(TestJson request) {
		TestJson tj = new TestJson();
		tj.setSessionId(request.getSessionId());
		tj.setAuthApplicationId(request.getAuthApplicationId());
		tj.setOriginHost(request.getDestinationHost());
		tj.setOriginRealm(request.getDestinationRealm());
		tj.setDestinationHost(request.getOriginHost());
		tj.setDestinationRealm(request.getOriginRealm());
		tj.setCCRequestType(request.getCCRequestType());
		tj.setCCRequestNumber(request.getCCRequestNumber());
		tj.setResultCode("2001");
		return Response.status(200).entity(tj).build();
	}

	@Override
	public Response getTestJson() {
		TestJson tj = new TestJson();
		tj.setSessionId("123456");
		tj.setAuthApplicationId("123");
		tj.setOriginHost("oh");
		tj.setOriginRealm("or");
		tj.setCCRequestType(1);
		tj.setCCRequestNumber(1);
		tj.setResultCode("2001");
		//return tj;
		return Response.status(200).entity(tj).build();
	}

	@Override
	public Response putTestJson(TestJson request) {
		return Response.status(200).build();
	}

}
