package com.example.studentdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.createStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int studentId){
    return studentRepo.getStudent(studentId);
    }
    @PutMapping("/student/{id}")
    public boolean upsateStudent(@PathVariable("id") int studentId, Student student){
        return studentRepo.updateStudent(studentId,student);
    }
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int studentId){
            studentRepo.deleteStudent(studentId);
        }
    }
