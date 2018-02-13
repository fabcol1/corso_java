package mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityMailTest {
	public static void main(String[] args) throws IOException, AddressException, MessagingException {
		
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate( "templates/emailTemplate.html" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "Ciao Mari, ti invio questa email da Java yuhuu XD. TI AMO");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() ); 
        
        
        Properties props = new Properties();
		try (InputStream in = Files.newInputStream(Paths.get("mail", "mail.properties"))) {
			props.load(in);
		}
		System.out.println(props.toString());

		String to = "maripasotti21@gmail.com";
		String subject = "Email da java";
		String messageContent = writer.toString();
		String password = "ciao1234";
		
		Session mailSession = Session.getDefaultInstance(props);
		mailSession.setDebug(true);
	
		MimeMessage message = new MimeMessage(mailSession);
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		// for html
		message.setContent(messageContent, "text/html; charset=utf-8");
		// for simple text
//		message.setText(messageContent);
		
		Transport tr = mailSession.getTransport();
		try {
			tr.connect(null, password);
			tr.sendMessage(message, message.getAllRecipients());
		} finally {
			tr.close();
		}
	}
}
