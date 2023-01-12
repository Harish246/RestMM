package com.rmgyantra.Validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class HamcrestByStatic {

	@Test
	public void validResponceTime() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(lessThan(5000L), TimeUnit.MILLISECONDS)
		.assertThat().body("[1].projectName", equalTo("harish484"))
		.log().all(); 
	}

}
