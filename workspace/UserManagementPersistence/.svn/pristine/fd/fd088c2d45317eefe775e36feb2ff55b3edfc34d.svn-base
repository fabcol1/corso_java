package org.db;
/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;

import com.commons.PropertiesManager;

/**
 * @author corsi
 *
 */
public class DBManager {

	private Connection connection;

	public DBManager() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		String hostname = PropertiesManager.getPropertyAsString("database.hostname");
		String port = PropertiesManager.getPropertyAsString("database.port");
		String schema = PropertiesManager.getPropertyAsString("database.schema");
		String username = PropertiesManager.getPropertyAsString("database.username");
		String password = PropertiesManager.getPropertyAsString("database.password");

		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + schema;

		this.connection = DriverManager.getConnection(url, username, password);
	}

	public Connection getConnection() {
		return connection;
	}

}
