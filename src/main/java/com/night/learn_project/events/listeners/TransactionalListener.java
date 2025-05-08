package com.night.learn_project.events.listeners;


import com.night.learn_project.events.TransactionalEventAfter;
import com.night.learn_project.events.TransactionalEventBefore;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Log4j2
public class TransactionalListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void beforeCommit(TransactionalEventBefore event){
        log.info("new transaction failed. id: {}. message: {}", event.getId(), event.getMessage());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(TransactionalEventAfter event){
        log.info("new transaction completed. id: {}. message: {}", event.getId(), event.getMessage());

    }
}
