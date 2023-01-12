package com.rmgyantra.CRUD_With_BDD;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchUpdate {
	
	@Test
	public void creatProject() {
		JSONObject jobj= new JSONObject();
		jobj.put("name", "morpheus");
		jobj.put("job", "zion resident");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}

