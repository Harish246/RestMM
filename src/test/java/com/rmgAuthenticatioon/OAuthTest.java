 package com.rmgAuthenticatioon;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuthTest {
	@Test
	public void auTho() {
		Response rsps = given()
		// data we took from coops.api
		.formParam("client_id", "Sdet_9Tyss")
		.formParam("client_secret", "dbb6f83e93a926d6936b66d0de38ba50")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token= rsps.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID","3969")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
		.log().all();
	}

}
