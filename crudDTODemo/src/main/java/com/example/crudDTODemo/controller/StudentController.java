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

        // return ResponseEntity.ok(createStudentResponseDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudentResponseDto);
    }

    // read 1 student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id) {
        CreateStudentResponseDto createStudentResponseDto = studentService.getStudent(id);

        return ResponseEntity.ok(createStudentResponseDto);
    }

    // read all student
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }


    // update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @Valid @RequestBody UpdateStudentRequestDto updateStudentRequestDto) {
        UpdateStudentResponseDto updateStudentResponseDto = studentService.updateStudent(id, updateStudentRequestDto);

        return ResponseEntity.ok(updateStudentResponseDto);
    }

    // delete student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);

//        return ResponseEntity
//                .status(HttpStatus.NO_CONTENT)
//                .build();
         return ResponseEntity.noContent().build();
    }

    // soft delete student
    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }


}
