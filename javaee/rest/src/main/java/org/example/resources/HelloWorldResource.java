package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public Response helloworld() {
        return Response
                .ok() // header: 200 OK
                .entity("Hello world!") // content
                .build();
    }

}
