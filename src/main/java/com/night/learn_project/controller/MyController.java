package com.night.learn_project.controller;

import com.night.learn_project.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService service;

    @GetMapping("app-name")
    public String getAppName() {
        return service.getAppName();
    }

}
