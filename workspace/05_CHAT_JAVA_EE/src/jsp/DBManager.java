package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public boolean registration(String email, String password) throws ClassNotFoundException, SQLException {
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) return false;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		String query = "INSERT INTO users (email, password) VALUES (?, ?)";

		PreparedStatement pStatement = con.prepareStatement(query);
		
		pStatement.setString(1, email);
		pStatement.setString(2, password);

		boolean val = false;
		try {
			pStatement.executeUpdate();
			val = true;
		} catch(SQLException e) {
			val = false;
		}
		pStatement.close();
		con.close();
		return val;
	}
	
	
}
