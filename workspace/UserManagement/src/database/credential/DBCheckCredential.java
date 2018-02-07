package database.credential;

import java.sql.*;

import database.DBConnection;

public class DBCheckCredential {

	/**
	 * Static method for check if an email exists on database.
	 * @param email
	 * @throws Exception 
	 */
	public static boolean checkEmail(String email) throws Exception {
		if(email == null || email.isEmpty()) return false;
	
		// create db connection
		DBConnection db = new DBConnection();
		
		// statement + query on db 
		Statement cmd = db.getConnection().createStatement();
		String query = "SELECT email FROM users";
		ResultSet res = cmd.executeQuery(query);
		
		// itero finchè non trovo l'email nel resultset a quel punto ritorno true ( email trovata)
		while(res.next()) {
			if(email.equals(res.getString("email"))) {
				res.close();
				return true;
			}
		}
		// se sono arrivato qua non ho trovato l'email nel db... ritorno false ( email non trovata)
		res.close();
		return false;
	}
}
