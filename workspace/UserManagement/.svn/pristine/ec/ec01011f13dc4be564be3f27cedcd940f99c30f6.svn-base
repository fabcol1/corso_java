package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsersAccessDB {
	
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://mercurio:3306/testDB?useSSL=false";
		java.sql.Connection con = DriverManager.getConnection(url, "test3", "test3");
		System.out.println("connessione eseguita.");
		return con;		
	}
	
	public static ArrayList<User> getUsers() throws Exception {		
			
		Connection con= getConnection();
		java.sql.Statement cmd = con.createStatement();
		String sql="select * from users";
		ResultSet resultSet=cmd.executeQuery(sql);
		
		ArrayList<User> users=new ArrayList<>();
		
		
		while (resultSet.next()) {
			User user=new User();
			user.setId(resultSet.getInt("id"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setFirstname(resultSet.getString("firstname"));
			user.setLastname(resultSet.getString("lastname"));
			user.setBorndate(resultSet.getString("borndate"));
			user.setRegdate(resultSet.getString("regdate"));
			users.add(user);
		}
		
		return users;
		
	}
	
	/*public static void main(String[] args) throws Exception {
		
		for (User user : getUsers()) {
			//System.out.println(user.getId());
			System.out.println(user.getEmail());
			System.out.println(user.getFirstname());
			System.out.println(user.getLastname());
			System.out.println("####################");
			//System.out.println(user.getId());
		}
	}*/
}
