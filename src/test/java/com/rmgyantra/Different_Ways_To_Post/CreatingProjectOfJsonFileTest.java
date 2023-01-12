package com.rmgyantra.Different_Ways_To_Post;

import java.io.File;

import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreatingProjectOfJsonFileTest {
	@Test
	public void CreateJson() {
		
		File f=new File("./Data.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(f)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
	}
	

}
