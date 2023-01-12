package com.rmgyantra.ParameterTest;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rmgyantra.PojoTest.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUpdateDeleTest {
	@Test
	public void createUpdateDel() throws Throwable {
	
	POJOClass pojoClass = new POJOClass("hat1", "vamsi", "created", 9);
	POJOClass pojoClass1 = new POJOClass("rats1", "phvamsi", "created", 6);
	//String expectedProjectName="tetl431";
	Response rsps = given()
			.contentType(ContentType.JSON)
			.body(pojoClass)
			.when()
			.post("http://localhost:8084/addProject");
	
	String proId = rsps.jsonPath().get("projectId");
	System.out.println(proId);

	given()
	.pathParam("projectId", proId)
	.contentType(ContentType.JSON)
	.body(pojoClass1)
	.when()
	.put("http://localhost:8084/projects/{projectId}");
//	System.out.println(body);
	
	given()
	.pathParam("projectId", proId)
	.when()
	.delete("http://localhost:8084/projects/{projectId}");
	
//	String projectNAME = rsps.jsonPath().get("projectName");
//	System.out.println(projectNAME);
//	Assert.assertEquals(expectedProjectName, projectNAME);
//	System.out.println("verified sucessfully");
	
	Connection con=null;
	try {
		Driver dre = new Driver();
		DriverManager.registerDriver(dre);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//Step-3 create statement
		Statement stmt = con.createStatement();
		
		//Step-4 execute query
		ResultSet res = stmt.executeQuery("select project_name from project;");
		while (res.next()) {
			if(!proId.equals(res.getString(1))) {
				System.out.println("Validation Sucessful");
				break;
			}
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	//close connect with dataBase
	con.close();
	System.out.println("connection is closed");
	}
	}
}
