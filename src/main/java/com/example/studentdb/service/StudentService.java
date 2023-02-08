package com.example.studentdb.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.studentdb.model.Student;


public interface StudentService {
    List<Student> findAllStudents();
    boolean isListEmpty();
    Long numberofStudentEntry();
    Student  save(Student student);
    Optional<Student> findStudentbyId(Long id);
}
