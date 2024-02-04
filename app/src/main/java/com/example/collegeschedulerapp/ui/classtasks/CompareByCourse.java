package com.example.collegeschedulerapp.ui.classtasks;
import java.util.Comparator;

public class CompareByCourse implements Comparator<ClassTaskData> {
    @Override
    public int compare(ClassTaskData task1, ClassTaskData task2) {
        return task1.getCourse().compareTo(task2.getCourse());
    }
}