package com.project.animalproject91455.interfaces;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@Setter
@Getter
@Entity
@Table(name = "animals")
public class Animals {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "created_at", nullable = false)
    private LocalDate created_at;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "status", nullable = false)
    private int status;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "owner_id", nullable = false)
    private Integer owner_id;
    @Column(name = "age", nullable = false)
    private double age;
    @Column(name = "size", nullable = false)
    private double size;
    @Column(name = "short_description", nullable = false)
    private String short_description;
    @Column(name = "long_description", nullable = false)
    private String long_description;

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
        this.short_description = null;
        this.long_description = null;
    }

    public Animals(Integer id, String name, LocalDate created_at, String type, int status, String category, Integer owner_id, double age, double size, String short_description, String long_description) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.type = type;
        this.status = status;
        this.category = category;
        this.owner_id = owner_id;
        this.age = age;
        this.size = size;
        this.short_description = short_description;
        this.long_description = long_description;
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
    public int getStatus() {
        return status;
    }
    public String getCategory() {
        return category;
    }
    public double getAge() {
        return age;
    }
    public double getSize() {
        return size;
    }
    public Integer getId() {
        return id;
    }
    public Integer getOwner_id() {return owner_id;}

    public void setId(Integer id) {
        this.id = id;
    }
    public String getShort_description() {
        return short_description;
    }
    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
    public String getLong_description() {
        return long_description;
    }
    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }
}
