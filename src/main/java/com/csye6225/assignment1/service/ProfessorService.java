package com.csye6225.assignment1.service;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.ProfessorModel;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    public List<ProfessorModel> getAll() {
        return new ArrayList<>(Database.professors.values());
    }

    public ProfessorModel get(String name) {
        return Database.professors.get(name);
    }

    public ProfessorModel delete(String name) {
        return Database.professors.remove(name);
    }

    public ProfessorModel add(ProfessorModel professor) {
        return Database.professors.put(professor.getName(), professor);
    }

    public ProfessorModel update(String name, ProfessorModel professor) {
        return Database.professors.put(name, professor);
    }
}
