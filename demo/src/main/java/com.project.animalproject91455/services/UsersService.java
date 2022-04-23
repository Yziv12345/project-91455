package com.project.animalproject91455.services;

import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findByName(String userName) {
        var users = (List<Users>) usersRepository.findByName(userName);
        return users;
    }

    @Override
    public Optional<Users> findById(Integer owner_id) {
        var users = (Optional<Users>) usersRepository.findById(owner_id);
        return users;
    }
}
