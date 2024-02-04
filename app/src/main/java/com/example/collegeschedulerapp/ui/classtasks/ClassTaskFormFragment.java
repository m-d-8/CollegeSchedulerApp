package com.example.collegeschedulerapp.ui.classtasks;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.collegeschedulerapp.R;

import com.example.collegeschedulerapp.databinding.ClassTaskFormBinding;

import java.util.ArrayList;

public class ClassTaskFormFragment extends Fragment{

    private ClassTaskFormBinding binding;
    private ClassTasksViewModel sharedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = ClassTaskFormBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedViewModel = new ViewModelProvider(requireActivity()).get(ClassTasksViewModel.class);

        if(sharedViewModel.isEditMode()){

            EditText classTaskName = root.findViewById(R.id.classTaskName);
            EditText dateTimePicker = root.findViewById(R.id.dateTimePicker);
            EditText coursePicker = root.findViewById(R.id.coursePicker);
            EditText locationPicker = root.findViewById(R.id.locationPicker);
            RadioGroup radioGroup = root.findViewById(R.id.classTaskRadioGroup);

            ArrayList<ClassTaskData> cTasks = sharedViewModel.getClassTasks();
            classTaskName.setText(cTasks.get(sharedViewModel.getPosition()).getTitle());
            dateTimePicker.setText(cTasks.get(sharedViewModel.getPosition()).getDateTime());
            coursePicker.setText(cTasks.get(sharedViewModel.getPosition()).getCourse());
            locationPicker.setText(cTasks.get(sharedViewModel.getPosition()).getLocation());

            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                if (radioButton.getText().toString().equals(cTasks.get(sharedViewModel.getPosition()).getTaskType())) {
                    radioButton.setChecked(true);
                    break;
                }
            }
            cTasks.remove(cTasks.get(sharedViewModel.getPosition()));
            sharedViewModel.turnOffEdit();
        }

        Button discardButton = root.findViewById(R.id.discardButton);
        Button saveButton = root.findViewById(R.id.saveButton);
        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText classTaskName = root.findViewById(R.id.classTaskName);
                EditText dateTimePicker = root.findViewById(R.id.dateTimePicker);
                EditText coursePicker = root.findViewById(R.id.coursePicker);
                EditText locationPicker = root.findViewById(R.id.locationPicker);

                String classTaskNameText = classTaskName.getText().toString();
                String dateTimePickerText = dateTimePicker.getText().toString();
                String coursePickerText = coursePicker.getText().toString();
                String locationPickerText = locationPicker.getText().toString();

                //code for grabbing radio group
                RadioGroup radioGroup = root.findViewById(R.id.classTaskRadioGroup);
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = root.findViewById(selectedRadioButtonId);
                String classTaskTypeText = selectedRadioButton.getText().toString();

                ArrayList<ClassTaskData> cTasks = sharedViewModel.getClassTasks();
                ClassTasksViewModel.addToClassTasks(new ClassTaskData(classTaskNameText,classTaskTypeText,dateTimePickerText,coursePickerText,locationPickerText,R.drawable.paper));

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
        return root;
    }
}