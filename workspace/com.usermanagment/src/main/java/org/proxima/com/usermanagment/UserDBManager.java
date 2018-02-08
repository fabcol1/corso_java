/**
 * 
 */
package org.proxima.com.usermanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maurizio
 *
 */
public class UserDBManager {

	protected static Connection con ;
	
	public static void openConnection () throws Exception {
//		System.out.println("CARICARE DRIVER PER CONNESSIONE");
	    //CARICARE DRIVER PER CONNESSIONE
        String driver = "com.mysql.jdbc.Driver";
	    Class.forName(driver);
	    //DEFINISCO url, username e password
//	    System.out.println("//DEFINISCO url, username e password");
	    String url = "jdbc:mysql://mercurio:3306/testDB";
	    String username = "test3" ;
	    String password = "test3" ;
        //stabilisco la connessione
		con = DriverManager.getConnection (url, username, password);
	}
	
	public static void closeConnection () throws Exception {
		try {			
			con.close();
			System.out.println("Chiusa connessione con il database....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<User> getUsers () {
		List<User> users = new ArrayList<User>();
		
		try {
			openConnection () ;		    
			//creo oggetto statement
			Statement cmd = con.createStatement ();
			//creo la query string
			String query = "SELECT * FROM users;";
			//interrogo il db e ottendo il risultato
			ResultSet res = cmd.executeQuery(query);
			User appoUser ;
			while (res.next()) {
				appoUser = new User () ;
				appoUser.setId(res.getLong(1));
				appoUser.setEmail(res.getString("email"));
				appoUser.setPassword(res.getString("password"));
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
				users.add(appoUser);
			}
			res.close();
			closeConnection () ;
			System.out.println("users.size(): " + users.size());
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return users ;
	}
	
//	public static User getUserById (int id) {
//		List<User> users = new ArrayList<User>();
//		
//		try {
//			openConnection () ;		    
//			//creo oggetto statement
////			Statement cmd = con.createStatement ();
//			
//			//creo la query string
//			String query = "SELECT * FROM users where id = ?;";
//			//interrogo il db e ottendo il risultato
////			ResultSet res = cmd.executeQuery(query);
//			
//			PreparedStatement cmd = con.prepareStatement(query);
//			cmd.setInt(1, id);
//			ResultSet res = cmd.executeQuery();
//			User appoUser ;
//			while (res.next()) {
//				appoUser = new User () ;
//				appoUser.setId(res.getLong(1));
//				appoUser.setEmail(res.getString("email"));
//				appoUser.setPassword(res.getString("password"));
//				System.out.println(res.getString(1));
//				System.out.println(res.getString(2));
//				users.add(appoUser);
//			}
//			res.close();
//			closeConnection () ;
//			System.out.println("users.size(): " + users.size());
//		} catch (Exception e) {			
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//
//		return users ;
//	}
	
	
	public static User getUserByEmail (String email) {
		System.out.println("email: " + email);
		User user = null ;
		
		try {
			openConnection () ;		    
			//creo oggetto statement
//			Statement cmd = con.createStatement ();
			
			//creo la query string
			String query = "SELECT * FROM users where email = ?;";
			//interrogo il db e ottendo il risultato
//			ResultSet res = cmd.executeQuery(query);
			System.out.println("DEBUG 1");
			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setString(1, email);
			ResultSet res = cmd.executeQuery();
//			User appoUser ;
			res.last();			
			System.out.println("res.getRow(); + " + res.getRow());
			res.beforeFirst();
			while (res.next()) {
				user = new User () ;
				user.setId(res.getLong(1));
				user.setEmail(res.getString("email"));
				user.setPassword(res.getString("password"));
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));				
			}
			res.close();
			closeConnection () ;
			System.out.println("user: " + user);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return user ;
	}
	
	public static int insertNewUser (String email, String password, int role) {
		int rows = 0;
		
		try {
			openConnection () ;
			//creo oggetto statement
			String query = "insert into users (email, password, role) values (?, ?, ?) ;";
			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setString(1, email);
			cmd.setString(2, password);
			cmd.setInt(3, role);
			//interrogo il db e ottendo il risultato
			rows = cmd.executeUpdate();			
			cmd.close();
			closeConnection () ;
			System.out.println("Inserted rows: " + rows);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows ;
	}
	
	public static int deleteAll () {
		int rows = 0;
		
		try {
			openConnection () ;
			//creo oggetto statement
			String query = "delete from users ;";
			Statement cmd = con.createStatement ();
			
			//interrogo il db e ottendo il risultato
			rows = cmd.executeUpdate(query);			
			cmd.close();
			closeConnection () ;
			System.out.println("Deleted rows: " + rows);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows ;
	}
	
//	public static void main (String[] args) {
//		insertNewUser("paperino", "topolino");
//		deleteAll();
//	}
	
}
