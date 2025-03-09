package com.night.learn_project.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Primary // Эта аннотация используется для решения конфликта двух классов,
// реализующих один интерфейс. Этот класс приоритетный при создании.
public class PetrolEngine implements Engine {
    @Override
    public Map<String, String> getParams() {
        return Map.of(
                "type", "v8",
                "volume", "6.2",
                "model", "magnum"
                     );
    }

    @Override
    public boolean turnOn(String key) {
        if (key.equals("key_for_engine")) {
            return true;
        }
        return false;
    }

    @Override
    public int getRPM() {
        return 1000;
    }
}
