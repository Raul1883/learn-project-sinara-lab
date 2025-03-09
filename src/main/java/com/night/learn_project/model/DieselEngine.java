package com.night.learn_project.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DieselEngine implements Engine {
    @Override
    public Map<String, String> getParams() {
        return Map.of(
                "type", "v6",
                "volume", "3.8",
                "model", "cummins"
                     );
    }

    @Override
    public boolean turnOn(String key) {
        return key.equals("key_for_engine");
    }

    @Override
    public int getRPM() {
        return 800;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Engine enable");
        // или другая логика логирования
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Engine disable");
        // или другая логика логирования
    }
}
