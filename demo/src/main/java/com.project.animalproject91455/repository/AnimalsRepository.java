package com.project.animalproject91455.repository;


import com.project.animalproject91455.interfaces.Animals;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalsRepository extends MongoRepository<Animals, Integer>{


}

