package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static boolean checkOnDB(String email, String password) {
		return false;
	}
	
	public static Topic[] getTopics() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM quest ORDER BY RAND() LIMIT 5;";
		
		ResultSet res = cmd.executeQuery(query);
		Topic[] topics = new Topic[5];
		Topic t;
		int i = 0;
		while(res.next()) {
			t = new Topic(res.getString("domanda"), res.getString("risposte").split(";"), res.getString("corrette").split(";"));
			topics[i++] = t;
		}
		res.close();
		return topics;
	}
}
