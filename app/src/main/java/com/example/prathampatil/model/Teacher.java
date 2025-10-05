package com.example.prathampatil.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String name;
    private String username;
    private String password;
    private String subject;
    private String experience;

    public Teacher(String name, String username, String password, String subject, String experience) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.subject = subject;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
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
