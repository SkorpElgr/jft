package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.WebDriver;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class EmailHelper{
    private Properties smtp = new Properties();
    private String message = "test message";
    private String subject = "test message";

    public static void main(String[] args) throws IOException, MessagingException {
        EmailHelper h = new EmailHelper();
     //   h.sendEmail();
        h.readEmail();
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
    private void readEmail() throws IOException, MessagingException {


        try {
            String target = System.getProperty("target", "smtp");
            smtp.load(new FileReader(new File(String.format("web-tests/src/test/resources/%s.properties", target))));
            Session session = Session.getDefaultInstance(smtp, null);

            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "*************@gmail.com", "your_password");

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();

            System.out.println("Total Messages:- " + messageCount);

            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");

            for (int i = 0; i < 10; i++) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
            }

            inbox.close(true);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
