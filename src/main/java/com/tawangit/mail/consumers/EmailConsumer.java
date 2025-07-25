package com.tawangit.mail.consumers;

import com.tawangit.mail.dtos.EmailRecordDto;
import com.tawangit.mail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }
    @RabbitListener(queues = "${broker.queue.email.name}") // o mesmo nome no arquivo application.properties
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
       try {
           emailService.sendInviteEmail(emailRecordDto);
           System.out.println("Email enviado para: " + emailRecordDto.email());
       } catch (Exception e) {
              System.err.println("Erro ao enviar email: " + emailRecordDto.email());
       }
    }
}
