package com.example.SpringBootCRUDDemo.controller;

import com.example.SpringBootCRUDDemo.entity.Student;
import com.example.SpringBootCRUDDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Student createdStudent = studentService.createStudent(student);

        // return ResponseEntity.ok(createdStudent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    // read 1 student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResponse = studentService.getStudent(id);

        if(studentResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }

    // read all student
    @GetMapping()
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }


    // update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student studentResponse = studentService.updateStudent(id, student);

        if(studentResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }

    // delete student

}
