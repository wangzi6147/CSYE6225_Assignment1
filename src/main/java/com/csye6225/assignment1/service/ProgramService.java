package com.csye6225.assignment1.service;

import com.csye6225.assignment1.model.Database;
import com.csye6225.assignment1.model.ProgramModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {

    public List<ProgramModel> getAll() {
        List<ProgramModel> result = new ArrayList<>();
        result.addAll(Database.programs.values());
        return result;
    }

    public ProgramModel get(String name) {
        return Database.programs.get(name);
    }

    public ProgramModel delete(String name) {
        return Database.programs.remove(name);
    }

    public ProgramModel add(ProgramModel program) {
        return Database.programs.put(program.getName(), program);
    }

    public ProgramModel update(String name, ProgramModel program) {
        return Database.programs.put(name, program);
    }

}
