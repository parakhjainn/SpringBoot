package com.example.SpringBootCRUDDemo.service;

import com.example.SpringBootCRUDDemo.entity.Student;
import com.example.SpringBootCRUDDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        // Business Logic

        // store to db
        Student studentResponse = studentRepository.save(studentReq);
        return studentResponse;
    }
}
