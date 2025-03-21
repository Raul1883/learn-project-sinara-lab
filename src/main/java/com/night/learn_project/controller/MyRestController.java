package com.night.learn_project.controller;


import com.night.learn_project.Exceptions.BadGateway502;
import com.night.learn_project.Model.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {

    @PostMapping("/post")
    public Request getRequestWithId(@RequestBody Request request) {
        long newId = getUniqueId();

        // псевдо проверка на уникальность id
        if (newId == 1) {
            // кастомное исключение
            throw new BadGateway502("Can't create new unique id for object %s"
                    .formatted(request.toString()));
        }

        request.getInfo().setId(getUniqueId());
        return request;
    }


    // Псевдо-метод для получения уникального id
    private long getUniqueId() {
        return 1L;
    }
}
