package com.project.animalproject91455.controllers;


import com.project.animalproject91455.customer.User;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users/register")
    public String registerUser(){
        return "users/register";
    }

    @GetMapping("/users/userProfile")
    public String seeUserProfile(){
        return "users/userProfile";
    }

    @GetMapping("/users/loggedInUser")
    public String loggedInUserPage(){
        return "users/loggedInUser";
    }

    //    @PostMapping("/register")
//    public Users registerUser(@RequestParam String name, @RequestParam String userName, @RequestParam String password) {
//        Random ran = new Random();
//        int rand_1 = ran.nextInt(6) + 5;
//        Users newUser = new Users(rand_1, name, new ArrayList<>(), new ArrayList<>(), password, userName);
//        try {
//            return usersRepository.save(newUser);
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//        return newUser;
//    }
    @PostMapping("/saveUser")
    public ModelAndView save(@ModelAttribute User user) {
        System.out.println("userName from UI = " + user);
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
//        Users newUser = new Users(rand_1, user.getName(), new ArrayList<>(), new ArrayList<>(), user.getUsername(), user.getPassword());
//        try {
//            usersRepository.save(newUser);
//        } catch (Exception e) {
//            System.out.print(e);
//        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/loggedInUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam(name="name", required=true) String name, @RequestParam(required=true) String password) {
        try {
            List<Users> users = usersRepository.findByName(name);
            Users user = null;
            if (users.size() > 0){
                user = users.get(0);
            }
            if (user != null && Objects.equals(user.getPassword(), password)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
}
