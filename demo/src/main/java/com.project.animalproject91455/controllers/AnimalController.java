package com.project.animalproject91455.controllers;

import com.project.animalproject91455.interfaces.Animals;
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
    @GetMapping("/index")
    public List<Animals> getAll() {
        List<Animals> res = animalRepository.findAll();
        return res;
    }

    @GetMapping("/petProfile")
    public String getRandomPetProfile() {
        return "animals/petProfile";
    }

    @GetMapping("/searchPet")
    public String getSearchPetPage(){
        return "animals/searchPet";
    }

    @GetMapping("/findAll")
    public String findAllPets(Model model) {
        List<Animals> animals = animalRepository.findAll();
        model.addAttribute("pets", animals);
        return "animals/allPets";
    }

    @GetMapping("/rehomePet")
    public String getRegisterUserPage(Model model){
        model.addAttribute("animals", new Animals());
        return "animals/rehomePet";
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
        Animals newAnimal = new Animals(rand_1, animal.getName(), LocalDate.now(), animal.getType(), 0, animal.getCategory(), 2, animal.getAge(), animal.getSize());
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
        var animal = animalRepository.findByName(petName);
        var user = usersRepository.findById(animal.getOwner_id());
        model.addAttribute("pet", animal);
        model.addAttribute("user", user.get());
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

