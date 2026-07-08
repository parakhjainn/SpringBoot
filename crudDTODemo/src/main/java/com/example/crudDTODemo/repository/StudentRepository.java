package com.example.crudDTODemo.repository;

import com.example.crudDTODemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository -> optional bcz interface doesn't have objects
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();

    // findAllAndDeletedIsFalse is not correct format
    // correct format = findBy + fieldName + Condition
}
