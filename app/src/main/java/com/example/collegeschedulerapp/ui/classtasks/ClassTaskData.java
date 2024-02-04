package com.example.collegeschedulerapp.ui.classtasks;

public class ClassTaskData {
    private String title;
    //private String dueDate;
    //private String dueTime;
    private String course;
    //private String location;
    private String taskType;

    private String dateTime;

    private String location;

    private int image;

    public ClassTaskData(String title, String taskType, String dateTime, String course, String location, int image) {
        this.title = title;
        this.course = course;
        this.taskType = taskType;
        this.image = image;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getImage() {
        return image;
    }

    public String getDateTime(){
        return dateTime;
    }

    public String getLocation(){
        return location;
    }
}
