package com.project.animalproject91455.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class UserLogin {
    @Id

    private String password;
    private String email;

    public UserLogin(String password, String email){
        this.password = password;
        this.email = email;
    }

    public UserLogin() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
