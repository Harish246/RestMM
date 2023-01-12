package com.rmgyantra.GenericLibrary;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApi {
	
	public DataBaseUtility dUtil= new DataBaseUtility();
	@BeforeSuite
	public void createConn() throws Throwable {
		dUtil.CreateConnectionWithDB();
	}
	@AfterSuite
	public void closeConn() throws Throwable {
		dUtil.closeConnectWithDB();
	}
	
}
