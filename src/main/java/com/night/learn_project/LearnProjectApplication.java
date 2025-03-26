package com.night.learn_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnProjectApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LearnProjectApplication.class, args);

        // Раскомментировать если хочется посмотреть на ошибку валидации
        // LocaleContextHolder.setLocale(new Locale("en", "RU"));
        // MyService service = context.getBean(MyService.class);
        // service.sendShirt(new Shirt("", "", ""));
    }
}
