   package com.rmgyantra.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidateResponceTimeTest {
	@Test
	public void validResponceTime() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.assertThat().body("[1].projectName", Matchers.equalTo("harish684"))
		.log().all(); 
	}

}
