package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameters {
	
	@Test
	public void pathParameter() {
		given()
		.pathParam("proId","TY_PROJ_1007")
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}

	
}
