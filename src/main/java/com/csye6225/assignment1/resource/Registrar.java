package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.RegistrarModel;
import com.csye6225.assignment1.service.RegistrarService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("registerOffering")
public class Registrar {

    RegistrarService rs = new RegistrarService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RegistrarModel add(RegistrarModel registrarModel) {
        return rs.add(registrarModel);
    }
}
