package com.example.prathampatil;

import java.util.ArrayList;
import java.util.List;

public class TimetableRepository {
    private static TimetableRepository instance;
    private List<TimetableItem> timetableList;

    private TimetableRepository() {
        timetableList = new ArrayList<>();
    }

    public static synchronized TimetableRepository getInstance() {
        if (instance == null) {
            instance = new TimetableRepository();
        }
        return instance;
    }

    public List<TimetableItem> getTimetableList() {
        return timetableList;
    }

    public void addTimetableItem(TimetableItem item) {
        timetableList.add(item);
    }
}