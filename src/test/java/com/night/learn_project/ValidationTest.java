package com.night.learn_project;


import com.night.learn_project.Model.Shirt;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ValidationTest {


    @Autowired
    private LocalValidatorFactoryBean validator;

    // Проверка на очень кривую футболку
    // "Ручная" валидация
    @Test
    void testInvalidShirt() {
        // Все параметры неверные
        Shirt invalidShirt = new Shirt("", "", "xcv");
        Set<ConstraintViolation<Shirt>> violations = validator.validate(invalidShirt);

        // Ожидаем, что все параметры (3 штуки) будут невалидны
        assertEquals(3, violations.size());
    }

    // Проверка на корректную футболку
    @Test
    void testValidShirt() {
        Shirt invalidShirt = new Shirt("Red", "Nike", "M");
        Set<ConstraintViolation<Shirt>> violations = validator.validate(invalidShirt);

        // Ожидаем 0 ошибок
        assertEquals(0, violations.size());
    }
}
