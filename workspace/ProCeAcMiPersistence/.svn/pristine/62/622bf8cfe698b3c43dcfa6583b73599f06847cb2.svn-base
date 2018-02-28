/**
 * 
 */
package com.commons;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author maurizio
 *
 */
public class PropertiesManager {

	final static Logger logger = Logger.getLogger(PropertiesManager.class);
	
	private static Properties applicationConfigurationProperties = new Properties();
	private static Properties databaseConfigurationProperties = new Properties();
	
		
	static {
		try {
			logger.debug("STARTING PropertiesManager....");
			String propFileName = "hibernate.properties";
			 
			InputStream inputStream = PropertiesManager.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			databaseConfigurationProperties.load(inputStream);
			logger.debug("STARTING PropertiesManager....");
			propFileName = "application.properties";
			 
			inputStream = PropertiesManager.class
					.getClassLoader().getResourceAsStream(propFileName);
			
			applicationConfigurationProperties.load(inputStream);
			logger.debug("PropertiesManager STARTED");
//			logger.debug(databaseConfigurationProperties.getProperty("hibernate.connection.username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args) throws Exception {
//		System.out.println("getPropertyAsString(\"database.hostname\"): " + getPropertyAsString("database.hostname"));
//		;
//	}
	
	public static String getAppPropertyAsString (String key) {
		String returnValue = "" ;
		try {
			returnValue = applicationConfigurationProperties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue ;
	}
	
	public static String getDBPropertyAsString (String key) {
		String returnValue = "" ;
		try {
			returnValue = databaseConfigurationProperties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue ;
	}

}
