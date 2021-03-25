package com.example.springsecuritytut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.springsecuritytut.repository")
public class SpringSecurityTutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTutApplication.class, args);
    }

}
