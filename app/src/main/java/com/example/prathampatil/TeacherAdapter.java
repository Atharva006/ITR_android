package com.example.prathampatil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<Teacher> teacherList;

    public TeacherAdapter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use simple list item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        Teacher currentTeacher = teacherList.get(position);
        holder.name.setText(currentTeacher.getFullName());
        holder.details.setText(currentTeacher.getSubject() + " - " + currentTeacher.getDepartment());
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    static class TeacherViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView details;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(android.R.id.text1);
            details = itemView.findViewById(android.R.id.text2);
        }
    }
}
