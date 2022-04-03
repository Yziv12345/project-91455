package com.project.animalproject91455.controllers;


import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @PostMapping("/register")
    public Users registerUser(@RequestParam String name, @RequestParam String userName, @RequestParam String password) {
        Random ran = new Random();
        int rand_1 = ran.nextInt(6) + 5;
        Users newUser = new Users(rand_1, name, new ArrayList<>(), new ArrayList<>(), password, userName);
        try {
            return usersRepository.save(newUser);
        } catch (Exception e) {
            System.out.print(e);
        }
        return newUser;
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam String name, @RequestParam String password) {
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
