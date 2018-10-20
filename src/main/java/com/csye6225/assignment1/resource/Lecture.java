package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.LectureModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("lecture")
public class Lecture {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LectureModel> getAll() {
        return new ArrayList<>(Database.lectures.values());
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel get(@PathParam("name") String name) {
        return Database.lectures.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel delete(@PathParam("name") String name) {
        return Database.lectures.remove(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel add(LectureModel lecture) {
        return Database.lectures.put(lecture.getName(), lecture);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel update(@PathParam("name") String name, LectureModel lecture) {
        return Database.lectures.put(name, lecture);
    }
}
