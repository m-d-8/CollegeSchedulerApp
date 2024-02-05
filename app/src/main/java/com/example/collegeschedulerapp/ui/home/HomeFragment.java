package com.example.collegeschedulerapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.collegeschedulerapp.R;


import com.example.collegeschedulerapp.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MyAdapter adapter;
    private ArrayList<Item> items;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //final approach that worked
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.courseList);
        items = new ArrayList<>();
//        items.add(new Item("CS 2340: Objects and Design", "Feijoo-garcia", "T/TH: 12:30 - 13:45", R.drawable.paper));
//        items.add(new Item("PSYCH 1101: General Psychology", "Rick Thomas", "T/TH: 14:00 - 15:15", R.drawable.paper));
//        items.add(new Item("CS 1100: Freshman Leap Seminar", "Instructor", "M: 11:00 - 11:50", R.drawable.paper));
//        items.add(new Item("APPH 1040: Scientific Foundations of Health", "Julie Taube", "F: 8:20 - 10:20", R.drawable.paper));
//        items.add(new Item("CS 1332: Data Structures & Algorithms", "Professor", "M/W/F: 14:00 - 14:50", R.drawable.paper));



        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);



        Button addButton = root.findViewById(R.id.add_button_main);
        addButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        return root;

    }

    private void addItem() {
        items.add(new Item());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}