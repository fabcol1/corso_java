package org.proxima.survey.pdfutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.proxima.survey.entities.Survey;
import org.proxima.survey.entities.SurveyQuestion;
import org.proxima.survey.entities.SurveyReply;
import org.proxima.survey.helper.SurveyEvaluator;
import org.proxima.survey.repository.SurveyJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfCreator {
	private static String userPath;
	
	@Autowired
	private SurveyJPARepository surveyRepository;
	@Autowired
	private SurveyEvaluator surveyEvaluator;
	
	/*public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<4; i++) {
			str.append("ciaoneeeee\n");
		}
		createPdf(new Long(5), str.toString(), new Date());	
		String string = DateFormat.getTimeInstance(DateFormat.LONG).format(new Date()).toString();
		System.out.println(string.replace(".", ":"));
		System.out.println(DateFormat.getTimeInstance(DateFormat.LONG).format(new Date()).toString());
	}*/
	
	private void initializePath() {
		userPath = PropertiesManager.getPropertyAsString("path.name");
	}

	public void createPdf(SurveyReply sr) {
		initializePath();
		Document document = new Document();
		try {			
			FileOutputStream fos = new FileOutputStream(userPath + sr.getPdffilename());
			
			PdfWriter pw = PdfWriter.getInstance(document, fos); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		document.open();
		com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		String informationForReport = getInformationForReport(sr);
		String[] infoLines = informationForReport.split("\n");
		
		for(String str : infoLines) {
			System.out.println(str);
			try {
				document.add(new Paragraph(str, font));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		document.close();
		
	}
	
	private String getInformationForReport(SurveyReply sr) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(sr.getStarttime());
		StringBuilder report = new StringBuilder();
		report.append("Welcome to your report user N." + sr.getUserId() + ".\n");
		report.append("This document reports your replies to our survey in date ");
		report.append(DateFormat.getDateInstance(DateFormat.MEDIUM).format(start.getTime()) + " in comparison with correct answers.\n");
		report.append("Begin time: ");
		report.append(DateFormat.getTimeInstance(DateFormat.LONG).format(start.getTime()).toString());
		report.append(" \nDelivery time: ");
		report.append(DateFormat.getTimeInstance(DateFormat.LONG).format(end.getTime()).toString());
		report.append("\n \n");
//		System.out.println(surveyRepository.toString());
		System.out.println(sr.getSurveyId());
		Optional<Survey> surveyOpt = surveyRepository.findById(sr.getSurveyId());
		Survey survey = surveyOpt.isPresent() ? surveyOpt.get() : null;
		Map<Long, List<String>> givenAnswers = surveyEvaluator.getAnswersJson(sr.getAnswers());
		int i=1;
		for (SurveyQuestion sq : survey.getSurveyquestions()) {
			report.append((i) + ") " + sq.getQuestion().toString());
			report.append("These are your answers:\n");
			givenAnswers.get(sq.getQuestion().getId()).forEach(s -> report.append(s.substring(s.length()-1) + " "));
			report.append("\n \n");
			i++;
		}
		report.append("Eventually, this is your result: " + surveyEvaluator.evaluate(sr) +
						" correct questions out of " + survey.getSurveyquestions().size());
		report.append("\n \n");
		return report.toString();
	}

}
