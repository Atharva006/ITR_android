package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    private Button loginButton;

    // Hardcoded credentials for demonstration
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        roleSpinner = findViewById(R.id.roleSpinner);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Setup the role spinner
        setupRoleSpinner();

        // Set Login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void setupRoleSpinner() {
        // Options for the dropdown
        String[] roles = new String[]{"Admin", "Student", "Teacher"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                roles
        );
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

        // We only handle Admin login for now, as requested.
        if (selectedRole.equals("Admin")) {
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                Toast.makeText(this, "Admin Login Successful!", Toast.LENGTH_SHORT).show();

                // Redirect to Admin Dashboard Activity
                Intent intent = new Intent(MainActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
                finish(); // Prevent user from going back to login screen
            } else {
                Toast.makeText(this, "Invalid Admin credentials.", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Placeholder for other roles
            Toast.makeText(this, "Login for " + selectedRole + " is not yet implemented.", Toast.LENGTH_SHORT).show();
        }
    }
}