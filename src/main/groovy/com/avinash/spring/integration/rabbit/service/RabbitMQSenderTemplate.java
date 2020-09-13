/**
 * Created by avinash on 6/10/20.
 */

package com.avinash.spring.integration.rabbit.service;

import com.avinash.spring.integration.rabbit.model.Department;
import com.avinash.spring.integration.rabbit.model.Employee;
import com.avinash.spring.integration.rabbit.rabbitConfig.TopicExchangeRabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderTemplate {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.avinash-directExchange.exchange}")
    String exchange;

    @Value("${rabbitmq.avinash-directExchange.routingkey}")
    private String routingkey;

    @Value("${rabbitmq.avinash-directExchange.depart-routingkey}")
    private String routingkey_depart;

    public void sendMessage(Employee data){
        rabbitTemplate.convertAndSend(exchange, routingkey, data);
    }

    public void sendMessage(Department data){
        rabbitTemplate.convertAndSend(exchange, routingkey_depart, data);
    }


    public void sendMessageUsingTopicExchange(Employee data, String queueType){
        switch (queueType) {
            case "emp":
                rabbitTemplate.convertAndSend(TopicExchangeRabbitMQConfig.TOPIC_EXCHANGE_NAME,
                        TopicExchangeRabbitMQConfig.EMPLOYEE_ROUTING_KEY, data);
                break;
            case "sales":
                rabbitTemplate.convertAndSend(TopicExchangeRabbitMQConfig.TOPIC_EXCHANGE_NAME,
                        TopicExchangeRabbitMQConfig.SALES_ROUTING_KEY, data);
                break;
            default:
                rabbitTemplate.convertAndSend(TopicExchangeRabbitMQConfig.TOPIC_EXCHANGE_NAME,
                        TopicExchangeRabbitMQConfig.ALL_ROUTING_KEY, data);
                break;

        }
    }
}
