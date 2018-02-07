package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.commons.PropertiesManager;

public class DBConnection {

	private Connection connection;
	
	public DBConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		
		String hostname= PropertiesManager.getPropertyAsString("database.hostname");
		String port= PropertiesManager.getPropertyAsString("database.port");
		String schema= PropertiesManager.getPropertyAsString("database.schema");
		String username= PropertiesManager.getPropertyAsString("database.username");
		String password= PropertiesManager.getPropertyAsString("database.password");

		String url = "jdbc:mysql://"
							+ hostname 
							+ ":"
							+ port
							+ "/"
							+ schema;
		
		this.connection = DriverManager.getConnection(url, 
											username,
											password);
	}

	public Connection getConnection() {
		return connection;
	}
}
