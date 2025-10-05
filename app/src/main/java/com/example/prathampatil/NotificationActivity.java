package com.example.prathampatil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Setup Toolbar
        MaterialToolbar toolbar = findViewById(R.id.toolbar_notification);
        toolbar.setNavigationOnClickListener(v -> {
            // This makes the back arrow work
            finish();
        });

        // Setup Recipient Spinner
        AutoCompleteTextView recipientSpinner = findViewById(R.id.recipientSpinner);
        String[] recipientGroups = new String[]{"Student", "Teacher"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                recipientGroups
        );
        recipientSpinner.setAdapter(adapter);
    }
}