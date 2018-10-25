package com.alex.model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 6201981523986833024L;

    private Integer id;

    private Integer userId;

    private String grade;

    private String subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
