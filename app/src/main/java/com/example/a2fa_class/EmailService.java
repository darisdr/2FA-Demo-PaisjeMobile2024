package com.example.a2fa_class;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {
    public static void sendEmail(String recipient, String subject, String body) {
        new Thread(() -> {
            try {
                System.out.println("thread created");
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("darisdragusha@gmail.com", "dhfu xqda axlj yolw");
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("darisdragusha@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                message.setSubject(subject);
                message.setText(body);

                Transport.send(message);
                System.out.println("message sent");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
