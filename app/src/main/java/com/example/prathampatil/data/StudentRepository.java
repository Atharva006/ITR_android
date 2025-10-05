package com.example.prathampatil.data;

import com.example.prathampatil.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static StudentRepository instance;
    private List<Student> studentList;

    private StudentRepository() {
        studentList = new ArrayList<>();
    }

    public static synchronized StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }
}