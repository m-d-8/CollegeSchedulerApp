package com.example.collegeschedulerapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.collegeschedulerapp.MainActivity;
import com.example.collegeschedulerapp.R;
import com.example.collegeschedulerapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private ArrayList<String> toDos;
    private ArrayAdapter<String> toDoListAdapter;
    private ListView listView;
    private Button addButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText editText = binding.editTextText;
        listView = binding.toDoListView;
        addButton = binding.addToListButton;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIten(v);
            }
        });

        toDos = new ArrayList<>();
        toDoListAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, toDos);
        listView.setAdapter(toDoListAdapter);

        return root;
    }

    private void addIten(View v ) {
        EditText input = binding.editTextText;
        String toDo = input.getText().toString();
        input.getText().clear();
        toDoListAdapter.add(toDo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}