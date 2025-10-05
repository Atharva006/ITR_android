package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // --- Teacher Management Buttons ---
        Button addTeacherButton = findViewById(R.id.addTeacherButton);
        addTeacherButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, AddTeacherActivity.class);
            startActivity(intent);
        });

        Button manageTeacherButton = findViewById(R.id.manageTeacherButton);
        manageTeacherButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, TeacherListActivity.class);
            startActivity(intent);
        });

        // --- Student Management Buttons ---
        Button addStudentButton = findViewById(R.id.btn_add_student_dashboard);
        addStudentButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });

        Button manageStudentsButton = findViewById(R.id.btn_manage_students_dashboard);
        manageStudentsButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, ManageStudentsActivity.class);
            startActivity(intent);
        });

        // --- Community Notifications Button ---
        Button sendNotificationButton = findViewById(R.id.sendNotificationButton);
        sendNotificationButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, NotificationActivity.class);
            startActivity(intent);
        });

        // --- Class Scheduling Button ---
        Button openSchedulerButton = findViewById(R.id.openSchedulerButton);
        openSchedulerButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, ScheduleActivity.class);
            startActivity(intent);
        });
    }
}