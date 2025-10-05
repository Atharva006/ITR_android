package com.example.prathampatil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddTeacherActivity extends AppCompatActivity {

    private TextInputEditText fullName, email, password, subjects, experience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_add_teacher);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Get references to all our input fields
        fullName = findViewById(R.id.edit_full_name);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        subjects = findViewById(R.id.edit_subjects);
        experience = findViewById(R.id.edit_experience);
        Button addTeacherButton = findViewById(R.id.add_teacher_button);

        // Set the click listener for the button
        addTeacherButton.setOnClickListener(v -> saveTeacherData());
    }

    private void saveTeacherData() {
        // Read the text from each input field
        String nameStr = fullName.getText().toString();
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();
        String subjectsStr = subjects.getText().toString();
        String experienceStr = experience.getText().toString();

        // Basic validation
        if (nameStr.isEmpty() || emailStr.isEmpty() || passwordStr.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Teacher object with the data
        Teacher newTeacher = new Teacher(nameStr, emailStr, passwordStr, subjectsStr, experienceStr);

        // Add the new teacher to our shared data store
        TeacherDataStore.teachers.add(newTeacher);

        // Show a success message and close the screen
        Toast.makeText(this, "Teacher Added Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}