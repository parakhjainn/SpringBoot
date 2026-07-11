package com.example.filterDemo.service;

import com.example.filterDemo.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDTO studentDTO) {
        System.out.println("Student created !");
        System.out.println(studentDTO.getName());
        System.out.println(studentDTO.getEmail());
    }
}
