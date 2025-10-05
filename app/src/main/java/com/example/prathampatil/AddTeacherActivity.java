package com.example.prathampatil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddTeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        // Create a simple form programmatically if layout doesn't have proper IDs
        Button saveButton = new Button(this);
        saveButton.setText("Add Teacher");
        saveButton.setOnClickListener(v -> {
            // Sample teacher data
            Teacher newTeacher = new Teacher(
                    "Sample Teacher",
                    "teacher" + System.currentTimeMillis(),
                    "password123",
                    "teacher@email.com",
                    "1234567890",
                    "Mathematics",
                    "Science"
            );

            TeacherDataStore.addTeacher(newTeacher);
            Toast.makeText(this, "Teacher added successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
