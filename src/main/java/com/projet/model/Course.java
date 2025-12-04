package com.projet.model;

public class Course {
    private int id;
    private String title;

    public Course() {}
    public Course(String title) {
        this.title = title;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
