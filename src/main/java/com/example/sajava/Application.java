package com.example.sajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example", "com.example.sajava", "com.example.sajava.controller", "com.example.sajava.model", "com.example.sajava.repository", "com.example.sajava.service"})
@EntityScan({"com.example", "com.example.sajava", "com.example.sajava.controller", "com.example.sajava.model", "com.example.sajava.repository", "com.example.sajava.service"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
