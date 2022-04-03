package com.project.animalproject91455.repository;

import com.project.animalproject91455.interfaces.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findByName(String userName);
}

