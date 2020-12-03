package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.generified.ContactDaoDB;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;

@Path("/contacts")
// http://localhost:9080/rest/api/contacts
// @Authorized
public class ContactsResource implements JsonResource {

    @Inject
    private ContactDaoDB dao;

    @GET
    public Collection<Contact> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAll() : dao.get(q);
    }

    @GET @Path("{id}")
    public Contact get(@PathParam("id") String id) {
        return dao.getById(id);
    }

    @POST
    public Contact post(Contact c) {
        if (dao.add(c) != null) {
            return c;
        } else {
            throw new RuntimeException("Post contact " + c + " failed.");
        }
    }

    @DELETE @Path("{id}")
    public void delete(@PathParam("id") String id) {
        if (!dao.remove(id)) {
            throw new BadRequestException("Delete contact with id " + id + " failed.");
        }
    }

    @PUT @Path("{id}")
    public Contact put(@PathParam("id") String id, Contact c) {
        if (dao.update(id, c)) {
            return c;
        } else {
            throw new RuntimeException("Update contact " + c + " failed.");
        }
    }

}
