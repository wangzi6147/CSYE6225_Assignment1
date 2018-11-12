package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.StudentModel;
import com.csye6225.assignment1.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("student")
public class Student {

    StudentService ss = new StudentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentModel> getAll() {
        return ss.getAll();
    }

    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel get(@PathParam("studentId") String studentId) {
        return ss.get(studentId);
    }

    @DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentModel delete(@PathParam("studentId") String studentId) {
        return ss.delete(studentId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel add(StudentModel student) {
        return ss.add(student);
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel update(@PathParam("studentId") String studentId, StudentModel student) {
        return ss.update(student);
    }
}