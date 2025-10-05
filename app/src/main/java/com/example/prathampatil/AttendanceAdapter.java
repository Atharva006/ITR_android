package com.example.prathampatil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prathampatil.R;
import com.example.prathampatil.model.Student;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private List<Student> studentList;

    public AttendanceAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_attendance, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.studentName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        SwitchCompat attendanceSwitch;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name_attendance);
            attendanceSwitch = itemView.findViewById(R.id.attendance_switch);
        }
    }
}