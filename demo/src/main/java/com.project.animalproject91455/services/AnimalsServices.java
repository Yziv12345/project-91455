package com.project.animalproject91455.services;


import com.project.animalproject91455.animal.Animal;
import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsServices implements IAnimalService {

    @Autowired
    private AnimalsRepository repository;
    @Override
    public List<Animals> findAll(){
        var animals = (List<Animals>) repository.findAll();
        return animals;
    }

    public Animals findByCategory(String category){
        var animals =  repository.findByCategory(category);
        return animals;
    }

    public List<Animals> findByName(String name){
        var animals = (List<Animals>) repository.findByName(name);
        return animals;
    }

}
