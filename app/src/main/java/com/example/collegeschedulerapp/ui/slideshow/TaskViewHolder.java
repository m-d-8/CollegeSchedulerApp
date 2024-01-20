package com.example.collegeschedulerapp.ui.slideshow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView, courseView;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        titleView = itemView.findViewById(R.id.title);
        courseView = itemView.findViewById(R.id.course);
    }

}
