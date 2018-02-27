package org.proxima.survey.pdfutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {
	private static String userPath;
	
	
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
	
	private static void initializePath() {
		userPath = PropertiesManager.getPropertyAsString("path.name");
		
	}

	public static void createPdf(Long userID, String informationForReport, Date beginDate) {
		initializePath();
		Document document = new Document();
		try {			
			PdfWriter.getInstance(document, new FileOutputStream(   userPath
																	+userID.toString()+ "_" +
																	DateFormat.getDateInstance(DateFormat.MEDIUM).format(beginDate).toString()
																	+".pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
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


}
