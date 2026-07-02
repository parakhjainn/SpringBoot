package com.example.SpringBootCRUDDemo.controller;

import com.example.SpringBootCRUDDemo.entity.Student;
import com.example.SpringBootCRUDDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create student
    @PostMapping  // @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside Student Controller");

        Student createdStudent = studentService.createStudent(student);

        System.out.println("Exiting Student Controller");
        // return ResponseEntity.ok(createdStudent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    // read student



    // update student


    // delete student

}
