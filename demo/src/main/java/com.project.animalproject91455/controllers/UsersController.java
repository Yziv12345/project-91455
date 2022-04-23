package com.project.animalproject91455.controllers;


import com.project.animalproject91455.customer.User;
import com.project.animalproject91455.customer.UserLogin;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.UsersRepository;
import com.project.animalproject91455.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class UsersController {

    private UsersRepository usersRepository;
    private UsersService usersService;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users/register")
    public String getRegisterUserPage(Model model){
        model.addAttribute("users", new Users());
        return "users/register";
    }

    @GetMapping("/users/pleaseLogIn")
    public String getPleaseLogInPage(Model model)
    {   model.addAttribute("userLogin", new UserLogin());
        return "users/pleaseLogIn";
    }

    @GetMapping("/users/login")
    public String getLoginUserPage(Model model)
    {   model.addAttribute("userLogin", new UserLogin());
        return "users/login";
    }

    @GetMapping("/users/userProfile")
    public String getUserProfile(@ModelAttribute User user, Model model){
        return "users/userProfile";
    }

    @GetMapping("/users/loggedInUser")
    public String getLoggedInUserPage(){
        return "users/loggedInUser";
    }

    @GetMapping("/users/loggedOutUser")
    public String getLoggedOutUserPage(){
        return "users/loggedOutUser";
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
    @PostMapping("/users/saveUser")
    public ModelAndView save(@RequestParam(value = "users") User user, Model model) {
        System.out.println("userName from UI = " + user.getUserName());
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
        Users newUser = new Users(rand_1, user.getName(), "", user.getPassword(), user.getUserName(), user.getEmail(), user.getPhoneNumber());
        try {
            usersRepository.save(newUser);
        } catch (Exception e) {
            System.out.print(e);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/loggedInUser");
        modelAndView.addObject("user", new Users());
        return modelAndView;
    }

    @GetMapping("/users/checkLoginUser")
    public String checkLoginUser(@RequestParam(value = "userLogin") UserLogin userLogin, Model model) {
        model.addAttribute("userLogin", userLogin);
        if(userLogin.getEmail().equals("Dov@walla.com") && userLogin.getPassword().equals("246")){
            model.addAttribute("loggedInMsg", "welcome back");
            return "users/loggedInUser";
        }
        else{
            model.addAttribute("incorrectPasswordMsg", "You have entered a wrong password");
            return "users/login";
        }
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
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
