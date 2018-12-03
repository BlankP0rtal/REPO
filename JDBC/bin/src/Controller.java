package com.jdbc.Controller;

import com.jdbc.DAOUtil.*;


public class Controller{
	String mapper;

	public Contoller(String mapper){
		this.mapper = mapper;
	}

	public HttpResponse responseDispatcher(HttpResponse response){
		response.setContentType("application/json");
		return response;
	}
}