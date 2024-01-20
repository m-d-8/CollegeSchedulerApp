package com.example.collegeschedulerapp;

import android.os.Bundle;
import android.view.Menu;
<<<<<<< Updated upstream
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
=======
import android.view.View;
>>>>>>> Stashed changes

import com.example.collegeschedulerapp.ui.slideshow.ClassTaskData;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeschedulerapp.databinding.ActivityMainBinding;
import com.example.collegeschedulerapp.ui.slideshow.TaskAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private ArrayList<String> toDoList;
    private ArrayAdapter<String> toDoListAdapter;
    private  ListView toDoListView;
    private Button addToListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setContentView(R.layout.fragment_slideshow);

//        RecyclerView recyclerView = findViewById(R.id.classTaskList);
//
//        List<ClassTaskData> cTasks = new ArrayList<ClassTaskData>();
//        cTasks.add(new ClassTaskData("Assignment 1","HTS 2053", "assignment",R.drawable.paper));
//        cTasks.add(new ClassTaskData("Assignment 2","HTS 2053", "assignment",R.drawable.paper));
//        cTasks.add(new ClassTaskData("Chapter 1 Readings","PSYC 1101", "assignment",R.drawable.paper));
//        cTasks.add(new ClassTaskData("Pre-Lecture Recordings 5","MATH 1554", "assignment",R.drawable.paper));
//        cTasks.add(new ClassTaskData("Midterm Exam","CS 2340", "exam",R.drawable.paper));
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new TaskAdapter(getApplicationContext(),cTasks));

        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}