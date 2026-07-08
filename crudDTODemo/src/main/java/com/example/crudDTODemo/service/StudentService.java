package com.example.crudDTODemo.service;

import com.example.crudDTODemo.dto.CreateStudentRequestDto;
import com.example.crudDTODemo.dto.CreateStudentResponseDto;
import com.example.crudDTODemo.dto.UpdateStudentRequestDto;
import com.example.crudDTODemo.dto.UpdateStudentResponseDto;
import com.example.crudDTODemo.entity.Student;
import com.example.crudDTODemo.exception.DuplicateResourceException;
import com.example.crudDTODemo.exception.ResourceNotFoundException;
import com.example.crudDTODemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto) {
        Student student = mapToEntity(createStudentRequestDto);

        if(emailExists(student)) {
            throw new DuplicateResourceException("Student with email : " + student.getEmail() + " already exists !");
        }

        Student studentResponse = studentRepository.save(student);

        return mapToCreateDto(studentResponse);
    }

    // select * from student where id = 1 & deleted = false;
    public CreateStudentResponseDto getStudent(Long id) {
        Student studentResponse = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id : " + id + " not found !"));

        return mapToCreateDto(studentResponse);
    }

    // select * from student where deleted = false;
    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToCreateDto)
                .toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto updateStudentRequestDto) {
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id : " + id + " not found !"));

        existingStudent.setRollNo(updateStudentRequestDto.getRollNo());
        existingStudent.setSubject(updateStudentRequestDto.getSubject());
        existingStudent.setAge(updateStudentRequestDto.getAge());
        existingStudent.setName(updateStudentRequestDto.getName());
        existingStudent.setDeleted(false); // by default
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);
        return mapToUpdateDto(savedStudent);
    }

    // delete whether deleted = false or not
    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id : " + id + " not found !"));

        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id : " + id + " not found !"));

        // update deleted = true
        studentToBeDeleted.setDeleted(true);

        // save
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();

        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setName(createStudentRequestDto.getName());
        student.setSubject(createStudentRequestDto.getSubject());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDto mapToCreateDto(Student student) {
        CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();

        createStudentResponseDto.setId(student.getId());
        createStudentResponseDto.setAge(student.getAge());
        createStudentResponseDto.setEmail(student.getEmail());
        createStudentResponseDto.setName(student.getName());
        createStudentResponseDto.setSubject(student.getSubject());
        createStudentResponseDto.setRollNo(student.getRollNo());
        createStudentResponseDto.setMessage("Student saved successfully !");
        createStudentResponseDto.setCreatedAt(student.getCreatedAt());
        createStudentResponseDto.setUpdatedAt(student.getUpdatedAt());

        return createStudentResponseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto updateStudentResponseDto = new UpdateStudentResponseDto();

        updateStudentResponseDto.setId(student.getId());
        updateStudentResponseDto.setAge(student.getAge());
        updateStudentResponseDto.setEmail(student.getEmail());
        updateStudentResponseDto.setName(student.getName());
        updateStudentResponseDto.setSubject(student.getSubject());
        updateStudentResponseDto.setRollNo(student.getRollNo());
        updateStudentResponseDto.setMessage("Student updated  successfully !");
        updateStudentResponseDto.setUpdatedAt(student.getUpdatedAt());

        return updateStudentResponseDto;
    }

    private boolean emailExists(Student student) {
        // In real world, below query is slow because indexing is done on Primary Key i.e id (FYI )
        return studentRepository.existsByEmail(student.getEmail());
    }

}
