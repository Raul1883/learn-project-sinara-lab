package com.night.learn_project.Service;

import com.night.learn_project.Model.Event;
import com.night.learn_project.Model.ToDoList;
import com.night.learn_project.Repositories.ToDoListRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;


    public ToDoList createToDoList(ToDoList toDoList) {

        for (Event event : toDoList.getEvents()) {
            event.setToDoList(toDoList);
        }

        toDoListRepository.save(toDoList);
        return toDoList;
    }

    public ToDoList getToDoList(String name) {
        return toDoListRepository.findByName(name)
                                 .orElseThrow(() -> new EntityNotFoundException("List does not exist"));
    }

    public List<ToDoList> getAllList() {
        return toDoListRepository.findAll();
    }
}
