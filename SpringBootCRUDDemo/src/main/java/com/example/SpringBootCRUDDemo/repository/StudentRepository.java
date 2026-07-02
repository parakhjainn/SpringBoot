package com.example.SpringBootCRUDDemo.repository;

import com.example.SpringBootCRUDDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository -> optional bcz interface doesn't have objects
public interface StudentRepository extends JpaRepository<Student, Long> {


}
