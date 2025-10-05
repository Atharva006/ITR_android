package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

public class TeacherDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        // Get the teacher data from the intent
        Intent intent = getIntent();
        String teacherName = intent.getStringExtra("TEACHER_NAME");
        String teacherDetails = intent.getStringExtra("TEACHER_DETAILS");

        // Find the views
        TextView teacherNameTextView = findViewById(R.id.teacher_name_text_view);
        TextView teacherDetailsTextView = findViewById(R.id.teacher_details_text_view);
        MaterialCardView markAttendanceCard = findViewById(R.id.card_mark_attendance);
        MaterialCardView sendAssignmentCard = findViewById(R.id.card_send_assignment);
        MaterialCardView viewTimetableCard = findViewById(R.id.card_view_timetable_teacher);

        // Set the teacher's details
        if (teacherName != null) {
            teacherNameTextView.setText(teacherName);
        }
        if (teacherDetails != null) {
            teacherDetailsTextView.setText(teacherDetails);
        }

        // Set up the toolbar with back navigation
        MaterialToolbar toolbar = findViewById(R.id.toolbar_teacher);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Set up click listeners for the cards
        markAttendanceCard.setOnClickListener(v -> {
            Intent markAttendanceIntent = new Intent(TeacherDashboardActivity.this, MarkAttendanceActivity.class);
            startActivity(markAttendanceIntent);
        });

        sendAssignmentCard.setOnClickListener(v -> {
            Intent sendAssignmentIntent = new Intent(TeacherDashboardActivity.this, SendAssignmentActivity.class);
            startActivity(sendAssignmentIntent);
        });

        viewTimetableCard.setOnClickListener(v -> {
            Intent viewTimetableIntent = new Intent(TeacherDashboardActivity.this, TimetableActivity.class);
            startActivity(viewTimetableIntent);
        });
    }
}