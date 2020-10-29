package org.example.dao;

import javax.persistence.EntityManager;

public class Dao<T> {

    protected final EntityManager em;

    public Dao(EntityManager em) {
        this.em = em;
    }

    public void save(T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public T get(Class<T> c, long id) {
        return em.find(c, id);
    }

}
