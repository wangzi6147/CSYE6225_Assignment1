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
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel get(@PathParam("professorId") String professorId) {
        return ps.get(professorId);
    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel delete(@PathParam("professorId") String professorId) {
        return ps.delete(professorId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel add(ProfessorModel professor) {
        return ps.add(professor);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel update(@PathParam("professorId") String professorId, ProfessorModel professor) {
        return ps.update(professor);
    }
}

