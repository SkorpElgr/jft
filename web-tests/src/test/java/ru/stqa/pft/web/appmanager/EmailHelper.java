package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.WebDriver;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailHelper{
    private Properties smtp = new Properties();
    private String message = "test message";
    private String subject = "test message";

    public static void main(String[] args) throws IOException, MessagingException {
        EmailHelper h = new EmailHelper();
        h.sendEmail();
    }

    private void sendEmail() throws IOException, MessagingException {
        try {
            String target = System.getProperty("target", "smtp");
            File parent = new File("");
            smtp.load(new FileReader(new File(String.format("web-tests/src/test/resources/%s.properties", target))));
//        String SMTP_USER = smtp.getProperty("SMTP_USER");
//        String SMTP_PASS = smtp.getProperty("SMTP_PASS");
        String SMTP_USER = "asiaticegle@gmail.com";
        String SMTP_PASS = "asiatic007";

        smtp.put("mail.transport.protocol", "smtps");
        smtp.put("mail.smtps.host", SMTP_USER);
        smtp.put("mail.smtps.auth", SMTP_PASS);


        Session session = Session.getDefaultInstance(smtp);
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, SMTP_USER, SMTP_PASS);

        MimeMessage message = new MimeMessage(session);
        message.setSubject("test Subject");
        message.setText("test Text");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("paul.skorodzievskiy@gmail.com"));
        message.setSentDate(new Date());

        transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
