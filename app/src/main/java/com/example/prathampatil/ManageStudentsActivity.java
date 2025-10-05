package com.example.prathampatil;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prathampatil.adapter.StudentAdapter;
import com.example.prathampatil.data.StudentRepository;
import com.example.prathampatil.model.Student;

import java.util.List;

public class ManageStudentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_students);

        recyclerView = findViewById(R.id.recyclerView_students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = StudentRepository.getInstance().getStudentList();

        studentAdapter = new StudentAdapter(studentList, new StudentAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(Student student) {
                // Remove student from the repository
                StudentRepository.getInstance().removeStudent(student);

                // Notify the adapter that the data set has changed
                studentAdapter.notifyDataSetChanged();

                Toast.makeText(ManageStudentsActivity.this, "Student deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (studentAdapter != null) {
            studentAdapter.notifyDataSetChanged();
        }
    }
}