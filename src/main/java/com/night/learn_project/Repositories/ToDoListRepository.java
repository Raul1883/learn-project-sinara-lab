package com.night.learn_project.Repositories;

import com.night.learn_project.Model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    Optional<ToDoList> findByName(String name);
}
