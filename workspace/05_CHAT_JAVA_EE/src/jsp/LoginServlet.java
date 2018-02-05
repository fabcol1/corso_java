package jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/checkLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		
		boolean val = false;
		try {
			val = DBManager.checkLogin(request.getParameter("email"), request.getParameter("password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		if(val) {
			destination = "/chatFrontEnd.jsp";
			request.setAttribute("email", request.getParameter("email"));
		} else {
			destination = "/loginKO.html";
		}
		
		
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
