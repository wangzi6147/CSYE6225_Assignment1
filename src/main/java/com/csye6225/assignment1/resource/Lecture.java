package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.LectureModel;
import com.csye6225.assignment1.service.LectureService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("lecture")
public class Lecture {

    LectureService ls = new LectureService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LectureModel> getAll() {

        return ls.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel get(@PathParam("name") String name) {
        return ls.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel delete(@PathParam("name") String name) {
        return ls.delete(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel add(LectureModel lecture) {
        return ls.add(lecture);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel update(@PathParam("name") String name, LectureModel lecture) {
        return ls.update(name, lecture);
    }
}
