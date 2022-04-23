package com.project.animalproject91455.interfaces;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class Users {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;
    @Column(name="animals", nullable = false)
    private String animals_ids;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="user_name", nullable = false)
    private String userName;

    public Users(Integer id, String name, String animals, String password, String username) {
        this.id = id;
        this.name = name;
        this.animals_ids = animals;
        this.password = password;
        this.userName = username;
    }

    public Users() {

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

    public String getAnimals_ids() {
        return animals_ids;
    }

    public void setAnimals_ids(String animals) {
        this.animals_ids = animals;
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
