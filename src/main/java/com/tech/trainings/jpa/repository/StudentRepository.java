package com.tech.trainings.jpa.repository;

import com.tech.trainings.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
