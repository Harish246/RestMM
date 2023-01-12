package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostPutDelParameters {
	@Test
	public void postPutParama() {
	
	POJOClass pojoClass = new POJOClass("ha1", "sa4", "created", 9);
	POJOClass pojoClass1 = new POJOClass("har1", "sa54", "created", 6);
	Response rsps = given()
			.contentType(ContentType.JSON)
			.body(pojoClass)
			.when()
			.post("http://localhost:8084/addProject");

	String proId = rsps.jsonPath().get("projectId");
	System.out.println(proId); 

	//Response rsps1 = 
			given()
			.contentType(ContentType.JSON)
			.body(pojoClass1)
	.pathParam("projectId", proId)
	.when()
	.put("http://localhost:8084/projects/{projectId}");
	//String projectId1=rsps1.jsonPath().get("projectId");
	
	given()
	.pathParam("projectId", proId)
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.log().all();
	}

}
