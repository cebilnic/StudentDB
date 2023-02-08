package com.example.studentdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentdb.repo.StudentRepo;
import com.example.studentdb.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo repo;

    @Override
    public List<Student> findAllStudents(){
        return repo.findAll();
    }

    @Override
    public boolean isListEmpty(){
        return (repo.count() == 0);
    }

    @Override
    public Long numberofStudentEntry(){
        return repo.count();
    }

    @Override
    public Student save(Student student){
        return repo.save(student);
    }

    @Override
    public Optional<Student> findStudentbyId(Long id){
        return repo.findById(id);
    }

/*     @Override
    public Student updateStudentData(Long id){
        return repo.
    } */
}
