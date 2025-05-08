package com.night.learn_project.events.listeners;

import com.night.learn_project.events.SpringEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AsyncListener {

    @Async
    @EventListener
    public void listenMessageAsync(SpringEvent event){
        log.info("Async handle message. id: {}. message: {}", event.getId(), event.getMessage());
    }
}
