package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.ContactDao;

import javax.ws.rs.*;
import java.util.List;

@Path("/contacts")
// http://localhost:9080/rest/api/contacts
public class ContactsResource implements JsonResource {

    private static final ContactDao dao = new ContactDao();

    @GET
    public List<Contact> getAll() {
        return dao.getAll();
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

}
