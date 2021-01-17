package com.andremgomes.status;

import com.andremgomes.systemd.ApplicationStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/application/status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GET
    public List<ApplicationStatus> getApplicationStatus() throws IOException, InterruptedException {
        return statusService.getAllApplicationStatus();
    }
}
