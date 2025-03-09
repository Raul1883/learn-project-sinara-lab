package com.night.learn_project;

import com.night.learn_project.service.Road;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnProjectApplication implements CommandLineRunner {

    // DI через поле
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(LearnProjectApplication.class, args);

    }

    // Эмулируем работу чего-то типа контроллера
    @Override
    public void run(String... args) {
        Road road = context.getBean(Road.class);
        System.out.println(road.getCurrentCar());


    }

}
