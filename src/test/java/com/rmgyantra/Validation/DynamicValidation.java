package com.rmgyantra.Validation;


import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DynamicValidation {
	@Test
	public void dynamicValidation() {
	String expProName="harish684";
	
	Response rsps= when()
	.get("http://localhost:8084/projects");
	
	List <String> actProList=rsps.jsonPath().get("projectName");
	int count=actProList.size();
	
	for (int i=0;i<count;i++) {
		
		String actProName=actProList.get(i);
		if(expProName.equals(actProName)) {
			System.out.println(expProName+"is available");
			break;
			}
		}
	}	
}
