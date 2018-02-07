package database.credential;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class DBUpdateCredential {
	
	/**
	 * Static method for update an email.
	 */
	public static void updatePassword(String email, String newPassword) throws Exception {
		if(email == null || newPassword == null || email.isEmpty() || newPassword.isEmpty()) return;
	
		// create db connection
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();

		String query = "UPDATE users SET password=? WHERE email=?";
		PreparedStatement pStatement = con.prepareStatement(query);
		
		pStatement.setString(1, newPassword);
		pStatement.setString(2, email);
		
		pStatement.executeUpdate();
		pStatement.close();
	}
}
