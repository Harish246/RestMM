package com.rmgyantra.Different_Ways_To_Post;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectByJsonTest {
	@Test
	public void creatProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "beds");
		jobj.put("projectName", "Sedt1");
		jobj.put("status", "created");
		jobj.put("teamSize", 9);
		
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
