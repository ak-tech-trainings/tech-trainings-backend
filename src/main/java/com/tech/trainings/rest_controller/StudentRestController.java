package com.tech.trainings.rest_controller;

import com.tech.trainings.jpa.model.Student;
import com.tech.trainings.jpa.repository.StudentRepository;
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
@RequestMapping(path = "/students")
public class StudentRestController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/all")
    public Set<Student> getStudents() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @GetMapping(path = "/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).get();
    }

    @DeleteMapping
    public void deleteFaculty(@RequestBody Student student) {
        studentRepository.delete(student);
    }

    @PostMapping
    public void saveFaculty(@RequestBody Student student) {
        studentRepository.save(student);
    }
}
