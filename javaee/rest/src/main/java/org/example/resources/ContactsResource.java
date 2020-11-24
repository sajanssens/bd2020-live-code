package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.ContactDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/contacts")
// http://localhost:9080/rest/api/contacts
public class ContactsResource implements JsonResource {

    private final ContactDao dao = new ContactDao();

    @GET
    public List<Contact> getAll() {
        return dao.getAll();
    }

}
