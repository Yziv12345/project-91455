package com.project.animalproject91455.services;

import com.project.animalproject91455.interfaces.Users;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    List<Users> findByName(String userName);

    Optional<Users> findById(Integer owner_id);
}
