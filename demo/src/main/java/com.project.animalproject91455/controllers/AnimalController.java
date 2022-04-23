package com.project.animalproject91455.controllers;

import com.project.animalproject91455.animal.Animal;
import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import com.project.animalproject91455.services.IAnimalService;
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
    private IAnimalService animalService;

    @Autowired
    private AnimalsRepository animalRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/findAll")
    public String findAllPets(Model model) {

        List<Animals> animals = animalService.findAll();

        model.addAttribute("pets", animals);

    return "animals/allPets";

    }

    public AnimalController(AnimalsRepository animalRepository, UsersRepository usersRepository) {
        this.animalRepository = animalRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/petProfile")
    public String getRandomPetProfile() {
        return "animals/petProfile";
    }

    @GetMapping("/searchPet")
    public String getSearchPetPage(){
        return "animals/searchPet";
    }

    @GetMapping(value = "/searchPetByCategory")
    public String getSearchPetByCategoryPage(@RequestParam(value = "category") String category, Model model){
        var animals = animalRepository.findByCategory(category);
        model.addAttribute("pets", animals);
        return "animals/searchPetByCategory";
    }

    @GetMapping("")
    public List<Animals> getAll() {
        List<Animals> res = animalRepository.findAll();
        return res;
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

//    @GetMapping("/getByCategory")
//    public Animals getAnimalByCategory(@RequestParam String category) {
//        Animals animal = null;
//        try {
//            animal = animalRepository.findByCategory(category);
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//        return animal;
//    }

    @GetMapping(value = "/getAnimalDetails")
    public String getAnimalDetails(@RequestParam(value = "petName") String petName, Model model){
        System.out.println("petName is: "+petName);
        var animal = animalRepository.findByName(petName);
        var user = usersRepository.findById(animal.getOwner_id());
        model.addAttribute("pet", animal);
        model.addAttribute("user", user);
        return "animals/petProfile";
    }
//    @GetMapping("/getAnimalDetails")
//    public Optional<Users> getAnimalDetails(@RequestParam String name) {
//        Animals animal = null;
//        Optional<Users> user = null;
//        try {
//            animal = animalRepository.findByName(name);
//            user = usersRepository.findById(animal.getOwner_id());
//
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//        return user;
//    }
}

