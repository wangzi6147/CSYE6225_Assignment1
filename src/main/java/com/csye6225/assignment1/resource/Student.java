package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.StudentModel;
import com.csye6225.assignment1.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("student")
public class Student {

    StudentService ss = new StudentService();

    public List<StudentModel> getAll() {
        return ss.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel get(@PathParam("name") String name) {
        return ss.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel delete(@PathParam("name") String name) {
        return ss.delete(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel add(StudentModel student) {
        return ss.add(student);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel update(@PathParam("name") String name, StudentModel student) {
        return ss.update(name, student);
    }
}