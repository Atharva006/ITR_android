package com.example.prathampatil;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.prathampatil.data.StudentRepository;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class AddStudentActivity extends AppCompatActivity {

    private TextInputEditText editFullName, editDob, editAge, editEmail, 
                              editPassword, editClassName, editRollNumber, editPhone;
    private Button addStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_add_student);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Initialize views
        initViews();

        // Initialize StudentRepository
        StudentRepository.initializeSampleData();

        // Set click listeners
        setClickListeners();
    }

    private void initViews() {
        editFullName = findViewById(R.id.edit_full_name);
        editDob = findViewById(R.id.edit_dob);
        editAge = findViewById(R.id.edit_age);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        editClassName = findViewById(R.id.edit_class_name);
        editRollNumber = findViewById(R.id.edit_roll_number);
        editPhone = findViewById(R.id.edit_phone);
        addStudentButton = findViewById(R.id.add_student_button);
    }

    private void setClickListeners() {
        // Date picker for DOB
        editDob.setOnClickListener(v -> showDatePicker());

        // Add student button click
        addStudentButton.setOnClickListener(v -> addStudent());
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
                    
                    // Auto-calculate age
                    int age = Calendar.getInstance().get(Calendar.YEAR) - selectedYear;
                    editAge.setText(String.valueOf(age));
                }, year, month, day);
        datePickerDialog.show();
    }

    private void addStudent() {
        // Validate input fields
        if (!validateInput()) {
            return;
        }

        // Get input values
        String fullName = editFullName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String className = editClassName.getText().toString().trim();
        String rollNumber = editRollNumber.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String ageText = editAge.getText().toString().trim();
        
        int age = 0;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            age = 18; // Default age
        }

        // Generate unique username
        String username = generateUsername(fullName);

        // Generate unique student ID
        String studentId = generateStudentId(rollNumber);

        // Create student object
        Student newStudent = new Student(
                fullName,
                username,
                password,
                email,
                phone,
                className,
                "General", // Department - can be modified
                studentId,
                age
        );

        // Add student to repository
        StudentRepository.addStudent(newStudent);

        // Show success message
        Toast.makeText(this, "Student added successfully!\nUsername: " + username + 
                      "\nStudent ID: " + studentId, Toast.LENGTH_LONG).show();

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

        if (TextUtils.isEmpty(editClassName.getText())) {
            editClassName.setError("Class name is required");
            isValid = false;
        }

        if (TextUtils.isEmpty(editRollNumber.getText())) {
            editRollNumber.setError("Roll number is required");
            isValid = false;
        }

        if (TextUtils.isEmpty(editPhone.getText())) {
            editPhone.setError("Phone number is required");
            isValid = false;
        } else if (editPhone.getText().toString().length() < 10) {
            editPhone.setError("Please enter a valid phone number");
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

    private String generateStudentId(String rollNumber) {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        return "STU" + year.substring(2) + rollNumber;
    }

    private boolean isUsernameExists(String username) {
        for (Student student : StudentRepository.getStudents()) {
            if (student.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void clearForm() {
        editFullName.setText("");
        editDob.setText("");
        editAge.setText("");
        editEmail.setText("");
        editPassword.setText("");
        editClassName.setText("");
        editRollNumber.setText("");
        editPhone.setText("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}