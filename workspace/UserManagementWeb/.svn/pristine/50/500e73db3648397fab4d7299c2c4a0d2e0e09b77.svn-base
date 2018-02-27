package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.db.UserDBManager;
import org.entities.User;

import utils.MailUtility;
import utils.RandomPassword;

/**
 * Servlet implementation class ResetEmail
 */
@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession session = request.getSession();

		String outputJSP = "";
		// String email = (String) session.getAttribute("user");
		String email = "testproxima2018@gmail.com";
		String oldPassword = (String) request.getParameter("oldPassword");
		String newPassword = (String) request.getParameter("newPassword");
		String newPasswordCheck = (String) request.getParameter("newPasswordCheck");
		User u = null;

		try {
			u = UserDBManager.getUserByEmail(email);
			// Controllo se oldPassword inserita � uguale a Password on DB
			System.out.println(u.getPassword());
			System.out.println(oldPassword);
			System.out.println(newPassword);
			System.out.println(newPasswordCheck);
			if (u.getPassword().equals(oldPassword)) {
				// Controllo che le 2 newPassword siano corrette
				if (newPassword.equals(newPasswordCheck)) {
					// Contatto il DB per aggiornare la password
					Boolean checkUpdate = false;
					try {
						UserDBManager.updatePasswordByEmail(email, newPassword);
						checkUpdate = true ;
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (checkUpdate) {
						// Invio email con la nuova password al client
						try {
//							MailUtility.sendMail(email, newPassword);
							MailUtility.sendMailPassword(email, newPassword);
						} catch (MessagingException e) {
							e.printStackTrace();
						}

						// Invio pagina JSP di conferma cambio password
						outputJSP = "/outputJSP/passwordReset/okPasswordReset.jsp";
					} else {
						outputJSP = "/outputJSP/passwordReset/koPasswordReset1.jsp";
					}
				} else {
					// KO - la nuova password non coincide con la checkpassword
					outputJSP = "/outputJSP/passwordReset/koPasswordReset3.jsp";
				}

			} else {
				// KO - la old password non � corretta
				outputJSP = "/outputJSP/passwordReset/koPasswordReset2.jsp";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Invio al client la relativa pagina .jsp in base al risultato ottenuto
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(outputJSP);
		rDispatcher.forward(request, response);

	}

}
