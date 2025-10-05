package com.example.prathampatil;

import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {
    private static AttendanceRepository instance;
    private List<AttendanceItem> attendanceList;

    private AttendanceRepository() {
        attendanceList = new ArrayList<>();
    }

    public static synchronized AttendanceRepository getInstance() {
        if (instance == null) {
            instance = new AttendanceRepository();
        }
        return instance;
    }

    public List<AttendanceItem> getAttendanceList() {
        return attendanceList;
    }

    public void addAttendanceItem(AttendanceItem item) {
        attendanceList.add(item);
    }
}