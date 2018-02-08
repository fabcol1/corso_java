package org.db;
/**
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author corsi
 *
 */
public class DBManager {
	
	
	public static void executeTestSelect () {
		try {
			System.out.println("CARICARE DRIVER PER CONNESSIONE");
		    //CARICARE DRIVER PER CONNESSIONE
	        String driver = "com.mysql.jdbc.Driver";
		    Class.forName(driver);
		    //DEFINISCO url, username e password
		    System.out.println("//DEFINISCO url, username e password");
		    String url = "jdbc:mysql://localhost:3306/testDB";
		    String username = "test3" ;
		    String password = "test3" ;
		    //stabilisco la connessione
			Connection con = DriverManager.getConnection (url, username, password);
			//creo oggetto statement
			Statement cmd = con.createStatement ();
			//creo la query string
			String query = "SELECT * FROM Immobile;";
			//interrogo il db e ottendo il risultato
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
			}
			res.close();
			cmd.close();
			con.close();
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
