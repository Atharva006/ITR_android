package com.example.prathampatil;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TeacherListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherAdapter adapter;
    private List<Teacher> teacherList;
    private FloatingActionButton fabAddTeacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        recyclerView = findViewById(R.id.teacher_recycler_view); // Correct ID
        fabAddTeacher = findViewById(R.id.fab_add_teacher);

        // Initialize teacher list
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher("John Doe", "Mathematics"));
        teacherList.add(new Teacher("Jane Smith", "Physics"));
        teacherList.add(new Teacher("Alice Johnson", "Chemistry"));

        // Setup adapter
        adapter = new TeacherAdapter(teacherList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // FAB click listener (example)
        fabAddTeacher.setOnClickListener(v -> {
            // Add a new teacher dynamically (example)
            Teacher newTeacher = new Teacher("New Teacher", "New Subject");
            teacherList.add(newTeacher);
            adapter.notifyItemInserted(teacherList.size() - 1);
            recyclerView.scrollToPosition(teacherList.size() - 1);
        });
    }
}
