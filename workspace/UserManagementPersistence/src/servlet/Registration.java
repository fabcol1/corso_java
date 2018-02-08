package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String user = request.getParameter("uname");    
//	    String pwd = request.getParameter("pass");
//	    String fname = request.getParameter("fname");
//	    String lname = request.getParameter("lname");
//	    String email = request.getParameter("email");
//	    String borndate = request.getParameter("borndate");
//	    HttpSession session = request.getSession();
//	    
//	    
//	    String driver = "com.mysql.jdbc.Driver";
//		Class.forName(driver);
//		String url = "jdbc:mysql://mercurio:3306/testDB";
//		Connection con = DriverManager.getConnection(url, "test3", "test3");
//	    
//	    Statement st = con.createStatement();
//	    ResultSet rs;
////	    int i = st.executeUpdate("insert into users(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())");
////	    if (i > 0) {
////	        session.setAttribute("email", email);
////	        response.sendRedirect("welcome.jsp");
//////	        out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
////	    } else {
////	        response.sendRedirect("index.jsp");
////	    }
//		
//		
		
		
		doGet(request, response);
	}

}
