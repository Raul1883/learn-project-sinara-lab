package com.night.learn_project.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionalEventAfter {
    private Long id;
    private String message;
}
