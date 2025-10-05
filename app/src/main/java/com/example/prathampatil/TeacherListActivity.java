package com.example.prathampatil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prathampatil.data.TeacherDataStore;
import com.example.prathampatil.model.Teacher;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class TeacherListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherAdapter adapter;
    private List<Teacher> teacherList;

    private final ActivityResultLauncher<Intent> addTeacherLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK) {
                            adapter.notifyDataSetChanged();
                            Toast.makeText(this, "Teacher list updated", Toast.LENGTH_SHORT).show();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_teacher_list);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.teacher_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teacherList = TeacherDataStore.getInstance().getTeacherList();
        adapter = new TeacherAdapter(teacherList, this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab_add_teacher);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(TeacherListActivity.this, AddTeacherActivity.class);
            addTeacherLauncher.launch(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
