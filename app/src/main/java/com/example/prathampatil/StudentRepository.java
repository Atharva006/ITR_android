package com.example.prathampatil;

import java.util.ArrayList;

public class StudentRepository {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static boolean initialized = false;

    public static void initializeSampleData() {
        if (!initialized) {
            studentList.clear();
            studentList.add(new Student("Alice Johnson", "student1", "pass123", "alice@school.edu", "9876543220", "Class 10A", "Science", "S001", 16));
            studentList.add(new Student("Bob Smith", "student2", "pass123", "bob@school.edu", "9876543221", "Class 10B", "Commerce", "S002", 16));
            studentList.add(new Student("Charlie Brown", "student3", "pass123", "charlie@school.edu", "9876543222", "Class 11A", "Science", "S003", 17));
            studentList.add(new Student("Diana Prince", "student4", "pass123", "diana@school.edu", "9876543223", "Class 11B", "Arts", "S004", 17));
            studentList.add(new Student("Edward Norton", "student5", "pass123", "edward@school.edu", "9876543224", "Class 12A", "Science", "S005", 18));
            initialized = true;
        }
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void addStudent(Student student) {
        if (studentList != null) {
            studentList.add(student);
        }
    }

    public static void removeStudent(Student student) {
        if (studentList != null) {
            studentList.remove(student);
        }
    }

    public static Student findStudentByUsername(String username) {
        for (Student student : studentList) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }
}
