package com.vik.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    private Student addNewStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    private Student fetchStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping
    private List<Student> fetchAllStudent() {
        return studentRepository.findAll();
    }
}