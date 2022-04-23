package com.project.animalproject91455.services;

import com.project.animalproject91455.interfaces.Animals;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAnimalService {
    List<Animals> findAll();
    Animals findByCategory(String category);
    List<Animals> findByName(String name);
}
