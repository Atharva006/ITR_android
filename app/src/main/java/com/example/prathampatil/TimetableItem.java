package com.example.prathampatil;

public class TimetableItem {
    private String time;
    private String subject;
    private String teacher;

    public TimetableItem(String time, String subject, String teacher) {
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }
}