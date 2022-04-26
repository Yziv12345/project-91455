package com.project.animalproject91455.repository;

import com.project.animalproject91455.interfaces.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AnimalsRepository extends JpaRepository<Animals, Integer> {

    List<Animals> findAll();
    Animals findByName(String name);
    List<Animals> findByCategory(String category);
    List<Animals> getAnimalsByOwner(String owner);
    Long deleteByName(String name);
    Long removeByName(String name);
}

