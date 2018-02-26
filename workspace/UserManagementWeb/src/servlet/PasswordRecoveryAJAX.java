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
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.db.UserDBManager;
import org.entities.User;

import com.google.gson.Gson;

import gson.StringWrapper;
import utils.MailUtility;
import utils.RandomToken;
import utils.TokenSingleton;

/**
 * Servlet implementation class PasswordRecoveryAJAX
 */
@WebServlet("/PasswordRecoveryAJAX")
public class PasswordRecoveryAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordRecoveryAJAX() {
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
		// prendo l'email 
		Gson gson = new Gson();
		StringWrapper w = gson.fromJson(json, StringWrapper.class);
		//carico l'user..
		User u=null;
		boolean checkEmail = false;
		StringWrapper outValue = new StringWrapper();
		outValue.setValue(new String[] {"ko"});
		try {
			u = UserDBManager.getUserByEmail(w.getValue()[0]);
			if(u != null) {
				checkEmail = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (checkEmail) {
			String token = RandomToken.generate();
			TokenSingleton.getTokenSingleton()
							.getTokenMail().put(token, w.getValue()[0]);
			try {
				MailUtility.sendMailToken(w.getValue()[0], token);
				outValue.setValue(new String[] {"ok"});
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} 
		
		String outString = gson.toJson(outValue);
		response.getWriter().append(outString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
