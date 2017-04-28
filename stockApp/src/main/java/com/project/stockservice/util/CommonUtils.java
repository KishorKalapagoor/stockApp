package com.project.stockservice.util;

import java.util.regex.Pattern;

/**
 * Common utils for app.
 * @author kishor
 *
 */
public class CommonUtils {
	/**
	 * Converts csv cell string value to double
	 * @param val csv cell string value
	 * @return double value
	 */
	public static double handleDouble(String val) {
		Double result;
		if (Pattern.matches("N/A", val)) {  
			result = 0.00;   
		} else { 
			result = Double.parseDouble(val);  
		}  
		return result;
	}
	
	/**
	 * Converts csv cell string value to int
	 * @param val csv cell string value
	 * @return Int value
	 */	
	public static int handleInt(String val) {
		int Result;
		if (Pattern.matches("N/A", val)) {  
			Result = 0;   
		} else { 
			Result = Integer.parseInt(val);  
		} 
		return Result;
	}

}
