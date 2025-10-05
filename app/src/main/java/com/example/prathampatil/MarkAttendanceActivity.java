package com.example.prathampatil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MarkAttendanceActivity extends AppCompatActivity {

    private ListView listView;
    private Button submitButton;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create views programmatically
        listView = new ListView(this);
        submitButton = new Button(this);
        submitButton.setText("Submit Attendance");

        setContentView(listView);

        setupData();
        setupListView();
        setupSubmitButton();
    }

    private void setupData() {
        studentList = StudentRepository.getStudentList();
    }

    private void setupListView() {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, studentList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void setupSubmitButton() {
        submitButton.setOnClickListener(v -> {
            int presentCount = listView.getCheckedItemCount();
            int totalCount = studentList.size();
            int absentCount = totalCount - presentCount;

            Toast.makeText(this,
                    "Attendance Submitted! Present: " + presentCount + ", Absent: " + absentCount,
                    Toast.LENGTH_LONG).show();

            finish();
        });
    }
}
