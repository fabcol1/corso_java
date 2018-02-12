package utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtility
{
  public static void sendMail (String dest, String newPass)
      throws MessagingException, IOException
  {
		Properties props = new Properties();
		
		props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
//		System.out.println(props.toString());

		String to = dest;
		
		String subject = "Nuova password";
		String messageContent = "Eccoti la tua nuova password: " + newPass;
		
		String password = "ciao1234";
		
		Session mailSession = Session.getDefaultInstance(props);
//		mailSession.setDebug(true);
	
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