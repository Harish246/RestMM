package com.rmgyantra.CRUD_Without_BDD;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GettingDataTest {
	
	@Test
	public void getData(){
		Response rsps= RestAssured.get("http://localhost:8084/projects");
//		Response rsps1= RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1202");
		rsps.prettyPrint();
		
		int actstatus= rsps.getStatusCode();
		Assert.assertEquals(actstatus,200);
//		int actstatus1= rsps1.getStatusCode();
//		Assert.assertEquals(actstatus1,204);
//		System.out.println(rsps.asString());
	}

}
