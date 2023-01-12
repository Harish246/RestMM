package com.rmgyantra.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	public Connection con;
	public void CreateConnectionWithDB() throws Throwable {

		Driver dre = new Driver();
		DriverManager.registerDriver(dre);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
	}
	public void closeConnectWithDB() throws Throwable {
		con.close();
	}
	
	public ResultSet executeQuer(String query) throws Throwable {
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		return result;
	}

}
