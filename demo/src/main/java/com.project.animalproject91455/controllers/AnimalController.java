package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.repository.AnimalsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnimalController {

    private AnimalsRepository animalRepository;

    public AnimalController(AnimalsRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @RequestMapping("/animals")
    public String getAll(Model model) {
        model.addAttribute("pets",animalRepository.findAll() );
        return "animals/allPets";
    }
}

