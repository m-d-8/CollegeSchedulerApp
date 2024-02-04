package com.example.collegeschedulerapp.ui.classtasks;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.R;
import com.example.collegeschedulerapp.databinding.FragmentClasstasksBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassTasksFragment extends Fragment {

    private FragmentClasstasksBinding binding;

    private ClassTasksViewModel sharedViewModel;

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClasstasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedViewModel = new ViewModelProvider(requireActivity()).get(ClassTasksViewModel.class);

        FloatingActionButton generalAddButton = root.findViewById(R.id.generalAddButton);
        generalAddButton.setEnabled(true);

        //code for add class/class task button that shows up on course schedule and class task page
        generalAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu addOptions = new PopupMenu(getActivity().getApplicationContext(), generalAddButton);
                addOptions.getMenuInflater().inflate(R.menu.add_button_options, addOptions.getMenu());
                addOptions.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem addOption){
                        //Toast.makeText(getActivity().getApplicationContext(), "You clicked " + addOption.getTitle(), Toast.LENGTH_SHORT).show();
                        if("Add Class Task".equals(addOption.getTitle())){
                            //Toast.makeText(getActivity().getApplicationContext(), "You clicked " + addOption.getTitle(), Toast.LENGTH_SHORT).show();
                            switchToClassTaskForm();
                        }
                        addOptions.dismiss();
                        return true;
                    }
                });

                addOptions.show();
            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.classTaskList);

        ArrayList<ClassTaskData> cTasks = sharedViewModel.getClassTasks();

        TaskAdapter adapter = new TaskAdapter(getActivity().getApplicationContext(),cTasks);

        adapter.setEditClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition((View) v.getParent());
                sharedViewModel.setPosition(position);
                sharedViewModel.turnOnEdit();
                switchToClassTaskForm();
            }
        });
        adapter.setDeleteClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition((View) v.getParent());
                cTasks.remove(cTasks.get(position));
                adapter.notifyItemRemoved(position);
            }
        });

        // code for the sort function where we can either sort by due date or sort by course
        Button buttonForSortDueDate = root.findViewById(R.id.btnSortByDueDate);
        Button buttonForSortCourse = root.findViewById(R.id.btnSortByCourse);
        buttonForSortDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortClassTasksByDueDate();
            }
        });
        buttonForSortCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortClassTasksByCourse();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void switchToClassTaskForm(){
        ClassTaskFormFragment classTaskForm = new ClassTaskFormFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment previousFragment = fragmentManager.findFragmentById(R.id.classTaskContainer);
        if (previousFragment != null) {
            transaction.remove(previousFragment);
        }
        transaction.replace(R.id.classTaskContainer, classTaskForm);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // methods usd to sort the assignments/exams
    private void sortClassTasksByDueDate() {
        Collections.sort(sharedViewModel.getClassTasks(), new CompareByDueDate());
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void sortClassTasksByCourse() {
        Collections.sort(sharedViewModel.getClassTasks(), new CompareByCourse());
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}