package com.csye6225.assignment1.model;

import java.util.List;

public class ProgramModel {

    private List<CourseModel> courses;
    private String name;

    public ProgramModel() {

    }

    public List<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseModel> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
