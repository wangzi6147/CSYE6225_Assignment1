package com.csye6225.assignment1.service;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.LectureModel;

import java.util.ArrayList;
import java.util.List;

public class LectureService {
    public List<LectureModel> getAll() {
        return new ArrayList<>(Database.lectures.values());
    }

    public LectureModel get(String name) {
        return Database.lectures.get(name);
    }

    public LectureModel delete(String name) {
        return Database.lectures.remove(name);
    }

    public LectureModel add(LectureModel lecture) {
        return Database.lectures.put(lecture.getName(), lecture);
    }

    public LectureModel update(String name, LectureModel lecture) {
        return Database.lectures.put(name, lecture);
    }
}
