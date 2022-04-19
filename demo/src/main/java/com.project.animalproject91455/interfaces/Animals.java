package com.project.animalproject91455.interfaces;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animals {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private LocalDate created_at;
    private String type;
    private int status;
    private String category;
    private Integer owner_id;
    private double age;
    private double size;

    public Animals() {
        this.id = null;
        this.name = null;
        this.created_at = null;
        this.type = null;
        this.status = 0;
        this.category = null;
        this.owner_id = null;
        this.age = 0;
        this.size = 0;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwner_id() {return owner_id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Animals(Integer id, String name, LocalDate created_at, String type, int status, String category, Integer owner_id, double age, double size) {
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

}
