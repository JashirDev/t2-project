package com.example.correspondence.mailing;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MyMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to,String subject,String text){


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ashuragoose@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

    }
}
