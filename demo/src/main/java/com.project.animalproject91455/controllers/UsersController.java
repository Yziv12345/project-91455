package com.project.animalproject91455.controllers;

import com.project.animalproject91455.customer.User;
import com.project.animalproject91455.customer.UserLogin;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping(value = "/index")
    public String getHomePage(){
        return "index";
    }

    @GetMapping(value = "/home/homeSignedIn")
    public String gethomeSignedIn(){
        return "home/homeSignedIn";
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

    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public ModelAndView getLoginUserPage(Model model){
        ModelAndView mav = new ModelAndView("users/login");
        mav.addObject("userLogin", new UserLogin());
        return mav;
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

    @RequestMapping(value ="/users/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("users") Users user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //errors handling
        }
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
        Users newUser = new Users(rand_1, user.getName(), "0", user.getPassword(), user.getUserName(), user.getUserEmail(), user.getUserPhoneNumber());
        try {
            usersRepository.save(newUser);
        } catch (Exception e) {
            System.out.print(e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("users/loggedInUser");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/users/checkLoginUser", method = RequestMethod.POST)
    public ModelAndView checkLoginUser(@ModelAttribute("userLogin") UserLogin userLogin, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //errors handling
        }
        if(userLogin.getEmail().equals("Dov@walla.com") && userLogin.getPassword().equals("246")){
            ModelAndView mav = new ModelAndView("users/loggedInUser");
            mav.addObject("loggedInMsg", "welcome back");
            return mav;
        }
        else{
            ModelAndView mav = new ModelAndView("users/login");
            mav.addObject("incorrectPasswordMsg", "You have entered a wrong password");
            return mav;
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
