package com.project.animalproject91455.interfaces;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
public class Customers {

    @Id
    private Integer id;
    private String name;
    private List<Integer> animals;
    private List<Integer> actions;
    private String password;
    private String username;

    public Customers(Integer id, String name, List<Integer> animals, List<Integer> actions, String password, String username) {
        this.id = id;
        this.name = name;
        this.animals = animals;
        this.actions = actions;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Integer> animals) {
        this.animals = animals;
    }

    public List<Integer> getActions() {
        return actions;
    }

    public void setActions(List<Integer> actions) {
        this.actions = actions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
