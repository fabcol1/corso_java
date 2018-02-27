package org.proxima.survey.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entities.User;
import org.proxima.survey.entities.Reply;
import org.proxima.survey.frontutils.QuestionCorrection;
import org.proxima.survey.utility.RetrieverUtility;

/**
 * Servlet implementation class NextQuestionServlet
 */
@WebServlet("/NextQuestionServlet")
public class NextQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static List<QuestionCorrection> corrections;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(corrections == null) {
			corrections = RetrieverUtility.getQuestionCorrection();
		}		
//		InfoSurveySession info = (InfoSurveySession) request.getSession().getAttribute("infoSurveySession");
		
		int index = Integer.getInteger(request.getParameter("index"));
		
		checkReply(request.getParameter("quesID"), 
									request.getParameterValues(request.getParameter("quesID")),
									(User)request.getSession().getAttribute("loggedUser"),
									Integer.getInteger(request.getParameter("questionnaireID")));
		
		
//		 request.setAttribute("index", (index+1));
//		 request.getRequestDispatcher("survey.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	/**
	 * UTILITY METHOD TO RETRIEVE A REPLY
	 * @param quesID
	 * @param answers
	 * @param user 
	 * @param index 
	 * @return
	 */
	protected static Reply checkReply(String quesID, String[] answers, User user, int index) {
		int countExactness = 0;
		boolean guessed = false;
		Reply result = new Reply();
		QuestionCorrection correction = null;
		for(QuestionCorrection q : corrections) {
			if(q.getQuestionID().equals(quesID)) {
				correction = q;
				break;
			}
		}
		List<String> correctAnswers = Arrays.asList(correction.getAnswers());
		
		if(answers!=null) {
			
			for(String str : answers) {
				switch(str) {
				case "AnsA": result.setAnsa(true); break;
				case "AnsB": result.setAnsb(true); break;
				case "AnsC": result.setAnsc(true); break;
				case "AnsD": result.setAnsd(true); break;
				case "AnsE": result.setAnse(true); break;
				case "AnsF": result.setAnsf(true); break;
				}
				if(correctAnswers.contains(str))
					countExactness++;
			}
			if(countExactness == correctAnswers.size())
				guessed = true;
		}
		
		result.setIdQuestion(Integer.getInteger(correction.getQuestionID()));
		result.setIdUser(new Long(user.getId()));
		result.setGuessed(guessed);
		RetrieverUtility.insertReply(result);
		RetrieverUtility.updateQuestionnaire(index, result.getId());
		return result;
	}
	
	
}
