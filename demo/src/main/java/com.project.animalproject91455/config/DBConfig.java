package com.project.animalproject91455.config;


import com.project.animalproject91455.animal.Animal;
import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.StatusType;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.util.ArrayList;

@EnableMongoRepositories(basePackageClasses = AnimalsRepository.class)
@Configuration
public class DBConfig {

    @Bean
    CommandLineRunner commandLineRunner(AnimalsRepository animalsRepository, UsersRepository usersRepository) {
        return strings -> {
            animalsRepository.save(new Animals(1, "Peter", LocalDate.now(), "Dog",1,"Mammals", 1, 6.50, 27.3));
            animalsRepository.save(new Animals(2, "Lucky", LocalDate.now(), "Toad",1,"Amphibians", 2, 2, 13));
            animalsRepository.save(new Animals(3, "Sharky", LocalDate.now(), "Fish",1,"Fish", 3, 1, 0.200));
            animalsRepository.save(new Animals(4, "Ricko", LocalDate.now(), "Rats",1,"Rats", 4, 4, 1.5));
            usersRepository.save(new Users(1, "Yossi", "1", "135", "YossiCohen", "yossi@gmail.com", "0542555333"));
            usersRepository.save(new Users(2, "Dov", "2", "246", "Navon", "Dov@walla.com", "09-8994422"));
        };
    }

}
