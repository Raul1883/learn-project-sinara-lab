package com.night.learn_project.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason="can't create id")
public class BadGateway502 extends RuntimeException {
    public BadGateway502(String message) {
        super(message);
    }
}
