package com.example.collegeschedulerapp.ui.toDo;

public class ToDoData {
    private String todo;
    private int id;
    public ToDoData(String todo, int id) {
        this.todo = todo;
        this.id = id;
    }
    public String getToDo() {
        return todo;
    }
    public void setToDo(String todo) {
        this.todo = todo;
    }
    public int getId() {
        return id;
    }
}
