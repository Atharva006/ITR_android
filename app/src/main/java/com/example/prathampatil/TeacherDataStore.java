package com.example.prathampatil;

import java.util.ArrayList;

public class TeacherDataStore {
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    private static boolean initialized = false;

    public static void initializeSampleData() {
        if (!initialized) {
            teachers.clear();
            teachers.add(new Teacher("Dr. John Smith", "teacher1", "pass123", "john@school.edu", "9876543210", "Mathematics", "Science"));
            teachers.add(new Teacher("Prof. Sarah Johnson", "teacher2", "pass123", "sarah@school.edu", "9876543211", "Physics", "Science"));
            teachers.add(new Teacher("Mr. Michael Brown", "teacher3", "pass123", "michael@school.edu", "9876543212", "English", "Arts"));
            teachers.add(new Teacher("Ms. Emily Davis", "teacher4", "pass123", "emily@school.edu", "9876543213", "Chemistry", "Science"));
            teachers.add(new Teacher("Dr. Robert Wilson", "teacher5", "pass123", "robert@school.edu", "9876543214", "Computer Science", "Technology"));
            initialized = true;
        }
    }

    public static void addTeacher(Teacher teacher) {
        if (teachers != null) {
            teachers.add(teacher);
        }
    }

    public static void removeTeacher(Teacher teacher) {
        if (teachers != null) {
            teachers.remove(teacher);
        }
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }
}
