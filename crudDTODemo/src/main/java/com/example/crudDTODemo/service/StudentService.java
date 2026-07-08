package com.example.crudDTODemo.service;

import com.example.crudDTODemo.dto.CreateStudentRequestDto;
import com.example.crudDTODemo.dto.CreateStudentResponseDto;
import com.example.crudDTODemo.dto.UpdateStudentRequestDto;
import com.example.crudDTODemo.dto.UpdateStudentResponseDto;
import com.example.crudDTODemo.entity.Student;
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

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        Student studentResponse = studentRepository.save(student);

        return mapToCreateDto(studentResponse);
    }

    // select * from student where id = 1 & deleted = false;
    public CreateStudentResponseDto getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResponse.isPresent()) {
            return mapToCreateDto(studentResponse.get());
        }

        return null;
    }

    // select * from student where deleted = false;
    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToCreateDto)
                .toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto updateStudentRequestDto) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setRollNo(updateStudentRequestDto.getRollNo());
        studentToSave.setSubject(updateStudentRequestDto.getSubject());
        studentToSave.setAge(updateStudentRequestDto.getAge());
        studentToSave.setName(updateStudentRequestDto.getName());
        studentToSave.setDeleted(false); // by default
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return mapToUpdateDto(savedStudent);
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

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();

        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setName(createStudentRequestDto.getName());
        student.setSubject(createStudentRequestDto.getSubject());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setDeleted(false);

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
}
