package com.example.spring_data_jpa_04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpa04Application {

    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Hugh", "Murdoch"));
        repository.save(new Employee("Bruce", "Wayne"));
        repository.save(new Employee("Peter", "Parker"));
        repository.save(new Employee("Tony", "Stark"));
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpa04Application.class, args);
    }

}
