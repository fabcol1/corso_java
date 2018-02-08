package utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailUtility
{
  public static void sendMail (String dest, String mitt, String oggetto, String testoEmail)
      throws MessagingException
  {
    // Creazione di una mail session
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.mioprovider.it");
    Session session = Session.getDefaultInstance(props);

    // Creazione del messaggio da inviare
    MimeMessage message = new MimeMessage(session);
    message.setSubject(oggetto);
    message.setText(testoEmail);
    // Alternativa di invio messaggio con codice HTML
    //message.setContent("<h2>Questo è il corpo del messaggio HTML</h2>", "text/html");

    // Aggiunta degli indirizzi del mittente e del destinatario
    InternetAddress fromAddress = new InternetAddress(mitt);
    InternetAddress toAddress = new InternetAddress(dest);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);
  }
}