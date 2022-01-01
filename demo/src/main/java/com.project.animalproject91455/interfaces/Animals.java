package com.project.animalproject91455.interfaces;


import com.project.animalproject91455.interfaces.StatusType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Animals {

    @Id
    private Integer id;
    private String name;
    private LocalDate created_at;
    private String type;
    private StatusType status= new StatusType(false);
    private String category;
    private Integer owner_id;
    private double age;
    private double size;


    public Animals(Integer id) {
        this.id = id;
    }

    public Animals(Integer id, String name, LocalDate created_at, String type, StatusType status, String category, Integer owner_id, double age, double size) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.type = type;
        this.status = status;
        this.category = category;
        this.owner_id = owner_id;
        this.age = age;
        this.size = size;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public String getType() {
        return type;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public double getAge() {
        return age;
    }

    public double getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSize(double size) {
        this.size = size;
    }

}
