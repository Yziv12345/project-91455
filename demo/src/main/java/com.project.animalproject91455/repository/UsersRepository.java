package com.project.animalproject91455.repository;

import com.project.animalproject91455.interfaces.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, Integer>{
}

