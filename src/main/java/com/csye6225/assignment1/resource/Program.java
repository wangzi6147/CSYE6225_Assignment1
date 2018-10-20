package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.Database;
import com.csye6225.assignment1.model.ProgramModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("program")
public class Program {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProgramModel> getAll() {
        List<ProgramModel> result = new ArrayList<>();
        result.addAll(Database.programs.values());
        return result;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramModel get(@PathParam("name") String name) {
        return Database.programs.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramModel delete(@PathParam("name") String name) {
        return Database.programs.remove(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProgramModel add(ProgramModel program) {
        return Database.programs.put(program.getName(), program);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProgramModel update(@PathParam("name") String name, ProgramModel program) {
        return Database.programs.put(name, program);
    }
}

