package com.example.prathampatil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private ArrayList<Teacher> teacherList;

    public TeacherAdapter(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_teacher, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        Teacher currentTeacher = teacherList.get(position);
        holder.name.setText(currentTeacher.getFullName());
        holder.subject.setText("Subject: " + currentTeacher.getSubject());
        holder.email.setText(currentTeacher.getEmail());
        holder.experience.setText("Experience: " + currentTeacher.getExperience() + " years");
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    // This class holds the views for a single list item
    public static class TeacherViewHolder extends RecyclerView.ViewHolder {
        public TextView name, subject, email, experience;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacher_name);
            subject = itemView.findViewById(R.id.teacher_subject);
            email = itemView.findViewById(R.id.teacher_email);
            experience = itemView.findViewById(R.id.teacher_experience);

            itemView.findViewById(R.id.delete_button).setOnClickListener(v -> {
                // Placeholder for delete functionality
                Toast.makeText(itemView.getContext(), "Delete clicked for " + name.getText(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}