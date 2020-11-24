package org.example.domain;

import java.util.Collection;

public interface IContactDao {

    Collection<Contact> getAll();

    Collection<Contact> get(String q);

    boolean add(Contact c);

    boolean remove(String id);

    boolean update(String id, Contact c);
}

