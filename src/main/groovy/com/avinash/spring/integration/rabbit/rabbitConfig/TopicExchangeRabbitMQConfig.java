/**
 * Created by avinash on 6/10/20.
 */

package com.avinash.spring.integration.rabbit.rabbitConfig;

import groovy.util.logging.Slf4j;
import org.springframework.amqp.core.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TopicExchangeRabbitMQConfig {

    public static final String ADMIN_ROUTING_KEY_PREFIX = "admin.routingKey";

    public static final String ALL_ROUTING_KEY = ADMIN_ROUTING_KEY_PREFIX+".*";
    public static final String ALL_ROUTING_QUEUE = "all-queue";

    public static final String EMPLOYEE_ROUTING_KEY = ADMIN_ROUTING_KEY_PREFIX+".employee";
    public static final String EMPLOYEE_ROUTING_QUEUE = "emp-queue";

    public static final String SALES_ROUTING_KEY = ADMIN_ROUTING_KEY_PREFIX+".sales";
    public static final String SALES_ROUTING_QUEUE = "sales-queue";


    public static final String TOPIC_EXCHANGE_NAME = "topic-avinash";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Queue allQueue(){
        return new Queue(ALL_ROUTING_QUEUE, false);
    }

    @Bean
    Binding allbinding(){
        return BindingBuilder.bind(allQueue()).to(topicExchange()).with(ALL_ROUTING_KEY);
    }

    @Bean
    Queue empQueue(){
        return new Queue(EMPLOYEE_ROUTING_QUEUE, false);
    }

    @Bean
    Binding empbinding(){
        return BindingBuilder.bind(empQueue()).to(topicExchange()).with(EMPLOYEE_ROUTING_KEY);
    }

    @Bean
    Queue salesQueue(){
        return new Queue(SALES_ROUTING_QUEUE, false);
    }

    @Bean
    Binding salesbinding(){
        return BindingBuilder.bind(salesQueue()).to(topicExchange()).with(SALES_ROUTING_KEY);
    }
}
