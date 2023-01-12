package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndPutParams {
	@Test
	public void postPutParama() {
	
	POJOClass pojoClass = new POJOClass("harish1", "savi94", "created", 9);
	POJOClass pojoClass1 = new POJOClass("harishu1", "savi154", "created", 6);
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
	.put("http://localhost:8084/projects/{projectId}")
	.then()
	.log().all();
	}

}
