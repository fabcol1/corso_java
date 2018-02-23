/**
 * 
 */
package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bean.User;
import org.hibernate.Session;

/**
 * @author maurizio
 *
 */
public class UserDBManager extends DBManager {

	final static Logger logger = Logger.getLogger(UserDBManager.class);
	
	protected static Connection con;

	static {
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass);
	}

	public static void openConnection() throws Exception {
		Class.forName(connectorMainClass);
		con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		logger.info("Connection opened successfully...");
	}

	public static void closeConnection() throws Exception {
		try {
			con.close();
			logger.info("Connection closed successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}

	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		try {
			openConnection();
			// creo oggetto statement
			Statement cmd = con.createStatement();
			// creo la query string
			String query = "SELECT * FROM users;";
			// interrogo il db e ottendo il risultato
			ResultSet res = cmd.executeQuery(query);
			User appoUser;
			while (res.next()) {
				appoUser = new User();
				appoUser.setId(res.getLong(1));
				appoUser.setEmail(res.getString("email"));
				appoUser.setPassword(res.getString("password"));
				appoUser.setFirstname(res.getString("firstname"));
				appoUser.setLastname(res.getString("lastname"));
				appoUser.setBorndate(res.getString("borndate"));
				appoUser.setRegdate(res.getString("regdate"));
				appoUser.setRole(res.getInt("role"));
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
				users.add(appoUser);
			}
			res.close();
			closeConnection();
			System.out.println("users.size(): " + users.size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return users;
	}

	public static User getUserByEmail(String email) {
		System.out.println("email: " + email);
		User user = null;

		try {
			openConnection();
			// creo la query string
			String query = "SELECT * FROM users where email = ?;";
			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setString(1, email);
			ResultSet res = cmd.executeQuery();
			res.last();
			System.out.println("res.getRow(); + " + res.getRow());
			res.beforeFirst();
			while (res.next()) {
				user = new User();
				user.setId(res.getLong(1));
				user.setEmail(res.getString("email"));
				user.setPassword(res.getString("password"));
				user.setFirstname(res.getString("firstname"));
				user.setLastname(res.getString("lastname"));
				user.setBorndate(res.getString("borndate"));
				user.setRegdate(res.getString("regdate"));
				user.setRole(res.getInt("role"));
			}
			res.close();
			closeConnection();
			System.out.println("user: " + user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return user;
	}

	public static User getUserById(int id) {

		User appoUser = new User();

		try {

			openConnection();

			String query = "SELECT * FROM users WHERE id = ?;";

			PreparedStatement cmd = con.prepareStatement(query);

			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();
			res.last();
			System.out.println("row number: " + res.getRow());
			res.beforeFirst();

			while (res.next()) {

				appoUser = new User();
				appoUser.setId(res.getLong(1));
				appoUser.setEmail(res.getString("email"));
				appoUser.setPassword(res.getString("password"));
				appoUser.setFirstname(res.getString("firstname"));
				appoUser.setLastname(res.getString("lastname"));
				appoUser.setBorndate(res.getString("borndate"));
				appoUser.setRegdate(res.getString("regdate"));
				appoUser.setRole(res.getInt("role"));
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));

			}

			res.close();
			closeConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return appoUser;

	}

	public static int updateUserById(int id, String email, String password, String firstName, String lastName,
			String bornDate) {

		int rows = 0;

		try {

			openConnection();

			String query = "UPDATE users SET email = ?, password = ?, firstname = ?, lastname = ?, borndate = ? WHERE ID = ?";

			PreparedStatement cmd = con.prepareStatement(query);

			cmd.setString(1, email);
			cmd.setString(2, password);
			cmd.setString(3, firstName);
			cmd.setString(4, lastName);
			cmd.setString(5, bornDate);
			cmd.setInt(6, id);

			rows = cmd.executeUpdate();

			System.out.println("hai aggiornato l'utente con id " + id);

			closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return rows;

	}

	public static int deleteUserById(int id) {

		int rows = 0;

		try {

			openConnection();

			// creo oggetto statement

			String query = "delete from users where id = ?;";

			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setInt(1, id);

			// interrogo il db e ottendo il risultato

			rows = cmd.executeUpdate();

			closeConnection();
			System.out.println("Deleted rows: " + rows);
			System.out.println("Hai cancellato l'utente con id " + id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows;
	}

	// METODO DI INSERIMENTO UTENTE IN FASE DI REGISTRAZIONE

//	public static int insertUser(User user) throws Exception {
//
//		openConnection();
//		int rows = 0;
//		String query = "INSERT INTO users (email, password, firstname, lastname, borndate, regdate, role) VALUES (?,?,?,?,?,?,?)";
//		PreparedStatement pStatement = con.prepareStatement(query);
//
//		pStatement.setString(1, user.getEmail());
//		pStatement.setString(2, user.getPassword());
//		pStatement.setString(3, user.getFirstname());
//		pStatement.setString(4, user.getLastname());
//		pStatement.setString(5, user.getBorndate());
//		pStatement.setString(6, user.getRegdate());
//		pStatement.setInt(7, user.getRole());
//
//		try {
//			rows = pStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		pStatement.close();
//		closeConnection();
//		return rows;
//	}
	
	public static void insertUser(org.entities.User user) throws Exception {
//		Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = getSessionFactory().openSession();
	    session.beginTransaction();	    
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
//	    logger.debug("Insert user returns: " + user.getId());
//	    return user.getId();
	}
	

	/**
	 * Metodo per aggiornare la password data un'email e la nuova password
	 * 
	 * @throws Exception
	 */
	public static boolean updatePasswordByEmail(String email, String newPassword) throws Exception {
		try {
			boolean val = false;

			// create db connection
			openConnection();

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
			closeConnection();
			return val;
		} catch (Exception e) {
			e.printStackTrace();
			closeConnection();
			return false;
		}
	}

	public static int deleteAll() {
		int rows = 0;

		try {
			openConnection();
			// creo oggetto statement
			String query = "delete from users ;";
			Statement cmd = con.createStatement();

			// interrogo il db e ottendo il risultato
			rows = cmd.executeUpdate(query);
			cmd.close();
			closeConnection();
			System.out.println("Deleted rows: " + rows);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows;
	}

}
