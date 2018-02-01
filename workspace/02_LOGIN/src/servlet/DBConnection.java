package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import utils.Question;

public class DBConnection {
	
	private boolean loginOK;
	private boolean registrationOK;
	private boolean questionOK;
	
	public DBConnection() {
		loginOK = false;
		registrationOK = false;
		questionOK = false;
	}
	
	public void checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) return;
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
					loginOK = true;
					break;
				}
			}
		}
		res.close();
	}
	
	public void registration(String email, String password) throws ClassNotFoundException, SQLException {
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) return;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		String query = "INSERT INTO users (email, password) VALUES (?, ?)";
	
		PreparedStatement pStatement = con.prepareStatement(query);
		
		pStatement.setString(1, email);
		pStatement.setString(2, password);

		try {
			pStatement.executeUpdate();
			registrationOK = true;
		} catch(SQLException e) {
//			e.printStackTrace();
			registrationOK = false;
		}
		
		pStatement.close();
		con.close();
	}
	
	public Question generateQuestion() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM quest ORDER BY RAND() LIMIT 1;";
		
		ResultSet res = cmd.executeQuery(query);
		Question q = new Question();

		while(res.next()) {
			q.domanda = res.getString("domanda");
			q.id = res.getInt("id");
			q.risposte = res.getString("risposte").split(";");
		}
		res.close();

		return q;
	}
	
	public void checkQuestion(String id, String[] answer) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/testDB";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM quest WHERE ID=?";
		
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setString(1, id);
		
		ResultSet res = pStatement.executeQuery();
		
		Question q = new Question();

		while(res.next()) {
			q.corrette = res.getString("corrette").split(";");
		}
		res.close();

		Arrays.sort(answer);
		Arrays.sort(q.corrette);
		if(Arrays.equals(answer, q.corrette)) {
			questionOK = true;
		} else {
			questionOK = false;
		}
	}
	
	public boolean login() {
		return loginOK;
	}
	public boolean registration() {
		return registrationOK;
	}
	public boolean question() {
		return questionOK;
	}
}
