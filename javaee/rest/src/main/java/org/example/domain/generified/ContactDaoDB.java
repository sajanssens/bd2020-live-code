package org.example.domain.generified;

import org.example.domain.Contact;

import javax.ejb.Stateless;

@Stateless
public class ContactDaoDB extends Dao<Contact> {

    public int deleteAll() {
        return em.createNativeQuery("DELETE FROM contact").executeUpdate();
    }
}
