package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.ProfessorModel;
import com.csye6225.assignment1.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("professor")
public class Professor {

    ProfessorService ps = new ProfessorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorModel> getAll() {
        return ps.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel get(@PathParam("name") String name) {
        return ps.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel delete(@PathParam("name") String name) {
        return ps.delete(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel add(ProfessorModel professor) {
        return ps.add(professor);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel update(@PathParam("name") String name, ProfessorModel professor) {
        return ps.update(name, professor);
    }
}

