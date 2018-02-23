package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.bean.UserLoginToken;

import com.commons.PropertiesManager;

/**
 * @author luga
 *
 */

public class UserLoginTokenDBManager {

	final static Logger logger = Logger.getLogger(UserLoginTokenDBManager.class);

	protected static Connection con;

	private static String dbUsername;
	private static String dbPassword;
	private static String connectorMainClass;
	private static String dbUrl;

	static {
		dbUsername = PropertiesManager.getPropertyAsString("database.username");
		dbPassword = PropertiesManager.getPropertyAsString("database.password");
		dbUrl = PropertiesManager.getPropertyAsString("database.connection.url");
		connectorMainClass = PropertiesManager.getPropertyAsString("database.connector.mainclass");

		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: "
				+ dbUrl + " - connectorMainClass: " + connectorMainClass);
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

	public static List<UserLoginToken> getUserLoginToken() {
		List<UserLoginToken> user_tokens = new ArrayList<UserLoginToken>();

		try {
			openConnection();
			Statement cmd = con.createStatement();
			String query = "SELECT * FROM userlogintoken;";
			ResultSet res = cmd.executeQuery(query);
			UserLoginToken appoUserToken;
			while (res.next()) {
				appoUserToken = new UserLoginToken();
				appoUserToken.setId(res.getLong(1));
				appoUserToken.setEmail(res.getString("email"));
				appoUserToken.setGeneratedToken(res.getString("generated_token"));
				appoUserToken.setTokenExpired(res.getString("expiration_date"));
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getString(4));
				user_tokens.add(appoUserToken);
			}
			res.close();
			closeConnection();
			System.out.println("user_tokens.size(): " + user_tokens.size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return user_tokens;
	}

	public static UserLoginToken getUserByToken(String email_token) throws Exception {
		System.out.println("generatedToken " + email_token);
		UserLoginToken user_tokens = null;

		openConnection();
		String query = "SELECT * FROM userlogintoken where email = ?;";
		PreparedStatement cmd = con.prepareStatement(query);
		cmd.setString(1, email_token);
		ResultSet res = cmd.executeQuery();
		res.last();
		System.out.println("res.getRow(); + " + res.getRow());
		res.beforeFirst();
		while (res.next()) {
			user_tokens = new UserLoginToken();
			user_tokens.setId(res.getLong(1));
			user_tokens.setEmail(res.getString("email"));
			user_tokens.setGeneratedToken(res.getString("generated_token"));
			user_tokens.setTokenExpired(res.getString("expiration_date"));

			
			System.out.println("user_tokens: " + user_tokens);

		}
		res.close();
		closeConnection();
		return user_tokens;
	}

	public static int setTokenDataUser(String email) throws Exception {
		openConnection();

		String random_token = "";

		Random r = new Random();
		String resultT;

		// GENERA IL TOKEN E VERIFICA SE IL TOKEN GENERATO E' RIDONDANTE.
		// SE RIDONDANTE RICOMINCIA DA CAPO

		do {

			// GENERA UN TOKEN CASUALE CON I CARATTERI DELLA STRINGA ALPHABET

			String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz=?!@#";
			for (int i = 0; i < 50; i++) {
				random_token += alphabet.charAt(r.nextInt(alphabet.length()));
			}

			// LATO SQL PER VERIFICA DELLA RIDONDANZA SUL TOKEN GENERATO

			String check = "SELECT * FROM userlogintoken where generated_token = ?;";
			PreparedStatement chk = con.prepareStatement(check);
			chk.setString(1, random_token);

			ResultSet rs = chk.executeQuery();
			
			if(rs.next()) {
				// INSERISCE IL RISULTATO IN UNA VARIABILE
				resultT = rs.getString("generated_token");	
			} else {
				resultT = "";
			}

		} while (random_token.equals(resultT));

		// CREA UNA SCADENZA DEL TOKEN DI 5 MINUTI

		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String folderName = formatter.format(today);

		String dt = folderName;
		Calendar c = Calendar.getInstance();
		c.setTime(formatter.parse(dt));
		c.add(Calendar.MINUTE, Integer.parseInt(PropertiesManager.getPropertyAsString("token.expirationtime")));
		dt = formatter.format(c.getTime());

		// LATO SQL PER INSERIMENTO DATI DI UN UTENTE CON TOKEN GENERATO E SCADENZA DEL
		// TOKEN

		String query = "INSERT INTO userlogintoken (email, generated_token, expiration_date) values (?, ?, ?);";
		PreparedStatement cmd = con.prepareStatement(query);
		cmd.setString(1, email);
		cmd.setString(2, random_token);
		cmd.setString(3, dt);

		int rows = cmd.executeUpdate();

		closeConnection();
		
		return rows;

	}

	public static int deleteAll() {
		int rows = 0;

		try {
			openConnection();
			String query = "delete from userlogintoken ;";
			Statement cmd = con.createStatement();

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
	
//	public static void main (String[] args) throws Exception {
//		System.out.println("#########");
//		System.out.println("PROVA TOKEN ATTIVO");
//		System.out.println("#########");
////		UserLoginTokenDBManager.setTokenDataUser("provatest1@prova.com");
//		System.out.println("DEBUG 1");
//		UserLoginToken u = UserLoginTokenDBManager.getUserByToken("provatest1@prova.com");
//		
////		String s = u.isTokenExpired();
//	}

}
