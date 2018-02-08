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

import database.credential.DBCheckCredential;
import database.credential.DBUpdateCredential;
import utils.MailUtility;
import utils.RandomPassword;

/**
 * Servlet implementation class ResetEmail
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
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

		Boolean checkEmail = false;
		String outputJSP;
		String email = request.getParameter("email");
		// Contatto il DB per ricevere i dati dell'user (che potrebbe non esistere)
		// Se la query non torna nulla allora l'user non esiste --> invio
		try {
			checkEmail = DBCheckCredential.checkEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (checkEmail) {

			// Creo email random
			String newPassword = RandomPassword.generate();

			// Contatto il DB per aggiornare la password
			Boolean checkUpdate = false;
			try {
				checkUpdate = DBUpdateCredential.updatePassword(email, newPassword);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if(checkUpdate) {
				// Invio email con la nuova password al client
				try {
					MailUtility.sendMail(email, "Proxima", "Reset Password",
							"Questa è la tua nuova password: " + newPassword);
				} catch (MessagingException e) {
					e.printStackTrace();
				}

				// Invio pagina JSP di conferma cambio password
				outputJSP = "/outputJSP/resetPassword/okReset.jsp";
			} else {
				outputJSP = "/outputJSP/resetPassword/koReset.jsp";
			}
		} else {

			// Invio pagina JSP di errore
			outputJSP = "/outputJSP/resetPassword/koReset.jsp";
		}

		// Invio al client la relativa pagina .jsp in base al risultato ottenuto
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(outputJSP);
		rDispatcher.forward(request, response);

	}

}
