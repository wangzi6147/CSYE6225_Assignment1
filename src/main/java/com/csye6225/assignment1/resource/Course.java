package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.CourseModel;
import com.csye6225.assignment1.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("course")
public class Course {

    CourseService cs = new CourseService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseModel> getAll() {
        return cs.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel get(@PathParam("name") String name) {
        return cs.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel delete(@PathParam("name") String name) {
        return cs.delete(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel add(CourseModel course) {
        return cs.add(course);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel update(@PathParam("name") String name, CourseModel course) {
        return cs.update(name, course);
    }
}

