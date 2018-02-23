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

import utils.MailUtility;
import utils.RandomPassword;
import utils.TokenSingleton;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/PasswordRecoveryWithToken")
public class PasswordRecoveryWithToken extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordRecoveryWithToken() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String outputJSP = "/outputJSP/passwordRecovery/koPasswordRecovery2.jsp";
		String email = TokenSingleton.getTokenSingleton().getTokenMail().get(request.getParameter("t"));

		if (email != null) {
			String newPassword = RandomPassword.generate();

			Boolean checkUpdate = false;
			try {
				checkUpdate = UserDBManager.updatePasswordByEmail(email, newPassword);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if (checkUpdate) {
				try {
					MailUtility.sendMailPassword(email, newPassword);
//					MailUtility.sendMail(email, newPassword);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				outputJSP = "/outputJSP/passwordRecovery/okPasswordRecovery2.jsp";
			} else {
				outputJSP = "/outputJSP/passwordRecovery/koPasswordRecovery2.jsp";
			}
		} else {
			outputJSP = "/outputJSP/passwordRecovery/koPasswordRecovery3.jsp";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(outputJSP);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
