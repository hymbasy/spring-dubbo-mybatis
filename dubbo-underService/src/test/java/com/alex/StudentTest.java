package com.alex;

import com.alex.model.Student;
import com.alex.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void add() {
        Student student = new Student();
        student.setUserId(1);
        student.setGrade("三年级");
        student.setSubject("语文");
        studentService.saveStudent(student);
    }
}
