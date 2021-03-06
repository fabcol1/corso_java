package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserDBManager;
import org.entities.User;

import utils.MailUtility;
import utils.RandomToken;
import utils.TokenSingleton;

/**
 * Servlet implementation class ResetPasswordWithToken
 */
@WebServlet("/PasswordRecovery")
public class PasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordRecovery() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean checkEmail = false;
		String outputJSP = "";
		String email = request.getParameter("email");
		User u=null;

		try {
			u = UserDBManager.getUserByEmail(email);
			if(u != null) {
				checkEmail = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (checkEmail) {
			String token = RandomToken.generate();
			
//			String url = "http://localhost:8080/UserManagementWeb/PasswordRecoveryWithToken?t="+token;
			
			TokenSingleton.getTokenSingleton()
							.getTokenMail().put(token, email);
			
			try {
//				MailUtility.sendMail(email, url);
				MailUtility.sendMailToken(email, token);
				outputJSP="/outputJSP/passwordRecovery/okPasswordRecovery1.jsp";
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		} else {
			outputJSP = "/outputJSP/passwordRecovery/koPasswordRecovery1.jsp";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(outputJSP);
		rDispatcher.forward(request, response);
	}

}
