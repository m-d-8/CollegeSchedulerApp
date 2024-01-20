package com.example.collegeschedulerapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;
import com.example.collegeschedulerapp.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //setContentView(R.layout.fragment_slideshow);

        //View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.classTaskList);

        List<ClassTaskData> cTasks = new ArrayList<ClassTaskData>();
        cTasks.add(new ClassTaskData("Assignment 1","HTS 2053", "assignment",R.drawable.paper));
        cTasks.add(new ClassTaskData("Assignment 2","HTS 2053", "assignment",R.drawable.paper));
        cTasks.add(new ClassTaskData("Chapter 1 Readings","PSYC 1101", "assignment",R.drawable.paper));
        cTasks.add(new ClassTaskData("Pre-Lecture Recordings 5","MATH 1554", "assignment",R.drawable.paper));
        cTasks.add(new ClassTaskData("Midterm Exam","CS 2340", "exam",R.drawable.paper));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TaskAdapter(getActivity().getApplicationContext(),cTasks));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}