package com.example.prathampatil;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsRepository {
    private static AssignmentsRepository instance;
    private List<AssignmentsItem> assignmentsList;

    private AssignmentsRepository() {
        assignmentsList = new ArrayList<>();
    }

    public static synchronized AssignmentsRepository getInstance() {
        if (instance == null) {
            instance = new AssignmentsRepository();
        }
        return instance;
    }

    public List<AssignmentsItem> getAssignmentsList() {
        return assignmentsList;
    }

    public void addAssignmentItem(AssignmentsItem item) {
        assignmentsList.add(item);
    }
}