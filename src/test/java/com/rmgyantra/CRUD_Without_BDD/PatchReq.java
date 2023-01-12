package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PatchReq {
	@Test
	public void updateProject() {
		
		JSONObject jobj= new JSONObject();
		jobj.put("name", "morpheus");
		jobj.put("job", "zion resident");
		jobj.put("updatedAt", "30-10-2022");
		
		RequestSpecification reqSpec= RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		Response rsps=reqSpec.patch("https://reqres.in/api/users/2");
		ValidatableResponse vres= rsps.then();
		vres.assertThat().statusCode(200);
		vres.log().all();
	}

}
