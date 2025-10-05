package com.example.prathampatil;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class AddTeacherActivity extends AppCompatActivity {

    private TextInputEditText editFullName, editDob, editExperience, editEmail, 
                              editPassword, editSubjects, editCity;
    private Button addTeacherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_add_teacher);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Initialize views
        initViews();

        // Initialize TeacherDataStore
        TeacherDataStore.initializeSampleData();

        // Set click listeners
        setClickListeners();
    }

    private void initViews() {
        editFullName = findViewById(R.id.edit_full_name);
        editDob = findViewById(R.id.edit_dob);
        editExperience = findViewById(R.id.edit_experience);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        editSubjects = findViewById(R.id.edit_subjects);
        editCity = findViewById(R.id.edit_city);
        addTeacherButton = findViewById(R.id.add_teacher_button);
    }

    private void setClickListeners() {
        // Date picker for DOB
        editDob.setOnClickListener(v -> showDatePicker());

        // Add teacher button click
        addTeacherButton.setOnClickListener(v -> addTeacher());
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editDob.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void addTeacher() {
        // Validate input fields
        if (!validateInput()) {
            return;
        }

        // Get input values
        String fullName = editFullName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String subjects = editSubjects.getText().toString().trim();
        String city = editCity.getText().toString().trim();
        String experience = editExperience.getText().toString().trim();

        // Generate unique username
        String username = generateUsername(fullName);

        // Create teacher object
        Teacher newTeacher = new Teacher(
                fullName,
                username,
                password,
                email,
                "", // Phone number - can be added later
                subjects,
                city // Using city as department for now
        );

        // Add teacher to data store
        TeacherDataStore.addTeacher(newTeacher);

        // Show success message
        Toast.makeText(this, "Teacher added successfully!\nUsername: " + username, 
                      Toast.LENGTH_LONG).show();

        // Clear form
        clearForm();
        
        // Finish activity
        finish();
    }

    private boolean validateInput() {
        boolean isValid = true;

        if (TextUtils.isEmpty(editFullName.getText())) {
            editFullName.setError("Full name is required");
            isValid = false;
        }

        if (TextUtils.isEmpty(editEmail.getText())) {
            editEmail.setError("Email is required");
            isValid = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches()) {
            editEmail.setError("Please enter a valid email");
            isValid = false;
        }

        if (TextUtils.isEmpty(editPassword.getText())) {
            editPassword.setError("Password is required");
            isValid = false;
        } else if (editPassword.getText().toString().length() < 6) {
            editPassword.setError("Password must be at least 6 characters");
            isValid = false;
        }

        if (TextUtils.isEmpty(editSubjects.getText())) {
            editSubjects.setError("Subject(s) is required");
            isValid = false;
        }

        if (TextUtils.isEmpty(editCity.getText())) {
            editCity.setError("City is required");
            isValid = false;
        }

        return isValid;
    }

    private String generateUsername(String fullName) {
        String baseUsername = fullName.toLowerCase().replaceAll("\\s+", "");
        String username = baseUsername;
        int counter = 1;

        // Check if username already exists
        while (isUsernameExists(username)) {
            username = baseUsername + counter;
            counter++;
        }

        return username;
    }

    private boolean isUsernameExists(String username) {
        for (Teacher teacher : TeacherDataStore.getTeachers()) {
            if (teacher.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void clearForm() {
        editFullName.setText("");
        editDob.setText("");
        editExperience.setText("");
        editEmail.setText("");
        editPassword.setText("");
        editSubjects.setText("");
        editCity.setText("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}