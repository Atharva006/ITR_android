package com.example.prathampatil;

// This class holds all the information for a single teacher.
public class Teacher {
    private String fullName;
    private String email;
    private String password;
    private String subject;
    private String experience;

    // Constructor to create a new Teacher object
    public Teacher(String fullName, String email, String password, String subject, String experience) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.subject = subject;
        this.experience = experience;
    }

    // Getter methods to access the teacher's data
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSubject() {
        return subject;
    }

    public String getExperience() {
        return experience;
    }
}