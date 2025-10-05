package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TeacherDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        // Set the teacher's name in the header
        TextView teacherNameDashboard = findViewById(R.id.teacher_name_dashboard);
        String teacherName = getIntent().getStringExtra("TEACHER_NAME");
        if (teacherName != null && !teacherName.isEmpty()) {
            teacherNameDashboard.setText(teacherName);
        }

        // --- Setup Dashboard Cards ---
        setupDashboardCard(R.id.card_mark_attendance, R.drawable.ic_mark_attendance, "Mark Attendance", "Mark daily student attendance", "Mark", MarkAttendanceActivity.class);
        setupDashboardCard(R.id.card_send_assignment, R.drawable.ic_send_assignment, "Send Assignment", "Send assignments to students", "Send", SendAssignmentActivity.class);
        setupDashboardCard(R.id.card_attendance_report, R.drawable.ic_attendance_report, "View Attendance Report", "Check student attendance", "View", ViewAttendanceActivity.class);
        setupDashboardCard(R.id.card_view_timetable, R.drawable.ic_view_timetable, "View Timetable", "Check your class schedule", "View", ViewTimetableActivity.class);
    }

    private void setupDashboardCard(int cardId, int iconId, String title, String description, String buttonText, Class<?> activityClass) {
        View cardView = findViewById(cardId);
        ImageView icon = cardView.findViewById(R.id.card_icon);
        TextView cardTitle = cardView.findViewById(R.id.card_title);
        TextView cardDescription = cardView.findViewById(R.id.card_description);
        Button cardButton = cardView.findViewById(R.id.card_button);

        // Set the content for each part of the card
        icon.setImageResource(iconId);
        cardTitle.setText(title);
        cardDescription.setText(description);
        cardButton.setText(buttonText);

        // Set the click listener to open the correct activity
        cardButton.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherDashboardActivity.this, activityClass);
            startActivity(intent);
        });
    }
}