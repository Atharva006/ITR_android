package com.example.prathampatil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ManageStudentsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Student> adapter;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_students);

        // Create ListView programmatically
        listView = new ListView(this);
        setContentView(listView);

        loadStudents();
        setupListView();
    }

    private void loadStudents() {
        studentList = StudentRepository.getStudentList();
    }

    private void setupListView() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Student student = studentList.get(position);
            new AlertDialog.Builder(this)
                    .setTitle("Delete Student")
                    .setMessage("Are you sure you want to delete " + student.getName() + "?")
                    .setPositiveButton("Delete", (dialog, which) -> {
                        StudentRepository.removeStudent(student);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
            return true;
        });
    }
}
