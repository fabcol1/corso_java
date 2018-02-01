package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckQuestion
 */
@WebServlet("/check")
public class CheckQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection con = new DBConnection();
		System.out.println(request.getParameter("id"));
		System.out.println(Arrays.toString(request.getParameterValues("checkbox")));
		
		try {
			con.checkQuestion(request.getParameter("id"), request.getParameterValues("checkbox"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String destination;
		if(con.question()) {
			destination = "/corretto.html";
		} else {
			destination = "/incorretto.html";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
