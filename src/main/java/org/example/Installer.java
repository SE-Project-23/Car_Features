package org.example;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;

public class Installer {
    private String email;
    private static final Logger logger1 = Logger.getLogger(Installer.class.getName());

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Installer(String emailtoSend) {
        this.email = emailtoSend;
    }

 public void sendMessage( String email) {

        String from = "abdoaseel2002@gmail.com";
        String to = email;
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("abdoaseel2002@gmail.com", "zmtjtexsmsfqllnu");
                }
            });
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            message.setSubject("Installation Request");
            // Now set the actual message
            message.setText("A new installation request is received.");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException m) {
            
        }
    }


    public String receiveInstallationRequest(String requestDetails) {
        return  requestDetails;
    }

}





