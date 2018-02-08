package database.credential;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class DBUpdateCredential {
	
	/**
	 * Static method for update an email.
	 * @throws Exception 
	 */
	public static boolean updatePassword(String email, String newPassword) throws Exception  {
		if(email == null || newPassword == null || email.isEmpty() || newPassword.isEmpty()) return false;
	
		boolean val = false;
		
		// create db connection
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();

		String query = "UPDATE users SET password=? WHERE email=?";
		PreparedStatement pStatement = con.prepareStatement(query);
		
		pStatement.setString(1, newPassword);
		pStatement.setString(2, email);
		
		try {
			pStatement.executeUpdate();
			val = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pStatement.close();
		return val;
	}
}
