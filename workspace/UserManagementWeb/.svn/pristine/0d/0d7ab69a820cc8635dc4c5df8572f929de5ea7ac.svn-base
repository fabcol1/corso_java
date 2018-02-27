package servletusers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.User;
import org.entities.UserLoginToken;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServletToken")
public class TestServletToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
        response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("nomeutente");
		
		User u = UserDBManager.getUserByEmail(email);

		String em = u.getEmail();
		
		
		if (em.equals(null)) {
			
		    throw new NullPointerException();
			
		} else {
			
			UserLoginTokenDBManager.setTokenDataUser(email);
			
            response.sendRedirect("token.jsp");
        }
		
		} catch (NullPointerException e) {
			
			response.sendRedirect("ko.html");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
