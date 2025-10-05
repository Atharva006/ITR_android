package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.example.prathampatil.TimetableActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Get the student data from the intent
        Intent intent = getIntent();
        String studentName = intent.getStringExtra("STUDENT_NAME");
        String studentDetails = intent.getStringExtra("STUDENT_DETAILS");

        // Find the views
        TextView studentNameTextView = findViewById(R.id.student_name_text_view);
        TextView studentDetailsTextView = findViewById(R.id.student_details_text_view);
        MaterialCardView viewAttendanceCard = findViewById(R.id.card_view_attendance);
        MaterialCardView viewAssignmentsCard = findViewById(R.id.card_view_assignments);
        MaterialCardView viewTimetableCard = findViewById(R.id.card_view_timetable);

        // Set the student's details
        if (studentName != null) {
            studentNameTextView.setText(studentName);
        }
        if (studentDetails != null) {
            studentDetailsTextView.setText(studentDetails);
        }

        // Set up the toolbar with back navigation
        MaterialToolbar toolbar = findViewById(R.id.toolbar_student);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());


        // Set up click listeners for the cards
        viewAttendanceCard.setOnClickListener(v -> {
            Intent attendanceIntent = new Intent(StudentDashboardActivity.this, AttendanceActivity.class);
            startActivity(attendanceIntent);
        });

        viewAssignmentsCard.setOnClickListener(v -> {
            Intent assignmentsIntent = new Intent(StudentDashboardActivity.this, AssignmentsActivity.class);
            startActivity(assignmentsIntent);
        });

        viewTimetableCard.setOnClickListener(v -> {
            Intent timetableIntent = new Intent(StudentDashboardActivity.this, TimetableActivity.class);
            startActivity(timetableIntent);
        });
    }
}