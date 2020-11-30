package org.example.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Stateless
public class LaptopDaoDB implements Dao<Laptop> {

    @PersistenceContext // Container managed persistence context
    private EntityManager em;

    @Override
    public List<Laptop> getAll() {
        return em.createNamedQuery("Laptop.findAll", Laptop.class).getResultList();
    }

    @Override
    public Laptop getById(String id) { return null; }

    @Override
    public Collection<Laptop> get(String q) {
        return null;
    }

    @Override
    public boolean add(Laptop c) {
        em.persist(c);
        return true; // Fix me ...
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override public boolean update(String id, Laptop c) {
        return false;
    }

}
