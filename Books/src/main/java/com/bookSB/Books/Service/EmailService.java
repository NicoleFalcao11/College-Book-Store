package com.bookSB.Books.Service;

import java.util.Optional;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bookSB.Books.Entity.Student;
import com.bookSB.Books.Repository.StudentRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final StudentRepository s;

    public EmailService(JavaMailSender javaMailSender, StudentRepository s) {
        this.javaMailSender = javaMailSender;
		this.s = s;
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


public void sendMail(String to,String subject,String body , Long sellId , String bkname , String  mail) {

    try {
    	
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setSubject(subject);
        
        String htmlContent = "<html><body>"
                + "<p>" + body + "</p>"
                + "<a href='http://localhost:3000/accepted'><button style='"
                + "background-color: #4CAF50; "
                + "border: none; "
                + "color: white; "
                + "padding: 15px 32px; "
                + "text-align: center; "
                + "text-decoration: none; "
                + "display: inline-block; "
                + "font-size: 16px; "
                + "margin: 4px 2px; "
                + "cursor: pointer; "
                + "border-radius: 12px;'>Accept</button></a>"
                + "<a href='http://localhost:8080/student/rejected/" + sellId + "/"+mail+"/"+bkname+"'><button style='"
                + "background-color: #f44336; "
                + "border: none; "
                + "color: white; "
                + "padding: 15px 32px; "
                + "text-align: center; "
                + "text-decoration: none; "
                + "display: inline-block; "
                + "font-size: 16px; "
                + "margin: 4px 2px; "
                + "cursor: pointer; "
                + "border-radius: 12px;'>Reject</button></a>"
                + "</body></html>";

        helper.setText(htmlContent, true);
        
        javaMailSender.send(message);
    } catch (MessagingException e) {
        e.printStackTrace();
        e.getMessage();
        throw new RuntimeException(e);
    }

}

public void reject(String mail,String bkname , Long seller) {

    try {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(mail);
        Optional <Student> st = s.findById(seller);
        Student stu = st.get();
       
        helper.setSubject("Book Request Rejection Notification");
        String body = "We inform you that the seller "+stu.getName()+" has rejected your request to buy the book "+bkname;
        String htmlContent = "<html><body>"
                + "<p>" + body + "</p>"
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


