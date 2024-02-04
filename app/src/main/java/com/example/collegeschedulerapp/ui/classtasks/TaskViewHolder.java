package com.example.collegeschedulerapp.ui.classtasks;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView, courseView, locationView, dateTimeView;

    Button editButton;
    Button deleteButton;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        titleView = itemView.findViewById(R.id.title);
        courseView = itemView.findViewById(R.id.course);
        locationView = itemView.findViewById(R.id.location);
        dateTimeView = itemView.findViewById(R.id.dueDate);
        editButton = itemView.findViewById(R.id.editButton);
        deleteButton = itemView.findViewById(R.id.deleteButton);
    }

}