package com.example.collegeschedulerapp.ui.classtasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ClassTasksViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private static ArrayList<ClassTaskData> cTasks = new ArrayList<ClassTaskData>();

    private boolean editMode;

    private int position;

    public ClassTasksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    // getter
    public ArrayList<ClassTaskData> getClassTasks() {
        return cTasks;
    }

    // add method
    public static void addToClassTasks(ClassTaskData data) {
        cTasks.add(data);
    }
    public LiveData<String> getText() {
        return mText;
    }

    public boolean isEditMode(){
        return editMode;
    }

    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }

    public void turnOnEdit(){
        editMode = true;
    }

    public void turnOffEdit(){
        editMode = false;
    }
}