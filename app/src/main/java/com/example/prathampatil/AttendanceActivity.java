package com.example.prathampatil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

import com.example.prathampatil.data.AttendanceRepository;
import com.example.prathampatil.model.AttendanceItem;

import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AttendanceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_attendance);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.attendance_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Use model AttendanceItem directly
        List<AttendanceItem> attendanceList = AttendanceRepository.getInstance().getAttendanceList();

        adapter = new AttendanceAdapter(attendanceList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

        private List<AttendanceItem> attendanceList;

        public AttendanceAdapter(List<AttendanceItem> attendanceList) {
            this.attendanceList = attendanceList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_attendance_card, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            AttendanceItem item = attendanceList.get(position);

            holder.subjectName.setText(item.getSubjectName());
            holder.attendanceDetails.setText("Classes: " + item.getClassesAttended() + "/" + item.getTotalClasses());

            // Compute percentage
            int percentage = 0;
            if (item.getTotalClasses() > 0) {
                percentage = (int) (((double) item.getClassesAttended() / item.getTotalClasses()) * 100);
            }
            holder.attendancePercentage.setText(percentage + "%");

            // Set color based on percentage
            if (percentage < 75) {
                holder.attendancePercentage.setTextColor(getResources().getColor(R.color.red));
            } else {
                holder.attendancePercentage.setTextColor(getResources().getColor(R.color.black));
            }
        }

        @Override
        public int getItemCount() {
            return attendanceList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView subjectName;
            TextView attendanceDetails;
            TextView attendancePercentage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                subjectName = itemView.findViewById(R.id.subject_name_text_view);
                attendanceDetails = itemView.findViewById(R.id.attendance_details_text_view);
                attendancePercentage = itemView.findViewById(R.id.attendance_percentage_text_view);
            }
        }
    }
}
