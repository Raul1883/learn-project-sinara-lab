package com.night.learn_project.service;


import com.night.learn_project.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Road {

    private Car car;

    // DI через сеттер
    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }


    public Car getCurrentCar() {
        return car;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Road enable");
        // или другая логика логирования
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Road disable");
        // или другая логика логирования
    }
}
