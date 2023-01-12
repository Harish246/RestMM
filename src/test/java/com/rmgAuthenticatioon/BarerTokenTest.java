   package com.rmgAuthenticatioon;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerTokenTest {
	@Test
	public void barerToken() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
