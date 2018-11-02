package com.csye6225.assignment1.service;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<StudentModel> getAll() {
        return new ArrayList<>(Database.students.values());
    }

    public StudentModel get(String name) {
        return Database.students.get(name);
    }

    public StudentModel delete(String name) {
        return Database.students.remove(name);
    }

    public StudentModel add(StudentModel student) {
        return Database.students.put(student.getName(), student);
    }

    public StudentModel update(String name, StudentModel student) {
        return Database.students.put(name, student);
    }

}
