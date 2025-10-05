package com.example.prathampatil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class ViewAttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        // This makes the back arrow on the toolbar work
        MaterialToolbar toolbar = findViewById(R.id.toolbar_view_attendance);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}