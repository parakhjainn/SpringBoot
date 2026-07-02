package com.example.SpringBootCRUDDemo.service;

import com.example.SpringBootCRUDDemo.entity.Student;
import com.example.SpringBootCRUDDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findById(id);
        if(studentResponse.isPresent()) return studentResponse.get();
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setName(studentReq.getName());

        return studentRepository.save(studentToSave);
    }
}
