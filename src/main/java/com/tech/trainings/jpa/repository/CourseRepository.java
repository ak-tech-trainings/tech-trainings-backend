package com.tech.trainings.jpa.repository;

import com.tech.trainings.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
