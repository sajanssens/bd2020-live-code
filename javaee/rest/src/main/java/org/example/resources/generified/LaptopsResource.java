package org.example.resources.generified;

import org.example.domain.Laptop;
import org.example.domain.generified.Dao;
import org.example.resources.JsonResource;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/laptops")
public class LaptopsResource extends Resource<Laptop> implements JsonResource {

    // setter injection, no constructor injection, since that doesn't combine with JAX-RS-lifecycle.
    @Inject public void setDao(Dao<Laptop> dao) { this.dao = dao; }

}
