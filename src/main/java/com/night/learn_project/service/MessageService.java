package com.night.learn_project.service;

import com.night.learn_project.events.SpringEvent;
import com.night.learn_project.events.TransactionalEventAfter;
import com.night.learn_project.events.TransactionalEventBefore;
import com.night.learn_project.model.MessageDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final ApplicationEventPublisher publisher;

    public void SaveMessage(MessageDTO dto) {
        //Сохранение и обработка сущности, реализовывать для этой темы излишне
        publisher.publishEvent(new SpringEvent(dto.getId(), dto.getMessage()));
    }

    @Transactional
    public void SaveTransactional(MessageDTO dto) {
        publisher.publishEvent(new TransactionalEventBefore(dto.getId(), dto.getMessage()));
        publisher.publishEvent(new TransactionalEventAfter(dto.getId(), dto.getMessage()));

        // костыль исключение, чтобы эмулировать ошибку записи в бд
        throw new RuntimeException();
    }


}
