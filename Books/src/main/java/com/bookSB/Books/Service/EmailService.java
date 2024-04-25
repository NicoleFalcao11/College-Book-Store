package com.bookSB.Books.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to,String subject,String body) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            e.getMessage();
            throw new RuntimeException(e);
        }

    }


public void sendMail(String to,String subject,String body) {

    try {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setSubject(subject);
        
        //helper.setText(body,true);
        String htmlContent = "<html><body>"
                + "<p>"+body+"</p>"
                + "<a href='http://localhost:3000/accepted'><button>Accept</button></a>"
                + "<a href='http://localhost:3000/rejected'><button>Reject</button></a>"
                + "</body></html>";

        helper.setText(htmlContent, true);
        
        javaMailSender.send(message);
    } catch (MessagingException e) {
        e.printStackTrace();
        e.getMessage();
        throw new RuntimeException(e);
    }

}

}


