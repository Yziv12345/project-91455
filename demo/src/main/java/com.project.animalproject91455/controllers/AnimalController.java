package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalsRepository animalRepository;

    @Autowired
    UsersRepository usersRepository;


    public AnimalController(AnimalsRepository animalRepository, UsersRepository usersRepository) {
        this.animalRepository = animalRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/allPets")
    public List<Animals> getAll() {
        List<Animals> animalsList = animalRepository.findAll();
        System.out.println("animalsList"+animalsList);
        System.out.println("animalRepository.findAll()"+animalRepository.findAll());
        return animalRepository.findAll();
    }

    @GetMapping("/searchPetByCategory/{category}")
    public String searchPetByCategory(@PathVariable String category){
//        List<Animals> animalsList = (List<Animals>) animalRepository.findByCategory(category);
//        System.out.println("animalsList "+animalsList);
        System.out.println("animalRepository.findByCategory(category) "+animalRepository.findByCategory(category));
        animalRepository.findByCategory(category);
        return "animals/searchPetByCategory";
    }

//    @GetMappingetMapping("/animals")
//    public String getAll(Model model){
//        model.addAttribute("pets", animalRepository.findAll());
//        System.out.println("animalRepository.findAll(): " + animalRepository.findAll());
//        return "animals/allPets";
//    }

    @GetMapping("/animals/searchPet")
    public String searchPet(){
        return "animals/searchPet";
    }

    @GetMapping("/animals/rehome")
    public String rehomePetPage(){
        return "animals/rehome";
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

//    @GetMapping("/animals")
//    public Animals getAnimal(@RequestParam String name) {
//        Animals animal = null;
//        try {
//            animal = animalRepository.findByName(name);
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//        return animal;
//    }

    @GetMapping("/getByCategory")
    public Animals getAnimalByCategory(@RequestParam String category) {
        Animals animal = null;
        try {
            animal = animalRepository.findByCategory(category);
        } catch (Exception e) {
            System.out.print(e);
        }
        return animal;
    }

    @GetMapping("/index2")
    String getTest(Model model) {
        model.addAttribute("something", "this is coming from animal controller");
        return "index1";
    }

    @GetMapping("/getAnimalDetails")
    public Optional<Users> getAnimalDetails(@RequestParam String name) {
        Animals animal = null;
        Optional<Users> user = null;
        try {
            animal = animalRepository.findByName(name);
            user = usersRepository.findById(animal.getOwner_id());

        } catch (Exception e) {
            System.out.print(e);
        }
        return user;
    }
}

