package utils;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.velocity.*;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class MailUtility {
	
	public static void sendMailToken(String dest, String token) throws MessagingException, IOException {
		
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate( "templates/template.token.vm" );
        VelocityContext context = new VelocityContext();
        context.put("token", token);
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
		
		Properties props = new Properties();

		props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
		// System.out.println(props.toString());

		String to = dest;
		String subject = "Richiesta di cambio password";
		String messageContent = writer.toString();
		String password = "ciao1234";

		Session mailSession = Session.getDefaultInstance(props);
		// mailSession.setDebug(true);

		MimeMessage message = new MimeMessage(mailSession);
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(messageContent, "text/html; charset=utf-8");

		Transport tr = mailSession.getTransport();
		try {
			tr.connect(null, password);
			tr.sendMessage(message, message.getAllRecipients());
		} finally {
			tr.close();
		}
	}
	
public static void sendMailPassword(String dest, String newPassword) throws MessagingException, IOException {
		
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate( "templates/template.password.vm" );
        VelocityContext context = new VelocityContext();
        context.put("newPassword", newPassword);
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
		
		Properties props = new Properties();

		props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
		// System.out.println(props.toString());

		String to = dest;
		String subject = "Nuova password";
		String messageContent = writer.toString();
		String password = "ciao1234";

		Session mailSession = Session.getDefaultInstance(props);
		// mailSession.setDebug(true);

		MimeMessage message = new MimeMessage(mailSession);
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(messageContent, "text/html; charset=utf-8");

		Transport tr = mailSession.getTransport();
		try {
			tr.connect(null, password);
			tr.sendMessage(message, message.getAllRecipients());
		} finally {
			tr.close();
		}
	}
	
	public static void sendMail(String dest, String newPass) throws MessagingException, IOException {
		Properties props = new Properties();

		props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
		// System.out.println(props.toString());

		String to = dest;

		String subject = "Nuova password";
		String messageContent = "Eccoti la tua nuova password: " + newPass;

		String password = "ciao1234";

		Session mailSession = Session.getDefaultInstance(props);
		// mailSession.setDebug(true);

		MimeMessage message = new MimeMessage(mailSession);
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(messageContent);

		Transport tr = mailSession.getTransport();
		try {
			tr.connect(null, password);
			tr.sendMessage(message, message.getAllRecipients());
		} finally {
			tr.close();
		}
	}
}