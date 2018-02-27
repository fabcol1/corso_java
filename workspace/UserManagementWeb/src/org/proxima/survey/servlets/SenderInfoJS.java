package org.proxima.survey.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proxima.survey.frontutils.QuestionInfo;

import com.google.gson.Gson;

/**
 * Servlet implementation class SenderInfoJS
 */
@WebServlet("/SenderInfoJS")
public class SenderInfoJS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SenderInfoJS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void main(String args[]) {
		String answers[] = {"ciao", "a", "te"};
		convertQuestionInfoInJson(new QuestionInfo("2", "CIAONE", answers), 1, 2);
	}
	
	protected static String convertQuestionInfoInJson(QuestionInfo s, int index, int idQuestionnaire) {
		
		StringBuilder string = new StringBuilder();
		string.append("{\"index\":" + '"' + index +"\",");
		string.append("\"idQuestionnaire\":" + '"' + idQuestionnaire + "\",");
		Gson gson = new Gson();
		string.append("\"currentQuestion\":"+ gson.toJson(s) + "}");
	
		return string.toString();
	}

}
