package com.example.car.util;

public class IntegerUtil {

	public static boolean isInteger(String srt){
		try {
		 Integer.parseInt(srt);

		}	
		catch(Exception e) {
			return false;		
		}
		return true;		
	}
}
