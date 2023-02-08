package com.example.studentdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdb.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
