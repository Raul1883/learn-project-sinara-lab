package com.night.learn_project.model;

import java.util.Map;

// интерфейс для всех двигателей
public interface Engine {

    Map<String, String> getParams();

    boolean turnOn(String key);

    int getRPM();
}
