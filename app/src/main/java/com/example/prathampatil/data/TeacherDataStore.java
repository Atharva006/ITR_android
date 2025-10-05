package com.example.prathampatil.data;

import com.example.prathampatil.model.Teacher;
import java.util.ArrayList;
import java.util.List;

public class TeacherDataStore {

    private static TeacherDataStore instance;
    private final List<Teacher> teacherList;

    // Private constructor for singleton
    private TeacherDataStore() {
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher("John Doe", "johndoe", "password123", "Computer Science", "5 years"));
        teacherList.add(new Teacher("Jane Smith", "janesmith", "pass456", "Mathematics", "3 years"));
    }

    // Singleton getInstance method
    public static TeacherDataStore getInstance() {
        if (instance == null) {
            instance = new TeacherDataStore();
        }
        return instance;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }
}
