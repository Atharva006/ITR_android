package com.example.prathampatil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prathampatil.data.StudentRepository;
import com.example.prathampatil.model.Student;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddStudentActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView studentPhoto;
    private TextInputEditText etStudentName, etPassword, etClass, etDivision, etDepartment, etEmail, etDob, etBloodGroup, etCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Initialize UI components
        studentPhoto = findViewById(R.id.student_photo);
        etStudentName = findViewById(R.id.et_student_name);
        etPassword = findViewById(R.id.et_password);
        etClass = findViewById(R.id.et_class);
        etDivision = findViewById(R.id.et_division);
        etDepartment = findViewById(R.id.et_department);
        etEmail = findViewById(R.id.et_email);
        etDob = findViewById(R.id.et_dob);
        etBloodGroup = findViewById(R.id.et_blood_group);
        etCity = findViewById(R.id.et_city);

        Button btnUploadPhoto = findViewById(R.id.btn_upload_photo);
        Button btnAddStudent = findViewById(R.id.btn_add_student);

        View.OnClickListener photoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        };
        btnUploadPhoto.setOnClickListener(photoClickListener);
        studentPhoto.setOnClickListener(photoClickListener);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudentData();
            }
        });
    }

    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            studentPhoto.setImageURI(imageUri);
            Toast.makeText(this, "Photo selected!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveStudentData() {
        String studentName = etStudentName.getText().toString();
        String password = etPassword.getText().toString();
        String studentClass = etClass.getText().toString();
        String studentDivision = etDivision.getText().toString();
        String studentDepartment = etDepartment.getText().toString();
        String studentEmail = etEmail.getText().toString();

        if (studentName.isEmpty() || password.isEmpty() || studentClass.isEmpty() || studentDivision.isEmpty() || studentDepartment.isEmpty() || studentEmail.isEmpty()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Pass the studentName as the username
        Student newStudent = new Student(studentName, password, studentClass + studentDivision, studentDepartment, studentEmail);
        StudentRepository.getInstance().addStudent(newStudent);

        Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}