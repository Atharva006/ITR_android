package com.example.prathampatil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class ViewTimetableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_timetable);

        // This makes the back arrow on the toolbar work
        MaterialToolbar toolbar = findViewById(R.id.toolbar_view_timetable);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}