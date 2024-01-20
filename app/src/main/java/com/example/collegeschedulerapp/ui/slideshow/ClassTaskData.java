package com.example.collegeschedulerapp.ui.slideshow;

public class ClassTaskData {
    private String title;
    //private String dueDate;
    //private String dueTime;
    private String course;
    //private String location;
    private String taskType;

    private int image;

    public ClassTaskData(String title, String course, String taskType, int image) {
        this.title = title;
        this.course = course;
        this.taskType = taskType;
        this.image = image;
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
}
