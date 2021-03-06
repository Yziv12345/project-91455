package com.project.animalproject91455.config;
import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.Users;
import com.project.animalproject91455.repository.AnimalsRepository;
import com.project.animalproject91455.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@EnableMongoRepositories(basePackageClasses = AnimalsRepository.class)
@Configuration
public class DBConfig {

    @Bean
    CommandLineRunner commandLineRunner(AnimalsRepository animalsRepository, UsersRepository usersRepository) {
        return strings -> {
            animalsRepository.save(new Animals(1, "Peter", LocalDate.now(), "Dog",1,"Mammals", "Yossi", 6.50, 27.3));
            animalsRepository.save(new Animals(2, "Lucky", LocalDate.now(), "Toad",1,"Amphibians", "Dov", 2, 13));
            animalsRepository.save(new Animals(3, "Sharky", LocalDate.now(), "Fish",1,"Fish", "unknown", 1, 0.200));
            animalsRepository.save(new Animals(4, "Ricko", LocalDate.now(), "Rats",1,"Rats", "unknown", 4, 1.5));
            usersRepository.save(new Users(1, "Yossi", "Peter", "135", "YossiCohen", "yossi@gmail.com", "0542555333"));
            usersRepository.save(new Users(2, "Dov", "Lucky", "246", "Navon", "Dov@walla.com", "09-8994422"));
        };
    }

}
