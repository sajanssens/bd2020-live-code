package org.example.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class ContactDao {

    private int maxId = 0;

    private final Map<String, Contact> contacts;

    public ContactDao() {
        List<Contact> contacts = Arrays.asList(
                Contact.builder().id(nextId()).firstName("Sammie").surname("Smith").email("sam.smith@music.com").build(),
                Contact.builder().id(nextId()).firstName("Frank").surname("Muscles").email("frank@muscles.com").build(),
                Contact.builder().id(nextId()).firstName("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build(),
                Contact.builder().id(nextId()).firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").build()
        );

        this.contacts = contacts.stream().collect(toMap(Contact::getId, c -> c));
    }

    public Collection<Contact> getAll() { return contacts.values(); }

    public boolean add(Contact c) {
        if (c.getId() == null) c.setId(nextId());
        return this.contacts.put(c.getId(), c) == null;
    }

    public boolean remove(String id) {
        return this.contacts.remove(id) != null;
    }

    public boolean update(String id, Contact c) {
        return this.contacts.put(id, c) != null;
    }

    private String nextId() { return ++maxId + ""; }
}
