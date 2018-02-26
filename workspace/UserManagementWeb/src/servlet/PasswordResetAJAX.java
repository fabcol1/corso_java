package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserDBManager;
import org.entities.User;

import com.google.gson.Gson;

import gson.StringWrapper;
import utils.MailUtility;

/**
 * Servlet implementation class PasswordResetAJAX
 */
@WebServlet("/PasswordResetAJAX")
public class PasswordResetAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		// prendo l'oggetto
		Gson gson = new Gson();
		StringWrapper w = gson.fromJson(json, StringWrapper.class);
		
		String email = "testproxima2018@gmail.com";
		String[] oldAndNewPassword = w.getValue();
		
		User u = null;
		StringWrapper outValue = new StringWrapper();
		outValue.setValue(new String[] {"ko"});

		try {
			u = UserDBManager.getUserByEmail(email);
			if(u != null && u.getPassword().equals(oldAndNewPassword[0])) {
				// Contatto il DB per aggiornare la password
				boolean checkUpdate = false;
				try {
					UserDBManager.updatePasswordByEmail(email, oldAndNewPassword[1]);
					checkUpdate = true ;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if (checkUpdate) {
					// Invio email con la nuova password al client
					try {
						MailUtility.sendMailPassword(email, oldAndNewPassword[1]);
						//se tutto va bene compreso l'invio email mando un OK!
						outValue.setValue(new String[] {"ok"});
					} catch (MessagingException e) {
						e.printStackTrace();
						// se l'invio mail non va a buon fine reimposto l'email vecchia
						UserDBManager.updatePasswordByEmail(email, oldAndNewPassword[0]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String outString = gson.toJson(outValue);
		response.getWriter().append(outString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
