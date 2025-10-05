package com.example.prathampatil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prathampatil.model.Teacher;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<Teacher> teacherList;
    private Context context;

    public TeacherAdapter(List<Teacher> teacherList, Context context) {
        this.teacherList = teacherList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_teacher, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        Teacher currentTeacher = teacherList.get(position);
        holder.name.setText(currentTeacher.getName());
        holder.subject.setText("Subject: " + currentTeacher.getSubject()); // fixed method
        holder.email.setText(currentTeacher.getUsername());
        holder.experience.setText("Experience: " + currentTeacher.getExperience());
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public static class TeacherViewHolder extends RecyclerView.ViewHolder {
        public TextView name, subject, email, experience;
        public ImageButton deleteButton;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacher_name);
            subject = itemView.findViewById(R.id.teacher_subject);
            email = itemView.findViewById(R.id.teacher_email);
            experience = itemView.findViewById(R.id.teacher_experience);
            deleteButton = itemView.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(v ->
                    Toast.makeText(itemView.getContext(),
                            "Delete clicked for " + name.getText(),
                            Toast.LENGTH_SHORT).show()
            );
        }
    }
}
