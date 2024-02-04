package com.example.collegeschedulerapp.ui.toDo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.collegeschedulerapp.R;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    private Context context;
    private List<ToDoData> toDo;
    private ToDoClickListener clickListener;

    public ToDoAdapter(Context context, List<ToDoData> toDo, ToDoClickListener clickListener) {
        this.context = context;
        this.toDo = toDo;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false), clickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        holder.toDoView.setText(toDo.get(position).getToDo());
    }
    @Override
    public int getItemCount() {
        return toDo.size();
    }
}
