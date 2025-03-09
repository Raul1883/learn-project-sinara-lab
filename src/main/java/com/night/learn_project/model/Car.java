package com.night.learn_project.model;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor // Тут сгенерированный ломбоком конструктор, через который и внедряется зависимость
public class Car {
    // поля берутся из application.properties
    @Value("${car.brand}")
    private String brand;

    @Value("${car.model}")
    private String model;

    @Value("${car.horsePower}")
    private int horsePower;

    @Value("${car.year}")
    private String year;

    private final Engine engine;

    @PostConstruct
    private void postConstruct() {
        System.out.println("Car enable");
        // или другая логика логирования
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Car disable");
        // или другая логика логирования
    }
}
