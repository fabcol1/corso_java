package servletusers;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;

import org.bean.UserLoginToken;
import org.db.UserLoginTokenDBManager;

public class ValidateGenerationTK
 {
	
	private final static Properties configProp = new Properties();
	
	protected static String dbConnectionURL;
	protected static String dbUser;
	protected static String dbPassword;
	
	
     public static boolean checkToken(String token) 
     {
      boolean st = false;
      try{

     		String propFileName = "application.properties";
  			InputStream inputStream = Validate.class
  					.getClassLoader().getResourceAsStream(propFileName);
  			
  			configProp.load(inputStream);
  		  
  			dbConnectionURL = configProp.getProperty("database.connection.url");
  			dbUser = configProp.getProperty("database.username");
  			dbPassword = configProp.getProperty("database.password");
  			
           Class.forName("com.mysql.jdbc.Driver");

           Connection con=DriverManager.getConnection
                          (dbConnectionURL,dbUser,dbPassword);
       
         PreparedStatement ps =con.prepareStatement
                             ("select * from userlogintoken where generated_token=?");
         ps.setString(1, token);
         ResultSet rs = ps.executeQuery();
         st = rs.next();
         
         if (rs != null) {
        	 
        	UserLoginToken u = UserLoginTokenDBManager.getUserByToken(token);
     		UserLoginTokenDBManager.setTokenDataUser(u.getEmail());
     		
     		String s = u.isTokenExpired();
     		
     	if (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(new Date()) != true) {
     		
     		return true;
     		
     	} else {
     		
     		return false;
     		
     	}
     		
     		
        	 
         }
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
     }
     
 }
