package com.example.prathampatil;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String studentClass;
    private String department;
    private String rollNumber;
    private int age;

    public Student() {}

    public Student(String name, String username, String password, String email, String phone,
                   String studentClass, String department, String rollNumber, int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
        this.department = department;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStudentClass() { return studentClass; }
    public String getDepartment() { return department; }
    public String getRollNumber() { return rollNumber; }
    public int getAge() { return age; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }
    public void setDepartment(String department) { this.department = department; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return name + " (" + rollNumber + ")";
    }
}
