package com.example.collegeschedulerapp.ui.home;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    //    public interface listenChangeText {
//        void onTextChanged(int position, String replacedText);
//    }
    Context context;
    //List<Item> items;
    private final ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }


    //Changes made feb 2 12:30am
//    public interface listenChangeText {
//        void on
//    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view,parent,false);
        //feb 1st additions 11:40 pm
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.setAdapter(this);
        return viewHolder;

        //originally just this line
//        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.classNameView.setText(currentItem.getClassName());
        holder.instructorView.setText(currentItem.getInstructor());
//        holder.daysView.setText(currentItem.getDays());
//        holder.locationView.setText(currentItem.getLocation());
        holder.timeView.setText(currentItem.getTime());

    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void update(int position, String className, String instructor, String time) {
        Item item = items.get(position);
        item.setClassName(className);
        item.setInstructor(instructor);
        item.setTime(time);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
