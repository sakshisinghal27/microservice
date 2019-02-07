package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello/x")
public class HelloXRes {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello X world!";
    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@PathParam("name") String name) {
        return "XX " + name;
    }
}
