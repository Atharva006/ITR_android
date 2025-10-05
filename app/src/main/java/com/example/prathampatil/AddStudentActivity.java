package com.example.prathampatil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        // Create a simple form programmatically if layout doesn't have proper IDs
        Button saveButton = new Button(this);
        saveButton.setText("Add Student");
        saveButton.setOnClickListener(v -> {
            // Sample student data
            Student newStudent = new Student(
                    "Sample Student",
                    "student" + System.currentTimeMillis(),
                    "password123",
                    "student@email.com",
                    "1234567890",
                    "Class 10A",
                    "Science",
                    "S" + System.currentTimeMillis(),
                    16
            );

            StudentRepository.addStudent(newStudent);
            Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
