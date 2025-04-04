package com.night.learn_project.Controller;


import com.night.learn_project.Model.ToDoList;
import com.night.learn_project.Service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;

    @PostMapping("/createToDoList")
    public ResponseEntity<ToDoList> createToDoList(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoListService.createToDoList(toDoList));
    }

    @GetMapping("/toDoLists")
    public ResponseEntity<List<ToDoList>> getAllLists() {
        return ResponseEntity.ok(toDoListService.getAllList());
    }

    @GetMapping("/ToDoList/{name}")
    public ResponseEntity<ToDoList> getList(@PathVariable String name) {
            return ResponseEntity.ok(toDoListService.getToDoList(name));
    }
}
