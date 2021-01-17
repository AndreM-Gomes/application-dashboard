package com.andremgomes.register.application;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterController {


    @POST
    public Response registerApplication(ApplicationRegistry applicationRegistry){
        return Response.status(Response.Status.CREATED).build();
    }
}
