package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalsRepository animalRepository;

    @Autowired
    private UsersRepository usersRepository;

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

    @GetMapping("/rehomePet")
    public String getRegisterUserPage(Model model){
        model.addAttribute("animals", new Animals());
        return "animals/rehomePet";
    }

    @GetMapping("/findAll")
    public String findAllPets(Model model) {
        List<Animals> animals = animalRepository.findAll();
        model.addAttribute("pets", animals);
        return "animals/allPets";
    }

    @RequestMapping(value = "/userAllPets", method = RequestMethod.POST)
    public ModelAndView userAllPets(@ModelAttribute("users") Users users, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //errors handling
        }
        ModelAndView mav = new ModelAndView("/animals/userAllPets");
//        mav.addObject("users", new Users());
        List<Animals> allPets = animalRepository.getAnimalsByOwner(users.getName());
        mav.addObject("animals", new Animals());
        mav.addObject("pets", allPets);
        return mav;
    }

    @RequestMapping(value="/removePet", method = RequestMethod.POST)
    public ModelAndView removePetFromData(@ModelAttribute("animals") Animals animals, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //errors handling
        }
        animalRepository.removeByName(animals.getName());
        ModelAndView mav = new ModelAndView("users/loggedInUser");
        mav.addObject("users", new Users());
        return mav;
    }

    @GetMapping(value = "/searchPetByCategory")
    public String getSearchPetByCategoryPage(@RequestParam(value = "category") String category, Model model){
        var animals = animalRepository.findByCategory(category);
        model.addAttribute("pets", animals);
        return "animals/searchPetByCategory";
    }

    @RequestMapping(value = "/addAnimalToData", method = RequestMethod.POST)
    public ModelAndView addAnimalToData(@ModelAttribute("animals") Animals animal, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //errors handling
        }
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
        Animals newAnimal = new Animals(rand_1, animal.getName(), LocalDate.now(), animal.getType(), 1, animal.getCategory(), animal.getOwner(), animal.getAge(), animal.getSize(), animal.getShort_description(), animal.getLong_description(), animal.getPic_location());
        try {
            animalRepository.save(newAnimal);
        } catch (Exception e) {
            System.out.print(e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("animals/allPets");
        mav.addObject("pets", animalRepository.findAll());
        return mav;
    }

    @GetMapping(value = "/getAnimalDetails")
    public String getAnimalDetails(@RequestParam(value = "petName") String petName, Model model){
        var animal = animalRepository.findByName(petName);
        var user = usersRepository.findByName(animal.getOwner());
        model.addAttribute("pet", animal);
        model.addAttribute("user", user.get(0));
        return "animals/petProfile";
    }
}

