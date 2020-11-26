package org.example.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

// @Alternative
@Stateless
public class ContactDaoDB implements IContactDao {

    @PersistenceContext // Container managed persistence context
    private EntityManager em;

    @Override
    public List<Contact> getAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    @Override
    public Contact getById(String id) { return null; }

    @Override public Collection<Contact> get(String q) {
        return null;
    }

    @Override public boolean add(Contact c) {
        return false;
    }

    @Override public boolean remove(String id) {
        return false;
    }

    @Override public boolean update(String id, Contact c) {
        return false;
    }

}
