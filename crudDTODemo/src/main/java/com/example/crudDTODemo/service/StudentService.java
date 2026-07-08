package com.example.crudDTODemo.service;

import com.example.crudDTODemo.entity.Student;
import com.example.crudDTODemo.repository.StudentRepository;
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
        studentReq.setDeleted(false); // by default

        // store to db
        Student studentResponse = studentRepository.save(studentReq);
        return studentResponse;
    }

    // select * from student where id = 1 & deleted = false;
    public Student getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResponse.isPresent()) {
            return studentResponse.get();
        }

        return null;
    }

    // select * from student where deleted = false;
    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setName(studentReq.getName());
        studentToSave.setDeleted(false); // by default

        return studentRepository.save(studentToSave);
    }

    // delete whether deleted = false or not
    public Boolean deleteStudent(Long id) {
        Boolean studentExist = studentRepository.existsById(id);

        if(!studentExist) return false;

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        // get the student
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return false;
        }

        // update deleted = true
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);

        // save
        studentRepository.save(studentToSave);

        return true;
    }
}
