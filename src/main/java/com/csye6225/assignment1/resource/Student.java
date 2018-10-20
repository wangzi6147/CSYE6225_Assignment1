package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.StudentModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class Student {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentModel> getAll() {
        return new ArrayList<>(Database.students.values());
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel get(@PathParam("name") String name) {
        return Database.students.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel delete(@PathParam("name") String name) {
        return Database.students.remove(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel add(StudentModel student) {
        return Database.students.put(student.getName(), student);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel update(@PathParam("name") String name, StudentModel student) {
        return Database.students.put(name, student);
    }
}