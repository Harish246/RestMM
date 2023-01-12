 package com.rmgyantra.Different_Ways_To_Post;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;

public class CreatingProjectUsingPOJOClass {
	
	@Test(dataProvider = "provideData")
	public void creatingProject(String createdBy, String projectName, String status,int teamSize) {
		POJOClass pc=new POJOClass(createdBy, projectName, status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pc)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
	@DataProvider
	public Object[][] provideData() {
		Object[][] objArr = new Object[2][4];
		
		objArr[0][0]="Hello";
		objArr[0][1]="Mana9";
		objArr[0][2]="created";
		objArr[0][3]=8;
		
		objArr[1][0]="Helloo";
		objArr[1][1]="Ma072";
		objArr[1][2]="created";
		objArr[1][3]=3;
		
		return objArr;
	}
	

}
