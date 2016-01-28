package com.intuit.training;

import java.io.FileNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class MyExceptionMapper implements ExceptionMapper<FileNotFoundException> {

	@Override
	public Response toResponse(FileNotFoundException e) {
		// TODO Auto-generated method stub
		Response response=Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		return response;
	}

}
