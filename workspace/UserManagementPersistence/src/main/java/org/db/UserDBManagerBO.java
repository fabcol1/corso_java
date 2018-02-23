/**
 * 
 */
package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.bean.User;

/**
 * @author UTENTE12
 *
 */
public class UserDBManagerBO extends UserDBManager {
	final static Logger logger = Logger.getLogger(UserDBManager.class);

	public static boolean checkCredentials(String email,String password) throws Exception {
		//String driver = "com.mysql.jdbc.Driver";
		//Class.forName(driver);
		//stringa di connessione
//		String url = "jdbc:mysql://localhost:3306/testMyDB";
		//connessione con username e password
		//Connection con = DriverManager.getConnection (url, "testme",
		//"testme");
		openConnection();	
		Statement cmd = con.createStatement ();
		String query = "SELECT email,password FROM Users where email = '"+email+"' and password = '"+password+"'";
		System.out.println(query);
		ResultSet res = cmd.executeQuery(query);
		while (res.next()) {
		    String usermail = res.getString("email");
		    System.out.println(email);
		    
			String userPass = res.getString("password");
			System.out.println(password);
			System.out.println((email.equals(usermail)));
			System.out.println((password.equals(userPass)));
			if((email.equals(usermail))&& (password.equals(userPass))){
				return true;
			}
		}
		res.close();
		closeConnection();		
		return false;
	}

	public static void executeDeleteStmt(int id) throws Exception {
//		String driver = "com.mysql.jdbc.Driver";
//		Class.forName(driver);
		// stringa di connessione
//		String url = "jdbc:mysql://localhost:3306/testMyDB";
		// connessione con username e password
//		Connection con = DriverManager.getConnection(url, "testme", "testme");
		openConnection();
		Statement cmd = con.createStatement();

		String query = "DELETE FROM Users WHERE id=" + id;
		int rowsUpdated = cmd.executeUpdate(query);
		System.out.println("rows deleted: " + rowsUpdated);

	}
	
	public static void deleteAllBO() throws Exception{
		openConnection();
		Statement cmd = con.createStatement();

		String query = "DELETE * FROM Users";
		int rowsUpdated = cmd.executeUpdate(query);
		System.out.println("rows deleted: " + rowsUpdated);

	}

	public static int executeInsertStment(String firstName, String lastName, String email, String password, String Borndate,String Regdate,int role )
			throws Exception {
		//String driver = "com.mysql.jdbc.Driver";
		//Class.forName(driver);
		// stringa di connessione
		//String url = "jdbc:mysql://localhost:3306/testMyDB";
		// connessione con username e password
		openConnection();
//		Connection con = DriverManager.getConnection(url, "testme", "testme");
		Statement cmd = con.createStatement();
		String query = "INSERT INTO users ( firstName,lastName,email,password,dateOfBirth,Regdate,role) VALUES" 
		+ "('" + firstName + "', '"
				+ lastName + "','" + email + "','" + password + "','"+ Borndate +"','"+ Regdate + "','"+ role+ "')";
		System.out.println(query);
		int rowsUpdated = cmd.executeUpdate(query);
		System.out.println("rows inserted: " + rowsUpdated);
		cmd.close();
		return rowsUpdated;
	}

	public static int executeUpdateStmt(long id, String firstNamePar, String lastNamePar, String emailPar,
			String PasswordPar,String BorndatePar,String RegdatePar,int role) throws Exception {
		System.out.println("Executing executeUpdateStmt method");
//		String driver = "com.mysql.jdbc.Driver";
//		Class.forName(driver);

		// stringa di connessione
		//String url = "jdbc:mysql://localhost:3306/testMyDB";
		// connessione con username e password
//		Connection con = DriverManager.getConnection(url, "testme", "testme");
		openConnection();
		Statement cmd = con.createStatement();

		String query = "UPDATE users SET firstName ='" + firstNamePar + "', lastName='" + lastNamePar + "',email='"
				+ emailPar + "',password='" + PasswordPar + "',dateOfBirth='" + BorndatePar + "' ,Regdate='" + RegdatePar +
						 "' WHERE id=" + id;
		System.out.println("Update query: "+query);
		int rowsUpdated = cmd.executeUpdate(query);
		System.out.println("rows updated: " + rowsUpdated);
		// cmd.close();
		return rowsUpdated;

	}

	public static User selectById(long id)throws Exception {
//			 String driver = "com.mysql.jdbc.Driver";
				//Class.forName(driver);
				User user = null ;
				//stringa di connessione
				//String url = "jdbc:mysql://localhost:3306/testMyDB";
				//connessione con username e password
				//Connection c
                 openConnection();
				Statement cmd = con.createStatement ();
				String query = "SELECT * FROM users WHERE id="+id;
				ResultSet res = cmd.executeQuery(query);
				
//				    System.out.println(res);
				    
				while (res.next()) {
					
					Long userId = (long) res.getInt("id");
				    String usermail = res.getString("email");
				    System.out.println(usermail);
				    
					String userPass = res.getString("password");
					System.out.println(userPass);
					
					String userFirstName = res.getString("firstName");
					System.out.println(userFirstName);
					String userLastName = res.getString("lastName");
					System.out.println(userLastName);
					
//					
			        user = new User ();
			        user.setEmail(usermail);
			        user.setPassword(userPass);
			        user.setId(userId);
			        user.setFirstname(userFirstName);
			        user.setLastname(userLastName);
					
				} 
		 
			

			return user ;
			 
			
		}

	public static List<User> getAllUsersBO () throws Exception{
		System.out.println("Executing getAllUsers method...");
		 List<User> users = new ArrayList<User>();
		
				openConnection();
		// String driver = "com.mysql.jdbc.Driver";
		 //Class.forName(driver);
		 User user = null ;
		 //stringa di connessione
//		 String url = "jdbc:mysql://localhost:3306/testMyDB";
		 //connessione con username e password
		 //Connection con = DriverManager.getConnection (url, "testme",
		// "testme");
		 Statement cmd = con.createStatement ();
		 String query = "SELECT * FROM users";

		 ResultSet res = cmd.executeQuery(query);

//		     System.out.println(res);
		     
		 while (res.next()) {
		 	User apuser = new User();
		 	apuser = new User () ;
		 	apuser.setEmail(res.getString("email"));
		 	apuser.setFirstname(res.getString("firstname"));
		 	apuser.setLastname(res.getString("lastName"));
		 	apuser.setPassword(res.getString("password"));
		 	apuser.setBorndate(res.getString("dateOfBirth"));
		 	apuser.setRegdate(res.getString("Regdate"));
		 	apuser.setRole(res.getInt("role"));
		 	int userId = res.getInt("id");
		 	apuser.setId((long) userId);
		 	users.add(apuser);
		 }
			res.close();
			closeConnection();


			return users ;
	}
	
	public static void main (String []args)throws Exception {
		List<User>user1 ;
				user1 =getAllUsersBO();
				System.out.println(user1.size());
		
//	 int r=  executeUpdateStmt( "tinny","tictac","tinny@prox.com","tpass123","1987-12-08", "2018-02-08",5);
//	 System.out.println(r);
		
	}
	 }
