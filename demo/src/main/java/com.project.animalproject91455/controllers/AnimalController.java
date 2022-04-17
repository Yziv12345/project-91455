package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.repository.AnimalsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalsRepository animalRepository;

    public AnimalController(AnimalsRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("")
    public List<Animals> getAll() {
        return animalRepository.findAll();
    }

    @GetMapping("/index2")
    String getTest(Model model) {
        model.addAttribute("something", "this is coming from animal controller");
        return "index1";
    }
 }
