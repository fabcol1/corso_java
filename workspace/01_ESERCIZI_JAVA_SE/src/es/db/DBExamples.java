package es.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBExamples {
	public static void main(String[] args) throws Exception {
		// driver di tipo "bridge jdbc-odbc"
		String driver = "com.mysql.jdbc.Driver";
		// se la chiamata va a buon fine. Ho i driver caricati correttamente nel class path
		Class.forName(driver);
		
		// stringa di connessione
		String url = "jdbc:mysql://127.0.0.1:3306/testDB?autoReconnect=true&useSSL=true";
		Connection con = DriverManager.getConnection(url, "root", "pippo");
		Statement cmd = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String line;
		
		do {
			System.out.print("Inserisci istruzione (select, insert, update, delete, quit, selectParam) : ");
			line = sc.nextLine();
			
			switch(line) {
			case "select":
				System.out.println("-------------------SELECT---------------------------");
				querySelect(cmd);
				break;
			case "insert":
				System.out.print("Inserisci nome: ");
				String nome = sc.nextLine();
				System.out.print("Inserisci cognome: ");
				String cognome = sc.nextLine();
				System.out.println("INSERT di " + nome + " " + cognome);
				queryInsert(cmd, nome, cognome);
				break;
			case "update":
				System.out.print("Inserisci nome vecchio: ");
				String oldName = sc.nextLine();
				System.out.print("Inserisci nome nuovo: ");
				String newName = sc.nextLine();
				queryUpdateName(cmd, oldName, newName);
				break;
			case "delete":
				System.out.print("Inserisci nome da cancellare: ");
				String name = sc.nextLine();
				queryDeleteByName(cmd, name);
				break;
			case "selectParam":
				System.out.println("-------------------SELECT PARAM---------------------------");
				System.out.print("Inserisci nome da cercare: ");
				nome = sc.nextLine();
				querySelectParam(con, nome);
				break;
			}
		} while(!(line).equals("quit"));
		
		cmd.close();
		con.close();
	}
	
	private static void queryDeleteByName(Statement cmd, String name) throws SQLException {
		String query = "DELETE FROM testDBTable WHERE nome='"+name+"'";
		cmd.executeUpdate(query);
	}
	
	private static void queryUpdateName(Statement cmd, String oldName, String newName) throws SQLException {
		String query = "UPDATE testDBTable SET nome='"+newName+"' WHERE nome='"+oldName+"'";
		cmd.executeUpdate(query);
	}
	
	private static void queryInsert(Statement cmd, String nome, String cognome) throws SQLException {
		String query = "INSERT INTO testDBTable (nome,password) VALUES('"+ nome +"','"+ cognome + "')";
		cmd.executeUpdate(query);
	}
	
	private static void querySelect(Statement cmd) throws Exception {
		String query = "SELECT * FROM testdbtable";
		
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			System.out.format("Nome: %-15s Cognome: %-10s\n", res.getString("nome"), res.getString("password"));
		}
		res.close();
	}
	
	private static void querySelectParam(Connection con, String nome) throws Exception {
		String query = "SELECT * FROM testdbtable WHERE nome = ?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setString(1, nome);
		ResultSet res = pStatement.executeQuery();
		
		while(res.next()) {
			System.out.format("Nome: %-15s Cognome: %-10s\n", res.getString("nome"), res.getString("password"));
		}
		res.close();
	}
}
