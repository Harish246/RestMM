 package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class creatTest {
	@Test
	public void createProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "radiuds");
		jobj.put("projectName", "Sedt213");
		jobj.put("status", "created"); 
		jobj.put("teamSize", 4);
		
		RequestSpecification reqSpec= RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		
		Response rsps=reqSpec. post("http://localhost:8084/addProject"); 
		ValidatableResponse vres= rsps.then();
		vres.assertThat().statusCode(201);
		vres.log().all();
		
		// This is used for post  rest assured

		
		// This is for put in rest assured
		
	//	Response rsps=reqSpec.put("http://localhost:8084/projects/TY_PROJ_604");
		
		
	}

}
