/**
 * 
 */
package db;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import commons.PropertiesManager;


/**
 * @author maurizio
 *
 */
public class DBManager {

	final static Logger logger = Logger.getLogger(DBManager.class);
	
	protected static String dbUsername;
	protected static String dbPassword;
	protected static String dbDialect;
	protected static String connectorMainClass;
	protected static String dbUrl;
	
	static {
		dbUsername = PropertiesManager.getPropertyAsString("database.username");
		dbPassword = PropertiesManager.getPropertyAsString("database.password");
		dbDialect = PropertiesManager.getPropertyAsString("database.dialect");
		dbUrl = PropertiesManager.getPropertyAsString("database.connection.url");
		connectorMainClass = PropertiesManager.getPropertyAsString("database.connector.mainclass");
		
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass + " - dbDialect: " + dbDialect);
	}
	
	protected static StandardServiceRegistry registry;
	protected static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				// Create registry builder
//	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
//	            Map<String, String> settings = new HashMap<>();
//	            settings.put(Environment.DRIVER, connectorMainClass);
//	            settings.put(Environment.URL, dbUrl);
//	            settings.put(Environment.USER, dbUsername);
//	            settings.put(Environment.PASS, dbPassword);
//	            settings.put(Environment.DIALECT, dbDialect);
//
//	            // Apply settings
//	            registryBuilder.applySettings(settings);
//
//	            // Create registry
//	            registry = registryBuilder.build();	            
	            
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
