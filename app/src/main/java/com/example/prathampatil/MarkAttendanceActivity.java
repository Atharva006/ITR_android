package com.example.prathampatil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prathampatil.data.StudentRepository;
import com.example.prathampatil.Student;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class MarkAttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_mark_attendance);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        AutoCompleteTextView deptSpinner = findViewById(R.id.department_spinner);
        AutoCompleteTextView divSpinner = findViewById(R.id.division_spinner);
        RecyclerView recyclerView = findViewById(R.id.students_recycler_view);
        Button fetchButton = findViewById(R.id.fetch_students_button);
        Button submitButton = findViewById(R.id.submit_attendance_button);

        // Dummy data for spinners
        String[] departments = {"Computer Science", "Electrical Engineering", "Mechanical Engineering"};
        String[] divisions = {"A", "B", "C"};
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, departments);
        ArrayAdapter<String> divAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, divisions);
        deptSpinner.setAdapter(deptAdapter);
        divSpinner.setAdapter(divAdapter);

        fetchButton.setOnClickListener(v -> {
            // Placeholder for fetching students logic
            List<Student> studentList = StudentRepository.getInstance().getStudentList();
            // TODO: Implement AttendanceAdapter and set it to the RecyclerView
            // AttendanceAdapter adapter = new AttendanceAdapter(studentList);
            // recyclerView.setAdapter(adapter);
            // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });

        submitButton.setOnClickListener(v -> {
            // Placeholder for submitting attendance logic
            Toast.makeText(this, "Attendance Submitted!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}