/**
 * Created by avinash on 6/10/20.
 */

package com.avinash.spring.integration.rabbit.web;


import com.avinash.spring.integration.rabbit.model.Employee;
import com.avinash.spring.integration.rabbit.service.RabbitMQSenderTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitProducerController {

    @Autowired
    RabbitMQSenderTemplate rabbitMQSenderTemplate;

    @RequestMapping(value = "/produce", method = RequestMethod.POST)
    public ResponseEntity producerMessage(@RequestBody Employee employee) {
        rabbitMQSenderTemplate.sendMessage(employee);
        return new ResponseEntity("Message Sent", HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/produce/topicEx/{type}", method = RequestMethod.POST)
    public ResponseEntity producerMessageTopicExchange(@RequestBody Employee employee,
                                                       @PathVariable String type) {
        rabbitMQSenderTemplate.sendMessageUsingTopicExchange(employee, type);
        return new ResponseEntity("Message Sent", HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/produce/topicEx/{type}/{noOfMessages}", method = RequestMethod.POST)
    public ResponseEntity producerMultipleMessageTopicExchange(@RequestBody Employee employee,
                                                       @PathVariable String type,
                                                       @PathVariable int noOfMessages) {

        for(int noOfMessage=1; noOfMessage <= noOfMessages; noOfMessage++){
            employee.setEmp_id((long)noOfMessage);
            rabbitMQSenderTemplate.sendMessageUsingTopicExchange(employee, type);
        }
        return new ResponseEntity("Message Sent", HttpStatus.ACCEPTED);
    }
}
