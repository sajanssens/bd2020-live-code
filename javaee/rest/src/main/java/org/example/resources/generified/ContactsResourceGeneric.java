package org.example.resources.generified;

import org.example.domain.Contact;
import org.example.domain.Dao;
import org.example.resources.JsonResource;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/genericcontacts") // demo...
public class ContactsResourceGeneric extends Resource<Contact> implements JsonResource {

    // setter injection, no constructor injection, since that doesn't combine with JAX-RS-lifecycle.
    @Inject public void setDao(Dao<Contact> dao) { this.dao = dao; }

}
