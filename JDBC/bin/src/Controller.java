package com.jdbc.Controller;

import com.jdbc.DAOUtil.*;


public class Controller{
	String mapper;

	public Contoller(String mapper){
		this.mapper = mapper;
	}

	public ApiUtil getApiLoaders(){
		
	}

	public Skill skillGenerator(PramsLoader params, List<SkillSet> skillSets, Action types){
		return new Skill();
	}

	public HttpResponse responseDispatcher(HttpResponse response){
		response.setContentType("application/json");
		return response;
	}
}

	