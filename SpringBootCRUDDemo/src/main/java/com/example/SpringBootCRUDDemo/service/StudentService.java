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
        System.out.println("Inside Student Service");

        // Business Logic

        // store to db
        Student studentResponse = studentRepository.saveStudent(studentReq);

        System.out.println("Exiting Student Service");
        return studentResponse;
    }
}
