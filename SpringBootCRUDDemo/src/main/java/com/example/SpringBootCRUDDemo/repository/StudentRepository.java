package com.example.SpringBootCRUDDemo.repository;

import com.example.SpringBootCRUDDemo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public Student saveStudent(Student studentReq) {
        System.out.println("Inside Student Repository");

        // save to DB

        System.out.println("Exiting Student Repository");

        Student s1 = new Student();
        s1.setName("Parakh");
        s1.setAge(26);
        s1.setEmail("Parakh@gmail.com");
        s1.setSubject("SpringBoot");
        s1.setRollNo(18);
        return s1;
    }
}
