package com.rmgyantra.CRUD_With_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUpdate {

	@Test
	public void creatProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "biuds");
		jobj.put("projectName", "Sedt");
		jobj.put("status", "created");
		jobj.put("teamSize", 6);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1405")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
