/**
 * Created by avinash on 6/10/20.
 */

package com.avinash.spring.integration.rabbit.service;

import com.avinash.spring.integration.rabbit.model.Department;
import com.avinash.spring.integration.rabbit.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerListener {

    @RabbitListener(queues = "${rabbitmq.avinash-directExchange.queue}")
    public void rabbitMessageReceiver(Employee employee){
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }

    @RabbitListener(queues = "${rabbitmq.avinash-directExchange.depart-queue}")
    public void rabbitMessageReceiverDepart(Department employee){
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }

    @RabbitListener(queues = "#{empQueue.name}")
    public void rabbitMessageReceiverEmployee(Employee employee) throws InterruptedException {
        System.out.println("Recieved Message From RabbitMQ: in EMPLOYEE " + employee);
    }

    @RabbitListener(queues = "#{allQueue.name}")
    public void rabbitMessageReceiverALL(Employee employee){
        System.out.println("Recieved Message From RabbitMQ: in ALL " + employee);
    }


    @RabbitListener(queues = "#{salesQueue.name}")
    public void rabbitMessageReceiverSales(Employee employee){
        System.out.println("Recieved Message From RabbitMQ: in SALES " + employee);
    }

}
