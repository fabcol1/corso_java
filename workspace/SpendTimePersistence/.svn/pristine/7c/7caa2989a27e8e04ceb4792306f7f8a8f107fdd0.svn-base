package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import utility.CurrentDate;


public class SpendTimeDBManager {
	
	final static Logger logger = Logger.getLogger(SpendTimeDBManager.class);
	
	int giorno, ora;
	public boolean check = false;;
	
	public void insertDb(int id, String giorno, int ora) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
	
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		String query = "INSERT INTO spendtime (id, data, ora) VALUES (?,?,?)";
		PreparedStatement ps  = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, giorno);
		ps.setInt(3, ora);
		
		try {
			ps.executeUpdate();
			} catch (SQLException s) {
				logger.error(s.getMessage());
			}
		// Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		}
	
	public static int selectByOra(String giorno) throws ClassNotFoundException, SQLException {
		int ora = 0;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		Statement cmd = con.createStatement();
		
		String query = "SELECT ora FROM spendtime WHERE data = "+" '"+giorno+"'";
		ResultSet res = cmd.executeQuery(query);
		while(res.next()) {
			ora = res.getInt(1);
			logger.debug(ora);
		}
		return ora;
	}
	
	public void updateDb(String giorno, int ora) throws ClassNotFoundException, SQLException {
		//boolean verifica = false;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		//Statement cmd = con.createStatement();
		
		String query = "Update spendtime SET ora="+ora+" WHERE data= '"+giorno+"'";
		PreparedStatement ps = con.prepareStatement(query);

		ps.executeUpdate();
		//verifica = true;
		//return verifica;
	}
	
	public ArrayList<SpendTime> selectDb() throws ClassNotFoundException, SQLException {
		ArrayList<SpendTime> dip = new ArrayList<SpendTime>();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);		
		String url = "jdbc:mysql://localhost:3306/dipendenti";
		Connection con = DriverManager.getConnection(url,"testuser","testuser");
		Statement cmd = con.createStatement();
		
		String query = "SELECT * FROM spendtime";
		ResultSet res = cmd.executeQuery(query);
		
		while(res.next()) {
			logger.debug(res.getString(2));
			dip.add(new SpendTime(res.getInt(1), res.getString(2), res.getInt(3)));
		}
		logger.debug(dip.size());
		return dip;		
	}
	
	
	public HashMap<String, Integer> getPrepopolatedValue () throws ClassNotFoundException, SQLException {
		ArrayList<SpendTime> dip = selectDb();
		HashMap<String, Integer> valori = new HashMap<String, Integer>();

		int sizeDip = dip.size();
		int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
		if( sizeDip < giorno ) {
			for(int i=sizeDip; i< giorno; i++ ) {
				insertDb(dip.get(0).getId(), (i+1)+"-"+CurrentDate.dataCorrente(), 0);
			}
		}
		dip = selectDb();
		sizeDip = dip.size();
		
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			logger.debug("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		logger.debug("Questa è la size dell'ArrayList: " + sizeDip);
		logger.debug("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	
	
	public static int deleteAll() {
		int rows = 0;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
		
			String url = "jdbc:mysql://localhost:3306/dipendenti";
			Connection con = DriverManager.getConnection(url,"testuser","testuser");
			String query = "delete from spendtime;";
			Statement cmd = con.createStatement();

			rows = cmd.executeUpdate(query);
			cmd.close();
			logger.error("Deleted rows: " + rows);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return rows;
	}
	
//	public static void main(String[] args) throws Exception {
//		SpendTimeDBManager sp = new SpendTimeDBManager();
//		sp.insertDb(1, "16-02-2018", 4);
//		logger.debug(SpendTimeDBManager.selectByOra("14-02-2018"));
//	}
}
