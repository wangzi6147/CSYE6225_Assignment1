package com.csye6225.assignment1.service;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    public List<CourseModel> getAll() {
        return new ArrayList<>(Database.courses.values());
    }

    public CourseModel get(String name) {
        return Database.courses.get(name);
    }

    public CourseModel delete(String name) {
        return Database.courses.remove(name);
    }

    public CourseModel add(CourseModel course) {
        return Database.courses.put(course.getTitle(), course);
    }

    public CourseModel update(String name, CourseModel course) {
        return Database.courses.put(name, course);
    }
}
