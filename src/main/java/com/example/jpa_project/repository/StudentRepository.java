package com.example.jpa_project.repository;

import com.example.jpa_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA provides all standard CRUD methods (findAll, findById, save, deleteById, etc.)
}