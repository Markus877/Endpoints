package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.model.Proyect;
import com.example.service.ProjectService;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class EjEndpoints2Application {
    public static void main(String[] args) {
        SpringApplication.run(EjEndpoints2Application.class, args);
    }

    @Bean
    CommandLineRunner init(ProjectService projectService) {
        return args -> {
            projectService.createProject(new Proyect(1L, "Proyecto 1", "Java", true));
            projectService.createProject(new Proyect(2L, "Proyecto 2", "Python", true));
            projectService.createProject(new Proyect(3L, "Proyecto 3", "JavaScript", false));
        };
    }
}
