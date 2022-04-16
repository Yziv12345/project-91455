package com.project.animalproject91455.config;


import com.project.animalproject91455.animal.Animal;
import com.project.animalproject91455.interfaces.Animals;
import com.project.animalproject91455.interfaces.StatusType;
import com.project.animalproject91455.repository.AnimalsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@EnableMongoRepositories(basePackageClasses = AnimalsRepository.class)
@Configuration
public class  MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(AnimalsRepository animalsRepository) {
        return strings -> {
            animalsRepository.save(new Animals(1, "Peter", LocalDate.now(), "Dog",1,"mammal", 1, 6.50, 27.3));
        };
    }

}
