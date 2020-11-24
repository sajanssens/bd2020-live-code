package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactDao {

    private final List<Contact> contacts = new ArrayList<>(Arrays.asList(
            Contact.builder().id("1").firstName("Sammie").surname("Smith").email("sam.smith@music.com").build(),
            Contact.builder().id("2").firstName("Frank").surname("Muscles").email("frank@muscles.com").build(),
            Contact.builder().id("3").firstName("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build(),
            Contact.builder().id("4").firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").build()
    ));

    public List<Contact> getAll() { return contacts; }

    public boolean add(Contact c) { return this.contacts.add(c); }

    public boolean remove(String id) {
        return this.contacts.removeIf(c -> c.getId().equals(id));
    }
}
