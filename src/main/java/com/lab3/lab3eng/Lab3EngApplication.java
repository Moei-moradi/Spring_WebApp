package com.lab3.lab3eng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab3EngApplication {
    private static final Logger log = (Logger) LoggerFactory.getILoggerFactory();

    public static void main(String[] args) {
        SpringApplication.run(Lab3EngApplication.class, args);
    }



}
