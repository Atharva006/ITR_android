package com.example.prathampatil.model;

public class AssignmentsItem {
    private String subjectName;
    private String title;
    private String dueDate;
    private String status;

    public AssignmentsItem(String subjectName, String title, String dueDate, String status) {
        this.subjectName = subjectName;
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}