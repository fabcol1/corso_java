package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	public static boolean checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) return false;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		Statement cmd = con.createStatement();
		
		String query = "SELECT email, password FROM users";
		
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			if(email.equals(res.getString("email"))) {
				if(password.equals(res.getString("password"))) {
					res.close();
					return true;
				}
			}
		}
		res.close();
		return false;
	}
	
}
