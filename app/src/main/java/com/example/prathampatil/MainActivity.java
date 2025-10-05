package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prathampatil.data.StudentRepository;
import com.example.prathampatil.model.Student;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView roleSpinner;
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roleSpinner = findViewById(R.id.roleSpinner);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        setupRoleSpinner();
        loginButton.setOnClickListener(v -> performLogin());
    }

    private void setupRoleSpinner() {
        String[] roles = new String[]{"Admin", "Student", "Teacher"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, roles);
        roleSpinner.setAdapter(adapter);
    }

    private void performLogin() {
        String selectedRole = roleSpinner.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

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
            Toast.makeText(this, "Invalid Admin credentials.", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginAsTeacher(String username, String password) {
        for (Teacher teacher : TeacherDataStore.teachers) {
            if (teacher.getFullName().equalsIgnoreCase(username) && teacher.getPassword().equals(password)) {
                Toast.makeText(this, "Teacher Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("TEACHER_NAME", teacher.getFullName());
                startActivity(intent);
                finish();
                return;
            }
        }
        Toast.makeText(this, "Invalid Teacher credentials.", Toast.LENGTH_SHORT).show();
    }

    private void loginAsStudent(String username, String password) {
        for (Student student : StudentRepository.getInstance().getStudentList()) {
            if (student.getUsername().equalsIgnoreCase(username) && student.getPassword().equals(password)) {
                Toast.makeText(this, "Student Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("TEACHER_NAME", student.getName()); // Reusing the same extra key for simplicity
                startActivity(intent);
                finish();
                return;
            }
        }
        Toast.makeText(this, "Invalid Student credentials.", Toast.LENGTH_SHORT).show();
    }
}