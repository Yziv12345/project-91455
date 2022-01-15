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
    private int status;
    private String category;
    private Integer owner_id;
    private double age;
    private double size;


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
