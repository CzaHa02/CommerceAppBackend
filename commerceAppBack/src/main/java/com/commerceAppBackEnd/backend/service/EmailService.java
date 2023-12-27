package com.commerceAppBackEnd.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOrderList(String recipient, String subject, String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        javaMailSender.send(mailMessage);
    }


}
