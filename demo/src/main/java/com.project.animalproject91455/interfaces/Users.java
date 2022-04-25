package com.project.animalproject91455.interfaces;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Setter
@Getter
@Entity
@Table(name = "users")
public class Users {
    @Id
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
    @Column(name="email", nullable = false)
    private String userEmail;
    @Column(name="phone_number", nullable = false)
    private String userPhoneNumber;

    public Users() {}

    public Users(Integer id, String name, String animals, String password, String username, String userEmail, String userPhoneNumber) {
        this.id = id;
        this.name = name;
        this.animals_ids = animals;
        this.password = password;
        this.userName = username;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
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
        return this.animals_ids;
    }

    public void setAnimals_ids(String animals) {
        this.animals_ids = animals;}

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

}
