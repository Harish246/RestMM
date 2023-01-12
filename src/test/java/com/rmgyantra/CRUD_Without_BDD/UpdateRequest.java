package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateRequest {
	@Test
	public void updateProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "lilli");
		jobj.put("projectName", "Sdt122");
		jobj.put("status", "created");
		jobj.put("teamSize", 4);
		
		RequestSpecification reqSpec= RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		Response rsps=reqSpec.put("http://localhost:8084/projects/TY_PROJ_1804");
		ValidatableResponse vres= rsps.then();
		vres.assertThat().statusCode(200);
		vres.log().all();
	}

}
