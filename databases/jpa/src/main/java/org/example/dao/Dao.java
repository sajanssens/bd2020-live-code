package org.example.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<E, I> { // E: type of entity; T: type of id of entity

    protected final EntityManager em;

    public Dao(EntityManager em) { this.em = em; }

    public E get(I id) {
        return em.find(T(), id);
    }

    public E getDetached(I id) {
        E e = em.find(T(), id);
        detach(e);
        return e;
    }

    public void save(E e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void saveAndDetach(E e) {
        em.getTransaction().begin();
        em.persist(e);
        detach(e);
        em.getTransaction().commit();
    }

    private void detach(E e) {
        em.flush();
        em.detach(e);
    }

    public E update(E e) {
        em.getTransaction().begin();
        E merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public void remove(E e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public boolean isManaged(E e) {
        return em.contains(e);
    }

    public List<E> findAll() {
        return em.createQuery("SELECT e FROM " + typeSimple() + " e ", T()).getResultList();
    }

    public List<E> findAllWithNamedQuery() {
        return em.createNamedQuery(typeSimple() + ".findAll", T()).getResultList();
    }

    private String typeSimple() { return T().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<E> T() {
        return (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
