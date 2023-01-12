 package com.rmgyantra.CRUD_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreatingProject {
	@Test
	public void createProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "budds");
		jobj.put("projectName", "Seedt");
		jobj.put("status", "created");
		jobj.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
