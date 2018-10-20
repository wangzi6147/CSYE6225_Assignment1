package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.ProfessorModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("professor")
public class Professor {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorModel> getAll() {
        return new ArrayList<>(Database.professors.values());
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel get(@PathParam("name") String name) {
        return Database.professors.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel delete(@PathParam("name") String name) {
        return Database.professors.remove(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel add(ProfessorModel professor) {
        return Database.professors.put(professor.getName(), professor);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel update(@PathParam("name") String name, ProfessorModel professor) {
        return Database.professors.put(name, professor);
    }
}

