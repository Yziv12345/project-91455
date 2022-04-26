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
    @Column(name = "owner")
    private String owner;
    @Column(name = "age", nullable = false)
    private double age;
    @Column(name = "size", nullable = false)
    private double size;
    @Column(name = "short_description", nullable = false)
    private String short_description;
    @Column(name = "long_description", nullable = false)
    private String long_description;
    @Column(name = "pic_location", nullable = false)
    private String pic_location;



    public Animals() {
        this.id = null;
        this.name = null;
        this.created_at = null;
        this.type = null;
        this.status = 0;
        this.category = null;
        this.owner = null;
        this.age = 0;
        this.size = 0;
        this.short_description = null;
        this.long_description = null;
    }

    public Animals(Integer id, String name, LocalDate created_at, String type, int status, String category, String owner, double age, double size, String short_description, String long_description, String pic_location) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.type = type;
        this.status = status;
        this.category = category;
        this.owner = owner;
        this.age = age;
        this.size = size;
        this.short_description = short_description;
        this.long_description = long_description;
        this.pic_location = pic_location;
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
    public String getOwner() {return owner;}
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
    public String getPic_location() {
        return pic_location;
    }
    public void setPic_location(String pic_location) {
        this.pic_location = pic_location;
    }
}
