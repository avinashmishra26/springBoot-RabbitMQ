package com.avinash.spring.integration.rabbit.rabbitConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by avinash on 6/10/20.
 */
@Configuration
public class DirectExchangeRabbitMQConfig {

    @Value("${rabbitmq.avinash-directExchange.queue}")
    String queue;

    @Value("${rabbitmq.avinash-directExchange.exchange}")
    String exchange;

    @Value("${rabbitmq.avinash-directExchange.routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
