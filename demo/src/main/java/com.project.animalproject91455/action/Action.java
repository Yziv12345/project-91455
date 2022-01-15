package com.project.animalproject91455.action;

import java.time.LocalDate;

public class Action {

    private Integer id;
    private String type;
    private String name;
    private Integer animal_id;
    private Integer user_id;
    private LocalDate timestamp;
    private String description;
    private String status;

    public Action(Integer id, String type, String name, Integer animal_id, Integer user_id, LocalDate timestamp, String description, String status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.animal_id = animal_id;
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(Integer animal_id) {
        this.animal_id = animal_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
