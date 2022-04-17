package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/animals")
public class AnimalController {


    private AnimalsRepository animalRepository;
    private UsersRepository usersRepository;


    public AnimalController(AnimalsRepository animalRepository, UsersRepository usersRepository) {
        this.animalRepository = animalRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping("")
    public List<Animals> getAll() {
        return animalRepository.findAll();
    }

    @PostMapping("/register")
    public Animals registerAnimal(@RequestParam String name, @RequestParam String type, @RequestParam String category, @RequestParam Integer user_id, @RequestParam Integer age, @RequestParam Integer size) {
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
        Animals newAnimal = new Animals(rand_1, name, LocalDate.now(), type, 0, category, user_id, age, size);
        try {
            return animalRepository.save(newAnimal);
        } catch (Exception e) {
            System.out.print(e);
        }
        return newAnimal;
    }

    @GetMapping("/get")
    public Animals getAnimal(@RequestParam String name) {
        Animals animal = null;
        try {
            animal = animalRepository.findAll(name);
        } catch (Exception e) {
            System.out.print(e);
        }
        return animal;
    }

    @GetMapping("/getByCategory")
    public Animals getAnimalByCategory(@RequestParam String category) {
        Animals animal = null;
        try {
            animal = animalRepository.findAll(category);
        } catch (Exception e) {
            System.out.print(e);
        }
        return animal;
    }

    @GetMapping("/getAnimalDetails")
    public Users getAnimalDetails(@RequestParam String name) {
        Animals animal = null;
        Users user = null;
        try {
            animal = animalRepository.findAll(name);
            user = usersRepository.findAll(animal.getOwner_id());

        } catch (Exception e) {
            System.out.print(e);
        }

        return user;
    }


}
