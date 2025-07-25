package com.tawangit.mail.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    // metodo para ler o nome da fila do arquivo application.properties
    @Value("${broker.queue.email.name}") // o mesmo nome no arquivo application.properties
    private String queue;

    @Bean // metodo pra criar a fila
    public Queue queue() {
        return new Queue(queue, true); // true para que a fila seja persistente
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
