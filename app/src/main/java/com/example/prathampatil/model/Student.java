package com.example.prathampatil.model;

public class Student {
    private String name;
    private String password;
    private String studentClass;
    private String department;
    private String email;

    public Student(String name, String password, String studentClass, String department, String email) {
        this.name = name;
        this.password = password;
        this.studentClass = studentClass;
        this.department = department;
        this.email = email;
    }

    // Getters for the new fields
    public String getUsername() {
        return name; // The student name is now the username
    }

    public String getPassword() {
        return password;
    }

    // Existing getters
    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }
}