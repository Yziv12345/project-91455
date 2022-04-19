package com.project.animalproject91455.customer;

import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Integer> animals;
    private List<Integer> actions;
    private String password;
    private String userName;


    public User(Integer id, String name, String email, String phoneNumber, List<Integer> animals, List<Integer> actions, String password, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.animals = animals;
        this.actions = actions;
        this.password = password;
        this.userName = username;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Override
    public String toString(){
        return "User [name=" + name + ", userName=" +userName +"]";
    }
}
