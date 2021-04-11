package com.jakartalabs.baseapi;

import com.google.gson.Gson;
import com.jakartalabs.utils.DataUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {
	
	private final String baseURI = "https://api-staging-builder.engineer.ai";
	
	protected RequestSpecification commonRequestSpec = new RequestSpecBuilder().
			setBaseUri(this.baseURI).
			setContentType("application/json").build().log().all();
	
	protected RequestSpecification formRequestSpec = new RequestSpecBuilder().
			setBaseUri(this.baseURI).
			setContentType("application/x-www-form-urlencoded").build().log().all();
	
	protected Gson gson = new Gson();
	
}
