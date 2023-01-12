package com.rmgyantra.Validation;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticValidation {
	@Test
	public void saticValid() {
		String expProName="harish684";
		Response rsps =when()
		.get("http://localhost:8084/projects");
		
		String actProName=rsps.jsonPath().get("[1].projectName");
		System.out.println(actProName);
		Assert.assertEquals(actProName, expProName);
			
	}		
}
