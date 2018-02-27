package org.proxima.survey.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proxima.survey.frontutils.Evaluation;


/**
 * Servlet implementation class FinalScoreServlet
 */
@WebServlet("/FinalScoreServlet")
public class FinalScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		InfoSurveySession info = (InfoSurveySession) request.getSession().getAttribute("infoSurveySession");
//		if(info.getFinalDate()==null) {
//			info.setFinalDate(new Date());
//		}
//		NextQuestionServlet.corrections = RetrieverUtility.getQuestionCorrection();
//		Reply newReply = NextQuestionServlet.checkReply(request.getParameter("quesID"), request.getParameterValues(request.getParameter("quesID")));
//		info.getGivenReplies().add(newReply);
//		int exactAnswers = 0;
//		for (Reply r : info.getGivenReplies()) {
//			if(r.isGuessed())
//				exactAnswers++;
//		}
//		Evaluation evaluation = new Evaluation(info.getUserID(), exactAnswers);
//		
//		PdfCreator.createPdf(info.getUserID(), getInformationForReport(info, evaluation), info.getBeginDate());
//		redirectWithResults(request, response, evaluation);
//		//redirectWithDismissal(response);
		
	}

	/**
	 * Private method that redirects to dismissal page, in case you want not to show score to user
	 * @param response
	 */
	@SuppressWarnings("unused")
	private void redirectWithDismissal(HttpServletResponse response) {
		try {
			response.sendRedirect("dismissal.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO ADD THE PERSISTENCE UNIT THAT REGISTER INFORMATION ABOUT SURVEY JUST SUBMITTED
	}

	/**
	 * Private method that redirects to finalScore page, in case you want to show score to user
	 * @param request
	 * @param response
	 * @param evaluation
	 */
	private void redirectWithResults(HttpServletRequest request, HttpServletResponse response, Evaluation evaluation) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("evaluation", evaluation);
		try {
			request.getRequestDispatcher("finalScore.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

//	
//	private String getInformationForReport(InfoSurveySession info, Evaluation evaluation) {
//		StringBuilder report = new StringBuilder();
//		report.append("Welcome to your report user N." + info.getUserID() + ".\n");
//		report.append("This document reports your replies to our survey in date ");
//		report.append(DateFormat.getDateInstance(DateFormat.MEDIUM).format(info.getBeginDate()) + " in comparison with correct answers.\n");
//		report.append("Begin time: ");
//		report.append(DateFormat.getTimeInstance(DateFormat.LONG).format(info.getBeginDate()).toString().replace(".", ":"));
//		report.append(" \nDelivery time: ");
//		report.append(DateFormat.getTimeInstance(DateFormat.LONG).format(info.getFinalDate()).toString().replace(".", ":"));
//		report.append("\n \n");
//		for (int i = 0; i < info.getQuestions().size(); i++) {
//			report.append((i+1) + ") " + info.getQuestions().get(i).toString());
//			report.append("These are the correct answers:\n");
//			for (QuestionCorrection el : NextQuestionServlet.corrections) {
//				if(el.getQuestionID().equals(info.getQuestions().get(i).getQuestionID())) {
//					report.append(el.toString());
//					break;
//				}
//			}
//			report.append("These are your answers:\n");
////			repot.append(info.getGivenReplies().get(i).toString());
//			report.append(" \n");
//		}
//		report.append("Eventually, this is your result: " + evaluation.getPoints() + " correct questions out of " + Evaluation.getTotalQuestions());
//		report.append("\n");
//		return report.toString();
//	}
}
