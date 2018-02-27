package servletusers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bean.UserLoginToken;
import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.User;
import org.entities.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ServletGeneratedToken")
public class ServletGeneratedToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGeneratedToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
        response.setContentType("text/html;charset=UTF-8");
		
		String token = request.getParameter("token");
		
			System.out.println("TOKEN PRESO? " + token);		

			System.out.println("TOKEN NEL DATABASE PRESO? " + UserLoginTokenDBManager.getUserByToken(token).getGeneratedToken());
			
			System.out.println("DATA DEL TOKEN? " + UserLoginTokenDBManager.getUserByToken(token).isTokenExpired());
			
			SimpleDateFormat today_date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			boolean expired = today_date.parse(UserLoginTokenDBManager.getUserByToken(token).isTokenExpired()).before(new Date());
			
			System.out.println("SCADUTO? " + expired);
			
			if (token.equals(UserLoginTokenDBManager.getUserByToken(token).getGeneratedToken())) {
				
				if (today_date.parse(UserLoginTokenDBManager.getUserByToken(token).isTokenExpired()).before(new Date()) == false) {
					

        	HttpSession session = request.getSession();
        	session.setAttribute("loggedUser", UserLoginTokenDBManager.getUserByToken(token));
            
        	response.sendRedirect("ok.html");
        	
        } else {
        	
        	response.sendRedirect("expiredtoken.jsp");
        	
        } 
		} if (!token.equals(UserLoginTokenDBManager.getUserByToken(token).getGeneratedToken())){
			
			response.sendRedirect("ko.html");
			
		}
			
		} catch (Exception e) {
			
			
			
		}
        
	}

}
