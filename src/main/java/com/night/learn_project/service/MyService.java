package com.night.learn_project.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Service
public class MyService {
    @Value("${spring.application.name}")
    private String appName;
}
