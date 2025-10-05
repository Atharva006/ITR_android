package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TeacherListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_teacher_list);
        toolbar.setNavigationOnClickListener(v -> finish());

        FloatingActionButton fab = findViewById(R.id.fab_add_teacher);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherListActivity.this, AddTeacherActivity.class);
            startActivity(intent);
        });

        // Setup the RecyclerView
        recyclerView = findViewById(R.id.teacher_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create the adapter with the shared teacher list and set it
        adapter = new TeacherAdapter(TeacherDataStore.teachers);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // This makes the list refresh every time you come back to this screen
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}