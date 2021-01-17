package com.andremgomes.register.company;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Path("/{id}/logo")
    @Produces("image/jpeg")
    public byte[] getIconImage(@PathParam("id")Long id){
        return this.clientService.getLogoById(id);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response registerCompany(@MultipartForm ClientCreateDTO clientCreateDTO){
        this.clientService.registerCompany(clientCreateDTO.toCompany());
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response updateCompany(
            @MultipartForm ClientCreateDTO clientCreateDTO,
            @PathParam("id") Long id
        ){
        this.clientService.updateCompany(clientCreateDTO.toCompany(), id);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCompany(@PathParam("id")Long id){
        this.clientService.deleteCompany(id);
        return Response.status(200).build();
    }


}
