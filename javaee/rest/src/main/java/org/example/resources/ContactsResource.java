package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.IContactDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;

@Path("/contacts")
// http://localhost:9080/rest/api/contacts
public class ContactsResource implements JsonResource {

    @Inject
    private IContactDao dao/* = new ContactDao()*/;

    @GET
    public Collection<Contact> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAll() : dao.get(q);
    }

    @POST
    public Contact post(Contact c) {
        if (dao.add(c)) {
            return c;
        } else {
            throw new RuntimeException("Post contact " + c + " failed.");
        }
    }

    @DELETE @Path("{id}")
    public void delete(@PathParam("id") String id) {
        if (!dao.remove(id)) {
            throw new RuntimeException("Delete contact with id " + id + " failed.");
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
