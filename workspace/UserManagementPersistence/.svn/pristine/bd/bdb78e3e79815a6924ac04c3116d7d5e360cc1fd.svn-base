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
public class PropertiesManager2 {

	private final static Properties configProp = null ;
	private static PropertiesManager2 instance = null;
	
	private PropertiesManager2 () {
		try {
			String propFileName = "application.properties";
			 
			InputStream inputStream = PropertiesManager2.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			configProp.load(inputStream);
			
			String dbHostname   = configProp.getProperty("database.hostname");
			String dbPort = configProp.getProperty("database.port");
	
			System.out.println("dbHostname: " + dbHostname + " - dbPort: " +  dbPort);
		} catch (Exception e) {
			e.printStackTrace () ;
		}
	}
	
	public static PropertiesManager2 getInstance () {
		if (instance==null) {
			instance = new PropertiesManager2 () ;
		}
		return instance ;
	}
	
	public static void main(String[] args) throws Exception {
		
		getInstance();
	}
	
	public static String getPropertyAsString (String key) {
		if (instance==null) {
			instance = getInstance() ;
		}
		return configProp.getProperty(key);
	}
	
//	/**
//	 * @param args
//	 */
//	public ReadingPropertiesFileExample () throws Exception {
//		String propFileName = "application.properties";
//		 
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//		
//		configProp.load(inputStream);
//		
//	}

}
