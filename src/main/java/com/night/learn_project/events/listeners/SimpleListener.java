package com.night.learn_project.events.listeners;

import com.night.learn_project.events.SpringEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SimpleListener {

    @EventListener
    public void simpleListener(SpringEvent event) {
        log.info("new message send. id: {}. message: {}", event.getId(), event.getMessage());
    }
}
