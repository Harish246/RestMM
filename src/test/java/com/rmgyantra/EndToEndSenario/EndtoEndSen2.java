package com.rmgyantra.EndToEndSenario;

import org.testng.annotations.Test;

import com.rmgyantra.GenericLibrary.BaseApi;
import com.rmgyantra.GenericLibrary.EndPoints;
import com.rmgyantra.GenericLibrary.javaUtility;
import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;



public class EndtoEndSen2 extends BaseApi{
	@Test
	public void endToEndscenario() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		POJOClass pojoClass= new POJOClass("hari1", "hanu"+javaUtility.GenerateRandomNum(), "on-going", 7);
		Response rsps=given()
		.contentType(ContentType.JSON)
		.body(pojoClass)
		.when()
		.post(EndPoints.addPro);
		
		String proId= rsps.jsonPath().get("projectId");
		
		Response rsps1 = given()
		.pathParam("projectId",proId)
		.when()
		.get(EndPoints.getSinglePro);
		String proName=rsps1.jsonPath().get("projectName");
		System.out.println(proName);
		
		Response rsps2 = given()
		.pathParam("projectId",proId)
		.when()
		.put(EndPoints.getSinglePro);
	
		 given()
		.pathParam("projectId",proId)
		.when()
		.delete(EndPoints.getSinglePro);
		
		ResultSet result=dUtil.executeQuer("select * from project;");
			
			while (result.next()) {
				if(!proName.equals(result.getString(4))) {
					System.out.println(proName+"is not available in dataBase");
					break;
				}
		}
			
	}
}



