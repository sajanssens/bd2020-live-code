package org.example.domain;

import javax.ejb.Singleton;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

// @Alternative
@Singleton
public class ContactDao implements IContactDao {

    private int maxId = 0;

    private final Map<String, Contact> contacts;

    public ContactDao() {
        List<Contact> contacts = Arrays.asList(
                Contact.builder().id(nextId()).firstName("Sammie").surname("Smith").email("sam.smith@music.com").build(),
                Contact.builder().id(nextId()).firstName("Frank").surname("Muscles").email("frank@muscles.com").build(),
                Contact.builder().id(nextId()).firstName("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build(),
                Contact.builder().id(nextId()).firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com")
                        .laptop(Laptop.builder().brand("DELL").id("a635634-fcd37846y").price(813.98).build()).build()
        );

        this.contacts = contacts.stream().collect(toMap(Contact::getId, c -> c));
    }

    public Collection<Contact> getAll() {
        return contacts.values();
    }

    public Contact getById(String id) {
        return this.contacts.get(id);
    }

    public Collection<Contact> get(String q) {
        Predicate<Contact> p1 = c -> c.getFirstName() != null && c.getFirstName().contains(q);
        Predicate<Contact> p2 = c -> c.getSurname() != null && c.getSurname().contains(q);
        Predicate<Contact> p3 = c -> c.getEmail() != null && c.getEmail().contains(q);

        return getAll().stream()
                .filter(p1.or(p2).or(p3))
                .collect(toList());
    }

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
