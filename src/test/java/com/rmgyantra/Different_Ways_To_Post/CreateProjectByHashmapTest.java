 package com.rmgyantra.Different_Ways_To_Post;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectByHashmapTest {
	@Test
	public void creatProject() {
	HashMap hp= new HashMap();
	hp.put("createdBy", "biuds");
	hp.put("projectName", "Sedt9665");
	hp.put("status", "created");
	hp.put("teamSize", 6);
	
	given()
	.contentType(ContentType.JSON)
	.body(hp)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();

	}
}
