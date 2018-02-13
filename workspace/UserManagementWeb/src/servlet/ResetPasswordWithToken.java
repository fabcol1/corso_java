package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.User;
import org.db.UserDBManager;

import utils.MailUtility;
import utils.RandomToken;
import utils.TokenSingleton;

/**
 * Servlet implementation class ResetPasswordWithToken
 */
@WebServlet("/ResetPasswordWithToken")
public class ResetPasswordWithToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordWithToken() {
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
		String outputJSP = "/outputJSP/resetPassword/koReset.jsp";
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
			
			String url = "http://192.168.178.32:8080/UserManagementWeb/ForgetPassword?t="+token;
			
			TokenSingleton.getTokenSingleton()
							.getTokenMail().put(token, email);
			
			try {
				MailUtility.sendMail(email, url);
				outputJSP="/outputJSP/resetPassword/okReset.jsp";
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		} else {
			outputJSP = "/outputJSP/resetPassword/koReset.jsp";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(outputJSP);
		rDispatcher.forward(request, response);
	}

}
