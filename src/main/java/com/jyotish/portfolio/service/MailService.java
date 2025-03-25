package com.jyotish.portfolio.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${my.email}")
    private String email;

    public void sendMail(String body){
        SimpleMailMessage mail = new SimpleMailMessage();
        try {
            mail.setTo(email);
            mail.setSubject("Hiring");
            mail.setText(body);
            javaMailSender.send(mail);
        } catch (MailException e) {
            log.error("Something went wrong");
        }
    }
}
