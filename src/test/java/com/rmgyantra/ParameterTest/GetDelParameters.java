package com.rmgyantra.ParameterTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetDelParameters {
	@Test
	public void getParam() {
		Response rsps = when()
		.get("http://localhost:8084/projects");

		String proId = rsps.jsonPath().get("[1].projectId");
		System.out.println(proId); 

		given()
		.pathParam("projectId", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all();
	}

}
