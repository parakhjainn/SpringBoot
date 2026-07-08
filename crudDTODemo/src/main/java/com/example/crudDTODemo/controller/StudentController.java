package com.example.crudDTODemo.controller;

import com.example.crudDTODemo.dto.CreateStudentRequestDto;
import com.example.crudDTODemo.dto.CreateStudentResponseDto;
import com.example.crudDTODemo.dto.UpdateStudentRequestDto;
import com.example.crudDTODemo.dto.UpdateStudentResponseDto;
import com.example.crudDTODemo.entity.Student;
import com.example.crudDTODemo.service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto createStudentRequestDto) {
        CreateStudentResponseDto createStudentResponseDto = studentService.createStudent(createStudentRequestDto);

        // return ResponseEntity.ok(createdStudent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudentResponseDto);
    }

    // read 1 student
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@RequestParam Long id) {
        CreateStudentResponseDto createStudentResponseDto = studentService.getStudent(id);

        if(createStudentResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(createStudentResponseDto);
    }

    // read all student
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(studentList);
    }


    // update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @Valid @RequestBody UpdateStudentRequestDto updateStudentRequestDto) {
        UpdateStudentResponseDto updateStudentResponseDto = studentService.updateStudent(id, updateStudentRequestDto);

        if(updateStudentResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateStudentResponseDto);
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
