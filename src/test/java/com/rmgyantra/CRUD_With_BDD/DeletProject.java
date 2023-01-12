package com.rmgyantra.CRUD_With_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeletProject {
	@Test
	public void creatProject() {
//		JSONObject jobj= new JSONObject();
//		jobj.put("createdBy", "biuds");
//		jobj.put("projectName", "Sedt");
//		jobj.put("status", "created");
//		jobj.put("teamSize", 6);
		
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1406")
		.then()
		.assertThat().statusCode(204)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
