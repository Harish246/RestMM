package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostDeleteParams {
	@Test
	public void postParams() {
		
		POJOClass pojoClass = new POJOClass("harishhh1", "savi54", "created", 5);
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(pojoClass)
				.when()
				.post("http://localhost:8084/addProject");

		String proId = rsps.jsonPath().get("projectId");
		System.out.println(proId); 

		given()
		.pathParam("projectId", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all();
	}

}
