package com.example.prathampatil;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class SendAssignmentActivity extends AppCompatActivity {

    private TextInputEditText etDueDate;
    private ActivityResultLauncher<String> filePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_assignment);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_send_assignment);
        toolbar.setNavigationOnClickListener(v -> finish());

        etDueDate = findViewById(R.id.et_due_date);
        etDueDate.setOnClickListener(v -> showDatePicker());

        LinearLayout uploadArea = findViewById(R.id.upload_area);
        uploadArea.setOnClickListener(v -> selectFile());

        Button sendButton = findViewById(R.id.send_assignment_button);
        sendButton.setOnClickListener(v -> {
            Toast.makeText(this, "Assignment Sent!", Toast.LENGTH_SHORT).show();
            finish();
        });

        // Initialize file picker
        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        Toast.makeText(this, "File selected: " + uri.getPath(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void selectFile() {
        filePickerLauncher.launch("*/*"); // Allow any file type
    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) ->
                        etDueDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1),
                year, month, day);
        datePickerDialog.show();
    }
}