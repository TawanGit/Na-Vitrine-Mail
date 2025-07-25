package com.tawangit.mail.services;

import com.tawangit.mail.dtos.EmailRecordDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendInviteEmail(EmailRecordDto emailRecordDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRecordDto.email());
        message.setSubject(emailRecordDto.subject());
        message.setText(emailRecordDto.text());
        javaMailSender.send(message);
    }
}
