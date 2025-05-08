package com.night.learn_project.controller;


import com.night.learn_project.model.MessageDTO;
import com.night.learn_project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyRestController {

    private final MessageService service;

    @PostMapping("/simple-message")
    @ResponseStatus(HttpStatus.OK)
    public void createSimpleMessage(@RequestBody MessageDTO dto) {
        service.SaveMessage(dto);
    }

    @PostMapping("/transactional-message")
    @ResponseStatus(HttpStatus.OK)
    public void createTransactionalMessage(@RequestBody MessageDTO dto) {
        service.SaveTransactional(dto);
    }


}
