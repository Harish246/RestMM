package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;

import com.mysql.cj.log.Log;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NewToCreate {

	public void newToCreate() {
		// TODO Auto-generated method stub
		JSONObject jobj= new JSONObject();
		jobj.put("Createdby", "harish212");
		jobj.put("ProjectName", "HelloDarlings");
		jobj.put("status", "on-going");
		jobj.put("teamSize", "4");
		
		RequestSpecification rsp = RestAssured.given();
		rsp.contentType(ContentType.JSON);
		rsp.body(jobj);
				
		Response rp= rsp.post("http://localhost:8084/");
		ValidatableResponse vrp=rp.then();	
		vrp.assertThat().statusCode(201);
		vrp.log().all();
		
				

	}

}
