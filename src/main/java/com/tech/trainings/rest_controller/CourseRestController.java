package com.tech.trainings.rest_controller;

import com.tech.trainings.jpa.model.Course;
import com.tech.trainings.jpa.repository.CourseRepository;
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
@RequestMapping(path = "/courses")
public class CourseRestController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "/all")
    private Set<Course> getCourses() {
        Set<Course> courses = new HashSet<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @GetMapping(path = "/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).get();
    }

    @DeleteMapping
    public void deleteCourse(@RequestBody Course course) {
        courseRepository.delete(course);
    }

    @PostMapping
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

}
