package com.project.animalproject91455.repository;

import com.project.animalproject91455.interfaces.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalsRepository extends JpaRepository<Animals, Integer> {

    List<Animals> findAll();
    Animals findByName(String name);
    List<Animals> findByCategory(String category);

}

