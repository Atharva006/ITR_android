package com.example.prathampatil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(Student student);
    }

    public StudentAdapter(List<Student> studentList, OnItemClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_card, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        ImageView studentPhoto;
        TextView studentName;
        TextView studentDetails;
        TextView studentEmail;
        ImageView btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentPhoto = itemView.findViewById(R.id.student_photo);
            studentName = itemView.findViewById(R.id.student_name);
            studentDetails = itemView.findViewById(R.id.student_details);
            studentEmail = itemView.findViewById(R.id.student_email);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }

        public void bind(final Student student) {
            studentName.setText(student.getName());
            studentDetails.setText("Class: " + student.getStudentClass() + " • " + student.getDepartment());
            studentEmail.setText(student.getEmail());

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onDeleteClick(student);
                    }
                }
            });
        }
    }
}
