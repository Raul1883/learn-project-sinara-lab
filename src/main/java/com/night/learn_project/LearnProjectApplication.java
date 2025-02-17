package com.night.learn_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnProjectApplication.class, args);
    }
}
