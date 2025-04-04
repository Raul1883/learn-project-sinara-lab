package com.night.learn_project.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventText;

    // Здесь может быть много дополнительных полей, например дата, время, место и пр.

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    @JsonBackReference
    private ToDoList toDoList;

    public Event(String text) {
        this.eventText = text;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventText='" + eventText + '\'' +
                ", id=" + id +
                '}';
    }
}
