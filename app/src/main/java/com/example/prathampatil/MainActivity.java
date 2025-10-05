package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView roleSpinner;
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRoleSpinner();
        initializeData();

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> performLogin());
    }

    private void initializeViews() {
        roleSpinner = findViewById(R.id.roleSpinner);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    private void initializeData() {
        // Initialize sample data
        TeacherDataStore.initializeSampleData();
        StudentRepository.initializeSampleData();
    }

    private void setupRoleSpinner() {
        String[] roles = new String[]{"Select Role", "Admin", "Student", "Teacher"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, roles);
        roleSpinner.setAdapter(adapter);
        roleSpinner.setText("Select Role", false);
    }

    private void performLogin() {
        String selectedRole = roleSpinner.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (selectedRole.isEmpty() || selectedRole.equals("Select Role")) {
            Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (selectedRole) {
            case "Admin":
                loginAsAdmin(username, password);
                break;
            case "Student":
                loginAsStudent(username, password);
                break;
            case "Teacher":
                loginAsTeacher(username, password);
                break;
            default:
                Toast.makeText(this, "Please select a valid role.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void loginAsAdmin(String username, String password) {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            Toast.makeText(this, "Admin Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AdminDashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid Admin credentials. Use admin/admin123", Toast.LENGTH_LONG).show();
        }
    }

    private void loginAsTeacher(String username, String password) {
        if (TeacherDataStore.teachers != null) {
            for (Teacher teacher : TeacherDataStore.teachers) {
                if (teacher.getUsername().equalsIgnoreCase(username) && teacher.getPassword().equals(password)) {
                    Toast.makeText(this, "Teacher Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, TeacherDashboardActivity.class);
                    intent.putExtra("TEACHER_NAME", teacher.getFullName());
                    intent.putExtra("TEACHER_USERNAME", teacher.getUsername());
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        }
        Toast.makeText(this, "Invalid Teacher credentials. Try teacher1/pass123", Toast.LENGTH_LONG).show();
    }

    private void loginAsStudent(String username, String password) {
        if (StudentRepository.getStudentList() != null) {
            for (Student student : StudentRepository.getStudentList()) {
                if (student.getUsername().equalsIgnoreCase(username) && student.getPassword().equals(password)) {
                    Toast.makeText(this, "Student Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, StudentDashboardActivity.class);
                    intent.putExtra("STUDENT_NAME", student.getName());
                    intent.putExtra("STUDENT_DETAILS", student.getDepartment() + " - " + student.getStudentClass());
                    intent.putExtra("STUDENT_USERNAME", student.getUsername());
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        }
        Toast.makeText(this, "Invalid Student credentials. Try student1/pass123", Toast.LENGTH_LONG).show();
    }
}
