package com.example.collegeschedulerapp.ui.classtasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    Context context;
    List<ClassTaskData> classTasks;
    private View.OnClickListener EditClickListener;
    private View.OnClickListener DeleteClickListener;

    public TaskAdapter(Context context, List<ClassTaskData> classTasks) {
        this.context = context;
        this.classTasks = classTasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.class_task_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.titleView.setText(classTasks.get(position).getTitle());
        holder.courseView.setText(classTasks.get(position).getCourse());
        holder.imageView.setImageResource(classTasks.get(position).getImage());
        holder.dateTimeView.setText(classTasks.get(position).getDateTime());
        holder.locationView.setText(classTasks.get(position).getLocation());

        holder.editButton.setOnClickListener(EditClickListener);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteClickListener.onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return classTasks.size();
    }

    public void setEditClickListener(View.OnClickListener onEditClickListener) {
        this.EditClickListener = onEditClickListener;
    }

    public void setDeleteClickListener(View.OnClickListener onDeleteClickListener) {
        this.DeleteClickListener = onDeleteClickListener;
    }

}
