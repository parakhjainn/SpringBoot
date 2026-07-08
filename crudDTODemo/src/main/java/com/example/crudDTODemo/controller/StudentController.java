package com.example.crudDTODemo.controller;

import com.example.crudDTODemo.entity.Student;
import com.example.crudDTODemo.service.StudentService;
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
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student studentResponse = studentService.getStudent(id);

        if(studentResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }

    // read all student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }


    // update student
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student student) {
        Student studentResponse = studentService.updateStudent(id, student);

        if(studentResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }

    // delete student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted !");
    }

    // soft delete student
    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted !");
    }


}
