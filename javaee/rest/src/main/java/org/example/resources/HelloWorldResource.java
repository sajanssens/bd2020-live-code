package org.example.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

// http://localhost:9080/rest/api/helloworld
@Path("/helloworld")
public class HelloWorldResource {

    // endpoint @ /helloworld?n=...
    @GET
    public Response getWithOptionalName(@QueryParam("n") String name) {
        String n = name != null ? name : "";
        return Response
                .ok() // header: 200 OK
                .entity("Hello world! " + n) // content
                .build();
    }

    // endpoint @ /helloworld
    @POST
    public Response post(String requestBody, @Context UriInfo uriInfo) {
        String body = requestBody != null ? requestBody : "";
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path("a_new_location");
        return Response
                .created(uriBuilder.build()) // header: 201 CREATED at path ...
                .entity("Hello posted world! " + body) // content
                .build();
    }

    // endpoint @ /helloworld/q?n=...
    @GET @Path("/q")
    public Response helloworldQ(@QueryParam("n") String name) {
        return Response
                .ok() // header: 200 OK
                .entity("Hello " + name + "!") // content
                .build();
    }

    // endpoint @ /helloworld/{some_name}.
    @GET @Path("{name}")
    public Response helloworldName(@PathParam("name") String name) {
        return Response
                .ok() // header: 200 OK
                .entity("Hello " + name + "!") // content
                .build();
    }

}
