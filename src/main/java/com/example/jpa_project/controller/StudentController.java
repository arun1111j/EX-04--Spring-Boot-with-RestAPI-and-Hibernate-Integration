package com.example.jpa_project.controller;

import com.example.jpa_project.entity.Student;
import com.example.jpa_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students") // Base path for all endpoints in this controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. Create a new Student
    // POST http://localhost:8080/students
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // 2. Get all Students
    // GET http://localhost:8080/students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 3. Get a single Student by ID
    // GET http://localhost:8080/students/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok) // If found, return 200 OK with student
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    // 4. Update an existing Student
    // PUT http://localhost:8080/students/1
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails)
                .map(ResponseEntity::ok) // If updated, return 200 OK with updated student
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    // 5. Delete a Student
    // DELETE http://localhost:8080/students/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        // Use <Void> for an empty response body
        return studentService.deleteStudent(id)
                ? ResponseEntity.ok().<Void>build() // If deleted, return 200 OK
                : ResponseEntity.notFound().build(); // If not found, return 404 Not Found
    }
}