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

import java.util.List;

public class AssignmentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AssignmentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_assignments);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.assignments_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Use AssignmentsItem directly
        List<AssignmentsItem> assignmentList = AssignmentsRepository.getInstance().getAssignmentsList();

        adapter = new AssignmentsAdapter(assignmentList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    // RecyclerView Adapter
    public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder> {

        private List<AssignmentsItem> assignmentList;

        public AssignmentsAdapter(List<AssignmentsItem> assignmentList) {
            this.assignmentList = assignmentList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_assignment_card, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            AssignmentsItem item = assignmentList.get(position);
            holder.assignmentTitle.setText(item.getSubjectName() + " - " + item.getTitle());
            holder.assignmentDueDate.setText("Due: " + item.getDueDate());
            holder.assignmentStatus.setText(item.getStatus());

            // Change status text and background color based on status
            if (item.getStatus().equals("Submitted")) {
                holder.assignmentStatus.setBackgroundResource(R.drawable.rounded_corner_background_submitted);
                holder.assignmentStatus.setTextColor(getResources().getColor(R.color.white));
            } else if (item.getStatus().equals("Pending")) {
                holder.assignmentStatus.setBackgroundResource(R.drawable.rounded_corner_background_pending);
                holder.assignmentStatus.setTextColor(getResources().getColor(R.color.black));
            } else if (item.getStatus().equals("Graded")) {
                holder.assignmentStatus.setBackgroundResource(R.drawable.rounded_corner_background_graded);
                holder.assignmentStatus.setTextColor(getResources().getColor(R.color.white));
            }
        }

        @Override
        public int getItemCount() {
            return assignmentList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView assignmentTitle;
            TextView assignmentDueDate;
            TextView assignmentStatus;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                assignmentTitle = itemView.findViewById(R.id.assignment_title);
                assignmentDueDate = itemView.findViewById(R.id.assignment_due_date);
                assignmentStatus = itemView.findViewById(R.id.assignment_status);
            }
        }
    }
}
