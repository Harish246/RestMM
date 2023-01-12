package com.rmgyantra.GenericLibrary;

import java.util.Random;

public class javaUtility {
	
	public static int GenerateRandomNum(){
		Random r= new Random();
		int ramNum= r.nextInt(2000);
		return ramNum;
	}

}
