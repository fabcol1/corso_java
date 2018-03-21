package org.proxima.util;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.log4j.Logger;
import org.apache.velocity.*;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * 
 * @author DaniG
 * @version 1.0
 * 
 *          La classe MailUtility fornisce un metodo statico per inviare una
 *          email ad un utente specificando: email dell'utente, oggetto e corpo
 *          della email
 * 
 *          Esempio di utilizzo: Boolean isSent =
 *          MailUtility.sendSimpleMail("utente123@gmail.com", "oggetto", "<p>Ciao Utente123 come stai?</p>");
 * 
 */

public class MailUtility {

	/**
	 * 
	 * Questo metodo permette di inviare una email specificando destinatario,
	 * oggetto e messaggio.
	 * 
	 * @param dest
	 *            Email del destinatario
	 * @param subject
	 *            Oggetto della email
	 * @param mess
	 *            Testo della email
	 * @return boolean Il metodo ritorna false solo se viene sollevata un'eccezione
	 * 
	 * 
	 */

	static Logger logger = Logger.getLogger(MailUtility.class);

	public static boolean sendSimpleMail(String dest, String subject, String mess) {
		boolean isSent = true;
		try {
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();
			Template t = ve.getTemplate("templates/template.default.vm");
			VelocityContext context = new VelocityContext();
			context.put("message", mess);
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			Properties props = new Properties();
			try {
				props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
			} catch (IOException e) {
				isSent = false;
				e.printStackTrace();
				logger.fatal("Errore caricamente file mail.properties");
			}
			String password = props.getProperty("mail.smtps.password");
			String messageContent = writer.toString();
			Session mailSession = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(mailSession);
			message.addRecipient(RecipientType.TO, new InternetAddress(dest));
			message.setSubject(subject);
			message.setContent(messageContent, "text/html; charset=utf-8");
			Transport tr = mailSession.getTransport();
			tr.connect(null, password);
			tr.sendMessage(message, message.getAllRecipients());
			tr.close();
			logger.debug("Email inviata correttamente");
		} catch (MessagingException e) {
			isSent = false;
			e.printStackTrace();
			logger.fatal("Errore in fase di invio email");
		}
		return isSent;
	}

}