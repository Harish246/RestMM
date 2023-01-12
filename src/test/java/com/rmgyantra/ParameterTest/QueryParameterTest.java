package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameterTest {
	@Test
	public void queryParams() {
		given()
		.pathParams("username","harish")
		.queryParams("sort","created")
		.when()
		.get(" https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}

}
