package br.edu.uniara.lpi2.rest.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Car("14785236912", "ABC1234", "Chevrolet", "Onix", 2022)));
            log.info("Preloading " + repository.save(new Car("23456789012", "DEF5678", "Volkswagen", "Gol", 2021)));
        };
    }
}
