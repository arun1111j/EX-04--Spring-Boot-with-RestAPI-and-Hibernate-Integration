package com.example.jpa_project.controller;

import com.example.jpa_project.entity.Student;
import com.example.jpa_project.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping("/")
    public String name(Student student)
    {
        return student.name;
    }
    @PostMapping("/arun")
    public void name1()
    {

    }


}
