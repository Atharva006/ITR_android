package com.example.prathampatil;

public class AttendanceItem {
    private String subjectName;
    private int classesAttended;
    private int totalClasses;

    public AttendanceItem(String subjectName, int classesAttended, int totalClasses) {
        this.subjectName = subjectName;
        this.classesAttended = classesAttended;
        this.totalClasses = totalClasses;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getClassesAttended() {
        return classesAttended;
    }

    public int getTotalClasses() {
        return totalClasses;
    }
}