package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.core.Greeting;
import com.javaeeeee.dwstart.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class MainHelloRes {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello world!";
    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNamedGreeting(@PathParam(value = "name") String name) {
        return "Hello " + name;
    }


    @Path("/query_param")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNamedStringWithParam(@DefaultValue("world") @QueryParam("name") String name) {
        return "Hello " + name;
    }

    @Path("/hello_json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getJSONGreeting() {
        return new Greeting("Hello world!");
    }

}
