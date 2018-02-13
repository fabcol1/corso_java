package mail;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailTest {

	public static void main(String[] args) throws IOException, AddressException, MessagingException {
		
		Properties props = new Properties();
		try (InputStream in = Files.newInputStream(Paths.get("mail", "mail.properties"))) {
			props.load(in);
		}
		System.out.println(props.toString());
		
//		//OPPURE
//		Properties props = new Properties();
//		
//		props.load(MailUtility.class.getClassLoader().getResourceAsStream("mail.properties"));
////		System.out.println(props.toString());

		String from = "ILRELUCA@gmail.com";
		String to = "michele.magurno@gmail.com";
		String subject = "Prima email da java";
		String messageContent = "SPAMMMMMMMMM";
		String password = "ciao1234";
		
		Session mailSession = Session.getDefaultInstance(props);
		mailSession.setDebug(true);
	
		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
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
