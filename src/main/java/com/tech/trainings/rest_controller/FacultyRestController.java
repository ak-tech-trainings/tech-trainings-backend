package com.tech.trainings.rest_controller;

import com.tech.trainings.jpa.model.Faculty;
import com.tech.trainings.jpa.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/faculties")
public class FacultyRestController {
    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping(path = "/all")
    public Set<Faculty> getFaculties() {
        Set<Faculty> faculties = new HashSet<>();
        facultyRepository.findAll().forEach(faculties::add);
        return faculties;
    }

    @GetMapping(path = "/faculty/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyRepository.findById(id).get();
    }

    @DeleteMapping
    public void deleteFaculty(@RequestBody Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    @PostMapping
    public void saveFaculty(@RequestBody Faculty faculty) {
        facultyRepository.save(faculty);
    }

}
