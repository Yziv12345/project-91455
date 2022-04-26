package com.project.animalproject91455.repository;

import com.project.animalproject91455.interfaces.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findByName(String userName);

    Optional<Users> findById(Integer id);

    Users findByUserEmail(String email);
//    Optional<Users> findByOwner_i(String owner_id);
}

