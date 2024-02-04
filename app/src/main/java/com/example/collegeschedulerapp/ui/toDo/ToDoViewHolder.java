package com.example.collegeschedulerapp.ui.toDo;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.collegeschedulerapp.R;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    TextView toDoView;
    ImageButton editButton;
    ImageButton deleteButton;
    public ToDoViewHolder(@NonNull View itemView, final ToDoClickListener clickListener) {
        super(itemView);
        toDoView = itemView.findViewById(R.id.todo);
        editButton = itemView.findViewById(R.id.editButton);
        deleteButton = itemView.findViewById(R.id.deleteButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && clickListener != null) {
                    clickListener.onEditClick(position);
                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && clickListener != null) {
                    clickListener.onDeleteClick(position);
                }
            }
        });
    }
}
