package com.night.learn_project;


import com.night.learn_project.Model.Shirt;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {

    // Класс, чтобы потестить ошибки на разных локалях.
    // В теории, тут может быть какая-то бизнес логика с отправкой, получение т.д. т.п. футболок.

    public void sendShirt(@Valid Shirt shirt){
        // это не логирование, а имитация бурной деятельности.
        System.out.println(shirt);
    }
}
