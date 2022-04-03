package com.project.animalproject91455.interfaces;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="animals")
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> animals;
    @Column(name="actions")
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> actions;
    @Column(name="password")
    private String password;
    @Column(name="user_name")
    private String userName;

    public Users() {

    }

    public Users(Integer id, String name, List<Integer> animals, List<Integer> actions, String password, String username) {
        this.id = id;
        this.name = name;
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
}
