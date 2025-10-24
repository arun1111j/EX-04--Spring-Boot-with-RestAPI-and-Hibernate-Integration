package com.example.jpa_project.service;

import com.example.jpa_project.entity.Student;
import com.example.jpa_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> updateStudent(Long id, Student studentDetails) {
        // Find the existing student
        return studentRepository.findById(id).map(existingStudent -> {
            // Update the fields
            existingStudent.setName(studentDetails.getName());
            existingStudent.setDepartment(studentDetails.getDepartment());
            existingStudent.setEmail(studentDetails.getEmail());
            // Save and return the updated student
            return studentRepository.save(existingStudent);
        });
    }

    public boolean deleteStudent(Long id) {
        // Check if the student exists
        return studentRepository.findById(id).map(student -> {
            // If exists, delete it
            studentRepository.delete(student);
            return true;
        }).orElse(false); // Otherwise, return false (not found)
    }
}