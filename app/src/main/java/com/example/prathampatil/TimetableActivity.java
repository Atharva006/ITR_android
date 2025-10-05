package com.example.prathampatil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TimetableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        // Use the correct RecyclerView ID
        recyclerView = findViewById(R.id.timetable_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<TimetableItem> timetableList = TimetableRepository.getInstance().getTimetableList();

        TimetableAdapter adapter = new TimetableAdapter(timetableList);
        recyclerView.setAdapter(adapter);
    }

    private static class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder> {

        private final List<TimetableItem> timetableList;

        TimetableAdapter(List<TimetableItem> timetableList) {
            this.timetableList = timetableList;
        }

        @Override
        public TimetableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_timetable_card, parent, false);
            return new TimetableViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TimetableViewHolder holder, int position) {
            TimetableItem item = timetableList.get(position);
            holder.subjectName.setText(item.getSubject());
            holder.dayText.setText(item.getTeacher());
            holder.timeText.setText(item.getTime());
        }

        @Override
        public int getItemCount() {
            return timetableList.size();
        }

        static class TimetableViewHolder extends RecyclerView.ViewHolder {
            TextView subjectName;
            TextView dayText;
            TextView timeText;

            TimetableViewHolder(View itemView) {
                super(itemView);
                subjectName = itemView.findViewById(R.id.timetable_subject_name);
                dayText = itemView.findViewById(R.id.timetable_day);
                timeText = itemView.findViewById(R.id.timetable_time);
            }
        }
    }
}
