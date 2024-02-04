package com.example.collegeschedulerapp.ui.toDo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.databinding.FragmentGalleryBinding;
import java.util.ArrayList;
import java.util.List;

public class ToDoFragment extends Fragment implements ToDoClickListener {

    private FragmentGalleryBinding binding;
    private List<ToDoData> toDos;
    private ToDoAdapter toDoAdapter;
    private RecyclerView recyclerView;
    private Button addButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final EditText editText = binding.editTextText;
        recyclerView = binding.todoList;
        addButton = binding.addToListButton;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });
        toDos = new ArrayList<>();
        toDoAdapter = new ToDoAdapter(requireContext(), toDos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(toDoAdapter);
        return root;
    }

    private void addItem(View v) {
        EditText input = binding.editTextText;
        String toDo = input.getText().toString();
        input.getText().clear();
        int newToDoId = toDos.size() + 1;
        toDos.add(new ToDoData(toDo, newToDoId));
        toDoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteClick(int position) {
        toDos.remove(position);
        toDoAdapter.notifyItemRemoved(position);
    }

    @Override
    public void onEditClick(int position) {
        final ToDoData selectedToDo = toDos.get(position);
        binding.editTextText.setText(selectedToDo.getToDo());
        addButton.setText("Update");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedText = binding.editTextText.getText().toString();
                selectedToDo.setToDo(updatedText);
                toDoAdapter.notifyItemChanged(position);
                binding.editTextText.getText().clear();
                addButton.setText("Add");
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addItem(v);
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
