/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author User
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class javaMail {
    private final Properties properties = new Properties();
    private Session session;
    private void init() {
        //properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.live.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");//587
        properties.put("mail.smtp.mail.sender", "supertodobaba@hotmail.com");
        //properties.put("mail.smtp.mail.sender", "supertodo.sanjuan@hotmail.com");
        properties.put("mail.smtp.password", "rizzo,2012");
        //properties.put("mail.smtp.password", "rizzoecuador2013");
        properties.put("mail.smtp.user", "supertodobaba@hotmail.com");
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }
    public void send(String destino,String asunto, String mensaje) {
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            /*message.addRecipient(Message.RecipientType.CC, new InternetAddress("vosthell@gmail.com"));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("c.kaiser.a@hotmail.com"));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("betsuka@hotmail.com"));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("jrmsupertodo@gmail.com"));
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress("karl02@hotmail.es"));*/
            
            message.setSubject(asunto);
            //TEXTO PLANO
            //message.setText(mensaje);
            //HTML
            message.setContent(mensaje,"text/html");
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            return;
        }
    }
}