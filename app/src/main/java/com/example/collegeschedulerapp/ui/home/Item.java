package com.example.collegeschedulerapp.ui.home;

import com.example.collegeschedulerapp.R;

public class Item {
    String className;
    String instructor;
    //    String days;
//    String location;
    String time;
    int image;


    public Item() {
        this.className = "Course name:";
        this.instructor = "Instructor: ";
        this.time = "Time: ";
        this.image = R.drawable.paper;
    }
    public Item(String className, String instructor, /*String days, String location,*/ String time, int image) {
        this.className = className;
        this.instructor = instructor;
//        this.days = days;
//        this.location = location;
        this.time = time;
        this.image = image;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

//    public String getDays() {
//        return days;
//    }
//
//    public void setDays(String days) {
//        this.days = days;
//    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}