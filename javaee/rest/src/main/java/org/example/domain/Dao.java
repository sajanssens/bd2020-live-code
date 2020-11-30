package org.example.domain;

import java.util.Collection;

public interface Dao<E> {

    Collection<E> getAll();

    E getById(String id);

    Collection<E> get(String q);

    boolean add(E c);

    boolean remove(String id);

    boolean update(String id, E c);
}

