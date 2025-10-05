package com.example.prathampatil;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // Setup Toolbar with back navigation
        MaterialToolbar toolbar = findViewById(R.id.toolbar_schedule);
        toolbar.setNavigationOnClickListener(v -> finish());

        // This placeholder method now correctly updates the schedule items
        updateScheduleItems();
    }

    // A placeholder method to make the list items different using their new IDs
    private void updateScheduleItems() {
        // --- First Item (Calculus) is already set by default in list_item_schedule.xml ---
        View calculusLayout = findViewById(R.id.calculus_item);

        // --- Second Item - Find the layout by its ID and then find the views inside it ---
        View physicsLayout = findViewById(R.id.physics_item);
        ImageView physicsIcon = physicsLayout.findViewById(R.id.item_icon);
        TextView physicsTitle = physicsLayout.findViewById(R.id.class_title);
        TextView physicsTime = physicsLayout.findViewById(R.id.class_time);

        physicsIcon.setImageResource(R.drawable.ic_physics);
        physicsTitle.setText("Physics II");
        physicsTime.setText("10:30 AM - 11:30 AM");


        // --- Third Item - Find the layout by its ID and then find the views inside it ---
        View chemistryLayout = findViewById(R.id.chemistry_item);
        ImageView chemistryIcon = chemistryLayout.findViewById(R.id.item_icon);
        TextView chemistryTitle = chemistryLayout.findViewById(R.id.class_title);
        TextView chemistryTime = chemistryLayout.findViewById(R.id.class_time);
        View chemistryTimeline = chemistryLayout.findViewById(R.id.timeline_line);

        chemistryIcon.setImageResource(R.drawable.ic_chemistry);
        chemistryTitle.setText("Chemistry Lab");
        chemistryTime.setText("1:00 PM - 2:00 PM");

        // Hide the connecting line on the last item for a cleaner look
        chemistryTimeline.setVisibility(View.GONE);
    }
}