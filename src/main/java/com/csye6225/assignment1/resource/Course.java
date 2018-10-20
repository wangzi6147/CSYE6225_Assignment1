package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.CourseModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("course")
public class Course {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseModel> getAll() {
        return new ArrayList<>(Database.courses.values());
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel get(@PathParam("name") String name) {
        return Database.courses.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel delete(@PathParam("name") String name) {
        return Database.courses.remove(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel add(CourseModel course) {
        return Database.courses.put(course.getTitle(), course);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel update(@PathParam("name") String name, CourseModel course) {
        return Database.courses.put(name, course);
    }
}

