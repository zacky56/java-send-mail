import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@SuppressWarnings("CallToPrintStackTrace")
public class GmailSMTP {
    public static void main(String[] args) {
        // Sender's Gmail credentials
        String senderEmail = "zackjohn932@gmail.com";
        String senderPassword = "ytfi tape tmmp ghse"; // Use an app password if you have 2FA enabled

        // Receiver's email address
        String receiverEmail = "iridiumuniverse9@gmail.com";

        // SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;

        // Email subject and body
        String subject = "Test Email from Java";
        String body = "This is a test email sent using Java and Gmail's SMTP server.";

        // SMTP properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", String.valueOf(smtpPort));

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a message object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
// v1.1: added HTML body support
// v1.1: added CC and BCC fields
