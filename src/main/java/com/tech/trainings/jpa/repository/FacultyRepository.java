package com.tech.trainings.jpa.repository;

import com.tech.trainings.jpa.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
