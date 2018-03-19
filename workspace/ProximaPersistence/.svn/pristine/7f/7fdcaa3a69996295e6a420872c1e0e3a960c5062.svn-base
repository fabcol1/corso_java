package org.proxima.survey.pdfutils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	private final static Properties configProp = new Properties();
	private final static String propFileName = "application.properties";
	
//	public static void main(String[] args) throws Exception {
//		
////		String propFileName = "application.properties";
////		 
////		InputStream inputStream = PropertiesManager.class
////				.getClassLoader().getResourceAsStream(propFileName);
////		
////		configProp.load(inputStream);
////		
////		String dbHostname   = configProp.getProperty("database.hostname");
////		String dbPort = configProp.getProperty("database.port");
////
////		System.out.println("dbHostname: " + dbHostname + " - dbPort: " +  dbPort);
//		System.out.println("getPropertyAsString(\"database.hostname\"): " + getPropertyAsString("path.name"));
//	}
	
	/**
	 * @param args
	 */
	public PropertiesManager () throws Exception {
		 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		configProp.load(inputStream);
		
	}
	
	public static String getPropertyAsString (String key) {
		String returnValue = "" ;
		try {
			 
			InputStream inputStream = PropertiesManager.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			configProp.load(inputStream);
			
			returnValue = configProp.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue ;
	}

}
