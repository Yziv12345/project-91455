package com.project.animalproject91455.interfaces;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Actions {

    @Id
    private Integer id;
    private String type;
    private String name;
    private Integer animal_id;
    private Integer user_id;
    private LocalDate timestamp;
    private String description;
    private String status;

    public Actions(Integer id, String type, String name, Integer animal_id, Integer user_id, LocalDate timestamp, String description, String status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.animal_id = animal_id;
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }
}
