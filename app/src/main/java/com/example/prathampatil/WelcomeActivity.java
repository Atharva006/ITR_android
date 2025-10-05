package com.example.prathampatil;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeMessage = findViewById(R.id.welcome_message);
        String teacherName = getIntent().getStringExtra("TEACHER_NAME");

        if (teacherName != null && !teacherName.isEmpty()) {
            welcomeMessage.setText("Welcome, " + teacherName + "!");
        }
    }
}