package com.example.prathampatil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private ArrayList<Student> studentList;
    private Map<String, Boolean> attendanceMap;

    public AttendanceAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
        this.attendanceMap = new HashMap<>();
        // Initialize all students as absent
        for (Student student : studentList) {
            attendanceMap.put(student.getUsername(), false);
        }
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use simple list item layout instead of custom layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textView.setText(student.getName() + " - " + student.getRollNumber());

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(attendanceMap.get(student.getUsername()));

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            attendanceMap.put(student.getUsername(), isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public Map<String, Boolean> getAttendanceMap() {
        return attendanceMap;
    }

    public int getPresentCount() {
        int count = 0;
        for (Boolean isPresent : attendanceMap.values()) {
            if (isPresent) count++;
        }
        return count;
    }

    public int getAbsentCount() {
        return studentList.size() - getPresentCount();
    }

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            checkBox = new CheckBox(itemView.getContext());
        }
    }
}
