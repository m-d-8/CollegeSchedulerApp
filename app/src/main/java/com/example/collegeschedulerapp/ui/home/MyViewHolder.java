package com.example.collegeschedulerapp.ui.home;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;
public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    EditText classNameView,instructorView,/*daysView,locationView,*/timeView;
    Button removeButton, saveButton;
    MyAdapter adapter;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        classNameView = itemView.findViewById(R.id.className);
        instructorView = itemView.findViewById(R.id.instructor);
//        daysView = itemView.findViewById(R.id.days);
//        locationView = itemView.findViewById(R.id.location);
        timeView = itemView.findViewById(R.id.time);
        removeButton = itemView.findViewById(R.id.remove);
        saveButton = itemView.findViewById(R.id.save);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAbsoluteAdapterPosition();
                if (position!= RecyclerView.NO_POSITION) {
                    adapter.removeItem(position);
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = classNameView.getText().toString();
                String instructor = instructorView.getText().toString();
                String time = timeView.getText().toString();


                int position = getAbsoluteAdapterPosition();
                adapter.update(position, className, instructor, time);
            }
        });

        //update feb 2 to come soon!!
        //set action for when clicking save button to save changes

    }

    public void setAdapter(MyAdapter adapter) {
        this.adapter = adapter;
    }

}