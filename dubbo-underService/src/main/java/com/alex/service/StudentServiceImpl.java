package com.alex.service;

import com.alex.model.Student;
import com.alex.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public void saveStudent(Student student) {
        studentRepo.saveStudent(student);
    }
}
