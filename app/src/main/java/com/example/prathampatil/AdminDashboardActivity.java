package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button addStudentButton = findViewById(R.id.btn_add_student_dashboard);
        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

        Button manageStudentsButton = findViewById(R.id.btn_manage_students_dashboard);
        manageStudentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ManageStudentsActivity.class);
                startActivity(intent);
            }
        });
    }
}