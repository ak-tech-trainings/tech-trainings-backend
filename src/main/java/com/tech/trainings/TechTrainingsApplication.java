package com.tech.trainings;

import com.tech.trainings.jpa.repository.CourseRepository;
import com.tech.trainings.jpa.repository.FacultyRepository;
import com.tech.trainings.jpa.repository.StudentRepository;
import com.tech.trainings.security.in_memory.jpa.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses ={CourseRepository.class, StudentRepository.class, FacultyRepository.class, UserRepository.class} )
@RestController
@CrossOrigin(origins = {"https://www.google.com"})
public class TechTrainingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechTrainingsApplication.class, args);
    }

    @GetMapping("/")
    public String welcome(){
        return "<h1>Home page</h1>";
    }

    @GetMapping("/user")
    public String getUser(){
        return "<h1>Welcome to user or admin</h1>";
    }

    @GetMapping("/admin")
    public String getManager(){
        return "<h1>Welcome to admin</h1>";
    }

}
