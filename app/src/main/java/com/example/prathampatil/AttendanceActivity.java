package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class AttendanceActivity extends AppCompatActivity {

    private ListView listView;
    private Button addAttendanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create views programmatically
        listView = new ListView(this);
        addAttendanceButton = new Button(this);
        addAttendanceButton.setText("Mark Attendance");

        setContentView(listView);

        setupData();
        setupButton();
    }

    private void setupData() {
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList(
                "Mathematics - 87.5%",
                "Physics - 84.2%",
                "Chemistry - 90.5%",
                "English - 85.7%"
        ));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);
    }

    private void setupButton() {
        addAttendanceButton.setOnClickListener(v -> {
            Intent intent = new Intent(AttendanceActivity.this, MarkAttendanceActivity.class);
            startActivity(intent);
        });
    }
}
