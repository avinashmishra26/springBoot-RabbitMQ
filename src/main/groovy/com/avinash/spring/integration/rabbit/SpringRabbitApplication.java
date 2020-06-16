/**
 * Created by avinash on 6/10/20.
 */


package com.avinash.spring.integration.rabbit;

import groovy.util.logging.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
public class SpringRabbitApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitApplication.class, args);

    }
}
