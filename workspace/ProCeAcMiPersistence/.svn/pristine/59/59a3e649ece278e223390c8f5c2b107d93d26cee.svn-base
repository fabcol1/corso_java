/**
 * 
 */
package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.commons.PropertiesManager;

/**
 * @author maurizio
 *
 */
public class DBManager {

	final static Logger logger = Logger.getLogger(DBManager.class);
	
	protected static String dbUsername;
	protected static String dbPassword;
//	protected static String dbDialect;
	protected static String connectorMainClass;
	protected static String dbUrl;
	
	static {
		dbUsername = PropertiesManager.getDBPropertyAsString("hibernate.connection.username");
		dbPassword = PropertiesManager.getDBPropertyAsString("hibernate.connection.password");
//		dbDialect = PropertiesManager.getPropertyAsString("database.dialect");
		dbUrl = PropertiesManager.getDBPropertyAsString("hibernate.connection.url");
		connectorMainClass = PropertiesManager.getDBPropertyAsString("hibernate.connection.driver_class");
//		String connectorMainClass2 = PropertiesManager.configProp.getProperty("hibernate.connection.driver_class");
		
//		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass + " - dbDialect: " + dbDialect);
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass);
//		logger.info("Properties loaded --> connectorMainClass2: " + connectorMainClass2);
	}
	
	protected static Connection con;

	static {
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass);
	}

	public static void openConnection() throws Exception {
		Class.forName(connectorMainClass);
		con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		logger.info("Connection opened successfully...");
	}

	public static void closeConnection() throws Exception {
		try {
			con.close();
			logger.info("Connection closed successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	
	protected static StandardServiceRegistry registry;
	protected static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
	            
				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
}
