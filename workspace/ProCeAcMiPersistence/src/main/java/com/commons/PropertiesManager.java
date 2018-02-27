/**
 * 
 */
package com.commons;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author maurizio
 *
 */
public class PropertiesManager {

	private final static Properties configProp = new Properties();
	
	
		
	static {
		try {
			String propFileName = "application.properties";
			 
			InputStream inputStream = PropertiesManager.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			configProp.load(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.out.println("getPropertyAsString(\"database.hostname\"): " + getPropertyAsString("database.hostname"));
		;
	}
	
	public static String getPropertyAsString (String key) {
		String returnValue = "" ;
		try {
			returnValue = configProp.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue ;
	}

}
