package com.example.prathampatil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prathampatil.adapter.AttendanceAdapter;
import com.example.prathampatil.data.StudentRepository;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class MarkAttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_mark_attendance);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Setup Spinners
        AutoCompleteTextView deptSpinner = findViewById(R.id.department_spinner);
        AutoCompleteTextView divSpinner = findViewById(R.id.division_spinner);

        String[] departments = {"Computer Science", "Mechanical", "Civil"};
        String[] divisions = {"A", "B", "C"};

        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, departments);
        ArrayAdapter<String> divAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, divisions);

        deptSpinner.setAdapter(deptAdapter);
        divSpinner.setAdapter(divAdapter);

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.students_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Button Listeners
        Button fetchButton = findViewById(R.id.fetch_students_button);
        fetchButton.setOnClickListener(v -> {
            // In a real app, you would fetch students from a database based on selection
            // For now, we just show all students
            AttendanceAdapter adapter = new AttendanceAdapter(StudentRepository.getInstance().getStudentList());
            recyclerView.setAdapter(adapter);
            Toast.makeText(this, "Fetched Students!", Toast.LENGTH_SHORT).show();
        });

        Button submitButton = findViewById(R.id.submit_attendance_button);
        submitButton.setOnClickListener(v -> {
            Toast.makeText(this, "Attendance Submitted!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}