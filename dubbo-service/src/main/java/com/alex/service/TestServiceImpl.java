package com.alex.service;

import com.alex.model.Student;
import com.alex.model.Users;
import com.alex.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepo testRepo;

    @Autowired
    private StudentService studentService;

    @Override
    public List<Users> hello() {
        List<Users> usersList = testRepo.findAllUsers();
        return usersList;
    }

    @Override
    public void saveUserAndStudent() {
        Users users = new Users();
        users.setNickName("比卡丘");
        users.setPassWord("123456");
        users.setUserName("我是一个比卡丘");
        users.setUserSex("女");
        testRepo.saveUser(users);
        Student student = new Student();
        student.setSubject("英语");
        student.setGrade("初一");
        student.setUserId(users.getId());
        studentService.saveStudent(student);
    }
}
