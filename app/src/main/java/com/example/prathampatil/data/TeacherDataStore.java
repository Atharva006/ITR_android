package com.example.prathampatil.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherDataStore {
    private final List<Teacher> teacherList = new ArrayList<>();

    public TeacherDataStore() {
        teacherList.add(new Teacher("John Doe", "johndoe", "password123", "Computer Science", "5 years"));
        teacherList.add(new Teacher("Jane Smith", "janesmith", "pass456", "Mathematics", "3 years"));
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }
}
