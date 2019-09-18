package br.com.gbotossi.revolutpoc.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloController {

    @GET
    public Response printMessage() {
        String result = "Hello World!";
        return Response.status(200).entity(result).build();
    }
}
