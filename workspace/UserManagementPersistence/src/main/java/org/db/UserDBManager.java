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

import org.bean.User;

/**
 * @author maurizio
 *
 */
public class UserDBManager {

	private static final String TABLE_USERS = "users";

	protected static Connection con;

	public static void openConnection() throws Exception {
		// System.out.println("CARICARE DRIVER PER CONNESSIONE");
		// CARICARE DRIVER PER CONNESSIONE
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// DEFINISCO url, username e password
		// System.out.println("//DEFINISCO url, username e password");
		String url = "jdbc:mysql://192.168.178.32:3306/testDB";
		String username = "test3";
		String password = "test3";
		// stabilisco la connessione
		con = DriverManager.getConnection(url, username, password);
	}

	public static void closeConnection() throws Exception {
		try {
			con.close();
			System.out.println("Chiusa connessione con il database....");
		} catch (Exception e) {
			e.printStackTrace();
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

	public static User getUserById(int id) {

		User appoUser = new User();

		try {

			openConnection();
			// creo oggetto statement

			// creo la query string

			String query = "SELECT * FROM users WHERE id = ?;";

			// interrogo il db e ottendo il risultato

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

	public static User getUserByEmail(String email) {
		System.out.println("email: " + email);
		User user = null;

		try {
			openConnection();
			// creo oggetto statement
			// Statement cmd = con.createStatement ();

			// creo la query string
			String query = "SELECT * FROM users where email = ?;";
			// interrogo il db e ottendo il risultato
			// ResultSet res = cmd.executeQuery(query);
			// System.out.println("DEBUG 1");
			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setString(1, email);
			ResultSet res = cmd.executeQuery();
			// User appoUser ;
			res.last();
			// System.out.println("res.getRow(); + " + res.getRow());
			res.beforeFirst();
			while (res.next()) {
				user = new User();
				user.setId(res.getLong(1));
				user.setEmail(res.getString("email"));
				user.setPassword(res.getString("password"));
				// System.out.println(res.getString(1));
				// System.out.println(res.getString(2));
			}
			res.close();
			closeConnection();
			// System.out.println("user: " + user);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return user;
	}

	public static int updateuserById(int id, String email, String password, String firstName, String lastName,
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

	public static int insertNewUser(String email, String password, int role) {
		int rows = 0;

		try {
			openConnection();
			// creo oggetto statement
			String query = "insert into users (email, password, role) values (?, ?, ?) ;";
			PreparedStatement cmd = con.prepareStatement(query);
			cmd.setString(1, email);
			cmd.setString(2, password);
			cmd.setInt(3, role);
			// interrogo il db e ottendo il risultato
			rows = cmd.executeUpdate();
			cmd.close();
			closeConnection();
			System.out.println("Inserted rows: " + rows);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return rows;
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

	// public static void main (String[] args) {
	// insertNewUser("paperino", "topolino");
	// deleteAll();
	// }

	// METODO DI INSERIMENTO UTENTE IN FASE DI REGISTRAZIONE

	public static boolean insertUser(User user) throws Exception {

		boolean result;

		DBManager db = new DBManager();
		Connection con = db.getConnection();

		String query = "INSERT INTO users (email, password, firstname, lastname, borndate, regdate, role) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pStatement = con.prepareStatement(query);

		pStatement.setString(1, user.getEmail());
		pStatement.setString(2, user.getPassword());
		pStatement.setString(3, user.getFirstname());
		pStatement.setString(4, user.getLastname());
		pStatement.setString(5, user.getBorndate());
		pStatement.setString(6, user.getRegdate());
		pStatement.setInt(7, user.getRole());

		try {
			pStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		pStatement.close();
		db.closeConnection();
		return result;
	}

	/**
	 * Metodo per controllare se l'email è presente nel DB.
	 * 
	 * @throws Exception
	 */
	public static boolean isEmailOnDB(String email) {
		// create db connection
		try {
			DBManager db = new DBManager();

			// statement + query on db
			Statement cmd = db.getConnection().createStatement();
			String query = "SELECT email FROM " + TABLE_USERS;
			ResultSet res = cmd.executeQuery(query);

			// itero finch� non trovo l'email nel resultset a quel punto ritorno true (
			// email trovata)
			while (res.next()) {
				if (email.equals(res.getString("email"))) {
					res.close();
					return true;
				}
			}
			// se sono arrivato qua non ho trovato l'email nel db... ritorno false ( email
			// non trovata)
			res.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo per aggiornare la password data un'email e la nuova password
	 */
	public static boolean updatePasswordByEmail(String email, String newPassword) {
		try {
			boolean val = false;

			// create db connection
			DBManager db = new DBManager();
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
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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

}
